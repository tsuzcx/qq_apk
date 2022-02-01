package com.tencent.biz.pubaccount.AccountDetail.model;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import nsv;

public final class AccountDetailVideoManager$5
  implements Runnable
{
  public void run()
  {
    try
    {
      TVK_SDKMgr.installPlugin(BaseApplicationImpl.getApplication().getApplicationContext(), new nsv(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AccountDetailVideoManager", 2, "installSDK t==" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailVideoManager.5
 * JD-Core Version:    0.7.0.1
 */