package com.tencent.biz.pubaccount.weishi_new;

import android.content.Context;

public class WSHomeLaunchParams
{
  private final Context a;
  private final int b;
  private final String c;
  private boolean d;
  private boolean e;
  private String f;
  private String g;
  private String h;
  private WSOpenHomeThenVideoParams i;
  
  public WSHomeLaunchParams(Context paramContext, int paramInt, String paramString)
  {
    this.a = paramContext;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public Context a()
  {
    return this.a;
  }
  
  public WSHomeLaunchParams a(WSOpenHomeThenVideoParams paramWSOpenHomeThenVideoParams)
  {
    this.i = paramWSOpenHomeThenVideoParams;
    return this;
  }
  
  public WSHomeLaunchParams a(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public WSHomeLaunchParams a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public WSHomeLaunchParams b(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public WSHomeLaunchParams b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public WSHomeLaunchParams c(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.f;
  }
  
  public String e()
  {
    return this.g;
  }
  
  public String f()
  {
    return this.h;
  }
  
  public boolean g()
  {
    return this.e;
  }
  
  public WSOpenHomeThenVideoParams h()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeLaunchParams
 * JD-Core Version:    0.7.0.1
 */