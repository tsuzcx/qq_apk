package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.c;
import java.util.concurrent.Callable;

public class b
{
  protected f a;
  private String b;
  private a c;
  private int d;
  private Context e;
  private String f;
  private GrsBaseInfo g;
  private c h;
  
  public b(String paramString1, int paramInt, a parama, Context paramContext, String paramString2, GrsBaseInfo paramGrsBaseInfo, c paramc)
  {
    this.b = paramString1;
    this.c = parama;
    this.d = paramInt;
    this.e = paramContext;
    this.f = paramString2;
    this.g = paramGrsBaseInfo;
    this.h = paramc;
  }
  
  private String a(String paramString)
  {
    return Uri.parse(paramString).getPath();
  }
  
  private b.a h()
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
  
  public a a()
  {
    return this.c;
  }
  
  public Context b()
  {
    return this.e;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public c f()
  {
    return this.h;
  }
  
  public Callable<f> g()
  {
    if (b.a.c.equals(h())) {
      return null;
    }
    if (b.a.b.equals(h())) {
      return new i(this.b, this.d, this.c, this.e, this.f, this.g);
    }
    return new j(this.b, this.d, this.c, this.e, this.f, this.g, this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.b
 * JD-Core Version:    0.7.0.1
 */