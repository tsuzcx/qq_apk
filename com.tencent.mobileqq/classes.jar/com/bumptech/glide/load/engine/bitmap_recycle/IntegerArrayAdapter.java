package com.bumptech.glide.load.engine.bitmap_recycle;

public final class IntegerArrayAdapter
  implements ArrayAdapterInterface<int[]>
{
  public int a(int[] paramArrayOfInt)
  {
    return paramArrayOfInt.length;
  }
  
  public String a()
  {
    return "IntegerArrayPool";
  }
  
  public int b()
  {
    return 4;
  }
  
  public int[] b(int paramInt)
  {
    return new int[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.IntegerArrayAdapter
 * JD-Core Version:    0.7.0.1
 */