package com.huawei.secure.android.common.webview;

import android.util.Log;
import android.webkit.WebView;
import com.huawei.secure.android.common.util.b;
import com.huawei.secure.android.common.util.c;
import java.util.concurrent.CountDownLatch;

public class SafeGetUrl
{
  private static final long B = 200L;
  private static final String TAG = "SafeGetUrl";
  private String C;
  private WebView D;
  
  public SafeGetUrl() {}
  
  public SafeGetUrl(WebView paramWebView)
  {
    this.D = paramWebView;
  }
  
  public String getUrlMethod()
  {
    if (this.D == null) {
      return "";
    }
    if (b.h()) {
      return this.D.getUrl();
    }
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    c.a(new SafeGetUrl.1(this, localCountDownLatch));
    try
    {
      localCountDownLatch.await();
      return this.C;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Log.e("SafeGetUrl", "getUrlMethod: InterruptedException " + localInterruptedException.getMessage(), localInterruptedException);
      }
    }
  }
  
  public WebView getWebView()
  {
    return this.D;
  }
  
  public void setUrl(String paramString)
  {
    this.C = paramString;
  }
  
  public void setWebView(WebView paramWebView)
  {
    this.D = paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.webview.SafeGetUrl
 * JD-Core Version:    0.7.0.1
 */