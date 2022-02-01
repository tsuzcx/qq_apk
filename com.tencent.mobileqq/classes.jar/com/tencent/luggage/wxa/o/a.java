package com.tencent.luggage.wxa.o;

import com.tencent.luggage.wxa.ao.x;

final class a
  implements b.a
{
  private final long a;
  private final int b;
  private final long c;
  
  public a(long paramLong1, int paramInt, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramInt;
    if (paramLong2 == -1L) {
      paramLong1 = -9223372036854775807L;
    } else {
      paramLong1 = a(paramLong2);
    }
    this.c = paramLong1;
  }
  
  public long a(long paramLong)
  {
    return Math.max(0L, paramLong - this.a) * 1000000L * 8L / this.b;
  }
  
  public boolean a()
  {
    return this.c != -9223372036854775807L;
  }
  
  public long b()
  {
    return this.c;
  }
  
  public long b(long paramLong)
  {
    long l = this.c;
    if (l == -9223372036854775807L) {
      return 0L;
    }
    paramLong = x.a(paramLong, 0L, l);
    return this.a + paramLong * this.b / 8000000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.o.a
 * JD-Core Version:    0.7.0.1
 */