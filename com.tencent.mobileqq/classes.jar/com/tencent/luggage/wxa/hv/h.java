package com.tencent.luggage.wxa.hv;

import java.util.Map;
import org.json.JSONObject;

public class h
{
  private static volatile int a = 0;
  private static volatile boolean b = false;
  private static e c;
  
  public static c a(Map paramMap)
  {
    if (a == 1) {
      return new l(paramMap);
    }
    return new d(paramMap);
  }
  
  public static JSONObject a(String paramString)
  {
    if (!b) {
      a();
    }
    if (a == 1) {
      return new i(paramString);
    }
    return new JSONObject(paramString);
  }
  
  public static void a()
  {
    e locale = c;
    if ((locale != null) && (locale.a())) {
      c.b();
    }
  }
  
  public static c b()
  {
    if (a == 1) {
      return new l();
    }
    return new d();
  }
  
  public static c b(String paramString)
  {
    if (a == 1) {
      return new l(paramString);
    }
    return new d(paramString);
  }
  
  public static a c()
  {
    if (a == 1) {
      return new k();
    }
    return new b();
  }
  
  public static a c(String paramString)
  {
    if (a == 1) {
      return new k(paramString);
    }
    return new b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hv.h
 * JD-Core Version:    0.7.0.1
 */