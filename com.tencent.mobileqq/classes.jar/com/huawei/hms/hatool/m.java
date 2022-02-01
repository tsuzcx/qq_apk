package com.huawei.hms.hatool;

public class m
{
  public k a;
  public k b;
  public k c;
  public k d;
  
  public m(String paramString) {}
  
  public k a()
  {
    return this.c;
  }
  
  public k a(String paramString)
  {
    if (paramString.equals("oper")) {
      return c();
    }
    if (paramString.equals("maint")) {
      return b();
    }
    if (paramString.equals("diffprivacy")) {
      return a();
    }
    if (paramString.equals("preins")) {
      return d();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HiAnalyticsInstData.getConfig(type): wrong type: ");
    localStringBuilder.append(paramString);
    y.f("hmsSdk", localStringBuilder.toString());
    return null;
  }
  
  public void a(k paramk)
  {
    this.a = paramk;
  }
  
  public k b()
  {
    return this.a;
  }
  
  public void b(k paramk)
  {
    this.b = paramk;
  }
  
  public k c()
  {
    return this.b;
  }
  
  public k d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.m
 * JD-Core Version:    0.7.0.1
 */