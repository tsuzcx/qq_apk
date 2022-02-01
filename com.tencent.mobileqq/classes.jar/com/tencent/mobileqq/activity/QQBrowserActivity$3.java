package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import mqq.app.MobileQQ;

class QQBrowserActivity$3
  implements Runnable
{
  QQBrowserActivity$3(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void run()
  {
    WebViewTitleStyleHelper.a().a(MobileQQ.sMobileQQ.waitAppRuntime(null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity.3
 * JD-Core Version:    0.7.0.1
 */