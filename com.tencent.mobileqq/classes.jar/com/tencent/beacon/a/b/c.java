package com.tencent.beacon.a.b;

import java.util.HashMap;
import java.util.Map;

public final class c
{
  public String a;
  public boolean b;
  public long c;
  public long d;
  public Map<String, String> e;
  public boolean f;
  
  public c(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
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
 * Qualified Name:     com.tencent.beacon.a.b.c
 * JD-Core Version:    0.7.0.1
 */