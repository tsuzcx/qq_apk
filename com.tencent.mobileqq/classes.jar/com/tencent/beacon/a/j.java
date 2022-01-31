package com.tencent.beacon.a;

import android.content.Context;
import com.tencent.beacon.d.c;
import com.tencent.beacon.event.UserAction;

public final class j
{
  private static j s;
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
  private boolean k = false;
  private String l = "";
  private String m = "";
  private String n = "";
  private String o = "";
  private String p = "";
  private String q = "";
  private String r = "";
  
  private j(Context paramContext)
  {
    f.a(paramContext);
    this.c = f.e(paramContext);
    this.d = f.c(paramContext);
    this.e = f.d(paramContext);
    if ("".equals(this.c))
    {
      str = f.f("/sys/class/net/eth0/address");
      if ((!str.trim().equals("")) && (str.length() >= 17)) {
        break label724;
      }
    }
    for (String str = "";; str = str.toLowerCase().substring(0, 17))
    {
      this.f = str;
      this.g = UserAction.getQQ();
      this.h = f.b();
      this.i = f.k();
      this.j = f.a();
      this.k = c.a().b();
      f.l(paramContext);
      str = b.b(paramContext, "f_non_empty_qimei_v2", "");
      Object localObject = str.split("\\|\\|\\|");
      if (localObject.length == 7)
      {
        this.l = localObject[0];
        this.m = localObject[1];
        this.n = localObject[2];
        this.o = localObject[3];
        this.p = localObject[4];
        this.q = localObject[5];
        this.r = localObject[6];
      }
      if ((!this.b.equals("")) && (this.l.trim().equals(""))) {
        this.l = this.b;
      }
      if ((!this.c.equals("")) && (this.m.trim().equals(""))) {
        this.m = this.c;
      }
      if ((!this.d.equals("")) && (this.n.trim().equals(""))) {
        this.n = this.d;
      }
      if ((!this.h.equals("")) && (this.o.trim().equals(""))) {
        this.o = this.h;
      }
      if ((!this.f.equals("")) && (this.p.trim().equals(""))) {
        this.p = this.f;
      }
      if ((!this.e.equals("")) && (this.q.trim().equals(""))) {
        this.q = this.e;
      }
      if ((!this.i.equals("")) && (this.r.trim().equals(""))) {
        this.r = this.i;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.l);
      ((StringBuilder)localObject).append("|||");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append("|||");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append("|||");
      ((StringBuilder)localObject).append(this.o);
      ((StringBuilder)localObject).append("|||");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append("|||");
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append("|||");
      ((StringBuilder)localObject).append(this.r);
      if (!((StringBuilder)localObject).toString().equals(str)) {
        b.a(paramContext, "f_non_empty_qimei_v2", ((StringBuilder)localObject).toString());
      }
      label724:
      try
      {
        paramContext = new com.tencent.beacon.d.b(paramContext).a();
        if ((paramContext != null) && (!"".equals(paramContext))) {
          this.a = paramContext;
        }
        return;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static j a(Context paramContext)
  {
    if (s == null) {
      s = new j(paramContext);
    }
    return s;
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
    return this.j;
  }
  
  public final boolean h()
  {
    return this.k;
  }
  
  public final String i()
  {
    return this.l;
  }
  
  public final String j()
  {
    return this.m;
  }
  
  public final String k()
  {
    return this.n;
  }
  
  public final String l()
  {
    return this.o;
  }
  
  public final String m()
  {
    return this.p;
  }
  
  public final String n()
  {
    return this.q;
  }
  
  public final String o()
  {
    return this.r;
  }
  
  public final String p()
  {
    return this.g;
  }
  
  public final String q()
  {
    return this.h;
  }
  
  public final String r()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.j
 * JD-Core Version:    0.7.0.1
 */