package com.tencent.luggage.wxa.an;

import com.tencent.luggage.wxa.am.f;
import com.tencent.luggage.wxa.am.f.a;

public final class c
  implements f.a
{
  private final a a;
  private final long b;
  private final int c;
  
  public c(a parama, long paramLong)
  {
    this(parama, paramLong, 20480);
  }
  
  public c(a parama, long paramLong, int paramInt)
  {
    this.a = parama;
    this.b = paramLong;
    this.c = paramInt;
  }
  
  public f a()
  {
    return new b(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.an.c
 * JD-Core Version:    0.7.0.1
 */