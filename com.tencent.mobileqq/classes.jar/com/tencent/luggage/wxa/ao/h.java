package com.tencent.luggage.wxa.ao;

import java.util.Arrays;

public final class h
{
  private int a;
  private long[] b;
  
  public h()
  {
    this(32);
  }
  
  public h(int paramInt)
  {
    this.b = new long[paramInt];
  }
  
  public int a()
  {
    return this.a;
  }
  
  public long a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a)) {
      return this.b[paramInt];
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid index ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", size is ");
    localStringBuilder.append(this.a);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void a(long paramLong)
  {
    int i = this.a;
    long[] arrayOfLong = this.b;
    if (i == arrayOfLong.length) {
      this.b = Arrays.copyOf(arrayOfLong, i * 2);
    }
    arrayOfLong = this.b;
    i = this.a;
    this.a = (i + 1);
    arrayOfLong[i] = paramLong;
  }
  
  public long[] b()
  {
    return Arrays.copyOf(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.h
 * JD-Core Version:    0.7.0.1
 */