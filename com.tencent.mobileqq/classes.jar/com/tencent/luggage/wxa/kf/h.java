package com.tencent.luggage.wxa.kf;

import android.annotation.TargetApi;
import android.util.Log;
import com.tencent.luggage.wxa.ke.b;
import com.tencent.luggage.wxa.kl.d;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public class h
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 178;
  private static final String NAME = "getBluetoothDevices";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.ke.c.a(166);
    Object localObject2 = paramc.getAppId();
    Object localObject1 = paramJSONObject;
    if (paramJSONObject == null) {
      localObject1 = "";
    }
    o.d("MicroMsg.JsApiGetBluetoothDevices", "appId:%s getBluetoothDevices data:%s", new Object[] { localObject2, localObject1 });
    localObject2 = com.tencent.luggage.wxa.ke.a.a((String)localObject2);
    if (localObject2 == null)
    {
      o.b("MicroMsg.JsApiGetBluetoothDevices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.a(paramInt, a("fail:not init", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(168, 170);
      return;
    }
    if (!((b)localObject2).j())
    {
      o.b("MicroMsg.JsApiGetBluetoothDevices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.a(paramInt, a("fail:not available", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(168, 172);
      return;
    }
    Object localObject3 = ((b)localObject2).g();
    paramJSONObject = new JSONObject();
    localObject1 = new JSONArray();
    if (localObject3 != null)
    {
      ((List)localObject3).addAll(((b)localObject2).h());
      localObject2 = ((List)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (d)((Iterator)localObject2).next();
        try
        {
          ((JSONArray)localObject1).put(((d)localObject3).a());
        }
        catch (JSONException localJSONException2)
        {
          o.a("MicroMsg.JsApiGetBluetoothDevices", localJSONException2, "", new Object[0]);
        }
      }
    }
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(d());
      ((StringBuilder)localObject2).append(":ok");
      paramJSONObject.put("errMsg", ((StringBuilder)localObject2).toString());
      paramJSONObject.put("devices", localObject1);
    }
    catch (JSONException localJSONException1)
    {
      o.b("MicroMsg.JsApiGetBluetoothDevices", "put json value error : %s", new Object[] { Log.getStackTraceString(localJSONException1) });
    }
    o.d("MicroMsg.JsApiGetBluetoothDevices", "retJson %s", new Object[] { paramJSONObject });
    paramc.a(paramInt, paramJSONObject.toString());
    com.tencent.luggage.wxa.ke.c.a(167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.h
 * JD-Core Version:    0.7.0.1
 */