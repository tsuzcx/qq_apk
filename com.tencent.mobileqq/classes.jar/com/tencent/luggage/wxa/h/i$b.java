package com.tencent.luggage.wxa.h;

import com.tencent.luggage.wxa.z.h.b;

public final class i$b
{
  public final h.b a;
  public final long b;
  public final long c;
  public volatile long d;
  public volatile long e;
  
  public i$b(int paramInt, long paramLong)
  {
    this(new h.b(paramInt), paramLong);
  }
  
  public i$b(h.b paramb, long paramLong)
  {
    this(paramb, paramLong, -9223372036854775807L);
  }
  
  public i$b(h.b paramb, long paramLong1, long paramLong2)
  {
    this.a = paramb;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramLong1;
    this.e = paramLong1;
  }
  
  public b a(int paramInt)
  {
    b localb = new b(this.a.a(paramInt), this.b, this.c);
    localb.d = this.d;
    localb.e = this.e;
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.i.b
 * JD-Core Version:    0.7.0.1
 */