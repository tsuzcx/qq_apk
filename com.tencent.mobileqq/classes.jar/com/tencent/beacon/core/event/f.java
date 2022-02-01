package com.tencent.beacon.core.event;

import java.util.HashMap;
import java.util.Map;

public class f
{
  public String a;
  public boolean b;
  public long c;
  public long d;
  public Map<String, String> e;
  public boolean f;
  public String g;
  
  public f(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    this.a = paramString2;
    this.b = paramBoolean1;
    this.c = paramLong1;
    this.d = paramLong2;
    if (paramMap != null)
    {
      this.e = new HashMap();
      this.e.putAll(paramMap);
    }
    this.f = paramBoolean2;
    this.g = paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.f
 * JD-Core Version:    0.7.0.1
 */