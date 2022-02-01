package com.tencent.biz.pubaccount.weishi_new.drama;

import android.content.Context;

public class WSDramaPageIntentParams
{
  private final String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private int f;
  private int g;
  private Context h;
  
  public WSDramaPageIntentParams(String paramString, Context paramContext)
  {
    this.a = paramString;
    this.h = paramContext;
  }
  
  public WSDramaPageIntentParams a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public Context b()
  {
    return this.h;
  }
  
  public WSDramaPageIntentParams b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public WSDramaPageIntentParams c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public int e()
  {
    return this.f;
  }
  
  public int f()
  {
    return this.g;
  }
  
  public String g()
  {
    return this.d;
  }
  
  public String h()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageIntentParams
 * JD-Core Version:    0.7.0.1
 */