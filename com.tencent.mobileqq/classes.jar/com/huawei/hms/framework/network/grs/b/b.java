package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.net.Uri;
import java.util.concurrent.Callable;

public class b
{
  protected d a;
  private String b;
  private a c;
  private int d;
  private Context e;
  private String f;
  
  public b(String paramString1, int paramInt, a parama, Context paramContext, String paramString2)
  {
    this.b = paramString1;
    this.c = parama;
    this.d = paramInt;
    this.e = paramContext;
    this.f = paramString2;
  }
  
  private String a(String paramString)
  {
    return Uri.parse(paramString).getPath();
  }
  
  private b.a g()
  {
    if (this.b.isEmpty()) {
      return b.a.c;
    }
    String str = a(this.b);
    if (str.contains("1.0")) {
      return b.a.b;
    }
    if (str.contains("2.0")) {
      return b.a.a;
    }
    return b.a.c;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public a b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public Context d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public Callable<d> f()
  {
    if (b.a.c.equals(g())) {
      return null;
    }
    if (b.a.b.equals(g())) {
      return new f(this.b, this.d, this.c, this.e, this.f);
    }
    return new g(this.b, this.d, this.c, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.b
 * JD-Core Version:    0.7.0.1
 */