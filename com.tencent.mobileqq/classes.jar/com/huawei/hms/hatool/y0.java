package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

public abstract class y0
{
  public final v0 a(int paramInt, Context paramContext)
  {
    String str2;
    String str1;
    if (paramInt != 0)
    {
      str2 = f();
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        return new v0(w0.b, str2);
      }
    }
    else
    {
      str1 = "";
    }
    if ((paramInt & 0x2) != 0)
    {
      str2 = b(paramContext);
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        return new v0(w0.a, str2);
      }
    }
    if ((paramInt & 0x1) != 0)
    {
      paramContext = c(paramContext);
      return new v0(w0.c, paramContext);
    }
    return new v0(w0.d, str1);
  }
  
  public v0 a(Context paramContext)
  {
    String str = c();
    if (!TextUtils.isEmpty(str)) {
      return new v0(w0.b, str);
    }
    str = a();
    if (!TextUtils.isEmpty(str)) {
      return new v0(w0.a, str);
    }
    boolean bool = e();
    str = b();
    if (!TextUtils.isEmpty(str))
    {
      if (bool) {
        return new v0(w0.c, str);
      }
      return new v0(w0.b, a(str));
    }
    if (bool) {
      return a(d(), paramContext);
    }
    return b(d(), paramContext);
  }
  
  public abstract String a();
  
  public abstract String a(String paramString);
  
  public final v0 b(int paramInt, Context paramContext)
  {
    if (((paramInt & 0x4) != 0) && ((paramInt & 0x1) != 0)) {
      return new v0(w0.b, a(c(paramContext)));
    }
    String str1;
    if ((paramInt & 0x1) != 0)
    {
      String str2 = c(paramContext);
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        return new v0(w0.c, str2);
      }
    }
    else
    {
      str1 = "";
    }
    if ((paramInt & 0x2) != 0)
    {
      paramContext = b(paramContext);
      return new v0(w0.a, paramContext);
    }
    return new v0(w0.d, str1);
  }
  
  public abstract String b();
  
  public final String b(Context paramContext)
  {
    l locall = i.c().b();
    if (TextUtils.isEmpty(locall.m())) {
      locall.h(z0.f(paramContext));
    }
    return locall.m();
  }
  
  public abstract String c();
  
  public final String c(Context paramContext)
  {
    l locall = i.c().b();
    if (TextUtils.isEmpty(locall.a())) {
      locall.l(z0.h(paramContext));
    }
    return locall.a();
  }
  
  public abstract int d();
  
  public final boolean e()
  {
    l locall = i.c().b();
    if (TextUtils.isEmpty(locall.i())) {
      locall.e(f.a());
    }
    return TextUtils.isEmpty(locall.i()) ^ true;
  }
  
  public final String f()
  {
    l locall = i.c().b();
    if (TextUtils.isEmpty(locall.c())) {
      locall.m(z0.c());
    }
    return locall.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.y0
 * JD-Core Version:    0.7.0.1
 */