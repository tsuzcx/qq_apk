package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class LongArray
{
  private static final int DEFAULT_INITIAL_CAPACITY = 32;
  private int size;
  private long[] values;
  
  public LongArray()
  {
    this(32);
  }
  
  public LongArray(int paramInt)
  {
    this.values = new long[paramInt];
  }
  
  public void add(long paramLong)
  {
    int i = this.size;
    long[] arrayOfLong = this.values;
    if (i == arrayOfLong.length) {
      this.values = Arrays.copyOf(arrayOfLong, i * 2);
    }
    arrayOfLong = this.values;
    i = this.size;
    this.size = (i + 1);
    arrayOfLong[i] = paramLong;
  }
  
  public long get(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.size)) {
      return this.values[paramInt];
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid index ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", size is ");
    localStringBuilder.append(this.size);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public int size()
  {
    return this.size;
  }
  
  public long[] toArray()
  {
    return Arrays.copyOf(this.values, this.size);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.LongArray
 * JD-Core Version:    0.7.0.1
 */