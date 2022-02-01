package com.tencent.luggage.wxa.sg;

import java.util.concurrent.TimeUnit;

public class c
  extends b
{
  private long b;
  
  public c(long paramLong, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.b = paramLong;
  }
  
  public long a(g paramg, TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.b, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sg.c
 * JD-Core Version:    0.7.0.1
 */