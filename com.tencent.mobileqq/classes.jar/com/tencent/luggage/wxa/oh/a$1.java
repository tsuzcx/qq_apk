package com.tencent.luggage.wxa.oh;

import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.iu.i.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.q;

class a$1
  implements i.b
{
  a$1(a parama) {}
  
  @UiThread
  public void a()
  {
    o.d("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| onRuntimeReady %s", new Object[] { a.a(this.a).getAppId() });
    Object localObject = a.b(this.a).q();
    if (localObject != null)
    {
      q localq = (q)a.c(this.a).getJsRuntime().a(q.class);
      localObject = new a.1.1(this, (d)localObject);
      if (localq.l())
      {
        ((Runnable)localObject).run();
        return;
      }
      localq.a((Runnable)localObject);
      return;
    }
    throw new IllegalStateException("onRuntimeReady runtime null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oh.a.1
 * JD-Core Version:    0.7.0.1
 */