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
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "start request: " + this.a);
    }
    ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).setPreloadWebProcess(true);
    SwiftWebViewUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity.6
 * JD-Core Version:    0.7.0.1
 */