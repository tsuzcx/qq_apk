package com.huawei.hms.stats;

import android.content.Context;
import android.text.TextUtils;

public abstract class bh
{
  private be a(int paramInt, Context paramContext)
  {
    if (((paramInt & 0x4) != 0) && ((paramInt & 0x1) != 0)) {
      return new be(bf.b, a(b(paramContext)));
    }
    String str1;
    if ((paramInt & 0x1) != 0)
    {
      String str2 = b(paramContext);
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        return new be(bf.c, str2);
      }
    }
    else
    {
      str1 = "";
    }
    if ((paramInt & 0x2) != 0)
    {
      paramContext = c(paramContext);
      return new be(bf.a, paramContext);
    }
    return new be(bf.d, str1);
  }
  
  private be b(int paramInt, Context paramContext)
  {
    Object localObject = "";
    if (paramInt != 0)
    {
      localObject = f();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return new be(bf.b, (String)localObject);
      }
    }
    if ((paramInt & 0x2) != 0)
    {
      String str = c(paramContext);
      localObject = str;
      if (!TextUtils.isEmpty(str)) {
        return new be(bf.a, str);
      }
    }
    if ((paramInt & 0x1) != 0)
    {
      paramContext = b(paramContext);
      return new be(bf.c, paramContext);
    }
    return new be(bf.d, (String)localObject);
  }
  
  private String b(Context paramContext)
  {
    q localq = n.a().c();
    if (TextUtils.isEmpty(localq.d())) {
      localq.a(bi.f(paramContext));
    }
    return localq.d();
  }
  
  private String c(Context paramContext)
  {
    q localq = n.a().c();
    if (TextUtils.isEmpty(localq.g())) {
      localq.d(bi.e(paramContext));
    }
    return localq.g();
  }
  
  private boolean e()
  {
    q localq = n.a().c();
    if (TextUtils.isEmpty(localq.f())) {
      localq.c(bi.a());
    }
    return !TextUtils.isEmpty(localq.f());
  }
  
  private String f()
  {
    q localq = n.a().c();
    if (TextUtils.isEmpty(localq.h())) {
      localq.e(bi.c());
    }
    return localq.h();
  }
  
  public be a(Context paramContext)
  {
    String str = a();
    if (!TextUtils.isEmpty(str)) {
      return new be(bf.b, str);
    }
    str = b();
    if (!TextUtils.isEmpty(str)) {
      return new be(bf.a, str);
    }
    boolean bool = e();
    str = c();
    if (!TextUtils.isEmpty(str))
    {
      if (bool) {
        return new be(bf.c, str);
      }
      return new be(bf.b, a(str));
    }
    if (bool) {
      return b(d(), paramContext);
    }
    return a(d(), paramContext);
  }
  
  public abstract String a();
  
  public abstract String a(String paramString);
  
  public abstract String b();
  
  public abstract String c();
  
  public abstract int d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.bh
 * JD-Core Version:    0.7.0.1
 */