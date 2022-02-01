package com.tencent.biz.webviewbase;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;

class AbsBaseWebViewActivity$6
  implements Runnable
{
  AbsBaseWebViewActivity$6(AbsBaseWebViewActivity paramAbsBaseWebViewActivity, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start request: ");
      localStringBuilder.append(this.a);
      QLog.d("WebLog_WebViewBase", 2, localStringBuilder.toString());
    }
    ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).setPreloadWebProcess(true);
    SwiftWebViewUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity.6
 * JD-Core Version:    0.7.0.1
 */