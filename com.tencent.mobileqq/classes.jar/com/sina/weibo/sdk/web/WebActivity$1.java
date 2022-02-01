package com.sina.weibo.sdk.web;

import android.text.TextUtils;
import android.webkit.WebView;
import com.sina.weibo.sdk.web.b.b.a;

final class WebActivity$1
  implements b.a
{
  WebActivity$1(WebActivity paramWebActivity) {}
  
  public final void onComplete()
  {
    String str = WebActivity.a(this.aA).getUrl();
    if (!TextUtils.isEmpty(str)) {
      WebActivity.b(this.aA).loadUrl(str);
    }
  }
  
  public final void onError(String paramString)
  {
    WebActivity.c(this.aA).m(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.web.WebActivity.1
 * JD-Core Version:    0.7.0.1
 */