package com.tencent.luggage.wxa.jz;

import android.text.TextUtils;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class h
  extends a
{
  public static final int CTRL_INDEX = 293;
  public static final String NAME = "getAudioState";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
      paramc.a(paramInt, b("fail:data is null"));
      return;
    }
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      o.b("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
      paramc.a(paramInt, b("fail:audioId is empty"));
      return;
    }
    h.a locala = new h.a(this, paramc, paramInt);
    locala.c = paramc.getAppId();
    locala.d = paramJSONObject;
    locala.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.h
 * JD-Core Version:    0.7.0.1
 */