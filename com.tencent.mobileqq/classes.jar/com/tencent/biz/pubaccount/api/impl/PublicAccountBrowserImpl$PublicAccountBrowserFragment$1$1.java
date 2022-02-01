package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class PublicAccountBrowserImpl$PublicAccountBrowserFragment$1$1
  implements Runnable
{
  PublicAccountBrowserImpl$PublicAccountBrowserFragment$1$1(PublicAccountBrowserImpl.PublicAccountBrowserFragment.1 param1) {}
  
  public void run()
  {
    try
    {
      boolean bool = SubscriptRecommendController.a((AppInterface)this.a.a.getAppRuntime(), false, PublicAccountBrowserImpl.PublicAccountBrowserFragment.a(this.a.a));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set subscribe full recommend switch = false , result : ");
        localStringBuilder.append(bool);
        QLog.d("WebLog_WebViewFragment", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment.1.1
 * JD-Core Version:    0.7.0.1
 */