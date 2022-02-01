package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.bd;
import com.tencent.mm.plugin.appbrand.page.u;

class w$1
  implements Runnable
{
  w$1(w paramw, b paramb, int paramInt, String paramString) {}
  
  public void run()
  {
    u localu = bd.a(this.a);
    if (localu == null)
    {
      this.a.a(this.b, this.d.b("fail"));
      return;
    }
    localu.g(this.c);
    this.a.a(this.b, this.d.b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.w.1
 * JD-Core Version:    0.7.0.1
 */