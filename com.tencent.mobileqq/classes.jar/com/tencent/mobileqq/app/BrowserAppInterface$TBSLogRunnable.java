package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;

public class BrowserAppInterface$TBSLogRunnable
  implements Runnable
{
  String a = null;
  
  public BrowserAppInterface$TBSLogRunnable(BrowserAppInterface paramBrowserAppInterface, String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a)) {
      QQToast.a(this.this$0.getApp(), this.a, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.BrowserAppInterface.TBSLogRunnable
 * JD-Core Version:    0.7.0.1
 */