package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.util.UUID;

public class x0
{
  public static x0 b;
  public Context a;
  
  public static x0 a()
  {
    try
    {
      if (b == null) {
        b = new x0();
      }
      x0 localx0 = b;
      return localx0;
    }
    finally {}
  }
  
  public String a(String paramString1, String paramString2)
  {
    return g.a(this.a, paramString1, paramString2);
  }
  
  public String a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return "";
    }
    String str2 = b.j();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str2 = g0.a(this.a, "global_v2", "uuid", "");
      str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = UUID.randomUUID().toString().replace("-", "");
        g0.b(this.a, "global_v2", "uuid", str1);
      }
      b.c(str1);
    }
    return str1;
  }
  
  public void a(Context paramContext)
  {
    if (this.a == null) {
      this.a = paramContext;
    }
  }
  
  public String b(String paramString1, String paramString2)
  {
    return g.b(this.a, paramString1, paramString2);
  }
  
  public v0 c(String paramString1, String paramString2)
  {
    return new x0.a(paramString1, paramString2).a(this.a);
  }
  
  public String d(String paramString1, String paramString2)
  {
    return a1.b(paramString1, paramString2);
  }
  
  public Pair<String, String> e(String paramString1, String paramString2)
  {
    if (a.f(paramString1, paramString2))
    {
      paramString1 = i.c().b().n();
      paramString2 = i.c().b().o();
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        return new Pair(paramString1, paramString2);
      }
      paramString1 = z0.e(this.a);
      i.c().b().i((String)paramString1.first);
      i.c().b().j((String)paramString1.second);
      return paramString1;
    }
    return new Pair("", "");
  }
  
  public String f(String paramString1, String paramString2)
  {
    return a1.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.x0
 * JD-Core Version:    0.7.0.1
 */