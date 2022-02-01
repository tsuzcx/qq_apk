package com.tencent.luggage.wxa.nf;

import com.tencent.luggage.wxa.oq.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.u;

class c$2
  implements Runnable
{
  c$2(c paramc, u paramu) {}
  
  public void run()
  {
    if ((this.a.d()) && (this.a.aj() != null))
    {
      d locald = this.a.aj().getFullscreenImpl();
      if (locald != null)
      {
        locald.c();
        o.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen");
        return;
      }
      o.b("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, state error");
      return;
    }
    o.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, invalid state");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.c.2
 * JD-Core Version:    0.7.0.1
 */