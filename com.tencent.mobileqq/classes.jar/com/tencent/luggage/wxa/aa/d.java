package com.tencent.luggage.wxa.aa;

import com.tencent.luggage.wxa.am.g;
import com.tencent.luggage.wxa.am.j;
import com.tencent.luggage.wxa.h.k;

public abstract class d
  extends a
{
  public final int i;
  
  public d(g paramg, j paramj, k paramk, int paramInt1, Object paramObject, long paramLong1, long paramLong2, int paramInt2)
  {
    super(paramg, paramj, 1, paramk, paramInt1, paramObject, paramLong1, paramLong2);
    com.tencent.luggage.wxa.ao.a.a(paramk);
    this.i = paramInt2;
  }
  
  public int e()
  {
    return this.i + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.aa.d
 * JD-Core Version:    0.7.0.1
 */