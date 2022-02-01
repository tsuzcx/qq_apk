package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ak
  extends u<com.tencent.luggage.wxa.du.c>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getPermissionBytes";
  
  public String a(com.tencent.luggage.wxa.du.c paramc, JSONObject paramJSONObject)
  {
    int i = 0;
    int j = 0;
    o.d("MicroMsg.JsApiGetPermissionBytes", "invoke jsapi: %s", new Object[] { "getPermissionBytes" });
    if (paramc == null)
    {
      o.d("MicroMsg.JsApiGetPermissionBytes", "fail:service is nil");
      return b("fail:service is nil");
    }
    if (paramJSONObject == null)
    {
      o.d("MicroMsg.JsApiGetPermissionBytes", "fail:data is nil");
      return b("fail:data is nil");
    }
    paramJSONObject = paramJSONObject.optJSONArray("indexes");
    if (paramJSONObject == null)
    {
      o.d("MicroMsg.JsApiGetPermissionBytes", "fail:indexes is nil");
      return b("fail:indexes is nil");
    }
    Object localObject = paramc.i();
    if (localObject == null)
    {
      o.d("MicroMsg.JsApiGetPermissionBytes", "fail:runtime is nil");
      return b("fail:runtime is nil");
    }
    com.tencent.luggage.wxa.on.c localc = ((d)localObject).a();
    if (localc == null)
    {
      o.b("MicroMsg.JsApiGetPermissionBytes", "invoke failed, NULL permissionController with appId:%s", new Object[] { ((d)localObject).aa() });
      return b("fail:internal error");
    }
    localObject = localc.a(paramc);
    if ((localObject != null) && (localObject.length > 0))
    {
      paramc = new JSONArray();
      if (paramJSONObject.length() == 0)
      {
        i = j;
        while (i < localObject.length)
        {
          paramc.put(localc.a((byte[])localObject, i));
          i += 1;
        }
      }
      while (i < paramJSONObject.length())
      {
        paramc.put(localc.a((byte[])localObject, paramJSONObject.optInt(i, -1)));
        i += 1;
      }
      paramJSONObject = new HashMap();
      paramJSONObject.put("permissionBytes", paramc);
      o.d("MicroMsg.JsApiGetPermissionBytes", "invoke getPermissionBytes ok");
      return a("ok", paramJSONObject);
    }
    o.d("MicroMsg.JsApiGetPermissionBytes", "fail:ctrlBytes is empty");
    return b("fail:ctrlBytes is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ak
 * JD-Core Version:    0.7.0.1
 */