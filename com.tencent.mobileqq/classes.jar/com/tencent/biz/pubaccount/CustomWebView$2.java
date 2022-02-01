package com.tencent.biz.pubaccount;

import com.tencent.qphone.base.util.QLog;

class CustomWebView$2
  implements Runnable
{
  CustomWebView$2(CustomWebView paramCustomWebView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomWebView", 2, "webview real destroy now");
    }
    this.this$0.destroyWebView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebView.2
 * JD-Core Version:    0.7.0.1
 */