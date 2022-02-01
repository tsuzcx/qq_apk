package com.tencent.luggage.wxa.ao;

public final class u
{
  private long a;
  private long b;
  private volatile long c = -9223372036854775807L;
  
  public u(long paramLong)
  {
    a(paramLong);
  }
  
  public static long d(long paramLong)
  {
    return paramLong * 1000000L / 90000L;
  }
  
  public static long e(long paramLong)
  {
    return paramLong * 90000L / 1000000L;
  }
  
  public long a()
  {
    return this.a;
  }
  
  public void a(long paramLong)
  {
    for (;;)
    {
      try
      {
        if (this.c == -9223372036854775807L)
        {
          bool = true;
          a.b(bool);
          this.a = paramLong;
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public long b()
  {
    long l2 = this.c;
    long l1 = -9223372036854775807L;
    if (l2 != -9223372036854775807L) {
      return this.c;
    }
    l2 = this.a;
    if (l2 != 9223372036854775807L) {
      l1 = l2;
    }
    return l1;
  }
  
  public long b(long paramLong)
  {
    if (paramLong == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    long l1 = paramLong;
    if (this.c != -9223372036854775807L)
    {
      long l3 = e(this.c);
      l1 = (4294967296L + l3) / 8589934592L;
      long l2 = (l1 - 1L) * 8589934592L + paramLong;
      paramLong += l1 * 8589934592L;
      l1 = paramLong;
      if (Math.abs(l2 - l3) < Math.abs(paramLong - l3)) {
        l1 = l2;
      }
    }
    return c(d(l1));
  }
  
  public long c()
  {
    if (this.a == 9223372036854775807L) {
      return 0L;
    }
    if (this.c == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    return this.b;
  }
  
  public long c(long paramLong)
  {
    if (paramLong == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    if (this.c != -9223372036854775807L)
    {
      this.c = paramLong;
    }
    else
    {
      long l = this.a;
      if (l != 9223372036854775807L) {
        this.b = (l - paramLong);
      }
    }
    try
    {
      this.c = paramLong;
      notifyAll();
      return paramLong + this.b;
    }
    finally {}
  }
  
  public void d()
  {
    this.c = -9223372036854775807L;
  }
  
  public void e()
  {
    try
    {
      while (this.c == -9223372036854775807L) {
        wait();
      }
      return;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.u
 * JD-Core Version:    0.7.0.1
 */