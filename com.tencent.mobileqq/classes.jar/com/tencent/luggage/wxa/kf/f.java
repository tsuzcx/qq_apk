package com.tencent.luggage.wxa.kf;

import android.annotation.TargetApi;
import com.tencent.luggage.wxa.ke.b;
import com.tencent.luggage.wxa.kl.e;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public class f
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 182;
  private static final String NAME = "getBLEDeviceServices";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.ke.c.a(136);
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data is null");
      paramc.a(paramInt, b("fail:invalid data"));
      com.tencent.luggage.wxa.ke.c.a(138, 139);
      return;
    }
    o.d("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    Object localObject = com.tencent.luggage.wxa.ke.a.a(paramc.getAppId());
    if (localObject == null)
    {
      o.b("MicroMsg.JsApiGetBLEDeviceServices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.a(paramInt, a("fail:not init", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(138, 141);
      return;
    }
    if (!((b)localObject).j())
    {
      o.b("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.a(paramInt, a("fail:not available", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(138, 145);
      return;
    }
    localObject = ((b)localObject).a(paramJSONObject.optString("deviceId"));
    paramJSONObject = new HashMap();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramJSONObject = new JSONArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        e locale = (e)((Iterator)localObject).next();
        if (af.c(locale.a)) {
          o.b("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
        } else {
          try
          {
            paramJSONObject.put(locale.a());
          }
          catch (JSONException localJSONException)
          {
            o.b("MicroMsg.JsApiGetBLEDeviceServices", "JSONException %s", new Object[] { localJSONException.getMessage() });
          }
        }
      }
      localObject = new JSONObject();
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(d());
        localStringBuilder.append(":ok");
        ((JSONObject)localObject).put("errMsg", localStringBuilder.toString());
        ((JSONObject)localObject).put("services", paramJSONObject);
        ((JSONObject)localObject).put("errCode", 0);
      }
      catch (JSONException paramJSONObject)
      {
        o.a("MicroMsg.JsApiGetBLEDeviceServices", paramJSONObject, "", new Object[0]);
      }
      o.d("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", new Object[] { ((JSONObject)localObject).toString() });
      paramc.a(paramInt, ((JSONObject)localObject).toString());
      com.tencent.luggage.wxa.ke.c.a(137);
      return;
    }
    o.b("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
    paramJSONObject.put("errCode", Integer.valueOf(10004));
    paramc.a(paramInt, a("fail:no service", paramJSONObject));
    com.tencent.luggage.wxa.ke.c.a(138, 144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.f
 * JD-Core Version:    0.7.0.1
 */