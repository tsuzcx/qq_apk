package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;

public class StickerRecData
  extends SimpleRemoteEmoticon
{
  int a = 0;
  private String b;
  private String c;
  private String d;
  private String e;
  private int f;
  private int g;
  private int h;
  private int i;
  private long j;
  private long k;
  private String l;
  private boolean m;
  private boolean n;
  private int o;
  private String p;
  private String q;
  private String r;
  private int s = 0;
  private String t;
  private String u;
  private String v;
  private String w;
  private int x;
  private String y;
  
  public int A()
  {
    if (TextUtils.isEmpty(this.c)) {
      return this.g;
    }
    return this.i;
  }
  
  public String B()
  {
    if (TextUtils.isEmpty(this.l)) {
      this.l = StickerRecConstants.a(y());
    }
    return this.l;
  }
  
  public String C()
  {
    return this.q;
  }
  
  public String D()
  {
    return this.r;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(String paramString)
  {
    this.y = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(String paramString)
  {
    this.p = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.j = paramLong;
  }
  
  public void c(String paramString)
  {
    this.b = paramString;
  }
  
  public void d(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.k = paramLong;
  }
  
  public void d(String paramString)
  {
    this.c = paramString;
  }
  
  public boolean d()
  {
    return this.n;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public void e(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void e(String paramString)
  {
    this.d = paramString;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public void f(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void f(String paramString)
  {
    this.e = paramString;
  }
  
  public void g(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void g(String paramString)
  {
    this.t = paramString;
  }
  
  public boolean g()
  {
    return this.m;
  }
  
  public int h()
  {
    return 0;
  }
  
  public void h(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void h(String paramString)
  {
    this.u = paramString;
  }
  
  public int i()
  {
    return 0;
  }
  
  public void i(String paramString)
  {
    this.v = paramString;
  }
  
  public void j(String paramString)
  {
    this.w = paramString;
  }
  
  public void k(String paramString)
  {
    this.q = paramString;
  }
  
  public String l()
  {
    return this.d;
  }
  
  public void l(String paramString)
  {
    this.r = paramString;
  }
  
  public String n()
  {
    return this.y;
  }
  
  public String o()
  {
    return this.p;
  }
  
  public String p()
  {
    return this.e;
  }
  
  public long q()
  {
    return this.j;
  }
  
  public int r()
  {
    return this.o;
  }
  
  public int s()
  {
    return this.s;
  }
  
  public String t()
  {
    return this.t;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("imgUrl=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" thumbUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" imgMd5=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" thumbMd5=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" imgWidth=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" imgHeight=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" thumbWidth=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" thumbHeight=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" imgFileSize=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" thumbFileSize=");
    localStringBuilder.append(this.k);
    return localStringBuilder.toString();
  }
  
  public String u()
  {
    return this.u;
  }
  
  public String v()
  {
    return this.w;
  }
  
  public int w()
  {
    return this.x;
  }
  
  public String x()
  {
    if (TextUtils.isEmpty(this.c)) {
      return this.d;
    }
    return this.e;
  }
  
  public String y()
  {
    if (TextUtils.isEmpty(this.c)) {
      return this.b;
    }
    return this.c;
  }
  
  public int z()
  {
    if (TextUtils.isEmpty(this.c)) {
      return this.f;
    }
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData
 * JD-Core Version:    0.7.0.1
 */