package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class ar
  extends a<com.tencent.luggage.wxa.du.c>
{
  public static final int CTRL_INDEX = 430;
  public static final String NAME = "pageNotFoundCallback";
  
  public void a(com.tencent.luggage.wxa.du.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiPageNotFoundCallback", "data is null, do nothing");
      paramc.a(paramInt, b("fail"));
      return;
    }
    o.d("MicroMsg.JsApiPageNotFoundCallback", "pageNotFoundCallback data:%s", new Object[] { paramJSONObject });
    boolean bool = paramJSONObject.optBoolean("hasHandler", false);
    int i = paramJSONObject.optInt("webviewId", -1);
    paramJSONObject = paramc.f();
    if (bool)
    {
      if (paramJSONObject != null)
      {
        paramJSONObject.a(true);
        if (paramJSONObject.getComponentId() != i) {
          o.b("MicroMsg.JsApiPageNotFoundCallback", "appBrandPageView.getComponentId():%d, webviewId:%d, err", new Object[] { Integer.valueOf(paramJSONObject.getComponentId()), Integer.valueOf(i) });
        }
      }
      else
      {
        o.b("MicroMsg.JsApiPageNotFoundCallback", "appBrandPageView is null");
      }
      o.d("MicroMsg.JsApiPageNotFoundCallback", "already handler, ignore");
      paramc.a(paramInt, b("ok"));
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.getComponentId() == i)) {
      paramJSONObject.a(new ar.1(this, paramJSONObject));
    }
    o.b("MicroMsg.JsApiPageNotFoundCallback", "currentPageView is null, return");
    paramc.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ar
 * JD-Core Version:    0.7.0.1
 */