package com.tencent.luggage.wxa.o;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.l.i;

final class d
  implements b.a
{
  private final long a;
  private final long b;
  private final long c;
  private final long[] d;
  private final long e;
  private final int f;
  
  private d(long paramLong1, long paramLong2, long paramLong3)
  {
    this(paramLong1, paramLong2, paramLong3, null, 0L, 0);
  }
  
  private d(long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong, long paramLong4, int paramInt)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramArrayOfLong;
    this.e = paramLong4;
    this.f = paramInt;
  }
  
  private long a(int paramInt)
  {
    return this.b * paramInt / 100L;
  }
  
  public static d a(i parami, m paramm, long paramLong1, long paramLong2)
  {
    int i = parami.g;
    int j = parami.d;
    paramLong1 += parami.c;
    int k = paramm.n();
    if ((k & 0x1) == 1)
    {
      int m = paramm.t();
      if (m != 0)
      {
        long l1 = x.b(m, i * 1000000L, j);
        if ((k & 0x6) != 6) {
          return new d(paramLong1, l1, paramLong2);
        }
        long l2 = paramm.t();
        paramm.d(1);
        long[] arrayOfLong = new long[99];
        i = 0;
        while (i < 99)
        {
          arrayOfLong[i] = paramm.g();
          i += 1;
        }
        return new d(paramLong1, l1, paramLong2, arrayOfLong, l2, parami.c);
      }
    }
    return null;
  }
  
  public long a(long paramLong)
  {
    boolean bool = a();
    long l2 = 0L;
    if (bool)
    {
      long l1 = this.a;
      if (paramLong < l1) {
        return 0L;
      }
      double d1 = paramLong - l1;
      Double.isNaN(d1);
      double d2 = this.e;
      Double.isNaN(d2);
      d1 = d1 * 256.0D / d2;
      int i = x.a(this.d, d1, true, false) + 1;
      long l3 = a(i);
      if (i == 0) {
        paramLong = 0L;
      } else {
        paramLong = this.d[(i - 1)];
      }
      if (i == 99) {
        l1 = 256L;
      } else {
        l1 = this.d[i];
      }
      long l4 = a(i + 1);
      if (l1 == paramLong)
      {
        paramLong = l2;
      }
      else
      {
        d2 = l4 - l3;
        double d3 = paramLong;
        Double.isNaN(d3);
        Double.isNaN(d2);
        double d4 = l1 - paramLong;
        Double.isNaN(d4);
        paramLong = (d2 * (d1 - d3) / d4);
      }
      return l3 + paramLong;
    }
    return 0L;
  }
  
  public boolean a()
  {
    return this.d != null;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public long b(long paramLong)
  {
    if (!a()) {
      return this.a;
    }
    float f3 = (float)paramLong * 100.0F / (float)this.b;
    float f1 = 256.0F;
    float f2 = 0.0F;
    if (f3 <= 0.0F)
    {
      f1 = 0.0F;
    }
    else if (f3 < 100.0F)
    {
      int i = (int)f3;
      if (i != 0) {
        f2 = (float)this.d[(i - 1)];
      }
      if (i < 99) {
        f1 = (float)this.d[i];
      }
      f1 = (f1 - f2) * (f3 - i) + f2;
    }
    double d1 = f1;
    Double.isNaN(d1);
    double d2 = this.e;
    Double.isNaN(d2);
    long l1 = Math.round(d1 * 0.00390625D * d2);
    long l2 = this.a;
    paramLong = this.c;
    if (paramLong != -1L) {
      paramLong -= 1L;
    } else {
      paramLong = l2 - this.f + this.e - 1L;
    }
    return Math.min(l1 + l2, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.o.d
 * JD-Core Version:    0.7.0.1
 */