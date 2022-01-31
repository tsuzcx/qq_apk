package com.tencent.TMG.opengl.utils;

public class IntArray
{
  private static final int INIT_CAPACITY = 8;
  private int[] mData = new int[8];
  private int mSize = 0;
  
  public void add(int paramInt)
  {
    if (this.mData.length == this.mSize)
    {
      arrayOfInt = new int[this.mSize + this.mSize];
      System.arraycopy(this.mData, 0, arrayOfInt, 0, this.mSize);
      this.mData = arrayOfInt;
    }
    int[] arrayOfInt = this.mData;
    int i = this.mSize;
    this.mSize = (i + 1);
    arrayOfInt[i] = paramInt;
  }
  
  public void clear()
  {
    this.mSize = 0;
    if (this.mData.length != 8) {
      this.mData = new int[8];
    }
  }
  
  public int[] getInternalArray()
  {
    return this.mData;
  }
  
  public int removeLast()
  {
    this.mSize -= 1;
    return this.mData[this.mSize];
  }
  
  public int size()
  {
    return this.mSize;
  }
  
  public int[] toArray(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt != null)
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= this.mSize) {}
    }
    else
    {
      arrayOfInt = new int[this.mSize];
    }
    System.arraycopy(this.mData, 0, arrayOfInt, 0, this.mSize);
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.opengl.utils.IntArray
 * JD-Core Version:    0.7.0.1
 */