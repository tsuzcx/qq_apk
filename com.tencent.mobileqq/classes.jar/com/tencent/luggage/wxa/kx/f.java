package com.tencent.luggage.wxa.kx;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.ix.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class f
  extends d<h>
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  
  protected j a(h paramh)
  {
    return new k(paramh);
  }
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    super.b(paramh, paramJSONObject, paramInt);
    if (!(this.a instanceof k))
    {
      o.c("MicroMsg.AppBrand.JsApiEnableLocationUpdateWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramh.a(paramInt, b("fail:system error"));
      return;
    }
    k localk = (k)this.a;
    paramJSONObject = localk.l();
    if (paramJSONObject != null) {
      paramJSONObject.a();
    }
    if ((paramJSONObject == null) || (localk.a())) {
      paramJSONObject = new i();
    }
    localk.a(paramJSONObject);
    paramJSONObject.a(paramh.q());
    localk.a(new f.1(this, localk, paramh));
    paramJSONObject = localk.m();
    if (paramJSONObject != null) {
      paramh.q().al().b(paramJSONObject);
    }
    if ((paramJSONObject == null) || (localk.a())) {
      paramJSONObject = new f.2(this, localk);
    }
    paramh.q().al().a(paramJSONObject);
    localk.a(paramJSONObject);
    localk.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.f
 * JD-Core Version:    0.7.0.1
 */