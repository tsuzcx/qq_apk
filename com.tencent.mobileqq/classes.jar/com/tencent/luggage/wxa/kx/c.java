package com.tencent.luggage.wxa.kx;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class c<CONTEXT extends com.tencent.luggage.wxa.jx.c>
  extends a<CONTEXT>
{
  private static final int CTRL_INDEX = 587;
  private static final String NAME = "disableLocationUpdate";
  protected j a;
  
  public void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.AppBrand.JsApiDisableLocationUpdate", "disableLocationUpdate invoke");
    this.a = ((j)paramCONTEXT.c(j.class));
    paramJSONObject = this.a;
    if (paramJSONObject == null)
    {
      o.d("MicroMsg.AppBrand.JsApiDisableLocationUpdate", "fail:location update not enabled");
      paramCONTEXT.a(paramInt, b("fail:location update not enabled"));
      return;
    }
    paramJSONObject.j();
    paramCONTEXT.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.c
 * JD-Core Version:    0.7.0.1
 */