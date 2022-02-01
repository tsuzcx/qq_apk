package com.tencent.luggage.wxa.kv;

import android.annotation.TargetApi;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public class e
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 222;
  private static final String NAME = "stopBeaconDiscovery";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.JsApiStopBeaconDiscovery", "stopBeaconDiscovery!");
    Object localObject = a.a(paramc.getAppId());
    paramJSONObject = Integer.valueOf(11004);
    if (localObject == null)
    {
      o.b("MicroMsg.JsApiStopBeaconDiscovery", "beaconWorker is null");
      localObject = new HashMap();
      ((Map)localObject).put("errCode", paramJSONObject);
      paramc.a(paramInt, a("fail:not start", (Map)localObject));
      return;
    }
    if (((a.a)localObject).c())
    {
      a.b(paramc.getAppId());
      new HashMap().put("errCode", Integer.valueOf(0));
      paramc.a(paramInt, b("ok"));
    }
    else
    {
      localObject = new HashMap();
      ((Map)localObject).put("errCode", paramJSONObject);
      paramc.a(paramInt, a("fail:not start", (Map)localObject));
    }
    paramJSONObject = new e.a(null);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("available", a.c);
      ((JSONObject)localObject).put("discovering", false);
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.JsApiStopBeaconDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
    }
    o.d("MicroMsg.JsApiStopBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[] { ((JSONObject)localObject).toString() });
    paramJSONObject.b(paramc, paramc.getComponentId()).b(((JSONObject)localObject).toString()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kv.e
 * JD-Core Version:    0.7.0.1
 */