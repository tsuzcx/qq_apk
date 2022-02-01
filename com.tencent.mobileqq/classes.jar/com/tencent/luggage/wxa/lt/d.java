package com.tencent.luggage.wxa.lt;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
  extends a<com.tencent.luggage.wxa.jx.c>
{
  private static final int CTRL_INDEX = 64;
  private static final String NAME = "reportIDKey";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optJSONArray("dataArray");
    if (paramJSONObject == null)
    {
      paramc.a(paramInt, b("fail"));
      return;
    }
    com.tencent.luggage.wxa.ot.c localc = (com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class);
    if (localc == null)
    {
      paramc.a(paramInt, b("fail:not supported"));
      return;
    }
    int i = 0;
    while (i < paramJSONObject.length())
    {
      try
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        int j = localJSONObject.optInt("id");
        int k = localJSONObject.optInt("key");
        int m = localJSONObject.optInt("value");
        localc.a(j, k, m, false);
      }
      catch (Exception localException)
      {
        o.b("MicroMsg.JsApiReportIDKey", "parse json failed : %s", new Object[] { localException.getMessage() });
      }
      i += 1;
    }
    paramc.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lt.d
 * JD-Core Version:    0.7.0.1
 */