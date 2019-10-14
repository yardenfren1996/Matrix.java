package com.company;

public class Matrix {
    private final int MAX_NUM = 255;
    private final int MIN_NUM = 0;
    private int _rows,_columns;
    private  int [][] _array;


    
    //constructors
    public Matrix(int size1, int size2){
        this._rows = size1;
        this._columns = size2;
        _array = new int [_rows][_columns];

    }
    public Matrix (int [][] array) {
        _rows = array.length;
        _columns = array[0].length;
        this._array = new int[_rows][_columns];
        for (int i = 0; i < _rows; i++)
            for (int j = 0; j < _columns; j++)
                if (array[i][j] >= 0 && array[i][j] <= 255) {
                    this._array[i][j] = array[i][j];
                }
    }



    // method that returns the negative values of the matrix
    public Matrix makeNegative() {
        Matrix M =new Matrix(_rows,_columns);
        //runs on the matrix and subtracted from 255
        for (int i = 0; i < _array.length; i++) {
            for (int j = 0; j < _array[i].length; j++) {
                M._array[i][j] = MAX_NUM - this._array[i][j];
            }
        }
        return M;
    }




    //method that reduce the noise in a matrix (calculate the average value of each cell with his neighbors)
    public Matrix imageFilterAverage(){
        Matrix M = new Matrix(_rows,_columns);

        for (int i = 0; i < _array.length; i++) {
            for (int j = 0; j < _array[i].length; j++) {
                M._array[i][j] = cellsSum(i,j)/cellsAround(i,j);
            }
        }
        return M;

    }



    //rotates the matrix clockwise
    public Matrix rotateClockWise (){
        //switch the rows and columns
        Matrix M = new Matrix(_columns,_rows);

        for (int i = 0; i < _array.length; i++) {
            for (int j = 0; j < _array[i].length; j++) {
                M._array[j][_array.length-1-i] = this._array[i][j];
            }
        }
        return M;
    }

    //rotates the matrix counter clockwise
    public Matrix rotateCounterClockWise (){
        //switch the rows and columns
        Matrix M = new Matrix(_columns,_rows);

        for (int i = 0; i < _array.length; i++) {
            for (int j = 0; j < _array[i].length; j++) {
                M._array[_array[i].length-1-j][i] = this._array[i][j];
            }
        }
        return M;
    }

    public String toString (){
        String res ="";
        for (int i =0;i<_rows;i++){
            for (int j= 0;j<_columns;j++){
                res= res +_array[i][j]+"\t";
            }
            res= res +"\n";
        }
    return res;
    }


    // method that checks if the location of a cell is exist in the matrix
    private boolean isIn(int i, int j) {
        return i < _array.length && i >= 0 && j < _array[i].length  && j >= 0;
    }

    //this method calculate how many cells is around specific cell
    private int cellsAround(int i, int j) {
        int cells = 1;

        if (isIn(i + 1, j)) {
            cells++;
        }
        if (isIn(i - 1, j)) {
            cells++;
        }
        if (isIn(i, j + 1)) {
            cells++;
        }
        if (isIn(i, j - 1)) {
            cells++;
        }
        if (isIn(i - 1, j + 1)) {
            cells++;
        }
        if (isIn(i - 1, j - 1)) {
            cells++;
        }
        if (isIn(i + 1, j - 1)) {
            cells++;
        }
        if (isIn(i + 1, j + 1)) {
            cells++;
        }

        return cells;
    }


    //calculate the total amount of specific cell with his neighbors
    private int cellsSum(int i, int j) {
        int sum = _array[i][j];

        if (isIn(i + 1, j)) {
            sum += _array[i + 1][j];
        }
        if (isIn(i - 1, j)) {
            sum += _array[i - 1][j];
        }
        if (isIn(i, j + 1)) {
            sum += _array[i][j + 1];
        }
        if (isIn(i, j - 1)) {
            sum += _array[i][j - 1];
        }
        if (isIn(i - 1, j + 1)) {
            sum += _array[i - 1][j + 1];
        }
        if (isIn(i - 1, j - 1)) {
            sum += _array[i - 1][j - 1];
        }
        if (isIn(i + 1, j - 1)) {
            sum += _array[i + 1][j - 1];
        }
        if (isIn(i + 1, j + 1)) {
            sum += _array[i + 1][j + 1];
        }

        return sum;
    }
    //copy constructor
    private Matrix (Matrix m){
        this(m._array);
    }


    /*  // create a random matrix just for checks

    public Matrix createRandomMatrix (){
        Matrix M = new Matrix(_rows,_columns);

        for (int i = 0; i < _array.length; i++) {
            for (int j = 0; j < _array[i].length; j++) {
                M._array[i][j] =(int) (Math.random()*100);
            }
        }return M;
    }*/
}
