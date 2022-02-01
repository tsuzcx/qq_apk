package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

class AccountManageActivity$20
  extends AccountObserver
{
  AccountManageActivity$20(AccountManageActivity paramAccountManageActivity) {}
  
  public void onDeleteAccount(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDeleteAccount isSuccess ");
      localStringBuilder.append(paramBoolean);
      QLog.d("Switch_Account", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.20
 * JD-Core Version:    0.7.0.1
 */