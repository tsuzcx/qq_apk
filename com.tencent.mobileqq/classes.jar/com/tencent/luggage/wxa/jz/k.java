package com.tencent.luggage.wxa.jz;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import org.json.JSONObject;

public class k
  extends com.tencent.luggage.wxa.jx.a
{
  public static final int CTRL_INDEX = 297;
  public static final String NAME = "operateAudio";
  private m.a a;
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!com.tencent.luggage.wxa.nq.a.e(paramc.getAppId()))
    {
      o.b("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
      paramc.a(paramInt, b("fail:App is paused or background"));
      return;
    }
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
      paramc.a(paramInt, b("fail:data is null"));
      return;
    }
    o.d("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    String str1 = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("currentTime", 0);
    String str2 = paramJSONObject.optString("operationType");
    if (TextUtils.isEmpty(str1))
    {
      o.b("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
      paramc.a(paramInt, b("fail:audioId is empty"));
      return;
    }
    if (TextUtils.isEmpty(str2))
    {
      o.b("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
      paramc.a(paramInt, b("fail:operationType is empty"));
      return;
    }
    if (this.a == null) {
      this.a = new m.a(paramc);
    }
    this.a.b = paramc.getAppId();
    this.a.a();
    k.a locala = new k.a(this, paramc, paramInt);
    locala.c = paramc.getAppId();
    locala.d = str1;
    locala.f = i;
    locala.e = str2;
    if (str2.equalsIgnoreCase("play"))
    {
      long l2 = 0L;
      long l4 = paramJSONObject.optLong("timestamp", 0L);
      long l3 = System.currentTimeMillis();
      long l1 = l2;
      if (l4 > 0L)
      {
        l1 = l2;
        if (l4 < l3) {
          l1 = l3 - l4;
        }
      }
      locala.k = l1;
      locala.l = l3;
    }
    paramc = com.tencent.luggage.wxa.nq.a.c(str1);
    if (paramc != null)
    {
      locala.g = paramc.b;
      locala.h = paramc.a;
      locala.j = paramc.c;
    }
    locala.i = r.c();
    locala.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.k
 * JD-Core Version:    0.7.0.1
 */