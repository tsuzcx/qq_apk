package com.huawei.hms.stats;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.util.UUID;

public class bg
{
  private static bg b;
  private Context a;
  
  public static bg a()
  {
    try
    {
      if (b == null) {
        b = new bg();
      }
      bg localbg = b;
      return localbg;
    }
    finally {}
  }
  
  public be a(String paramString1, String paramString2)
  {
    return new bg.a(paramString1, paramString2).a(this.a);
  }
  
  public String a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      localObject = "";
    }
    do
    {
      return localObject;
      str = b.g();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    String str = ap.b(this.a, "global_v2", "uuid", "");
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = UUID.randomUUID().toString().replace("-", "");
      ap.a(this.a, "global_v2", "uuid", (String)localObject);
    }
    b.a((String)localObject);
    return localObject;
  }
  
  public void a(Context paramContext)
  {
    if (this.a == null) {
      this.a = paramContext;
    }
  }
  
  public Pair<String, String> b(String paramString1, String paramString2)
  {
    if (a.f(paramString1, paramString2))
    {
      paramString1 = n.a().c().n();
      paramString2 = n.a().c().o();
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
      {
        paramString1 = bi.g(this.a);
        n.a().c().l((String)paramString1.first);
        n.a().c().m((String)paramString1.second);
        return paramString1;
      }
      return new Pair(paramString1, paramString2);
    }
    return new Pair("", "");
  }
  
  public String c(String paramString1, String paramString2)
  {
    return bj.b(paramString1, paramString2);
  }
  
  public String d(String paramString1, String paramString2)
  {
    return bj.a(this.a, paramString1, paramString2);
  }
  
  public String e(String paramString1, String paramString2)
  {
    return bj.b(this.a, paramString1, paramString2);
  }
  
  public String f(String paramString1, String paramString2)
  {
    return bj.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.bg
 * JD-Core Version:    0.7.0.1
 */