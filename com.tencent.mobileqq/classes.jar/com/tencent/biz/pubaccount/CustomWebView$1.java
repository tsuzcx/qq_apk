package com.tencent.biz.pubaccount;

import android.os.Bundle;
import com.tencent.mobileqq.webview.cookie.SetCookiesCallback;

class CustomWebView$1
  implements SetCookiesCallback
{
  CustomWebView$1(CustomWebView paramCustomWebView, CustomWebView.LoadUrlInfo paramLoadUrlInfo) {}
  
  public void a(String paramString, Bundle paramBundle, long paramLong)
  {
    int i = this.a.a;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          this.b.loadDataWithBaseURL(paramString, this.a.c, this.a.d, this.a.e, this.a.f);
          return;
        }
        this.b.loadData(paramString, this.a.d, this.a.e);
        return;
      }
      this.b.loadUrlOriginal(paramString);
      return;
    }
    this.b.loadUrl(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebView.1
 * JD-Core Version:    0.7.0.1
 */