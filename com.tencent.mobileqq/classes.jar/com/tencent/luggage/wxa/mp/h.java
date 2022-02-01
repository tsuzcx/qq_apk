package com.tencent.luggage.wxa.mp;

import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.mo.g;
import com.tencent.luggage.wxa.rt.i;
import org.json.JSONObject;

public class h
  extends b
{
  public static final int CTRL_INDEX = 31;
  public static final String NAME = "startRecord";
  private c.c a;
  
  public void b(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    e locale = (e)paramc.a(e.class);
    if (locale == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiStartRecordVoice", "invoke with appId:%s, luggageRecorder is null, return", new Object[] { paramc.getAppId() });
      paramc.a(paramInt, b("fail:internal error"));
      return;
    }
    if (locale.k())
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiStartRecordVoice", "invoke with appId:%s, luggageRecorder is recording, return", new Object[] { paramc.getAppId() });
      paramc.a(paramInt, b("fail:audio is recording, don't start record again"));
      return;
    }
    Object localObject1 = paramc.getFileSystem();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("voice_");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(".pcm");
    localObject2 = ((com.tencent.mm.plugin.appbrand.appstorage.o)localObject1).i(((StringBuilder)localObject2).toString());
    if (localObject2 == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiStartRecordVoice", "toTempFilePath, alloc file failed");
      paramc.a(paramInt, b("fail alloc file failed"));
      return;
    }
    localObject1 = new e.d();
    ((e.d)localObject1).a = ((i)localObject2).l();
    if (paramJSONObject.has("duration"))
    {
      ((e.d)localObject1).b = (paramJSONObject.optInt("duration") * 1000);
      if (((e.d)localObject1).b <= 0)
      {
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
        ((e.d)localObject1).b = 60000;
      }
      if (((e.d)localObject1).b > 600000)
      {
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", new Object[] { Integer.valueOf(600000) });
        ((e.d)localObject1).b = 600000;
      }
    }
    if (this.a == null)
    {
      localObject2 = paramc.getAppId();
      this.a = new h.1(this, locale, (String)localObject2);
      com.tencent.luggage.wxa.iu.c.a((String)localObject2, this.a);
    }
    localObject2 = paramc.getAppId();
    h.a locala = (h.a)paramc.c(h.a.class);
    if (locala != null) {
      locale.b((String)localObject2, locala);
    }
    locala = new h.a(paramc, this, paramInt, paramJSONObject);
    locale.a((String)localObject2, locala);
    localObject1 = locale.a((e.d)localObject1);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiStartRecordVoice", "startRecord data:%s result:%s", new Object[] { paramJSONObject, localObject1 });
    if ((localObject1 != null) && (((g)localObject1).a())) {
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiStartRecordVoice", "startRecord fail");
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("fail:");
    paramJSONObject.append(((g)localObject1).b);
    paramc.a(paramInt, b(paramJSONObject.toString()));
    locale.b((String)localObject2, locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.h
 * JD-Core Version:    0.7.0.1
 */