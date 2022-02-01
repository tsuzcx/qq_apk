package com.tencent.luggage.wxa.ln;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b
  extends com.tencent.luggage.wxa.jx.u<com.tencent.mm.plugin.appbrand.page.u>
{
  public static int CTRL_INDEX = 71;
  public static String NAME = "getCurrentRoute";
  
  public String a(com.tencent.mm.plugin.appbrand.page.u paramu, JSONObject paramJSONObject)
  {
    paramJSONObject = new HashMap();
    paramJSONObject.put("route", paramu.an());
    return a("ok", paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.b
 * JD-Core Version:    0.7.0.1
 */