package com.tencent.biz.pubaccount.accountdetail.model;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class AccountDetailVideoManager$5$1
  implements TVK_SDKMgr.InstallListener
{
  AccountDetailVideoManager$5$1(AccountDetailVideoManager.5 param5) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("installSDK onInstalledFailed arg0=");
      localStringBuilder.append(paramInt);
      QLog.d("AccountDetailVideoManager", 2, localStringBuilder.toString());
    }
    AccountDetailVideoManager.c = false;
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailVideoManager", 2, "installSDK onInstalledSuccessed");
    }
    AccountDetailVideoManager.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.model.AccountDetailVideoManager.5.1
 * JD-Core Version:    0.7.0.1
 */