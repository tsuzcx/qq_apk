package com.tencent.luggage.wxa.ct;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.wxa.cv.c;
import com.tencent.luggage.wxa.ov.n;
import com.tencent.luggage.wxa.rt.k;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.y;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import org.jetbrains.annotations.Nullable;

class a$7
  extends y
{
  a$7(a parama) {}
  
  @Nullable
  private WebResourceResponse a(String paramString)
  {
    if (!c.b(paramString)) {
      return new WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
    }
    com.tencent.mm.plugin.appbrand.appstorage.o localo = a.c(this.a).getFileSystem();
    if (localo != null)
    {
      paramString = localo.a(paramString, false);
      if (paramString == null) {}
    }
    try
    {
      paramString = new WebResourceResponse("", "", k.a(paramString));
      return paramString;
    }
    catch (FileNotFoundException paramString) {}
    return null;
    return null;
  }
  
  public WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    if (paramWebResourceRequest != null)
    {
      if (paramWebResourceRequest.a() == null) {
        return null;
      }
      try
      {
        a.g(this.a).a(this.a.getPageView(), this.a.getUrl(), paramWebResourceRequest);
      }
      catch (Exception localException)
      {
        com.tencent.luggage.wxa.qz.o.a("Luggage.STANDALONE.AppBrandHTMLWebView", localException, "", new Object[0]);
      }
      paramWebResourceRequest = paramWebResourceRequest.a().toString();
      WebResourceResponse localWebResourceResponse = a(paramWebResourceRequest);
      if (localWebResourceResponse != null) {
        return localWebResourceResponse;
      }
      try
      {
        int i = paramBundle.getInt("resourceType");
        if ((i == 1) || (i == 7))
        {
          a.d(this.a).c(paramWebView, paramWebResourceRequest, a.f(this.a));
          return null;
        }
      }
      catch (Throwable paramWebView)
      {
        com.tencent.luggage.wxa.qz.o.b("Luggage.STANDALONE.AppBrandHTMLWebView", "shouldInterceptRequest with url(%s) and bundle, check resourceType get exception %s", new Object[] { paramWebResourceRequest, paramWebView });
      }
    }
    return null;
  }
  
  public WebResourceResponse a(WebView paramWebView, String paramString)
  {
    return a(paramString);
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.a.a(paramString2, paramInt, paramString1);
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    com.tencent.luggage.wxa.qz.o.d("Luggage.STANDALONE.AppBrandHTMLWebView", "onPageStarted hash:%d, url:%s", new Object[] { Integer.valueOf(this.a.hashCode()), paramString });
    a.a(this.a, paramString, paramBitmap);
    a.d(this.a).a(paramWebView, paramString, a.f(this.a));
  }
  
  public boolean a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.a() != null) && (a.d(this.a).b(paramWebView, paramWebResourceRequest.a().toString(), a.f(this.a)))) {
      return true;
    }
    return super.a(paramWebView, paramWebResourceRequest);
  }
  
  public WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.a() != null))
    {
      try
      {
        a.g(this.a).a(this.a.getPageView(), this.a.getUrl(), paramWebResourceRequest);
      }
      catch (Exception paramWebView)
      {
        com.tencent.luggage.wxa.qz.o.a("Luggage.STANDALONE.AppBrandHTMLWebView", paramWebView, "", new Object[0]);
      }
      return a(paramWebResourceRequest.a().toString());
    }
    return null;
  }
  
  public boolean b(WebView paramWebView, String paramString)
  {
    if (!c.b(paramString))
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.STANDALONE.AppBrandHTMLWebView", "shouldOverrideUrlLoading invalid url(%s)", new Object[] { paramString });
      return true;
    }
    if (a.d(this.a).b(paramWebView, paramString, a.f(this.a))) {
      return true;
    }
    return super.b(paramWebView, paramString);
  }
  
  public void c(WebView paramWebView, String paramString)
  {
    com.tencent.luggage.wxa.qz.o.d("Luggage.STANDALONE.AppBrandHTMLWebView", "onPageFinished hash:%d, url:%s", new Object[] { Integer.valueOf(this.a.hashCode()), paramString });
    a.b(this.a, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageFinished: ");
    localStringBuilder.append(paramString);
    com.tencent.luggage.wxa.qz.o.d("Luggage.STANDALONE.AppBrandHTMLWebView", localStringBuilder.toString());
    a.d(this.a).a(paramWebView, paramString);
  }
  
  public void d(WebView paramWebView, String paramString)
  {
    a.c(this.a, paramString);
    a.d(this.a).b(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.a.7
 * JD-Core Version:    0.7.0.1
 */