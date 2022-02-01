package com.tencent.beacon.core.strategy;

import com.tencent.beacon.core.e.d;
import java.util.Map;
import java.util.Set;

public class b
{
  private final int a;
  private boolean b = false;
  public String c = "";
  private Map<String, String> d = null;
  private Set<String> e = null;
  private Set<String> f = null;
  private Object g = null;
  
  public b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public Map<String, String> a()
  {
    return this.d;
  }
  
  public void a(Object paramObject)
  {
    this.g = paramObject;
  }
  
  public void a(String paramString)
  {
    if ((this.a == 1) && (c.g().b))
    {
      d.i("[strategy] user event url has defined by api, don't change.", new Object[0]);
      return;
    }
    this.c = paramString;
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.d = paramMap;
  }
  
  public void a(Set<String> paramSet)
  {
    this.e = paramSet;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public Set<String> b()
  {
    return this.e;
  }
  
  public void b(Set<String> paramSet)
  {
    this.f = paramSet;
  }
  
  public Set<String> c()
  {
    return this.f;
  }
  
  public String d()
  {
    String str = com.tencent.beacon.core.c.a.b.a(c.g().a() ^ true, (c.g().d() ^ true) & d.a(), this.c);
    d.a("[strategy] module strategy url: %s", new Object[] { str });
    return str;
  }
  
  public int e()
  {
    return this.a;
  }
  
  public boolean f()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.b
 * JD-Core Version:    0.7.0.1
 */