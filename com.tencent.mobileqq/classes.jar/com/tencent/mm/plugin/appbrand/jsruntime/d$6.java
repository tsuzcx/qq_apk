package com.tencent.mm.plugin.appbrand.jsruntime;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class d$6
  implements Runnable
{
  d$6(d paramd, n.a parama, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void run()
  {
    n.b localb;
    if (this.a != null) {
      localb = new n.b();
    } else {
      localb = null;
    }
    if (localb != null) {
      localb.a = System.currentTimeMillis();
    }
    if (d.a(this.f) == 0L)
    {
      o.d("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by subscribeHandler event[%s] src[%d]", new Object[] { this.b, Integer.valueOf(this.c) });
      d locald = this.f;
      d.a(locald, JsBridgeBinding.nativeCreateRuntime(locald.k(), this.f.j()));
    }
    JsBridgeBinding.nativeSubscribeHandler(d.a(this.f), af.b(this.b), af.b(this.d), this.c, af.b(this.e));
    if (localb != null)
    {
      localb.b = System.currentTimeMillis();
      this.a.a("", localb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.d.6
 * JD-Core Version:    0.7.0.1
 */