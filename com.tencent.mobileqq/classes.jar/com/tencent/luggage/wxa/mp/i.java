package com.tencent.luggage.wxa.mp;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.mo.g;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class i
  extends b
{
  public static final int CTRL_INDEX = 32;
  public static final String NAME = "stopRecord";
  
  public void b(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = (e)paramc.a(e.class);
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiStopRecord", "luggageRecorder is null, return");
      paramc.a(paramInt, b("fail:internal error"));
      return;
    }
    paramJSONObject = paramJSONObject.j();
    o.d("MicroMsg.JsApiStopRecord", "startRecord result:%s", new Object[] { paramJSONObject });
    if ((paramJSONObject == null) || (!paramJSONObject.a())) {
      o.b("MicroMsg.JsApiStopRecord", "startRecord fail");
    }
    paramc.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.i
 * JD-Core Version:    0.7.0.1
 */