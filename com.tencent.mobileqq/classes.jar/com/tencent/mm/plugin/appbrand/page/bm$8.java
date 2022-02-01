package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.y;

class bm$8
  extends y
{
  bm$8(bm parambm) {}
  
  public WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.a() != null) && (!af.c(paramWebResourceRequest.a().toString())))
    {
      paramWebView = paramWebResourceRequest.a().toString();
      return bm.a(this.a, paramWebView);
    }
    return null;
  }
  
  public WebResourceResponse a(WebView paramWebView, String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    return bm.a(this.a, paramString);
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    com.tencent.luggage.wxa.qz.o.b("Luggage.XWebViewImpl", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
  }
  
  public void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    paramWebView = paramWebResourceRequest.a();
    if (paramWebView == null) {
      paramWebView = "null";
    } else {
      paramWebView = paramWebView.toString();
    }
    com.tencent.luggage.wxa.qz.o.b("Luggage.XWebViewImpl", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", new Object[] { paramWebView, paramWebResourceResponse.b(), Integer.valueOf(paramWebResourceResponse.d()) });
  }
  
  public void a(WebView paramWebView, com.tencent.xweb.o paramo, SslError paramSslError)
  {
    if (paramSslError.getPrimaryError() == 3)
    {
      if (bm.d(this.a).a(paramSslError.getCertificate()))
      {
        paramo.a();
        return;
      }
      paramo.b();
      return;
    }
    paramo.b();
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    bm.d(this.a).b(paramString);
  }
  
  public WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.a() != null) && (!af.c(paramWebResourceRequest.a().toString())))
    {
      paramWebView = paramWebResourceRequest.a().toString();
      return bm.a(this.a, paramWebView);
    }
    return null;
  }
  
  public boolean b(WebView paramWebView, String paramString)
  {
    com.tencent.luggage.wxa.qz.o.d("Luggage.XWebViewImpl", "shouldOverrideUrlLoading, url = %s", new Object[] { paramString });
    return true;
  }
  
  public void c(WebView paramWebView, String paramString)
  {
    bm.d(this.a).c(paramString);
  }
  
  public void d(WebView paramWebView, String paramString)
  {
    bm.d(this.a).d(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bm.8
 * JD-Core Version:    0.7.0.1
 */