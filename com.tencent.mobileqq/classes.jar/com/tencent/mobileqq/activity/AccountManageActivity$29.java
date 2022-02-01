package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

class AccountManageActivity$29
  extends SubAccountBindObserver
{
  AccountManageActivity$29(AccountManageActivity paramAccountManageActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    paramSubAccountBackProtocData = this.a;
    AccountManageActivity.e(paramSubAccountBackProtocData, AccountManageActivity.m(paramSubAccountBackProtocData));
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    AccountManageActivity.e(this.a, false);
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    AccountManageActivity.e(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.29
 * JD-Core Version:    0.7.0.1
 */