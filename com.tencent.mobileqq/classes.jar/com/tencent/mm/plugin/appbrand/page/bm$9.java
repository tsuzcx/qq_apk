package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.luggage.wxa.oq.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.u;

class bm$9
  extends u
{
  bm$9(bm parambm) {}
  
  public boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    o.c("Luggage.XWebViewImpl", "WebChromeClient onEnterFullscreen");
    if (this.a.isXWalkKernel())
    {
      if (bm.e(this.a) != null) {
        bm.e(this.a).a(new bm.9.1(this, paramCustomViewCallback));
      }
      return true;
    }
    return super.a(paramView, paramCustomViewCallback);
  }
  
  public boolean a(ConsoleMessage paramConsoleMessage)
  {
    if ((paramConsoleMessage != null) && (bm.d(this.a) != null)) {
      bm.d(this.a).a(paramConsoleMessage);
    }
    return super.a(paramConsoleMessage);
  }
  
  public void b(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    try
    {
      if (bm.e(this.a) != null)
      {
        bm.e(this.a).a(paramView, 90);
        bm.e(this.a).a(paramCustomViewCallback);
        return;
      }
    }
    catch (Exception paramView)
    {
      paramCustomViewCallback = new StringBuilder();
      paramCustomViewCallback.append("onShowCustomView error ");
      paramCustomViewCallback.append(paramView.getMessage());
      o.b("Luggage.XWebViewImpl", paramCustomViewCallback.toString());
    }
  }
  
  public void c()
  {
    try
    {
      if (bm.e(this.a) != null)
      {
        bm.e(this.a).c();
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHideCustomView error ");
      localStringBuilder.append(localException.getMessage());
      o.b("Luggage.XWebViewImpl", localStringBuilder.toString());
    }
  }
  
  public boolean o_()
  {
    o.c("Luggage.XWebViewImpl", "WebChromeClient onExitFullscreen");
    if (this.a.isXWalkKernel()) {
      return true;
    }
    return super.o_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bm.9
 * JD-Core Version:    0.7.0.1
 */