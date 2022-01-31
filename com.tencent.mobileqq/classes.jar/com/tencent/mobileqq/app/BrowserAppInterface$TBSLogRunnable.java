package com.tencent.mobileqq.app;

import android.text.TextUtils;
import bbmy;

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
      bbmy.a(this.this$0.getApp(), this.a, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BrowserAppInterface.TBSLogRunnable
 * JD-Core Version:    0.7.0.1
 */