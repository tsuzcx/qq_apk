package com.tencent.luggage.wxa.mo;

import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class d
  extends a
{
  public static final int CTRL_INDEX = 34;
  public static final String NAME = "pauseVoice";
  
  protected void a(c paramc, com.tencent.luggage.wxa.jx.c paramc1, JSONObject paramJSONObject, int paramInt)
  {
    paramc = paramc.d();
    o.d("MicroMsg.JsApiPausePlayVoice", "pause:%s", new Object[] { paramc });
    if (paramc.a())
    {
      paramc1.a(paramInt, b("ok"));
      return;
    }
    o.b("MicroMsg.JsApiPausePlayVoice", "pause fail %s", new Object[] { paramc });
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("fail:");
    paramJSONObject.append(paramc.b);
    paramc1.a(paramInt, paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mo.d
 * JD-Core Version:    0.7.0.1
 */