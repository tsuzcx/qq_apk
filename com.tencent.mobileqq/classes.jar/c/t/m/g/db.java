package c.t.m.g;

import android.text.TextUtils;

public final class db
{
  public final da a;
  public int b;
  String c;
  String d;
  public String e;
  String f;
  public String g;
  public String h;
  public String i;
  public String j;
  int k;
  int l;
  public long m;
  public int n = -2;
  private String o;
  private String p = "5.3.7";
  private String q = "180306";
  
  db(da paramda)
  {
    this.a = paramda;
  }
  
  public final String a()
  {
    if (TextUtils.isEmpty(this.c)) {
      return "0123456789ABCDEF";
    }
    return this.c;
  }
  
  public final String b()
  {
    if (TextUtils.isEmpty(this.d)) {
      return "0123456789ABCDEF";
    }
    return this.d;
  }
  
  public final String c()
  {
    if ((TextUtils.isEmpty(this.f)) || (this.f.contains("0000"))) {
      return "0123456789ABCDEF";
    }
    return this.f;
  }
  
  public final String d()
  {
    if (this.p == null) {
      return "None";
    }
    return this.p;
  }
  
  public final String e()
  {
    if (this.q == null) {
      return "None";
    }
    return this.q;
  }
  
  public final String f()
  {
    if (this.o == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(a()).append("_").append(b()).append("_").append(c()).append("_QQGeoLocation");
      this.o = f.a.e(localStringBuilder.toString());
    }
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.db
 * JD-Core Version:    0.7.0.1
 */