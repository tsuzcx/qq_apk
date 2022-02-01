package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.luggage.wxa.nk.j;
import com.tencent.luggage.wxa.nk.j.b;
import com.tencent.luggage.wxa.nk.l;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joor.Reflect;
import org.joor.ReflectException;

public final class g
{
  private static Map<String, String> a = new HashMap();
  private static Map<String, List<l>> b = new HashMap();
  private static Map<String, j> c = new HashMap();
  
  static String a(Class paramClass)
  {
    String str = paramClass.getName();
    if (a.containsKey(str)) {
      return (String)a.get(str);
    }
    try
    {
      paramClass = (String)paramClass.getDeclaredField("NAME").get(null);
      a.put(str, paramClass);
      return paramClass;
    }
    catch (NoSuchFieldException|IllegalAccessException paramClass) {}
    return null;
  }
  
  static void a(Class paramClass, j.b paramb)
  {
    j.a(c(paramClass), paramb);
  }
  
  static List<l> b(Class paramClass)
  {
    String str = paramClass.getName();
    if (b.containsKey(str)) {
      return (List)b.get(str);
    }
    ArrayList localArrayList = new ArrayList();
    a(paramClass, new g.1(localArrayList));
    b.put(str, localArrayList);
    return localArrayList;
  }
  
  public static j c(Class paramClass)
  {
    String str = paramClass.getName();
    if (c.containsKey(str)) {
      return (j)c.get(str);
    }
    try
    {
      paramClass = (List)Reflect.on(paramClass).get("sStepNodes");
      if (paramClass == null) {
        return null;
      }
      paramClass = j.a(paramClass);
      if (paramClass == null) {
        return null;
      }
      c.put(str, paramClass);
      return paramClass;
    }
    catch (ReflectException paramClass) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.g
 * JD-Core Version:    0.7.0.1
 */