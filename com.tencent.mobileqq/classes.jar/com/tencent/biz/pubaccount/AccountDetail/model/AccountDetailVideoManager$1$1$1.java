package com.tencent.biz.pubaccount.accountdetail.model;

import com.tencent.qphone.base.util.QLog;

class AccountDetailVideoManager$1$1$1
  implements Runnable
{
  AccountDetailVideoManager$1$1$1(AccountDetailVideoManager.1.1 param1) {}
  
  public void run()
  {
    if (this.a.a.a.a != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPlayStart time=");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d("AccountDetailVideoManager", 2, localStringBuilder.toString());
      }
      this.a.a.a.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.model.AccountDetailVideoManager.1.1.1
 * JD-Core Version:    0.7.0.1
 */