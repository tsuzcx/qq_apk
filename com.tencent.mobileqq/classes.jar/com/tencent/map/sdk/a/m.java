package com.tencent.map.sdk.a;

import java.util.HashMap;

public final class m
{
  private static HashMap<String, String> a = new HashMap();
  
  public static String a(String paramString)
  {
    return (String)a.get(paramString);
  }
  
  public static <T extends n> void a(Class<T> paramClass)
  {
    try
    {
      Object localObject = (n)paramClass.newInstance();
      if (localObject != null)
      {
        String str = ((n)localObject).className();
        localObject = str;
        if ("".equals(str)) {
          localObject = paramClass.getName();
        }
        a.put(localObject, paramClass.getName());
      }
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
      return;
    }
    catch (InstantiationException paramClass)
    {
      paramClass.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.m
 * JD-Core Version:    0.7.0.1
 */