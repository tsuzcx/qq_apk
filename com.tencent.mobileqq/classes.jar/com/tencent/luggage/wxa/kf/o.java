package com.tencent.luggage.wxa.kf;

import android.annotation.TargetApi;
import android.os.ParcelUuid;
import com.tencent.luggage.wxa.ke.b;
import com.tencent.luggage.wxa.kh.a.a;
import com.tencent.luggage.wxa.km.f.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(18)
public class o
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 176;
  private static final String NAME = "startBluetoothDevicesDiscovery";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.ke.c.a(11);
    if (paramJSONObject == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startBluetoothDevicesDiscovery data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.a(paramInt, a("fail:invalid data", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(13, 14);
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "appId:%s startBluetoothDevicesDiscovery data:%s", new Object[] { paramc.getAppId(), paramJSONObject });
    b localb = com.tencent.luggage.wxa.ke.a.a(paramc.getAppId());
    if (localb == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.a(paramInt, a("fail:not init", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(13, 16);
      return;
    }
    if (!localb.j())
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.a(paramInt, a("fail:not available", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(13, 18);
      return;
    }
    if (!localb.j())
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.a(paramInt, a("fail:not available", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(13, 18);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("allowDuplicatesKey");
    int j = paramJSONObject.optInt("interval");
    String str = paramJSONObject.optString("powerLevel", "medium");
    Object localObject = null;
    ArrayList localArrayList;
    if (paramJSONObject.has("services")) {
      localArrayList = new ArrayList();
    }
    try
    {
      paramJSONObject = new JSONArray(paramJSONObject.optString("services"));
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= paramJSONObject.length()) {
          break;
        }
        localObject = ParcelUuid.fromString(paramJSONObject.getString(i).toUpperCase());
        localArrayList.add(new f.a().a((ParcelUuid)localObject).a());
        i += 1;
      }
    }
    catch (Exception paramJSONObject)
    {
      label396:
      break label396;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "get uuid error!");
    paramJSONObject = new HashMap();
    paramJSONObject.put("isDiscovering", Boolean.valueOf(false));
    paramJSONObject.put("errCode", Integer.valueOf(10004));
    paramc.a(paramInt, a("fail:no service", paramJSONObject));
    com.tencent.luggage.wxa.ke.c.a(13);
    return;
    localb.a(new a.a().a(j).a(bool).a(str).a());
    localb.a(new o.1(this, paramc, paramInt), (List)localObject, new o.2(this, paramc));
    l.c.a(paramc, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.o
 * JD-Core Version:    0.7.0.1
 */