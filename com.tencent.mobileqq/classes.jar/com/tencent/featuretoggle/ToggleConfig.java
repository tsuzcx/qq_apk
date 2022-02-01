package com.tencent.featuretoggle;

import android.text.TextUtils;
import com.tencent.featuretoggle.utils.LogUtils;
import com.tencent.featuretoggle.utils.Utils;
import java.util.Map;

public class ToggleConfig
{
  private String a;
  private String b;
  private String c;
  private String d = "";
  private String e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private String i = "";
  private long j = 120000L;
  private String k = "";
  private Map<String, String> l;
  private int m = 0;
  private String n = "";
  private int o = (int)(Runtime.getRuntime().totalMemory() / 1024L / 8L);
  
  public ToggleConfig() {}
  
  public ToggleConfig(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.c = paramString2;
    this.b = paramString3;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 10L)
    {
      LogUtils.c("The time must be greater than 10, Unit: second ,set duration 10", new Object[0]);
      l1 = 10L;
    }
    this.j = (l1 * 1000L);
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    if (Utils.a(paramString)) {
      return;
    }
    this.e = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.i = str;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.n = paramString;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public void e(String paramString)
  {
    this.a = paramString;
  }
  
  public void f(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public void g(String paramString)
  {
    this.c = paramString;
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    return this.h;
  }
  
  public String i()
  {
    return this.i;
  }
  
  public long j()
  {
    return this.j;
  }
  
  public String k()
  {
    return this.k;
  }
  
  public Map<String, String> l()
  {
    return this.l;
  }
  
  public int m()
  {
    return this.m;
  }
  
  public String n()
  {
    return this.n;
  }
  
  public int o()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.ToggleConfig
 * JD-Core Version:    0.7.0.1
 */