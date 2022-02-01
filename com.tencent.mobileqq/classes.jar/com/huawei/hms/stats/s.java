package com.huawei.hms.stats;

public class s
{
  private p a;
  private p b;
  private p c;
  private p d;
  private String e;
  
  public s(String paramString)
  {
    this.e = paramString;
  }
  
  public p a()
  {
    return this.a;
  }
  
  public p a(String paramString)
  {
    if (paramString.equals("oper")) {
      return b();
    }
    if (paramString.equals("maint")) {
      return a();
    }
    if (paramString.equals("diffprivacy")) {
      return d();
    }
    if (paramString.equals("preins")) {
      return c();
    }
    af.c("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + paramString);
    return null;
  }
  
  public void a(p paramp)
  {
    this.a = paramp;
  }
  
  public p b()
  {
    return this.b;
  }
  
  public void b(p paramp)
  {
    this.b = paramp;
  }
  
  public p c()
  {
    return this.d;
  }
  
  public void c(p paramp)
  {
    this.d = paramp;
  }
  
  public p d()
  {
    return this.c;
  }
  
  public void d(p paramp)
  {
    this.c = paramp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.s
 * JD-Core Version:    0.7.0.1
 */