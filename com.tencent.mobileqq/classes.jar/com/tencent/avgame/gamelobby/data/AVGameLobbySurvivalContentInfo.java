package com.tencent.avgame.gamelobby.data;

import androidx.annotation.NonNull;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AVGameLobbySurvivalContentInfo
  extends AVGameBaseData
{
  private int a;
  private String b;
  private String c;
  private long d;
  private long e;
  private boolean f;
  private int g;
  private int h;
  private List<Long> i = new ArrayList();
  private String j;
  private String k;
  private String l;
  private boolean m = true;
  private int n;
  private int o;
  private String p;
  private String q;
  private boolean r;
  private int s;
  
  public AVGameLobbySurvivalContentInfo(int paramInt)
  {
    this.s = paramInt;
  }
  
  public int a()
  {
    return this.s;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean b()
  {
    return d() <= 2;
  }
  
  @NonNull
  public int c()
  {
    return 5;
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void c(String paramString)
  {
    this.j = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public int d()
  {
    if (this.d >= this.e) {
      return 0;
    }
    long l1 = System.currentTimeMillis() / 1000L;
    if (l1 >= this.e) {
      return 4;
    }
    long l2 = this.d;
    if (l1 >= l2) {
      return 3;
    }
    if (l2 - l1 > 900L) {
      return 1;
    }
    return 2;
  }
  
  public void d(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void d(String paramString)
  {
    this.k = paramString;
  }
  
  public String e()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    long l1 = this.d;
    if (l1 > 0L)
    {
      long l2 = this.e;
      if ((l2 > 0L) && (l1 <= l2))
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM月dd日 HH:mm");
        localStringBuffer.append("时间：");
        localStringBuffer.append(localSimpleDateFormat.format(Long.valueOf(this.d * 1000L)));
        localStringBuffer.append("～");
        if (l2 - l1 >= 86400L) {
          localStringBuffer.append(new SimpleDateFormat("MM月dd日 HH:mm").format(Long.valueOf(this.e * 1000L)));
        } else {
          localStringBuffer.append(new SimpleDateFormat("HH:mm").format(Long.valueOf(this.e * 1000L)));
        }
        return localStringBuffer.toString();
      }
    }
    return "";
  }
  
  public void e(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void e(String paramString)
  {
    this.l = paramString;
  }
  
  public int f()
  {
    return this.a;
  }
  
  public void f(String paramString)
  {
    this.p = paramString;
  }
  
  public String g()
  {
    return this.b;
  }
  
  public void g(String paramString)
  {
    this.q = paramString;
  }
  
  public String h()
  {
    return this.c;
  }
  
  public boolean i()
  {
    return this.f;
  }
  
  public int j()
  {
    return this.g;
  }
  
  public List k()
  {
    return this.i;
  }
  
  public String l()
  {
    return this.j;
  }
  
  public String m()
  {
    return this.k;
  }
  
  public String n()
  {
    return this.l;
  }
  
  public boolean o()
  {
    return this.m;
  }
  
  public int p()
  {
    return this.n;
  }
  
  public int q()
  {
    return this.o;
  }
  
  public String r()
  {
    return this.p;
  }
  
  public String s()
  {
    return this.q;
  }
  
  public boolean t()
  {
    return this.r;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbySurvivalContentInfo
 * JD-Core Version:    0.7.0.1
 */