package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.pp.o;
import com.tencent.mm.plugin.appbrand.page.u;

class h$1
  implements Runnable
{
  h$1(h paramh, u paramu, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    if (o.a(this.a, this.b, this.c, this.d))
    {
      this.a.a(this.e, this.f.b("ok"));
      return;
    }
    this.a.a(this.e, this.f.b("fail:invalid data"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.h.1
 * JD-Core Version:    0.7.0.1
 */