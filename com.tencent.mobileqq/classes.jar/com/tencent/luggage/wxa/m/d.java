package com.tencent.luggage.wxa.m;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.l.l;

abstract class d
{
  protected final l a;
  
  protected d(l paraml)
  {
    this.a = paraml;
  }
  
  protected abstract void a(m paramm, long paramLong);
  
  protected abstract boolean a(m paramm);
  
  public final void b(m paramm, long paramLong)
  {
    if (a(paramm)) {
      a(paramm, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.m.d
 * JD-Core Version:    0.7.0.1
 */