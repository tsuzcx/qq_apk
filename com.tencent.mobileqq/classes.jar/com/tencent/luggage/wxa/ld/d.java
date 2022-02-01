package com.tencent.luggage.wxa.ld;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.nz.j;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class d
  extends com.tencent.luggage.wxa.jx.a
{
  public static final int CTRL_INDEX = 615;
  public static final String NAME = "checkNetworkAPIURL";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      paramc.a(paramInt, b("fail:data nil"));
      o.c("MicroMsg.JsApiCheckNetworkAPIURL", "data is null");
      return;
    }
    HashMap localHashMap = new HashMap();
    String str = paramJSONObject.optString("api", "");
    paramJSONObject = paramJSONObject.optString("url", "");
    if ((!af.c(str)) && (!af.c(paramJSONObject)))
    {
      Object localObject = (com.tencent.luggage.wxa.nz.a)paramc.b(com.tencent.luggage.wxa.nz.a.class);
      boolean bool;
      if (str.equalsIgnoreCase("request"))
      {
        bool = j.b(((com.tencent.luggage.wxa.nz.a)localObject).k, paramJSONObject, false);
      }
      else if (str.equalsIgnoreCase("websocket"))
      {
        bool = j.b(((com.tencent.luggage.wxa.nz.a)localObject).l, paramJSONObject, ((com.tencent.luggage.wxa.nz.a)localObject).t);
      }
      else if (str.equalsIgnoreCase("downloadFile"))
      {
        bool = j.b(((com.tencent.luggage.wxa.nz.a)localObject).n, paramJSONObject, false);
      }
      else if (str.equalsIgnoreCase("uploadFile"))
      {
        bool = j.b(((com.tencent.luggage.wxa.nz.a)localObject).m, paramJSONObject, false);
      }
      else
      {
        if (!str.equalsIgnoreCase("udp")) {
          break label459;
        }
        bool = j.b(((com.tencent.luggage.wxa.nz.a)localObject).o, paramJSONObject, false);
      }
      localObject = (String)j.a(paramJSONObject).get("host");
      int i;
      if (!af.c((String)localObject))
      {
        o.d("MicroMsg.JsApiCheckNetworkAPIURL", "ipHost:%s", new Object[] { localObject });
        i = j.b((String)localObject);
      }
      else
      {
        i = 0;
      }
      o.d("MicroMsg.JsApiCheckNetworkAPIURL", "checkRet:%b,ipCheckRet:%d,api:%s,url:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), str, paramJSONObject });
      if (bool) {
        localHashMap.put("isInDomainList", Boolean.valueOf(true));
      } else {
        localHashMap.put("isInDomainList", Boolean.valueOf(false));
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            localHashMap.put("isInLAN", Boolean.valueOf(true));
            localHashMap.put("isLocalHost", Boolean.valueOf(false));
          }
        }
        else
        {
          localHashMap.put("isInLAN", Boolean.valueOf(true));
          localHashMap.put("isLocalHost", Boolean.valueOf(true));
        }
      }
      else
      {
        localHashMap.put("isInLAN", Boolean.valueOf(false));
        localHashMap.put("isLocalHost", Boolean.valueOf(false));
      }
      paramc.a(paramInt, a("ok", localHashMap));
      return;
      label459:
      o.c("MicroMsg.JsApiCheckNetworkAPIURL", "hy: unknown api: %s", new Object[] { str });
      localHashMap.put("isValid", Boolean.valueOf(false));
      paramc.a(paramInt, a("fail:unknow api", localHashMap));
      return;
    }
    o.c("MicroMsg.JsApiCheckNetworkAPIURL", "invalid api:%s,url:%s", new Object[] { str, paramJSONObject });
    localHashMap.put("isValid", Boolean.valueOf(false));
    paramc.a(paramInt, a("fail:api or url invalid", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ld.d
 * JD-Core Version:    0.7.0.1
 */