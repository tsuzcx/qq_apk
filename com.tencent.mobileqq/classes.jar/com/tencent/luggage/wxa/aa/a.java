package com.tencent.luggage.wxa.aa;

import com.tencent.luggage.wxa.am.g;
import com.tencent.luggage.wxa.am.j;
import com.tencent.luggage.wxa.am.t.c;
import com.tencent.luggage.wxa.h.k;

public abstract class a
  implements t.c
{
  public final j a;
  public final int b;
  public final k c;
  public final int d;
  public final Object e;
  public final long f;
  public final long g;
  protected final g h;
  
  public a(g paramg, j paramj, int paramInt1, k paramk, int paramInt2, Object paramObject, long paramLong1, long paramLong2)
  {
    this.h = ((g)com.tencent.luggage.wxa.ao.a.a(paramg));
    this.a = ((j)com.tencent.luggage.wxa.ao.a.a(paramj));
    this.b = paramInt1;
    this.c = paramk;
    this.d = paramInt2;
    this.e = paramObject;
    this.f = paramLong1;
    this.g = paramLong2;
  }
  
  public abstract long d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.aa.a
 * JD-Core Version:    0.7.0.1
 */