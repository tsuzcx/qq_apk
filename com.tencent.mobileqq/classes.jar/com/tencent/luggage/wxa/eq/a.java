package com.tencent.luggage.wxa.eq;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.bm.g;
import com.tencent.luggage.wxa.bm.g.a;
import com.tencent.luggage.wxa.bm.g.b;
import com.tencent.mm.plugin.appbrand.page.bm;
import com.tencent.xweb.WebView;

public class a
  implements g
{
  public static final a a = new a();
  private WebView b;
  
  public View a()
  {
    return this.b;
  }
  
  public void a(float paramFloat)
  {
    this.b.setTranslationY(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.b.setVisibility(paramInt);
  }
  
  public void a(Context paramContext)
  {
    this.b = new bm(paramContext);
  }
  
  public void a(g.b paramb)
  {
    this.b.setWebViewClient(new a.2(this, paramb));
  }
  
  public void a(String paramString)
  {
    this.b.loadUrl(paramString);
  }
  
  public g.a b()
  {
    return new a.1(this, this.b.getSettings());
  }
  
  public void b(String paramString)
  {
    this.b.evaluateJavascript(paramString, null);
  }
  
  public void c()
  {
    this.b.requestLayout();
  }
  
  public void d()
  {
    this.b.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eq.a
 * JD-Core Version:    0.7.0.1
 */