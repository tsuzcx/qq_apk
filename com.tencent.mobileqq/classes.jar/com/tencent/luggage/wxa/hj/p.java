package com.tencent.luggage.wxa.hj;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.hm.a;
import com.tencent.luggage.wxa.hp.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class p
{
  private static final Map<String, e> a = new ConcurrentHashMap();
  
  public static <T> T a(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2)
  {
    try
    {
      if (!paramClass2.isAssignableFrom(paramClass1))
      {
        com.tencent.luggage.wxa.hs.b.b("IPC.ObjectStore", "%s isAssignableFrom %s return false", new Object[] { paramClass2, paramClass1 });
        return null;
      }
      if (paramClass1.isAnnotationPresent(a.class))
      {
        String str = paramClass1.getName();
        e locale = (e)a.get(str);
        paramClass2 = locale;
        if (locale == null)
        {
          paramClass2 = new e(paramClass1);
          a.put(str, paramClass2);
        }
        return paramClass2.a();
      }
      paramClass1 = com.tencent.luggage.wxa.hr.b.a(paramClass1, paramClass2);
      return paramClass1;
    }
    catch (Exception paramClass1) {}
    return null;
  }
  
  public static <T> T a(@NonNull String paramString, @NonNull Class<?> paramClass)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      if (!paramClass.isAssignableFrom(localClass))
      {
        com.tencent.luggage.wxa.hs.b.b("IPC.ObjectStore", "%s isAssignableFrom %s return false", new Object[] { paramClass, localClass });
        return null;
      }
      if (localClass.isAnnotationPresent(a.class))
      {
        e locale = (e)a.get(paramString);
        paramClass = locale;
        if (locale == null)
        {
          paramClass = new e(localClass);
          a.put(paramString, paramClass);
        }
        return paramClass.a();
      }
      paramString = com.tencent.luggage.wxa.hr.b.a(paramString, paramClass);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static <T> T b(String paramString, Class<?> paramClass)
  {
    return com.tencent.luggage.wxa.hr.b.a(paramString, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.p
 * JD-Core Version:    0.7.0.1
 */