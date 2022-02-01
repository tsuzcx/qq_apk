package com.tencent.luggage.wxa.h;

public final class x$a
{
  public Object a;
  public Object b;
  public int c;
  public long d;
  private long e;
  private long[] f;
  private int[] g;
  private int[] h;
  private int[] i;
  private long[][] j;
  private long k;
  
  public int a(long paramLong)
  {
    long[] arrayOfLong = this.f;
    if (arrayOfLong == null) {
      return -1;
    }
    int m = arrayOfLong.length - 1;
    while (m >= 0)
    {
      arrayOfLong = this.f;
      if ((arrayOfLong[m] != -9223372036854775808L) && (arrayOfLong[m] <= paramLong)) {
        break;
      }
      m -= 1;
    }
    if ((m >= 0) && (!c(m))) {
      return m;
    }
    return -1;
  }
  
  public long a()
  {
    return this.d;
  }
  
  public long a(int paramInt)
  {
    return this.f[paramInt];
  }
  
  public a a(Object paramObject1, Object paramObject2, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramObject1, paramObject2, paramInt, paramLong1, paramLong2, null, null, null, null, (long[][])null, -9223372036854775807L);
  }
  
  public a a(Object paramObject1, Object paramObject2, int paramInt, long paramLong1, long paramLong2, long[] paramArrayOfLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, long[][] paramArrayOfLong1, long paramLong3)
  {
    this.a = paramObject1;
    this.b = paramObject2;
    this.c = paramInt;
    this.d = paramLong1;
    this.e = paramLong2;
    this.f = paramArrayOfLong;
    this.g = paramArrayOfInt1;
    this.h = paramArrayOfInt2;
    this.i = paramArrayOfInt3;
    this.j = paramArrayOfLong1;
    this.k = paramLong3;
    return this;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return paramInt2 < this.h[paramInt1];
  }
  
  public int b(int paramInt)
  {
    return this.i[paramInt];
  }
  
  public int b(long paramLong)
  {
    if (this.f == null) {
      return -1;
    }
    int m = 0;
    for (;;)
    {
      long[] arrayOfLong = this.f;
      if ((m >= arrayOfLong.length) || (arrayOfLong[m] == -9223372036854775808L) || ((paramLong < arrayOfLong[m]) && (!c(m)))) {
        break;
      }
      m += 1;
    }
    if (m < this.f.length) {
      return m;
    }
    return -1;
  }
  
  public long b()
  {
    return b.a(this.e);
  }
  
  public long b(int paramInt1, int paramInt2)
  {
    long[][] arrayOfLong = this.j;
    if (paramInt2 >= arrayOfLong[paramInt1].length) {
      return -9223372036854775807L;
    }
    return arrayOfLong[paramInt1][paramInt2];
  }
  
  public int c()
  {
    long[] arrayOfLong = this.f;
    if (arrayOfLong == null) {
      return 0;
    }
    return arrayOfLong.length;
  }
  
  public boolean c(int paramInt)
  {
    int[] arrayOfInt = this.g;
    return (arrayOfInt[paramInt] != -1) && (this.i[paramInt] == arrayOfInt[paramInt]);
  }
  
  public int d(int paramInt)
  {
    return this.g[paramInt];
  }
  
  public long d()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.x.a
 * JD-Core Version:    0.7.0.1
 */