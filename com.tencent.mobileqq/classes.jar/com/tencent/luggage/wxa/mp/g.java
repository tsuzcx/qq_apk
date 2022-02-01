package com.tencent.luggage.wxa.mp;

import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.jx.k;
import com.tencent.luggage.wxa.rt.i;
import org.json.JSONObject;

public class g
  extends b
{
  public static final int CTRL_INDEX = 295;
  public static final String NAME = "operateRecorder";
  private c.c a;
  
  public void b(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    e locale = (e)paramc.a(e.class);
    if (locale == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiOperateRecorder", "luggageRecorder is null, return");
      paramc.a(paramInt, b("fail:internal error"));
      return;
    }
    Object localObject1;
    if (this.a == null)
    {
      localObject1 = paramc.getAppId();
      this.a = new g.1(this, locale, (String)localObject1);
      com.tencent.luggage.wxa.iu.c.a((String)localObject1, this.a);
    }
    Object localObject2 = paramJSONObject.optString("operationType");
    if ((localObject2 != null) && (((String)localObject2).length() > 0))
    {
      String str = paramc.getAppId();
      localObject1 = (g.a)paramc.c(g.a.class);
      int i = -1;
      switch (((String)localObject2).hashCode())
      {
      default: 
        break;
      case 109757538: 
        if (((String)localObject2).equals("start")) {
          i = 0;
        }
        break;
      case 106440182: 
        if (((String)localObject2).equals("pause")) {
          i = 2;
        }
        break;
      case 3540994: 
        if (((String)localObject2).equals("stop")) {
          i = 3;
        }
        break;
      case -934426579: 
        if (((String)localObject2).equals("resume")) {
          i = 1;
        }
        break;
      }
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3)
            {
              localObject1 = null;
            }
            else
            {
              localObject2 = locale.j();
              locale.b(str, (e.c)localObject1);
              localObject1 = localObject2;
            }
          }
        }
      }
      for (;;)
      {
        break;
        localObject1 = locale.h();
        break;
        localObject1 = locale.i();
        break;
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = new g.a(paramc);
          paramc.a((k)localObject2);
        }
        localObject1 = new e.d();
        ((e.d)localObject1).b = paramJSONObject.optInt("duration");
        ((e.d)localObject1).c = paramJSONObject.optInt("sampleRate");
        ((e.d)localObject1).d = paramJSONObject.optInt("numberOfChannels");
        ((e.d)localObject1).f = paramJSONObject.optInt("encodeBitRate");
        ((e.d)localObject1).e = paramJSONObject.optString("format");
        ((e.d)localObject1).g = paramJSONObject.optDouble("frameSize");
        ((e.d)localObject1).h = e.a.a(paramJSONObject.optString("audioSource"), e.a.a);
        Object localObject3 = paramc.getFileSystem();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("voice_");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append(".");
        localStringBuilder.append(((e.d)localObject1).e);
        localObject3 = ((com.tencent.mm.plugin.appbrand.appstorage.o)localObject3).i(localStringBuilder.toString());
        if (localObject3 == null)
        {
          com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiOperateRecorder", "toTempFilePath, alloc file failed");
          paramc.a(paramInt, b("fail alloc file failed"));
          return;
        }
        ((e.d)localObject1).a = ((i)localObject3).l();
        locale.a(str, (e.c)localObject2);
        localObject3 = locale.a((e.d)localObject1);
        localObject1 = localObject3;
        if (!((com.tencent.luggage.wxa.mo.g)localObject3).a())
        {
          locale.b(str, (e.c)localObject2);
          localObject1 = localObject3;
        }
      }
      if (localObject1 == null)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiOperateRecorder", "result is null, return");
        paramc.a(paramInt, b("fail:internal error"));
        return;
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiOperateRecorder", "data:%s result:%s", new Object[] { paramJSONObject, localObject1 });
      if (((com.tencent.luggage.wxa.mo.g)localObject1).a())
      {
        paramc.a(paramInt, b("ok"));
        return;
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("fail:");
      paramJSONObject.append(((com.tencent.luggage.wxa.mo.g)localObject1).b);
      paramc.a(paramInt, b(paramJSONObject.toString()));
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiOperateRecorder", "operateType is null, return");
    paramc.a(paramInt, b("fail:invalid data"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.g
 * JD-Core Version:    0.7.0.1
 */