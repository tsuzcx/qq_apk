package com.tencent.av.opengl.utils;

public class IntArray
{
  private int[] a = new int[8];
  private int b = 0;
  
  public int a()
  {
    this.b -= 1;
    return this.a[this.b];
  }
  
  public void a(int paramInt)
  {
    int[] arrayOfInt1 = this.a;
    int i = arrayOfInt1.length;
    int j = this.b;
    if (i == j)
    {
      int[] arrayOfInt2 = new int[j + j];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, j);
      this.a = arrayOfInt2;
    }
    arrayOfInt1 = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfInt1[i] = paramInt;
  }
  
  public int[] a(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt != null)
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= this.b) {}
    }
    else
    {
      arrayOfInt = new int[this.b];
    }
    System.arraycopy(this.a, 0, arrayOfInt, 0, this.b);
    return arrayOfInt;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int[] c()
  {
    return this.a;
  }
  
  public void d()
  {
    this.b = 0;
    if (this.a.length != 8) {
      this.a = new int[8];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.utils.IntArray
 * JD-Core Version:    0.7.0.1
 */