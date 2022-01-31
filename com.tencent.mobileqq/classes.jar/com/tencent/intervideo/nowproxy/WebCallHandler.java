package com.tencent.intervideo.nowproxy;

import android.app.Activity;
import android.webkit.WebView;

public abstract interface WebCallHandler
{
  public abstract void getCookieInfo(NowCookieEvent paramNowCookieEvent);
  
  public abstract boolean onCallScheme(String paramString);
  
  public abstract void onWebPageReady(Activity paramActivity, WebView paramWebView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.WebCallHandler
 * JD-Core Version:    0.7.0.1
 */