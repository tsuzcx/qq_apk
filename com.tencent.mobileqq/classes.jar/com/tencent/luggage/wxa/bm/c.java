package com.tencent.luggage.wxa.bm;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView;

public class c
  implements g
{
  private WebView a;
  
  public View a()
  {
    return this.a;
  }
  
  public void a(float paramFloat)
  {
    this.a.setTranslationY(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
  
  public void a(Context paramContext)
  {
    this.a = new DtWebView(paramContext);
  }
  
  public void a(g.b paramb)
  {
    this.a.setWebViewClient(new c.2(this, paramb));
  }
  
  public void a(String paramString)
  {
    this.a.loadUrl(paramString);
  }
  
  public g.a b()
  {
    return new c.1(this, this.a.getSettings());
  }
  
  public void b(String paramString)
  {
    this.a.evaluateJavascript(paramString, null);
  }
  
  public void c()
  {
    this.a.requestLayout();
  }
  
  public void d()
  {
    this.a.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bm.c
 * JD-Core Version:    0.7.0.1
 */