package com.tencent.luggage.wxa.kf;

import android.annotation.TargetApi;
import com.tencent.luggage.wxa.ke.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public class d
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 183;
  private static final String NAME = "getBLEDeviceCharacteristics";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.ke.c.a(151);
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiGetBLEDeviceCharacteristics", "getBLEDeviceCharacteristics data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.a(paramInt, a("fail:invalid data", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(153, 154);
      return;
    }
    o.d("MicroMsg.JsApiGetBLEDeviceCharacteristics", "appId:%s getBLEDeviceCharacteristics data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    Object localObject = com.tencent.luggage.wxa.ke.a.a(paramc.getAppId());
    if (localObject == null)
    {
      o.b("MicroMsg.JsApiGetBLEDeviceCharacteristics", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.a(paramInt, a("fail:not init", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(153, 156);
      return;
    }
    if (!((b)localObject).j())
    {
      o.b("MicroMsg.JsApiGetBLEDeviceCharacteristics", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.a(paramInt, a("fail:not available", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(153, 158);
      return;
    }
    localObject = ((b)localObject).a(paramJSONObject.optString("deviceId"), paramJSONObject.optString("serviceId"));
    paramJSONObject = new HashMap();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramJSONObject = new JSONArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.luggage.wxa.kl.c localc = (com.tencent.luggage.wxa.kl.c)((Iterator)localObject).next();
        try
        {
          paramJSONObject.put(localc.a());
        }
        catch (JSONException localJSONException)
        {
          o.b("MicroMsg.JsApiGetBLEDeviceCharacteristics", "JSONException %s", new Object[] { localJSONException.getMessage() });
        }
      }
      localObject = new JSONObject();
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(d());
        localStringBuilder.append(":ok");
        ((JSONObject)localObject).put("errMsg", localStringBuilder.toString());
        ((JSONObject)localObject).put("characteristics", paramJSONObject);
        ((JSONObject)localObject).put("errCode", 0);
      }
      catch (JSONException paramJSONObject)
      {
        o.a("MicroMsg.JsApiGetBLEDeviceCharacteristics", paramJSONObject, "", new Object[0]);
      }
      o.d("MicroMsg.JsApiGetBLEDeviceCharacteristics", "retJson %s", new Object[] { ((JSONObject)localObject).toString() });
      paramc.a(paramInt, ((JSONObject)localObject).toString());
      com.tencent.luggage.wxa.ke.c.a(152);
      return;
    }
    o.b("MicroMsg.JsApiGetBLEDeviceCharacteristics", "not found characteristic");
    paramJSONObject.put("errCode", Integer.valueOf(10005));
    paramc.a(paramInt, a("fail:no characteristic", paramJSONObject));
    com.tencent.luggage.wxa.ke.c.a(153, 159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.d
 * JD-Core Version:    0.7.0.1
 */