package com.tencent.beacon.qimei;

import android.content.Context;
import com.tencent.beacon.core.b.c;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.event.UserAction;

public final class a
{
  private static a k;
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  
  private a(Context paramContext)
  {
    this.b = c.a(paramContext).a();
    com.tencent.beacon.core.b.d.a(paramContext);
    this.c = com.tencent.beacon.core.b.d.e(paramContext);
    this.d = com.tencent.beacon.core.b.d.c(paramContext);
    this.e = com.tencent.beacon.core.b.d.d(paramContext);
    if ("".equals(this.c)) {
      com.tencent.beacon.core.b.d.d();
    }
    this.f = UserAction.getQQ();
    this.g = com.tencent.beacon.core.b.d.b();
    this.h = com.tencent.beacon.core.b.d.e();
    this.i = com.tencent.beacon.core.b.d.a();
    this.j = com.tencent.beacon.core.b.d.h();
    com.tencent.beacon.core.b.d.j(paramContext);
    try
    {
      paramContext = d.a(paramContext);
      if ((paramContext != null) && (!"".equals(paramContext))) {
        this.a = paramContext;
      }
      return;
    }
    catch (Exception paramContext)
    {
      b.d("load qimei error ", new Object[] { paramContext });
    }
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (k == null) {
        k = new a(paramContext);
      }
      paramContext = k;
      return paramContext;
    }
    finally {}
  }
  
  public final String a()
  {
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
  
  public final String h()
  {
    return this.f;
  }
  
  public final String i()
  {
    return this.g;
  }
  
  public final String j()
  {
    return this.h;
  }
  
  public final String k()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.qimei.a
 * JD-Core Version:    0.7.0.1
 */