package com.tencent.luggage.wxa.kv;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class d$1
  implements a.a.a
{
  d.b a = new d.b(null);
  d.a b = new d.a(null);
  
  d$1(d paramd, c paramc) {}
  
  public void a(Map<String, JSONObject> paramMap)
  {
    o.e("MicroMsg.JsApiStartBeaconDiscovery", "found device ibeacon %s", new Object[] { paramMap });
    JSONArray localJSONArray = new JSONArray();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      localObject = (JSONObject)paramMap.next();
      if (localObject != null) {
        localJSONArray.put(localObject);
      }
    }
    paramMap = new JSONObject();
    try
    {
      paramMap.put("beacons", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", new Object[] { localJSONException });
    }
    d.b localb = this.a;
    Object localObject = this.c;
    localb.b((c)localObject, ((c)localObject).getComponentId()).b(paramMap.toString()).a();
  }
  
  public void a(boolean paramBoolean)
  {
    o.d("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("available", paramBoolean);
      localJSONObject.put("discovering", false);
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
    }
    o.e("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[] { localJSONObject.toString() });
    d.a locala = this.b;
    c localc = this.c;
    locala.b(localc, localc.getComponentId()).b(localJSONObject.toString()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kv.d.1
 * JD-Core Version:    0.7.0.1
 */