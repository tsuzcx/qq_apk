package com.tencent.luggage.wxa.kv;

import android.annotation.TargetApi;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public class d
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 221;
  private static final String NAME = "startBeaconDiscovery";
  private c.c a = null;
  private a.a.a b;
  
  private UUID[] a(JSONObject paramJSONObject)
  {
    boolean bool = paramJSONObject.has("uuids");
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if (bool) {
      localObject1 = localObject3;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(paramJSONObject.optString("uuids"));
      localObject1 = localObject3;
      paramJSONObject = new UUID[localJSONArray.length()];
      int i = 0;
      for (;;)
      {
        localObject2 = paramJSONObject;
        localObject1 = paramJSONObject;
        if (i >= localJSONArray.length()) {
          break;
        }
        localObject1 = paramJSONObject;
        localObject2 = localJSONArray.getString(i);
        localObject1 = paramJSONObject;
        o.e("MicroMsg.JsApiStartBeaconDiscovery", "uuid %s", new Object[] { localObject2 });
        localObject1 = paramJSONObject;
        paramJSONObject[i] = UUID.fromString((String)localObject2);
        i += 1;
      }
    }
    catch (JSONException paramJSONObject)
    {
      label114:
      break label114;
    }
    o.b("MicroMsg.JsApiStartBeaconDiscovery", "get uuid error!");
    localObject2 = localObject1;
    return localObject2;
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.JsApiStartBeaconDiscovery", "startBeaconDiscovery data %s", new Object[] { paramJSONObject });
    UUID[] arrayOfUUID = a(paramJSONObject);
    if ((arrayOfUUID != null) && (arrayOfUUID.length > 0))
    {
      String str = paramc.getAppId();
      Object localObject = a.a(paramc.getAppId());
      paramJSONObject = (JSONObject)localObject;
      if (localObject == null)
      {
        o.d("MicroMsg.JsApiStartBeaconDiscovery", "beaconWorker init");
        paramJSONObject = new a.a();
        a.a(str, paramJSONObject);
      }
      if (this.b == null)
      {
        o.d("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconScanCallback init");
        this.b = new d.1(this, paramc);
      }
      if (this.a == null)
      {
        o.d("MicroMsg.JsApiStartBeaconDiscovery", "listener init");
        this.a = new d.2(this, paramc);
        com.tencent.luggage.wxa.iu.c.a(paramc.getAppId(), this.a);
      }
      paramJSONObject.a(arrayOfUUID);
      paramJSONObject.a(this.b);
      paramJSONObject = paramJSONObject.b();
      localObject = new HashMap();
      ((Map)localObject).put("errCode", paramJSONObject.b());
      if (((Integer)paramJSONObject.b()).intValue() == 0) {
        paramJSONObject = "ok";
      } else {
        paramJSONObject = (String)paramJSONObject.c();
      }
      paramc.a(paramInt, a(paramJSONObject, (Map)localObject));
      return;
    }
    o.b("MicroMsg.JsApiStartBeaconDiscovery", "serviceUuids is empty");
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(11006));
    paramc.a(paramInt, a("fail:invalid data", paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kv.d
 * JD-Core Version:    0.7.0.1
 */