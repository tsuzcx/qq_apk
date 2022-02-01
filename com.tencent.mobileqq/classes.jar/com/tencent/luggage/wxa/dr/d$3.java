package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.u;
import com.tencent.mm.websocket.libwcwss.WcwssNative;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener;

class d$3
  implements Runnable
{
  d$3(d paramd, i parami, WcwssNative.IWcWssWebSocketListener paramIWcWssWebSocketListener, WcwssNative.IWcWssReportListener paramIWcWssReportListener) {}
  
  public void run()
  {
    o.d("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback ");
    if (d.d(this.d) != null)
    {
      o.b("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mContextId != null");
      return;
    }
    Object localObject = (u)this.a.a(u.class);
    if (localObject == null)
    {
      o.b("Luggage.WcWssNativeInstallHelper", "createWcWssBinding v8Addon is null");
      return;
    }
    d.a(this.d, new WcwssNative());
    if (d.a(this.d) != null)
    {
      d locald;
      if (d.e(this.d))
      {
        locald = this.d;
        d.a(locald, d.a(locald).initWcwss(((u)localObject).k(), ((u)localObject).j(), 0L));
      }
      else
      {
        locald = this.d;
        d.a(locald, d.a(locald).initWcwss(((u)localObject).k(), ((u)localObject).j(), 0L));
      }
      localObject = this.d;
      d.a((d)localObject, d.a((d)localObject).setCallback(this.b, this.c));
      o.d("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback mContextId:%s,mInitCallBack:%d", new Object[] { d.d(this.d), Integer.valueOf(d.f(this.d)) });
      return;
    }
    o.b("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mWcwssNative = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.d.3
 * JD-Core Version:    0.7.0.1
 */