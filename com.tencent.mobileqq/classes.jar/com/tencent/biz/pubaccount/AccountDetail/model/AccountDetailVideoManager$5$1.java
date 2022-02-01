package com.tencent.biz.pubaccount.AccountDetail.model;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class AccountDetailVideoManager$5$1
  implements TVK_SDKMgr.InstallListener
{
  AccountDetailVideoManager$5$1(AccountDetailVideoManager.5 param5) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailVideoManager", 2, "installSDK onInstalledFailed arg0=" + paramInt);
    }
    AccountDetailVideoManager.a = false;
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailVideoManager", 2, "installSDK onInstalledSuccessed");
    }
    AccountDetailVideoManager.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailVideoManager.5.1
 * JD-Core Version:    0.7.0.1
 */