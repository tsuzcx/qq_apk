package com.tencent.mobileqq.activity;

import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

class AccountManageActivity$38
  extends AccountObserver
{
  AccountManageActivity$38(AccountManageActivity paramAccountManageActivity) {}
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    AccountManageActivity.d(this.a);
  }
  
  public void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong)
  {
    AccountManageActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.38
 * JD-Core Version:    0.7.0.1
 */