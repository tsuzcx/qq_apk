package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.api.impl.WebProcessManagerServiceImpl;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.utils.ProxyConfig;
import com.tencent.qphone.base.util.QLog;

class QQBrowserActivity$1
  implements Runnable
{
  QQBrowserActivity$1(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start request: ");
      localStringBuilder.append(WebAccelerateHelper.isWebViewCache);
      QLog.d("WebLog_QQBrowserActivity", 2, localStringBuilder.toString());
    }
    WebProcessManagerServiceImpl.setPreloadSuccess(true);
    SwiftWebViewUtils.a();
    ProxyConfig.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity.1
 * JD-Core Version:    0.7.0.1
 */