package com.tencent.beacon.b;

import android.content.Context;
import com.tencent.beacon.a.c.d;
import com.tencent.beacon.event.UserAction;

public final class b
{
  private static b l;
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private boolean j = false;
  private String k = "";
  
  private b(Context paramContext)
  {
    this.b = d.a(paramContext).a();
    com.tencent.beacon.a.c.e.a(paramContext);
    this.c = com.tencent.beacon.a.c.e.e(paramContext);
    this.d = com.tencent.beacon.a.c.e.c(paramContext);
    this.e = com.tencent.beacon.a.c.e.d(paramContext);
    if ("".equals(this.c)) {
      com.tencent.beacon.a.c.e.d();
    }
    this.f = UserAction.getQQ();
    this.g = com.tencent.beacon.a.c.e.b();
    this.h = com.tencent.beacon.a.c.e.e();
    this.i = com.tencent.beacon.a.c.e.a();
    this.j = com.tencent.beacon.a.g.b.a().b();
    this.k = com.tencent.beacon.a.c.e.g();
    com.tencent.beacon.a.c.e.i(paramContext);
    try
    {
      paramContext = new e(paramContext).a();
      if ((paramContext != null) && (!"".equals(paramContext))) {
        this.a = paramContext;
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static b a(Context paramContext)
  {
    if (l == null) {
      l = new b(paramContext);
    }
    return l;
  }
  
  public final String a()
  {
    if ((this.a == null) || ("".equals(this.a)))
    {
      if ("".equals(this.b)) {
        return this.e;
      }
      return this.b;
    }
    return this.a;
  }
  
  public final void a(String paramString)
  {
    this.a = paramString;
  }
  
  public final String b()
  {
    return this.a;
  }
  
  public final String c()
  {
    return this.b;
  }
  
  public final String d()
  {
    return this.c;
  }
  
  public final String e()
  {
    return this.d;
  }
  
  public final String f()
  {
    return this.e;
  }
  
  public final String g()
  {
    return this.i;
  }
  
  public final boolean h()
  {
    return this.j;
  }
  
  public final String i()
  {
    return this.f;
  }
  
  public final String j()
  {
    return this.g;
  }
  
  public final String k()
  {
    return this.h;
  }
  
  public final String l()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.b.b
 * JD-Core Version:    0.7.0.1
 */