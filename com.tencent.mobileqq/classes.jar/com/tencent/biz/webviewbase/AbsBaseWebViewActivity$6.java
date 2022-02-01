package com.tencent.biz.webviewbase;

import bgyb;
import com.tencent.mobileqq.webprocess.WebProcessManager;
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
    WebProcessManager.a(true);
    bgyb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity.6
 * JD-Core Version:    0.7.0.1
 */