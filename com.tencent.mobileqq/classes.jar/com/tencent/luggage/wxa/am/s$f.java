package com.tencent.luggage.wxa.am;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class s$f
{
  private final Map<String, String> a = new HashMap();
  private Map<String, String> b;
  
  public Map<String, String> a()
  {
    try
    {
      if (this.b == null) {
        this.b = Collections.unmodifiableMap(new HashMap(this.a));
      }
      Map localMap = this.b;
      return localMap;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.b = null;
      this.a.put(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.s.f
 * JD-Core Version:    0.7.0.1
 */