package com.tencent.luggage.wxa.nb;

import android.view.View;
import com.tencent.luggage.wxa.oq.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.u;

class a$1
  implements Runnable
{
  a$1(a parama, u paramu, int paramInt) {}
  
  public void run()
  {
    if ((this.a.d()) && (this.a.aj() != null))
    {
      d locald = this.a.aj().getFullscreenImpl();
      View localView = this.a.aj().getWrapperView();
      if ((locald != null) && (localView != null))
      {
        locald.a(localView, this.b);
        o.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, target orientation:%s", new Object[] { Integer.valueOf(this.b) });
        return;
      }
      o.b("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", new Object[] { locald, localView });
      return;
    }
    o.d("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, invalid state");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nb.a.1
 * JD-Core Version:    0.7.0.1
 */