package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;

class BrowserAppInterface$TBSLogRunnable
  implements Runnable
{
  String a = null;
  
  BrowserAppInterface$TBSLogRunnable(BrowserAppInterface paramBrowserAppInterface, String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a)) {
      QQToast.makeText(this.this$0.getApp(), this.a, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BrowserAppInterface.TBSLogRunnable
 * JD-Core Version:    0.7.0.1
 */