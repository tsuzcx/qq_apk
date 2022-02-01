package com.huawei.hms.framework.network.grs.local.model;

import java.util.HashMap;
import java.util.Map;

public class a
{
  private String a;
  private long b;
  private Map<String, c> c = new HashMap(16);
  
  public c a(String paramString)
  {
    return (c)this.c.get(paramString);
  }
  
  public void a()
  {
    Map localMap = this.c;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(String paramString, c paramc)
  {
    this.c.put(paramString, paramc);
  }
  
  public String b()
  {
    return this.a;
  }
  
  public void b(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.local.model.a
 * JD-Core Version:    0.7.0.1
 */