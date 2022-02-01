package com.tencent.biz.pubaccount;

import com.tencent.qphone.base.util.QLog;

class CustomWebView$3
  implements Runnable
{
  CustomWebView$3(CustomWebView paramCustomWebView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomWebView", 2, "webview real destroy now");
    }
    this.this$0.destroyWebView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebView.3
 * JD-Core Version:    0.7.0.1
 */