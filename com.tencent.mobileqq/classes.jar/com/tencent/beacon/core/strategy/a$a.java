package com.tencent.beacon.core.strategy;

import java.util.Map;
import java.util.Set;

public final class a$a
{
  private final int a;
  private boolean b = false;
  private String c = "http://oth.eve.mdt.qq.com:8080/analytics/upload";
  private Map<String, String> d = null;
  private Set<String> e = null;
  private Set<String> f = null;
  
  public a$a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void a(String paramString)
  {
    if ((this.a == 1) && (a.a(a.a())))
    {
      com.tencent.beacon.core.d.b.c("[strategy] user event url has defined by api, don't change.", new Object[0]);
      return;
    }
    this.c = paramString;
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.d = paramMap;
  }
  
  public final void a(Set<String> paramSet)
  {
    this.e = paramSet;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.b;
  }
  
  public final String b()
  {
    boolean bool2;
    String str;
    boolean bool3;
    label34:
    boolean bool4;
    if (!a.a().h())
    {
      bool2 = true;
      str = a.a().b("stopTest");
      if (str == null) {
        break label82;
      }
      bool3 = "y".equals(str);
      bool4 = com.tencent.beacon.core.d.b.b;
      if (bool3) {
        break label87;
      }
    }
    label82:
    label87:
    for (boolean bool1 = true;; bool1 = false)
    {
      str = com.tencent.beacon.core.protocol.a.b.a(bool2, true, bool1 & bool4, this.c);
      com.tencent.beacon.core.d.b.b("[net] module strategy url: %s", new Object[] { str });
      return str;
      bool2 = false;
      break;
      bool3 = false;
      break label34;
    }
  }
  
  public final void b(Set<String> paramSet)
  {
    this.f = paramSet;
  }
  
  public final Map<String, String> c()
  {
    return this.d;
  }
  
  public final Set<String> d()
  {
    return this.e;
  }
  
  public final int e()
  {
    return this.a;
  }
  
  public final Set<String> f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.a.a
 * JD-Core Version:    0.7.0.1
 */