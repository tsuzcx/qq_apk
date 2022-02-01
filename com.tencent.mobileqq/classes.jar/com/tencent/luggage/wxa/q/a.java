package com.tencent.luggage.wxa.q;

import java.io.EOFException;
import java.io.IOException;

final class a
  implements f
{
  private final e a = new e();
  private final long b;
  private final long c;
  private final h d;
  private int e;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;
  
  public a(long paramLong1, long paramLong2, h paramh, int paramInt, long paramLong3)
  {
    boolean bool;
    if ((paramLong1 >= 0L) && (paramLong2 > paramLong1)) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.a(bool);
    this.d = paramh;
    this.b = paramLong1;
    this.c = paramLong2;
    if (paramInt == paramLong2 - paramLong1)
    {
      this.f = paramLong3;
      this.e = 3;
      return;
    }
    this.e = 0;
  }
  
  private long a(long paramLong1, long paramLong2, long paramLong3)
  {
    long l2 = this.c;
    long l1 = this.b;
    paramLong2 = paramLong1 + (paramLong2 * (l2 - l1) / this.f - paramLong3);
    paramLong1 = paramLong2;
    if (paramLong2 < l1) {
      paramLong1 = l1;
    }
    paramLong3 = this.c;
    paramLong2 = paramLong1;
    if (paramLong1 >= paramLong3) {
      paramLong2 = paramLong3 - 1L;
    }
    return paramLong2;
  }
  
  public long a(long paramLong)
  {
    int m = this.e;
    boolean bool;
    if ((m != 3) && (m != 2)) {
      bool = false;
    } else {
      bool = true;
    }
    com.tencent.luggage.wxa.ao.a.a(bool);
    long l1 = 0L;
    if (paramLong == 0L) {
      paramLong = l1;
    } else {
      paramLong = this.d.b(paramLong);
    }
    this.h = paramLong;
    this.e = 2;
    b();
    return this.h;
  }
  
  public long a(long paramLong, com.tencent.luggage.wxa.l.e parame)
  {
    if (this.i == this.j) {
      return -(this.k + 2L);
    }
    long l1 = parame.c();
    if (!a(parame, this.j))
    {
      paramLong = this.i;
      if (paramLong != l1) {
        return paramLong;
      }
      throw new IOException("No ogg page can be found.");
    }
    this.a.a(parame, false);
    parame.a();
    paramLong -= this.a.c;
    int n = this.a.h + this.a.i;
    if ((paramLong >= 0L) && (paramLong <= 72000L))
    {
      parame.b(n);
      return -(this.a.c + 2L);
    }
    if (paramLong < 0L)
    {
      this.j = l1;
      this.l = this.a.c;
    }
    else
    {
      l1 = parame.c();
      l2 = n;
      this.i = (l1 + l2);
      this.k = this.a.c;
      if (this.j - this.i + l2 < 100000L)
      {
        parame.b(n);
        return -(this.k + 2L);
      }
    }
    l1 = this.j;
    long l2 = this.i;
    if (l1 - l2 < 100000L)
    {
      this.j = l2;
      return l2;
    }
    int m;
    if (paramLong <= 0L) {
      m = 2;
    } else {
      m = 1;
    }
    l1 = n * m;
    l2 = parame.c();
    long l3 = this.j;
    long l4 = this.i;
    return Math.min(Math.max(l2 - l1 + paramLong * (l3 - l4) / (this.l - this.k), l4), this.j - 1L);
  }
  
  public long a(com.tencent.luggage.wxa.l.e parame)
  {
    int m = this.e;
    long l1;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m == 3) {
            return -1L;
          }
          throw new IllegalStateException();
        }
        long l2 = this.h;
        l1 = 0L;
        if (l2 != 0L)
        {
          l1 = a(l2, parame);
          if (l1 >= 0L) {
            return l1;
          }
          l1 = a(parame, this.h, -(l1 + 2L));
        }
        this.e = 3;
        return -(l1 + 2L);
      }
    }
    else
    {
      this.g = parame.c();
      this.e = 1;
      l1 = this.c - 65307L;
      if (l1 > this.g) {
        return l1;
      }
    }
    this.f = c(parame);
    this.e = 3;
    return this.g;
  }
  
  long a(com.tencent.luggage.wxa.l.e parame, long paramLong1, long paramLong2)
  {
    this.a.a(parame, false);
    while (this.a.c < paramLong1)
    {
      parame.b(this.a.h + this.a.i);
      paramLong2 = this.a.c;
      this.a.a(parame, false);
    }
    parame.a();
    return paramLong2;
  }
  
  public a.a a()
  {
    if (this.f != 0L) {
      return new a.a(this, null);
    }
    return null;
  }
  
  boolean a(com.tencent.luggage.wxa.l.e parame, long paramLong)
  {
    paramLong = Math.min(paramLong + 3L, this.c);
    byte[] arrayOfByte = new byte[2048];
    int m = arrayOfByte.length;
    for (;;)
    {
      long l1 = parame.c();
      long l2 = m;
      int n = 0;
      if (l1 + l2 > paramLong)
      {
        m = (int)(paramLong - parame.c());
        if (m < 4) {
          return false;
        }
      }
      parame.b(arrayOfByte, 0, m, false);
      int i1;
      for (;;)
      {
        i1 = m - 3;
        if (n >= i1) {
          break;
        }
        if ((arrayOfByte[n] == 79) && (arrayOfByte[(n + 1)] == 103) && (arrayOfByte[(n + 2)] == 103) && (arrayOfByte[(n + 3)] == 83))
        {
          parame.b(n);
          return true;
        }
        n += 1;
      }
      parame.b(i1);
    }
  }
  
  public void b()
  {
    this.i = this.b;
    this.j = this.c;
    this.k = 0L;
    this.l = this.f;
  }
  
  void b(com.tencent.luggage.wxa.l.e parame)
  {
    if (a(parame, this.c)) {
      return;
    }
    throw new EOFException();
  }
  
  long c(com.tencent.luggage.wxa.l.e parame)
  {
    b(parame);
    this.a.a();
    while (((this.a.b & 0x4) != 4) && (parame.c() < this.c))
    {
      this.a.a(parame, false);
      parame.b(this.a.h + this.a.i);
    }
    return this.a.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.q.a
 * JD-Core Version:    0.7.0.1
 */