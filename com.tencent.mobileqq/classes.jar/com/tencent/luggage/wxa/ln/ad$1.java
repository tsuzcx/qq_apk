package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.bd;
import com.tencent.mm.plugin.appbrand.page.u;

class ad$1
  implements Runnable
{
  ad$1(ad paramad, b paramb, int paramInt) {}
  
  public void run()
  {
    u localu = bd.a(this.a);
    if (localu == null)
    {
      this.a.a(this.b, this.c.b("fail:page don't exist"));
      return;
    }
    localu.g(true);
    this.a.a(this.b, this.c.b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.ad.1
 * JD-Core Version:    0.7.0.1
 */