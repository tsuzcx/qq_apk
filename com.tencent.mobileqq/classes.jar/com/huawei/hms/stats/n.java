package com.huawei.hms.stats;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class n
{
  static Map<String, s> a = new HashMap();
  private static n c;
  private q b = new q();
  
  public static n a()
  {
    if (c == null) {
      d();
    }
    return c;
  }
  
  private static void d()
  {
    try
    {
      if (c == null) {
        c = new n();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public s a(String paramString)
  {
    return (s)a.get(paramString);
  }
  
  public void a(String paramString, s params)
  {
    a.put(paramString, params);
  }
  
  public Set<String> b()
  {
    return a.keySet();
  }
  
  public q c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.n
 * JD-Core Version:    0.7.0.1
 */