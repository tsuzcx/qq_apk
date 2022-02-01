package com.tencent.luggage.wxa.bz;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b
  extends u<h>
{
  public static final int CTRL_INDEX = 527;
  public static final String NAME = "getABTestConfig";
  
  public String a(h paramh, JSONObject paramJSONObject)
  {
    paramh = new StringBuilder();
    paramh.append("JSONObject = ");
    paramh.append(paramJSONObject);
    o.d("MicroMsg.JsApiGetABTestConfig", paramh.toString());
    paramh = paramJSONObject.optString("experimentId");
    paramJSONObject = new HashMap();
    if ("clicfg_appbrand_native_socket_wcwss".equalsIgnoreCase(paramh)) {
      paramJSONObject.put("testConfig", "1");
    }
    if ("clicfg_appbrand_native_readfile".equalsIgnoreCase(paramh)) {
      paramJSONObject.put("testConfig", "1");
    }
    if ("clicfg_appbrand_native_download".equalsIgnoreCase(paramh)) {
      paramJSONObject.put("testConfig", "0");
    }
    return a("ok", paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bz.b
 * JD-Core Version:    0.7.0.1
 */