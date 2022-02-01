package com.tencent.luggage.wxa.nb;

import com.tencent.luggage.wxa.oq.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.u;

class a$2
  implements Runnable
{
  a$2(a parama, u paramu) {}
  
  public void run()
  {
    if ((this.a.d()) && (this.a.aj() != null))
    {
      d locald = this.a.aj().getFullscreenImpl();
      if (locald != null)
      {
        locald.c();
        o.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen");
        return;
      }
      o.b("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, state error");
      return;
    }
    o.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, invalid state");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nb.a.2
 * JD-Core Version:    0.7.0.1
 */