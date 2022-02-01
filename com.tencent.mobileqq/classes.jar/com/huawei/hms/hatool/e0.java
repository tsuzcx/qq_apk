package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

public final class e0
{
  public static e0 b;
  public volatile Map<String, f0> a = new HashMap();
  
  public static e0 a()
  {
    if (b == null) {
      b();
    }
    return b;
  }
  
  public static void b()
  {
    try
    {
      if (b == null) {
        b = new e0();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final f0 a(String paramString)
  {
    if (!this.a.containsKey(paramString))
    {
      f0 localf0 = new f0();
      this.a.put(paramString, localf0);
    }
    return (f0)this.a.get(paramString);
  }
  
  public f0 a(String paramString, long paramLong)
  {
    paramString = a(paramString);
    paramString.a(paramLong);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.e0
 * JD-Core Version:    0.7.0.1
 */