package com.tencent.av.opengl.utils;

public class IntArray
{
  private int jdField_a_of_type_Int = 0;
  private int[] jdField_a_of_type_ArrayOfInt = new int[8];
  
  public int a()
  {
    this.jdField_a_of_type_Int -= 1;
    return this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int];
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_ArrayOfInt.length != 8) {
      this.jdField_a_of_type_ArrayOfInt = new int[8];
    }
  }
  
  public void a(int paramInt)
  {
    int[] arrayOfInt1 = this.jdField_a_of_type_ArrayOfInt;
    int i = arrayOfInt1.length;
    int j = this.jdField_a_of_type_Int;
    if (i == j)
    {
      int[] arrayOfInt2 = new int[j + j];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, j);
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt2;
    }
    arrayOfInt1 = this.jdField_a_of_type_ArrayOfInt;
    i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    arrayOfInt1[i] = paramInt;
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public int[] a(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt != null)
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= this.jdField_a_of_type_Int) {}
    }
    else
    {
      arrayOfInt = new int[this.jdField_a_of_type_Int];
    }
    System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, 0, this.jdField_a_of_type_Int);
    return arrayOfInt;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.utils.IntArray
 * JD-Core Version:    0.7.0.1
 */