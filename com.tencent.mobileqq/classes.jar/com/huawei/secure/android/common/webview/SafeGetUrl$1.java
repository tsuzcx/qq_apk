package com.huawei.secure.android.common.webview;

import android.webkit.WebView;
import java.util.concurrent.CountDownLatch;

class SafeGetUrl$1
  implements Runnable
{
  SafeGetUrl$1(SafeGetUrl paramSafeGetUrl, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    SafeGetUrl localSafeGetUrl = this.H;
    localSafeGetUrl.setUrl(SafeGetUrl.a(localSafeGetUrl).getUrl());
    this.G.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.webview.SafeGetUrl.1
 * JD-Core Version:    0.7.0.1
 */