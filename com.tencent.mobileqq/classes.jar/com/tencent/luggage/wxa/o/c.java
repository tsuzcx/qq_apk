package com.tencent.luggage.wxa.o;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.l.i;

final class c
  implements b.a
{
  private final long[] a;
  private final long[] b;
  private final long c;
  
  private c(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong)
  {
    this.a = paramArrayOfLong1;
    this.b = paramArrayOfLong2;
    this.c = paramLong;
  }
  
  public static c a(i parami, m paramm, long paramLong1, long paramLong2)
  {
    paramm.d(10);
    int i = paramm.n();
    if (i <= 0) {
      return null;
    }
    int j = parami.d;
    long l1 = i;
    if (j >= 32000) {
      i = 1152;
    } else {
      i = 576;
    }
    long l2 = x.b(l1, 1000000L * i, j);
    int m = paramm.h();
    j = paramm.h();
    int n = paramm.h();
    paramm.d(2);
    l1 = paramLong1 + parami.c;
    i = m + 1;
    parami = new long[i];
    long[] arrayOfLong = new long[i];
    parami[0] = 0L;
    arrayOfLong[0] = l1;
    int k = 1;
    paramLong1 = l2;
    while (k < parami.length)
    {
      if (n != 1)
      {
        if (n != 2)
        {
          if (n != 3)
          {
            if (n != 4) {
              return null;
            }
            i = paramm.t();
          }
          else
          {
            i = paramm.k();
          }
        }
        else {
          i = paramm.h();
        }
      }
      else {
        i = paramm.g();
      }
      l1 = i * j + l1;
      parami[k] = (k * paramLong1 / m);
      if (paramLong2 == -1L) {
        l2 = l1;
      } else {
        l2 = Math.min(paramLong2, l1);
      }
      arrayOfLong[k] = l2;
      k += 1;
    }
    return new c(parami, arrayOfLong, paramLong1);
  }
  
  public long a(long paramLong)
  {
    return this.a[x.a(this.b, paramLong, true, true)];
  }
  
  public boolean a()
  {
    return true;
  }
  
  public long b()
  {
    return this.c;
  }
  
  public long b(long paramLong)
  {
    return this.b[x.a(this.a, paramLong, true, true)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.o.c
 * JD-Core Version:    0.7.0.1
 */