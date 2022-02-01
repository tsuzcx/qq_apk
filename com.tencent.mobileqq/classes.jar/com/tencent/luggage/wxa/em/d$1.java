package com.tencent.luggage.wxa.em;

import com.tencent.luggage.wxa.dd.b.a;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.mm.plugin.appbrand.jsruntime.i;

class d$1
  implements b.a
{
  d$1(d paramd) {}
  
  public void a() {}
  
  public void b()
  {
    if (this.a.au()) {
      return;
    }
    if (this.a.D() == d.a.a)
    {
      this.a.E();
      return;
    }
    if (this.a.ae() == null) {
      return;
    }
    this.a.ae().getJsRuntime().evaluateJavascript("if (wx && wx.logout) { wx.logout(function(res){}); }", new d.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.d.1
 * JD-Core Version:    0.7.0.1
 */