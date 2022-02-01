package com.tencent.luggage.wxa.jz;

import com.tencent.luggage.wxa.kd.a;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private Map<String, a> b = new HashMap(2);
  
  private c() {}
  
  public a a(String paramString)
  {
    if (!this.b.containsKey(paramString)) {
      this.b.put(paramString, new a());
    }
    return (a)this.b.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.c
 * JD-Core Version:    0.7.0.1
 */