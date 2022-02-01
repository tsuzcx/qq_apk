package com.tencent.luggage.wxa.kv;

import com.tencent.luggage.wxa.qz.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 223;
  private static final String NAME = "getBeacons";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    o.e("MicroMsg.JsApiGetBeacons", "getBeacons!");
    paramJSONObject = new JSONArray();
    Object localObject = a.a(paramc.getAppId());
    if (localObject != null)
    {
      localObject = ((a.a)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBeaconInfo, beaconInfos: ");
      localStringBuilder.append(localObject);
      o.e("MicroMsg.JsApiGetBeacons", localStringBuilder.toString());
      if ((localObject != null) && (((Map)localObject).size() > 0))
      {
        localObject = ((Map)localObject).values().iterator();
        while (((Iterator)localObject).hasNext()) {
          paramJSONObject.put((JSONObject)((Iterator)localObject).next());
        }
      }
    }
    else
    {
      o.b("MicroMsg.JsApiGetBeacons", "not found device");
    }
    localObject = new HashMap();
    ((Map)localObject).put("beacons", paramJSONObject);
    paramc.a(paramInt, a("ok", (Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kv.c
 * JD-Core Version:    0.7.0.1
 */