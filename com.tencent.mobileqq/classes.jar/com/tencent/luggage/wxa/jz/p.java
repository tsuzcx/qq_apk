package com.tencent.luggage.wxa.jz;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class p
  extends com.tencent.luggage.wxa.jx.a
{
  public static final int CTRL_INDEX = 481;
  public static final String NAME = "setInnerAudioOption";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    String str = paramc.getAppId();
    o.d("MicroMsg.Audio.JsApiSetInnerAudioOption", "data:%s, appId:%s", new Object[] { paramJSONObject, str });
    com.tencent.luggage.wxa.if.a locala2 = com.tencent.luggage.wxa.if.c.a();
    com.tencent.luggage.wxa.if.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new com.tencent.luggage.wxa.if.a();
    }
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(locala1.c)) && (!str.equalsIgnoreCase(locala1.c)))
    {
      locala1.a();
      o.d("MicroMsg.Audio.JsApiSetInnerAudioOption", "reset AudioContextParam");
    }
    locala1.c = str;
    if (paramJSONObject.has("mixWithOther")) {
      locala1.a = paramJSONObject.optBoolean("mixWithOther", true);
    }
    if (paramJSONObject.has("speakerOn")) {
      locala1.b = paramJSONObject.optBoolean("speakerOn", true);
    }
    if (!locala1.b) {
      locala1.a = false;
    }
    com.tencent.luggage.wxa.if.c.a(locala1);
    paramc.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.p
 * JD-Core Version:    0.7.0.1
 */