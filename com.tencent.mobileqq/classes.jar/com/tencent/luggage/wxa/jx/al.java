package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class al
  extends u<com.tencent.luggage.wxa.du.c>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getPluginPermissionBytes";
  
  public String a(com.tencent.luggage.wxa.du.c paramc, JSONObject paramJSONObject)
  {
    o.d("MicroMsg.JsApiGetPluginPermissionBytes", "invoke jsapi: %s", new Object[] { "getPluginPermissionBytes" });
    if (paramc == null)
    {
      o.d("MicroMsg.JsApiGetPluginPermissionBytes", "fail:service is nil");
      return b("fail:service is nil");
    }
    if (paramJSONObject == null)
    {
      o.d("MicroMsg.JsApiGetPluginPermissionBytes", "fail:data is nil");
      return b("fail:data is nil");
    }
    Object localObject1 = paramc.i();
    if (localObject1 == null)
    {
      o.d("MicroMsg.JsApiGetPluginPermissionBytes", "fail:runtime is nil");
      return b("fail:runtime is nil");
    }
    com.tencent.luggage.wxa.on.c localc = ((d)localObject1).a();
    if (localc == null)
    {
      o.b("MicroMsg.JsApiGetPluginPermissionBytes", "invoke failed, NULL permissionController with appId:%s", new Object[] { ((d)localObject1).aa() });
      return b("fail:internal error");
    }
    for (;;)
    {
      int i;
      try
      {
        paramJSONObject = new JSONArray(paramJSONObject.optString("pluginList"));
        localObject1 = new HashMap();
        HashMap localHashMap = new HashMap();
        i = 0;
        if (i < paramJSONObject.length())
        {
          Object localObject2 = paramJSONObject.optJSONObject(i);
          String str = ((JSONObject)localObject2).optString("pluginId");
          localObject2 = ((JSONObject)localObject2).optJSONArray("indexes");
          o.d("MicroMsg.JsApiGetPluginPermissionBytes", "pluginId:%s,indexes:%s", new Object[] { str, localObject2 });
          if (localObject2 == null)
          {
            o.d("MicroMsg.JsApiGetPluginPermissionBytes", "fail:indexes is nil");
            return b("fail:indexes is nil");
          }
          byte[] arrayOfByte = localc.a(paramc, str);
          if ((arrayOfByte != null) && (arrayOfByte.length > 0))
          {
            o.d("MicroMsg.JsApiGetPluginPermissionBytes", "pluginId:%s ctrlBytes:%d", new Object[] { str, Integer.valueOf(arrayOfByte.length) });
            JSONArray localJSONArray = new JSONArray();
            if (((JSONArray)localObject2).length() == 0)
            {
              j = 0;
              if (j < arrayOfByte.length)
              {
                localJSONArray.put(localc.a(arrayOfByte, j));
                j += 1;
                continue;
                if (j < ((JSONArray)localObject2).length())
                {
                  localJSONArray.put(localc.a(arrayOfByte, ((JSONArray)localObject2).optInt(j, -1)));
                  j += 1;
                  continue;
                }
              }
              localHashMap.put(str, localJSONArray);
              break label456;
            }
          }
          else
          {
            o.d("MicroMsg.JsApiGetPluginPermissionBytes", "fail:pluginId:%s ctrlBytes is empty", new Object[] { str });
            break label456;
          }
        }
        else
        {
          ((Map)localObject1).put("pluginPermissionMap", localHashMap);
          o.d("MicroMsg.JsApiGetPluginPermissionBytes", "invoke JsApiGetPluginPermissionBytes ok");
          paramc = a("ok", (Map)localObject1);
          return paramc;
        }
      }
      catch (Exception paramc)
      {
        o.b("MicroMsg.JsApiGetPluginPermissionBytes", "parse pluginList error:%s", new Object[] { paramc });
        return b("fail:parse pluginList error");
      }
      int j = 0;
      continue;
      label456:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.al
 * JD-Core Version:    0.7.0.1
 */