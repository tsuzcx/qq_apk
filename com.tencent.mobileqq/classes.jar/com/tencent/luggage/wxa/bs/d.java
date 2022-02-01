package com.tencent.luggage.wxa.bs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.u;

@SuppressLint({"ViewConstructor"})
public class d
  extends m
{
  private u b;
  private String c;
  
  public d(Context paramContext, com.tencent.mm.plugin.appbrand.page.o paramo)
  {
    super(paramContext, paramo);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.WAGamePage", "hy: WAGamePage on create");
  }
  
  private u f()
  {
    return getContainer().j();
  }
  
  protected View a()
  {
    u localu = f();
    this.b = localu;
    return localu.getContentView();
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
    this.b.a(paramString);
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    this.b.a(paramString1, paramString2);
  }
  
  public void b()
  {
    super.b();
    this.b.l();
  }
  
  public boolean b(String paramString)
  {
    return true;
  }
  
  public void c()
  {
    super.c();
    this.b.az();
  }
  
  public void d()
  {
    super.d();
    setEnableGesture(false);
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
  
  public void setCurrentUrl(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bs.d
 * JD-Core Version:    0.7.0.1
 */