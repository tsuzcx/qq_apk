package com.tencent.mm.plugin.appbrand.jsruntime;

import com.tencent.luggage.wxa.qz.o;

class d$5
  implements Runnable
{
  d$5(d paramd, int paramInt, String paramString) {}
  
  public void run()
  {
    if (d.a(this.c) == 0L)
    {
      o.d("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by invokeCallbackHandler callbackId[%d]", new Object[] { Integer.valueOf(this.a) });
      d locald = this.c;
      d.a(locald, JsBridgeBinding.nativeCreateRuntime(locald.k(), this.c.j()));
    }
    JsBridgeBinding.nativeInvokeCallbackHandler(d.a(this.c), this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.d.5
 * JD-Core Version:    0.7.0.1
 */