package com.tencent.luggage.wxa.kf;

import android.annotation.TargetApi;
import com.tencent.luggage.wxa.ke.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public class a
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 181;
  private static final String NAME = "closeBLEConnection";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.ke.c.a(91);
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiCloseBLEConnection", "JsApiCloseBLEConnection data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.a(paramInt, a("fail:invalid data", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(93, 94);
      return;
    }
    o.d("MicroMsg.JsApiCloseBLEConnection", "appId:%s closeBLEConnection data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    b localb = com.tencent.luggage.wxa.ke.a.a(paramc.getAppId());
    if (localb == null)
    {
      o.b("MicroMsg.JsApiCloseBLEConnection", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.a(paramInt, a("fail:not init", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(93, 96);
      return;
    }
    if (!localb.j())
    {
      o.b("MicroMsg.JsApiCloseBLEConnection", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.a(paramInt, a("fail:not available", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(93, 98);
      return;
    }
    String str = paramJSONObject.optString("deviceId");
    boolean bool1 = paramJSONObject.optBoolean("debug", false);
    boolean bool2 = paramJSONObject.optBoolean("mainThread", true);
    boolean bool3 = paramJSONObject.optBoolean("serial", true);
    paramJSONObject = new com.tencent.luggage.wxa.kj.a();
    paramJSONObject.i = bool1;
    paramJSONObject.j = bool2;
    paramJSONObject.k = bool3;
    localb.a(str, paramJSONObject, new a.1(this, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.a
 * JD-Core Version:    0.7.0.1
 */