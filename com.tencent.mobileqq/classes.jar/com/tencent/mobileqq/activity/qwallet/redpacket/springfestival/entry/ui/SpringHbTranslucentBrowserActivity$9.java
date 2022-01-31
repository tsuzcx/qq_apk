package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import aguz;
import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;

public class SpringHbTranslucentBrowserActivity$9
  implements Runnable
{
  SpringHbTranslucentBrowserActivity$9(SpringHbTranslucentBrowserActivity paramSpringHbTranslucentBrowserActivity, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.b();
    if (localObject == null)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "getCurrentWebViewFragment is null");
      return;
    }
    localObject = ((WebViewFragment)localObject).getWebView();
    if (Build.VERSION.SDK_INT >= 19) {
      ((CustomWebView)localObject).evaluateJavascript(this.a, new aguz(this));
    }
    for (;;)
    {
      QLog.d("springHb_SpringHbTranslucentBrowserActivity", 2, "Build.VERSION.SDK_INT" + Build.VERSION.SDK_INT + "evaluateJavascript done，script：" + this.a + ",webView:" + localObject + ",currentTime:" + System.currentTimeMillis());
      return;
      ((CustomWebView)localObject).loadUrl(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbTranslucentBrowserActivity.9
 * JD-Core Version:    0.7.0.1
 */