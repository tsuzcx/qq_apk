package com.tencent.luggage.wxa.jz;

import android.text.TextUtils;
import org.json.JSONObject;

public class g
  extends com.tencent.luggage.wxa.jx.a
{
  public static final int CTRL_INDEX = 290;
  public static final String NAME = "destroyAudioInstance";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    a(paramc, paramJSONObject, paramInt, paramc.getJsRuntime());
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt, com.tencent.mm.plugin.appbrand.jsruntime.o paramo)
  {
    if (paramJSONObject == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
      paramc.a(paramInt, b("fail:data is null"));
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", new Object[] { paramJSONObject.toString() });
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
      paramc.a(paramInt, b("fail:audioId is empty"));
      return;
    }
    paramo = new g.a(this, paramc, paramInt);
    paramo.c = paramc.getAppId();
    paramo.d = paramJSONObject;
    paramo.a();
    c.a.a(paramc.getAppId()).b(paramJSONObject);
  }
  
  public boolean e()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.g
 * JD-Core Version:    0.7.0.1
 */