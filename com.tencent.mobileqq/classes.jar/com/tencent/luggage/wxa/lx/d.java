package com.tencent.luggage.wxa.lx;

import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.pe.a;
import java.util.HashMap;
import org.json.JSONObject;

public class d
  extends u
{
  public static final int CTRL_INDEX = 425;
  public static final String NAME = "getBatteryInfo";
  
  public String a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject)
  {
    paramc = a.a.a();
    paramJSONObject = new HashMap();
    paramJSONObject.put("level", Integer.valueOf(paramc.b));
    paramJSONObject.put("isCharging", Boolean.valueOf(paramc.a));
    return a("ok", paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.d
 * JD-Core Version:    0.7.0.1
 */