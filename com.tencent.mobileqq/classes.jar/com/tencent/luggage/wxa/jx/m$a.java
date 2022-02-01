package com.tencent.luggage.wxa.jx;

import java.util.HashMap;
import java.util.Map;

public class m$a
{
  public final Map<String, Object> a = new HashMap();
  public final String b;
  
  public m$a(String paramString, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      this.b = String.format(paramString, paramVarArgs);
      return;
    }
    this.b = paramString;
  }
  
  public a a(String paramString, Object paramObject)
  {
    this.a.put(paramString, paramObject);
    return this;
  }
  
  public a a(Map<String, Object> paramMap)
  {
    if (paramMap != null) {
      this.a.putAll(paramMap);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.m.a
 * JD-Core Version:    0.7.0.1
 */