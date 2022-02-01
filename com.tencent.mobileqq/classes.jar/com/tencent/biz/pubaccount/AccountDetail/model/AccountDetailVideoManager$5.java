package com.tencent.biz.pubaccount.accountdetail.model;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

final class AccountDetailVideoManager$5
  implements Runnable
{
  public void run()
  {
    try
    {
      TVK_SDKMgr.installPlugin(BaseApplicationImpl.getApplication().getApplicationContext(), new AccountDetailVideoManager.5.1(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("installSDK t==");
        localStringBuilder.append(localThrowable.toString());
        QLog.d("AccountDetailVideoManager", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.model.AccountDetailVideoManager.5
 * JD-Core Version:    0.7.0.1
 */