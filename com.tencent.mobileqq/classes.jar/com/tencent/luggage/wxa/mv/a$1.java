package com.tencent.luggage.wxa.mv;

import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.mw.b;
import com.tencent.luggage.wxa.mw.d;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

class a$1
  implements Runnable
{
  a$1(a parama, com.tencent.luggage.wxa.jx.c paramc, m paramm, com.tencent.luggage.wxa.fx.a parama1, JSONObject paramJSONObject, int paramInt) {}
  
  public void run()
  {
    a.a(this.f, this.a);
    m localm = this.b;
    if ((localm instanceof b))
    {
      o.d("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "insert xweb camera");
      a.a(this.f, this.a, this.c, this.d, this.b, this.e);
      return;
    }
    if ((localm instanceof d))
    {
      o.d("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "update xweb camera");
      a.a(this.f, this.a, this.d, this.b, this.e);
      return;
    }
    if ((localm instanceof com.tencent.luggage.wxa.mw.c))
    {
      o.d("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "remove xweb camera");
      a.b(this.f, this.a, this.d, this.b, this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mv.a.1
 * JD-Core Version:    0.7.0.1
 */