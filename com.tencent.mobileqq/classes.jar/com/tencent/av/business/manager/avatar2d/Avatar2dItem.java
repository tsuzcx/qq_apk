package com.tencent.av.business.manager.avatar2d;

import com.tencent.av.business.manager.pendant.ItemBase;

public class Avatar2dItem
  extends ItemBase
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e = "";
  private boolean f;
  private String g;
  private String h;
  private int i;
  private String j;
  private String k;
  private String l;
  private String m = null;
  private String n = null;
  
  public String a()
  {
    return this.e;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b()
  {
    return this.g;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public String c()
  {
    return this.m;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public String d()
  {
    return this.n;
  }
  
  public void d(String paramString)
  {
    this.j = paramString;
  }
  
  public String e()
  {
    return this.l;
  }
  
  public void e(String paramString)
  {
    this.b = paramString;
  }
  
  public void f(String paramString)
  {
    this.c = paramString;
  }
  
  public void g(String paramString)
  {
    this.g = paramString;
  }
  
  public String getDesc()
  {
    return this.k;
  }
  
  public String getIconUrl()
  {
    return this.d;
  }
  
  public String getId()
  {
    return this.a;
  }
  
  public String getMd5()
  {
    return this.c;
  }
  
  public int getPlatform()
  {
    return this.i;
  }
  
  public String getResUrl()
  {
    return this.b;
  }
  
  public String getVersion()
  {
    return this.j;
  }
  
  public void h(String paramString)
  {
    this.h = paramString;
  }
  
  public void i(String paramString)
  {
    this.m = paramString;
  }
  
  public boolean isUsable()
  {
    return this.f;
  }
  
  public void j(String paramString)
  {
    this.n = paramString;
  }
  
  public void k(String paramString)
  {
    this.l = paramString;
  }
  
  public void setUsable(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], name[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], isDownloading[");
    localStringBuilder.append(this.isDownloading);
    localStringBuilder.append("] resUrl[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("] md5[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] iconUrl[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("] usable[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("] version[");
    localStringBuilder.append(this.j);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.avatar2d.Avatar2dItem
 * JD-Core Version:    0.7.0.1
 */