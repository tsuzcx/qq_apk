package com.tencent.luggage.wxa.kf;

import android.annotation.TargetApi;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public class c
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 180;
  private static final String NAME = "createBLEConnection";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.ke.c.a(25);
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiCreateBLEConnection", "createBLEConnection data is null, err");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.a(paramInt, a("fail:invalid data", paramJSONObject));
      return;
    }
    String str1 = paramc.getAppId();
    o.d("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection data %s", new Object[] { str1, paramJSONObject.toString() });
    com.tencent.luggage.wxa.ke.b localb = com.tencent.luggage.wxa.ke.a.a(paramc.getAppId());
    if (localb == null)
    {
      o.b("MicroMsg.JsApiCreateBLEConnection", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.a(paramInt, a("fail:not init", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(27, 30);
      return;
    }
    if (!localb.j())
    {
      o.b("MicroMsg.JsApiCreateBLEConnection", "bleWorker is disable, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.a(paramInt, a("fail:not available", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(27, 32);
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("debug", false);
    boolean bool2 = paramJSONObject.optBoolean("mainThread", true);
    boolean bool3 = paramJSONObject.optBoolean("serial", true);
    long l1 = paramJSONObject.optLong("timeout", 20000L);
    boolean bool4 = paramJSONObject.optBoolean("autoConnect", false);
    String str2 = paramJSONObject.optString("transport", "LE");
    long l2 = paramJSONObject.optLong("discoverDelay", 0L);
    String str3 = paramJSONObject.optString("connectionPriority", null);
    paramJSONObject = paramJSONObject.optString("deviceId");
    com.tencent.luggage.wxa.kj.b localb1 = new com.tencent.luggage.wxa.kj.b(paramJSONObject);
    localb1.i = bool1;
    localb1.j = bool2;
    localb1.k = bool3;
    localb1.l = l1;
    localb1.b = bool4;
    localb1.c = str2;
    localb1.d = l2;
    localb1.e = str3;
    localb.a(paramJSONObject, localb1, new c.1(this, str1, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.c
 * JD-Core Version:    0.7.0.1
 */