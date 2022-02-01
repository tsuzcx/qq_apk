package com.tencent.biz.pubaccount.weishi_new;

public class WSPublicAccLaunchParams
{
  private final String a;
  private final int b;
  private final boolean c;
  private String d;
  private String e;
  private boolean f;
  
  public WSPublicAccLaunchParams(String paramString, int paramInt, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramBoolean;
  }
  
  public WSPublicAccLaunchParams a(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public WSPublicAccLaunchParams a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public WSPublicAccLaunchParams b(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public boolean e()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSPublicAccLaunchParams
 * JD-Core Version:    0.7.0.1
 */