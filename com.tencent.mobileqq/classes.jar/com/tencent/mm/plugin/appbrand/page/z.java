package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

@SuppressLint({"ViewConstructor"})
public class z
  extends m
{
  private u b;
  private String c;
  
  public z(Context paramContext, o paramo)
  {
    super(paramContext, paramo);
  }
  
  protected View a()
  {
    if (this.b == null)
    {
      this.b = getContainer().j();
      this.b.a(this);
    }
    return this.b.getContentView();
  }
  
  public void a(String paramString)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandSinglePage", "AppBrandPageProfile| loadUrl");
    if (this.c != null) {
      return;
    }
    this.c = paramString;
    this.b.a(paramString);
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if (!a(paramArrayOfInt, this.b.getComponentId())) {
      return;
    }
    this.b.a(paramString1, paramString2);
  }
  
  public void b()
  {
    super.b();
    this.b.l();
  }
  
  public boolean b(String paramString)
  {
    return com.tencent.luggage.util.m.b(this.c).equals(com.tencent.luggage.util.m.b(paramString));
  }
  
  protected void c()
  {
    super.c();
    this.b.az();
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
    this.b.a(paramString);
  }
  
  public void d()
  {
    super.d();
    this.b.au();
  }
  
  public void e()
  {
    super.e();
    this.b.aw();
  }
  
  public u getCurrentPageView()
  {
    return this.b;
  }
  
  public String getCurrentUrl()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z
 * JD-Core Version:    0.7.0.1
 */