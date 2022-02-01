package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class i
{
  public static Map<String, m> b = new HashMap();
  public static i c;
  public l a = new l();
  
  public static i c()
  {
    if (c == null) {
      d();
    }
    return c;
  }
  
  public static void d()
  {
    try
    {
      if (c == null) {
        c = new i();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public m a(String paramString)
  {
    return (m)b.get(paramString);
  }
  
  public Set<String> a()
  {
    return b.keySet();
  }
  
  public void a(String paramString, m paramm)
  {
    b.put(paramString, paramm);
  }
  
  public l b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.i
 * JD-Core Version:    0.7.0.1
 */