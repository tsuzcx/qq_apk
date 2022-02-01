package com.tencent.luggage.wxa.jz;

import java.util.HashMap;
import java.util.Map;

class f$1
  extends a
{
  f$1(f paramf, com.tencent.luggage.wxa.jx.c paramc, com.tencent.mm.plugin.appbrand.jsruntime.o paramo, int paramInt) {}
  
  public void d()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: start create audio instance async");
    String str = e.a(this.a);
    HashMap localHashMap = new HashMap();
    localHashMap.put("audioId", str);
    c.a.a(this.a.getAppId()).a(str, this.b);
    this.a.a(this.c, this.d.a("ok", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.f.1
 * JD-Core Version:    0.7.0.1
 */