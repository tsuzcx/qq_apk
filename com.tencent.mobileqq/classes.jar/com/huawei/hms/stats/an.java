package com.huawei.hms.stats;

import java.util.HashMap;
import java.util.Map;

public final class an
{
  private static an a;
  private volatile Map<String, ao> b = new HashMap();
  
  public static an a()
  {
    if (a == null) {
      b();
    }
    return a;
  }
  
  private ao b(String paramString)
  {
    if (!this.b.containsKey(paramString))
    {
      ao localao = new ao();
      this.b.put(paramString, localao);
    }
    return (ao)this.b.get(paramString);
  }
  
  private static void b()
  {
    try
    {
      if (a == null) {
        a = new an();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ao a(String paramString, long paramLong)
  {
    paramString = b(paramString);
    paramString.a(paramLong);
    return paramString;
  }
  
  public void a(String paramString)
  {
    b(paramString).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.an
 * JD-Core Version:    0.7.0.1
 */