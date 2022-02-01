package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.bd;
import com.tencent.mm.plugin.appbrand.page.u;

class e$1
  implements Runnable
{
  e$1(e parame, b paramb, int paramInt) {}
  
  public void run()
  {
    u localu = bd.a(this.a);
    if (localu == null)
    {
      this.a.a(this.b, this.c.b("fail:page don't exist"));
      return;
    }
    localu.g(false);
    this.a.a(this.b, this.c.b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.e.1
 * JD-Core Version:    0.7.0.1
 */