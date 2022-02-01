package com.tencent.luggage.wxa.ro;

import com.tencent.luggage.wxa.rr.k;

class c$a
  implements e.c
{
  private int b;
  
  public c$a(c paramc, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(Object paramObject)
  {
    synchronized (this.a)
    {
      c.a(this.a);
      c.b(this.a)[this.b] = paramObject;
      if (c.c(this.a) == c.d(this.a).length) {
        h.a(c.e(this.a), new Object[] { k.b(c.b(this.a)) });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ro.c.a
 * JD-Core Version:    0.7.0.1
 */