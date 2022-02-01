package com.tencent.mobileqq.activity;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;

class QQBrowserActivity$3
  implements Runnable
{
  QQBrowserActivity$3(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void run()
  {
    WebViewTitleStyleHelper.getsInstance().parseJson(BaseApplicationImpl.sApplication.waitAppRuntime(null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity.3
 * JD-Core Version:    0.7.0.1
 */