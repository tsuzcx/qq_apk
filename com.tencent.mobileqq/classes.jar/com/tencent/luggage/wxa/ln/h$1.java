package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.mm.plugin.appbrand.page.o;
import org.json.JSONObject;

class h$1
  implements Runnable
{
  h$1(h paramh, b paramb, int paramInt, JSONObject paramJSONObject) {}
  
  public void run()
  {
    o localo = this.a.q().C();
    if (localo.getPageCount() <= 1)
    {
      this.a.a(this.b, this.d.b("fail cannot navigate back at first page"));
      return;
    }
    localo.a(this.c.optInt("delta", 1), "scene_jsapi_navigate_back", new h.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.h.1
 * JD-Core Version:    0.7.0.1
 */