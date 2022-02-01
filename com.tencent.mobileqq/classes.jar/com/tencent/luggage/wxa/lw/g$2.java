package com.tencent.luggage.wxa.lw;

import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.r;

class g$2
  implements Runnable
{
  g$2(g paramg, l paraml, h paramh, int paramInt, String paramString, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    String str;
    if (this.a.e == null) {
      str = "fail:data not found";
    } else {
      str = "ok";
    }
    g.a(this.g, str, this.a.e, this.a.f, this.b, this.c);
    g.a(this.g, 1, r.a(this.d, this.a.e), this.e, this.b);
    this.a.i();
    o.d("MicroMsg.JsApiGetStorage", "getStorage: %s, time: %d", new Object[] { this.a.d, Long.valueOf(System.currentTimeMillis() - this.f) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.g.2
 * JD-Core Version:    0.7.0.1
 */