package com.huawei.updatesdk.service.c;

import java.util.concurrent.ConcurrentHashMap;

public class d
  extends ConcurrentHashMap<String, b>
{
  private int a;
  
  public b a(String paramString, b paramb)
  {
    if (paramb == null) {
      return null;
    }
    if (-1 != paramb.b())
    {
      int i = this.a + 1;
      this.a = i;
      paramb.a(i);
    }
    String str = paramString;
    if (paramb.e() == c.b.a) {
      str = "pre_hispace_install_" + paramString;
    }
    super.remove(str);
    return (b)super.put(str, paramb);
  }
  
  public b a(String paramString, d.a parama)
  {
    return (b)super.get("pre_hispace_install_" + paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.c.d
 * JD-Core Version:    0.7.0.1
 */