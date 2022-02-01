package com.huawei.hms.stats;

import android.text.TextUtils;

public class am
{
  private static am a;
  private String b;
  private String c;
  
  public static am a()
  {
    if (a == null) {
      d();
    }
    return a;
  }
  
  private boolean a(String paramString)
  {
    af.b("RootKeyManager", "refresh sp aes key");
    paramString = e.a().a(e.a.a).b(f(), paramString);
    if (TextUtils.isEmpty(paramString))
    {
      af.b("RootKeyManager", "refreshLocalKey(): encrypted key is empty");
      return false;
    }
    ap.a(b.j(), "Privacy_MY", "PrivacyData", paramString);
    ap.a(b.j(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
    return true;
  }
  
  private static void d()
  {
    try
    {
      if (a == null) {
        a = new am();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private String e()
  {
    Object localObject = ap.b(b.j(), "Privacy_MY", "PrivacyData", "");
    e locale = e.a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = locale.b(e.a.a);
      a((String)localObject);
    }
    String str;
    do
    {
      return localObject;
      str = locale.a(e.a.a).a(f(), (String)localObject);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    localObject = locale.b(e.a.a);
    a((String)localObject);
    return localObject;
  }
  
  private String f()
  {
    if (TextUtils.isEmpty(this.c)) {
      this.c = new al().a();
    }
    return this.c;
  }
  
  public void b()
  {
    String str = e.a().b(e.a.a);
    if (a(str)) {
      this.b = str;
    }
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.b)) {
      this.b = e();
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.am
 * JD-Core Version:    0.7.0.1
 */