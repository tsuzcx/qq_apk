package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.qphone.base.util.QLog;

class PublicAccountBrowserImpl$PublicAccountBrowserFragment$5
  implements Runnable
{
  PublicAccountBrowserImpl$PublicAccountBrowserFragment$5(PublicAccountBrowserImpl.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public void run()
  {
    try
    {
      boolean bool = SubscriptRecommendController.a(this.this$0.mApp, false, this.this$0.mUrl);
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "set subscribe full recommend switch = false , result : " + bool);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment.5
 * JD-Core Version:    0.7.0.1
 */