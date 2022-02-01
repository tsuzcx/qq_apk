package com.tencent.luggage.wxa.kf;

import android.annotation.TargetApi;
import com.tencent.luggage.wxa.ke.b;
import com.tencent.luggage.wxa.kl.d;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public class i
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 179;
  private static final String NAME = "getConnectedBluetoothDevices";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.ke.c.a(191);
    o.d("MicroMsg.JsApiGetConnectedBluetoothDevices", "getConnectedBluetoothDevices!");
    o.d("MicroMsg.JsApiGetConnectedBluetoothDevices", "appId:%s getConnectedBluetoothDevices data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    Object localObject1 = com.tencent.luggage.wxa.ke.a.a(paramc.getAppId());
    if (localObject1 == null)
    {
      o.b("MicroMsg.JsApiGetConnectedBluetoothDevices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.a(paramInt, a("fail:not init", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(193, 195);
      return;
    }
    if (!((b)localObject1).j())
    {
      o.b("MicroMsg.JsApiGetConnectedBluetoothDevices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.a(paramInt, a("fail:not available", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(193, 197);
      return;
    }
    Object localObject2 = paramJSONObject.optJSONArray("services");
    paramJSONObject = null;
    Object localObject3;
    if (localObject2 != null)
    {
      int j = ((JSONArray)localObject2).length();
      paramJSONObject = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        localObject3 = ((JSONArray)localObject2).optString(i);
        if (localObject3 != null) {
          paramJSONObject.add(localObject3);
        }
        i += 1;
      }
    }
    localObject1 = ((b)localObject1).a(paramJSONObject);
    if (localObject1 == null)
    {
      o.b("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetoothDevices is empty!");
      paramc.a(paramInt, b("fail:internal error"));
      com.tencent.luggage.wxa.ke.c.a(193, 198);
      return;
    }
    paramJSONObject = new JSONArray();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (d)((Iterator)localObject1).next();
      localObject2 = ((d)localObject3).b;
      localObject3 = ((d)localObject3).a;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("deviceId", localObject2);
        localJSONObject.put("name", localObject3);
        paramJSONObject.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        o.b("MicroMsg.JsApiGetConnectedBluetoothDevices", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
    localObject1 = new JSONObject();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(d());
      localStringBuilder.append(":ok");
      ((JSONObject)localObject1).put("errMsg", localStringBuilder.toString());
      ((JSONObject)localObject1).put("devices", paramJSONObject);
    }
    catch (JSONException paramJSONObject)
    {
      o.a("MicroMsg.JsApiGetConnectedBluetoothDevices", paramJSONObject, "", new Object[0]);
    }
    o.d("MicroMsg.JsApiGetConnectedBluetoothDevices", "retJson %s", new Object[] { ((JSONObject)localObject1).toString() });
    paramc.a(paramInt, ((JSONObject)localObject1).toString());
    com.tencent.luggage.wxa.ke.c.a(192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.i
 * JD-Core Version:    0.7.0.1
 */