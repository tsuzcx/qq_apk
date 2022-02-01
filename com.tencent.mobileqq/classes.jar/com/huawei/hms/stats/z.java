package com.huawei.hms.stats;

import android.text.TextUtils;

public class z
{
  private static z a = new z();
  private final Object b = new Object();
  private String c;
  
  public static z a()
  {
    return a;
  }
  
  private String c()
  {
    String str1 = am.a().c();
    String str2 = ap.b(b.j(), "global_v2", "common_prop", "");
    return e.a().a(e.a.a).a(str1, str2);
  }
  
  private void d()
  {
    String str = am.a().c();
    str = e.a().a(e.a.a).b(str, this.c);
    ap.a(b.j(), "global_v2", "common_prop", str);
  }
  
  public void a(String paramString)
  {
    synchronized (this.b)
    {
      this.c = paramString;
      d();
      return;
    }
  }
  
  public String b()
  {
    synchronized (this.b)
    {
      if (TextUtils.isEmpty(this.c)) {
        this.c = c();
      }
      String str = this.c;
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.z
 * JD-Core Version:    0.7.0.1
 */