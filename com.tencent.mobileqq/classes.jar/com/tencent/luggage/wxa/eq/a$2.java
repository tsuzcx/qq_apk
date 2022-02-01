package com.tencent.luggage.wxa.eq;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.wxa.bm.g.b;
import com.tencent.luggage.wxa.bm.g.b.a;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.y;

class a$2
  extends y
{
  a$2(a parama, g.b paramb) {}
  
  private WebResourceResponse a(String paramString)
  {
    if (this.a.a(paramString))
    {
      paramString = this.a.c(g.b.b);
      return new WebResourceResponse(paramString.a, paramString.b, paramString.c);
    }
    return null;
  }
  
  public WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    return a(paramWebResourceRequest.a().toString());
  }
  
  public WebResourceResponse a(WebView paramWebView, String paramString)
  {
    return a(paramString);
  }
  
  public WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return a(paramWebResourceRequest.a().toString());
  }
  
  public void c(WebView paramWebView, String paramString)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eq.a.2
 * JD-Core Version:    0.7.0.1
 */