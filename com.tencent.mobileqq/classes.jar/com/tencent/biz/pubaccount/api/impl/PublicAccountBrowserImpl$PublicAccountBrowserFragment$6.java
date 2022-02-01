package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class PublicAccountBrowserImpl$PublicAccountBrowserFragment$6
  implements Runnable
{
  PublicAccountBrowserImpl$PublicAccountBrowserFragment$6(PublicAccountBrowserImpl.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public void run()
  {
    try
    {
      boolean bool = SubscriptRecommendController.a((AppInterface)this.this$0.getAppRuntime(), false, PublicAccountBrowserImpl.PublicAccountBrowserFragment.h(this.this$0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl.PublicAccountBrowserFragment.6
 * JD-Core Version:    0.7.0.1
 */