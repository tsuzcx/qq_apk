package com.tencent.luggage.wxa.lx;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class m
  extends a
{
  public static final int CTRL_INDEX = 535;
  public static final String NAME = "getVolume";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.JsApiGetVolume", "invoke JsApiGetVolume!");
    if (paramc == null)
    {
      o.b("MicroMsg.JsApiGetVolume", "component is null");
      return;
    }
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiGetVolume", "fail:context is null");
      paramc.a(paramInt, b("fail:context is null"));
      return;
    }
    if (!(paramJSONObject instanceof Activity))
    {
      o.b("MicroMsg.JsApiGetVolume", "fail:context is not Activity");
      paramc.a(paramInt, b("fail:context is not Activity"));
      return;
    }
    paramJSONObject = (AudioManager)paramJSONObject.getSystemService("audio");
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiGetVolume", "fail:manager is null");
      paramc.a(paramInt, b("fail:manager is null"));
      return;
    }
    int i = paramJSONObject.getStreamVolume(3);
    int j = paramJSONObject.getStreamMaxVolume(3);
    o.d("MicroMsg.JsApiGetVolume", "JsApiGetVolume %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    paramJSONObject = new HashMap();
    paramJSONObject.put("currentVolume", Integer.valueOf(i));
    paramJSONObject.put("maxVolume", Integer.valueOf(j));
    paramc.a(paramInt, a("ok", paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.m
 * JD-Core Version:    0.7.0.1
 */