package com.tencent.luggage.wxa.mo;

import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class f
  extends a
{
  public static final int CTRL_INDEX = 35;
  public static final String NAME = "stopVoice";
  
  protected void a(c paramc, com.tencent.luggage.wxa.jx.c paramc1, JSONObject paramJSONObject, int paramInt)
  {
    paramc = paramc.e();
    o.d("MicroMsg.JsApiStopPlayVoice", "stop:%s", new Object[] { paramc });
    if (paramc.a())
    {
      paramc1.a(paramInt, b("ok"));
      return;
    }
    o.b("MicroMsg.JsApiStopPlayVoice", "stop fail %s", new Object[] { paramc });
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("fail:");
    paramJSONObject.append(paramc.b);
    paramc1.a(paramInt, paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mo.f
 * JD-Core Version:    0.7.0.1
 */