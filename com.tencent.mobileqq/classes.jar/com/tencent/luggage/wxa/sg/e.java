package com.tencent.luggage.wxa.sg;

import java.util.concurrent.TimeUnit;

public class e
  extends b
{
  public e(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public long a(g paramg, TimeUnit paramTimeUnit)
  {
    long l1 = paramg.b("INCREMENT", 1L);
    long l2 = paramg.b("LAST_INCREMENT", 0L) + l1;
    paramg.a("LAST_INCREMENT", l1);
    paramg.a("INCREMENT", l2);
    return paramTimeUnit.convert(l2, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sg.e
 * JD-Core Version:    0.7.0.1
 */