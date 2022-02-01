package com.tencent.luggage.wxa.p;

import com.tencent.luggage.wxa.ao.x;

final class d
{
  public static d.a a(int paramInt, long[] paramArrayOfLong, int[] paramArrayOfInt, long paramLong)
  {
    int i1 = 8192 / paramInt;
    int k = paramArrayOfInt.length;
    int m = 0;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += x.a(paramArrayOfInt[i], i1);
      i += 1;
    }
    long[] arrayOfLong1 = new long[j];
    int[] arrayOfInt1 = new int[j];
    long[] arrayOfLong2 = new long[j];
    int[] arrayOfInt2 = new int[j];
    j = 0;
    k = 0;
    int n = 0;
    i = m;
    while (i < paramArrayOfInt.length)
    {
      m = paramArrayOfInt[i];
      long l = paramArrayOfLong[i];
      while (m > 0)
      {
        int i2 = Math.min(i1, m);
        arrayOfLong1[j] = l;
        arrayOfInt1[j] = (paramInt * i2);
        n = Math.max(n, arrayOfInt1[j]);
        arrayOfLong2[j] = (k * paramLong);
        arrayOfInt2[j] = 1;
        l += arrayOfInt1[j];
        k += i2;
        m -= i2;
        j += 1;
      }
      i += 1;
    }
    return new d.a(arrayOfLong1, arrayOfInt1, n, arrayOfLong2, arrayOfInt2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.d
 * JD-Core Version:    0.7.0.1
 */