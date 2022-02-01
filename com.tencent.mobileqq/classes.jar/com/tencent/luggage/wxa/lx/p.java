package com.tencent.luggage.wxa.lx;

import android.app.Activity;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import org.json.JSONObject;

public class p
  extends a
{
  public static final int CTRL_INDEX = 229;
  public static final String NAME = "setScreenBrightness";
  private float a = (0.0F / 0.0F);
  private float b;
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    o.e("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
    if (paramJSONObject == null)
    {
      paramc.a(paramInt, b("fail:data is null"));
      o.b("MicroMsg.JsApiSetScreenBrightness", "data is null");
      return;
    }
    if (!(paramc.getContext() instanceof Activity))
    {
      o.b("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
      paramc.a(paramInt, b("fail:context is not activity"));
      return;
    }
    t.a(new p.1(this, paramJSONObject, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.p
 * JD-Core Version:    0.7.0.1
 */