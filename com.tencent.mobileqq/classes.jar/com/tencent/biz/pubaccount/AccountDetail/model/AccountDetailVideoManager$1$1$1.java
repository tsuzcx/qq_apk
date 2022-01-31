package com.tencent.biz.pubaccount.AccountDetail.model;

import com.tencent.qphone.base.util.QLog;
import nfg;
import nfh;
import nfm;

class AccountDetailVideoManager$1$1$1
  implements Runnable
{
  AccountDetailVideoManager$1$1$1(AccountDetailVideoManager.1.1 param1) {}
  
  public void run()
  {
    if (this.a.a.a.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailVideoManager", 2, "onPlayStart time=" + System.currentTimeMillis());
      }
      this.a.a.a.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailVideoManager.1.1.1
 * JD-Core Version:    0.7.0.1
 */