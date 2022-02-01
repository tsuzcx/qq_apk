package com.tencent.luggage.wxa.kf;

import android.annotation.TargetApi;
import com.tencent.luggage.wxa.ke.b;
import com.tencent.luggage.wxa.kj.d;
import com.tencent.luggage.wxa.kj.e;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public class k
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 186;
  private static final String NAME = "notifyBLECharacteristicValueChanged";
  public static String a = "notification";
  public static String b = "indication";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.ke.c.a(71);
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "JsApiNotifyBLECharacteristicValueChanged data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.a(paramInt, a("fail:invalid data", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(73, 74);
      return;
    }
    String str2 = paramc.getAppId();
    o.d("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged data %s", new Object[] { str2, paramJSONObject.toString() });
    b localb = com.tencent.luggage.wxa.ke.a.a(paramc.getAppId());
    if (localb == null)
    {
      o.b("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.a(paramInt, a("fail:not init", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(73, 76);
      return;
    }
    if (!localb.j())
    {
      o.b("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.a(paramInt, a("fail:not available", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(73, 79);
      return;
    }
    String str1 = paramJSONObject.optString("deviceId");
    String str3 = paramJSONObject.optString("serviceId");
    String str4 = paramJSONObject.optString("characteristicId");
    boolean bool3 = paramJSONObject.optBoolean("state");
    String str5 = paramJSONObject.optString("type", b);
    boolean bool4 = paramJSONObject.optBoolean("debug", false);
    boolean bool5 = paramJSONObject.optBoolean("mainThread", false);
    boolean bool6 = paramJSONObject.optBoolean("serial", true);
    paramJSONObject = localb.a(str1, str3, str4);
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleCharacteristic is null, may not connect");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10005));
      paramc.a(paramInt, a("fail:no characteristic", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(73);
      return;
    }
    if ((paramJSONObject.e) && (!paramJSONObject.f)) {
      break label404;
    }
    label404:
    boolean bool1;
    if ((paramJSONObject.e) && (paramJSONObject.f) && (str5.toLowerCase().equals(a))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (((!paramJSONObject.e) && (paramJSONObject.f)) || ((paramJSONObject.e) && (paramJSONObject.f) && (str5.toLowerCase().equals(b)))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    o.d("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged isNotify:%b isIndicate:%b", new Object[] { str2, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (bool1)
    {
      paramJSONObject = new e(str3, str4, bool3);
      paramJSONObject.i = bool4;
      paramJSONObject.j = bool5;
      paramJSONObject.k = bool6;
      localb.a(str1, paramJSONObject, new k.1(this, paramc, paramInt));
      return;
    }
    if (bool2)
    {
      paramJSONObject = new d(str3, str4, bool3);
      paramJSONObject.i = bool4;
      paramJSONObject.j = bool5;
      paramJSONObject.k = bool6;
      localb.a(str1, paramJSONObject, new k.2(this, str2, paramc, paramInt));
      return;
    }
    o.d("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify and not support indicate...");
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(10007));
    paramc.a(paramInt, a("fail:internal error", paramJSONObject));
    com.tencent.luggage.wxa.ke.c.a(73, 82);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.k
 * JD-Core Version:    0.7.0.1
 */