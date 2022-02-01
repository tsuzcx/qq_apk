package com.tencent.featuretoggle.hltxkg.common.a.c;

import java.util.HashMap;
import java.util.Map;

public final class b
{
  private String a;
  private Map<String, c> b;
  
  public b(String paramString)
  {
    this.a = paramString;
    this.b = new HashMap();
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(c paramc)
  {
    this.b.put(paramc.a, paramc);
  }
  
  public final Map<String, c> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.c.b
 * JD-Core Version:    0.7.0.1
 */