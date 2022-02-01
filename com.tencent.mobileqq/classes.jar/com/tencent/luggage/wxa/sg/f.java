package com.tencent.luggage.wxa.sg;

import java.util.concurrent.TimeUnit;

public class f
  extends b
{
  private final float b;
  private final long c;
  
  public f(long paramLong, float paramFloat, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.b = paramFloat;
    this.c = paramLong;
  }
  
  public long a(g paramg, TimeUnit paramTimeUnit)
  {
    int i = paramg.c("incrementCount", 1);
    long l = ((float)this.c + i * this.b);
    paramg.a("incrementCount", i + 1);
    return paramTimeUnit.convert(l, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sg.f
 * JD-Core Version:    0.7.0.1
 */