package com.tencent.beacon.event;

import java.util.HashMap;
import java.util.Map;

public final class e
{
  public String a;
  public boolean b;
  public long c;
  public long d;
  public Map<String, String> e;
  boolean f;
  
  public e(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    this.a = paramString;
    this.b = paramBoolean1;
    this.c = paramLong1;
    this.d = paramLong2;
    if (paramMap != null)
    {
      this.e = new HashMap();
      this.e.putAll(paramMap);
    }
    this.f = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.e
 * JD-Core Version:    0.7.0.1
 */