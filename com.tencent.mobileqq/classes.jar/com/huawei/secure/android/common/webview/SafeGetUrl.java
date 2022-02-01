package com.huawei.secure.android.common.webview;

import android.util.Log;
import android.webkit.WebView;
import com.huawei.secure.android.common.util.b;
import com.huawei.secure.android.common.util.c;
import java.util.concurrent.CountDownLatch;

public class SafeGetUrl
{
  private static final long D = 200L;
  private static final String TAG = "SafeGetUrl";
  private String E;
  private WebView F;
  
  public SafeGetUrl() {}
  
  public SafeGetUrl(WebView paramWebView)
  {
    this.F = paramWebView;
  }
  
  public String getUrlMethod()
  {
    if (this.F == null) {
      return "";
    }
    if (b.isMainThread()) {
      return this.F.getUrl();
    }
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    c.a(new SafeGetUrl.1(this, localCountDownLatch));
    try
    {
      localCountDownLatch.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUrlMethod: InterruptedException ");
      localStringBuilder.append(localInterruptedException.getMessage());
      Log.e("SafeGetUrl", localStringBuilder.toString(), localInterruptedException);
    }
    return this.E;
  }
  
  public WebView getWebView()
  {
    return this.F;
  }
  
  public void setUrl(String paramString)
  {
    this.E = paramString;
  }
  
  public void setWebView(WebView paramWebView)
  {
    this.F = paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.webview.SafeGetUrl
 * JD-Core Version:    0.7.0.1
 */