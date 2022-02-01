package com.huawei.hms.framework.network.grs.local.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c
{
  private String a;
  private String b;
  private Map<String, d> c = new HashMap(16);
  private List<b> d = new ArrayList(16);
  
  public d a(String paramString)
  {
    return (d)this.c.get(paramString);
  }
  
  public List<b> a()
  {
    return this.d;
  }
  
  public void a(String paramString, d paramd)
  {
    this.c.put(paramString, paramd);
  }
  
  public void a(List<b> paramList)
  {
    this.d = paramList;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.a = paramString;
  }
  
  public void c(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.local.model.c
 * JD-Core Version:    0.7.0.1
 */