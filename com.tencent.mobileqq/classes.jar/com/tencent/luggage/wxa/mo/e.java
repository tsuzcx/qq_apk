package com.tencent.luggage.wxa.mo;

import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.rt.i;
import org.json.JSONObject;

public class e
  extends a
{
  public static final int CTRL_INDEX = 33;
  public static final String NAME = "playVoice";
  private c.c a;
  
  protected void a(c paramc, com.tencent.luggage.wxa.jx.c paramc1, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiStartPlayVoice", "playVoice invalid data");
      paramc1.a(paramInt, b("fail:invalid data"));
      return;
    }
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (af.c(paramJSONObject))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiStartPlayVoice", "filePath is null", new Object[] { d() });
      paramc1.a(paramInt, b("fail:invalid data"));
      return;
    }
    Object localObject = paramc1.getFileSystem().g(paramJSONObject);
    if ((localObject != null) && (((i)localObject).j()))
    {
      if (this.a == null)
      {
        paramJSONObject = paramc1.getAppId();
        this.a = new e.1(this, paramc, paramJSONObject);
        com.tencent.luggage.wxa.iu.c.a(paramJSONObject, this.a);
      }
      paramJSONObject = new e.2(this, paramc1, paramInt, paramc);
      paramc.a(paramJSONObject);
      localObject = paramc.a(((i)localObject).l());
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiStartPlayVoice", "play:%s", new Object[] { localObject });
      if (!((g)localObject).a())
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiStartPlayVoice", "play fail %s", new Object[] { localObject });
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fail:");
        localStringBuilder.append(((g)localObject).b);
        paramc1.a(paramInt, localStringBuilder.toString());
        paramc.b(paramJSONObject);
      }
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiStartPlayVoice", "file is null, return");
    paramc1.a(paramInt, b("file is not exist"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mo.e
 * JD-Core Version:    0.7.0.1
 */