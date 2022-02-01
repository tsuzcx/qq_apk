package com.tencent.luggage.wxa.p;

import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.x;

final class m
{
  public final int a;
  public final long[] b;
  public final int[] c;
  public final int d;
  public final long[] e;
  public final int[] f;
  
  public m(long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2)
  {
    int i = paramArrayOfInt1.length;
    int j = paramArrayOfLong2.length;
    boolean bool2 = true;
    boolean bool1;
    if (i == j) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a.a(bool1);
    if (paramArrayOfLong1.length == paramArrayOfLong2.length) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a.a(bool1);
    if (paramArrayOfInt2.length == paramArrayOfLong2.length) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    a.a(bool1);
    this.b = paramArrayOfLong1;
    this.c = paramArrayOfInt1;
    this.d = paramInt;
    this.e = paramArrayOfLong2;
    this.f = paramArrayOfInt2;
    this.a = paramArrayOfLong1.length;
  }
  
  public int a(long paramLong)
  {
    int i = x.a(this.e, paramLong, true, false);
    while (i >= 0)
    {
      if ((this.f[i] & 0x1) != 0) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public int b(long paramLong)
  {
    int i = x.b(this.e, paramLong, true, false);
    while (i < this.e.length)
    {
      if ((this.f[i] & 0x1) != 0) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.m
 * JD-Core Version:    0.7.0.1
 */