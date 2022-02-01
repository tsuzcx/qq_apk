package com.huawei.hms.framework.network.grs.local.model;

import java.util.HashMap;
import java.util.Map;

public class a
{
  private String a;
  private long b;
  private Map<String, c> c = new HashMap(16);
  
  public String a()
  {
    return this.a;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString, c paramc)
  {
    this.c.put(paramString, paramc);
  }
  
  public c b(String paramString)
  {
    return (c)this.c.get(paramString);
  }
  
  public Map<String, c> b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.local.model.a
 * JD-Core Version:    0.7.0.1
 */