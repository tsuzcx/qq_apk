package com.tencent.luggage.wxa.ju;

import com.tencent.luggage.wxa.fx.d;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class a
{
  private static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    try
    {
      paramJSONObject.put(paramString, paramObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      o.b("MicroMsg.SameLayer.AppBrandExtendPluginUtil", "build json object fail", new Object[] { paramJSONObject });
    }
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    a(paramJSONObject, "useXWebVideo", Boolean.valueOf(paramBoolean));
    a(paramJSONObject, "XWebVideoMinVersion", Integer.valueOf(d.a()));
  }
  
  public static void b(boolean paramBoolean, JSONObject paramJSONObject)
  {
    a(paramJSONObject, "useXWebMap", Boolean.valueOf(paramBoolean));
  }
  
  public static void c(boolean paramBoolean, JSONObject paramJSONObject)
  {
    a(paramJSONObject, "useXWebTextarea", Boolean.valueOf(paramBoolean));
  }
  
  public static void d(boolean paramBoolean, JSONObject paramJSONObject)
  {
    a(paramJSONObject, "supportXWebTextarea", Boolean.valueOf(paramBoolean));
  }
  
  public static void e(boolean paramBoolean, JSONObject paramJSONObject)
  {
    a(paramJSONObject, "supportXWebTouch", Boolean.valueOf(paramBoolean));
  }
  
  public static void f(boolean paramBoolean, JSONObject paramJSONObject)
  {
    a(paramJSONObject, "useXWebLive", Boolean.valueOf(paramBoolean));
  }
  
  public static void g(boolean paramBoolean, JSONObject paramJSONObject)
  {
    a(paramJSONObject, "useXWebCamera", Boolean.valueOf(paramBoolean));
  }
  
  public static void h(boolean paramBoolean, JSONObject paramJSONObject)
  {
    a(paramJSONObject, "abtestXWebCameraEnable", Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ju.a
 * JD-Core Version:    0.7.0.1
 */