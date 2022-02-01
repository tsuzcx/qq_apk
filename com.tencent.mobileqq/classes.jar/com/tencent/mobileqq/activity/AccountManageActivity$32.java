package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

class AccountManageActivity$32
  extends SubAccountBindObserver
{
  AccountManageActivity$32(AccountManageActivity paramAccountManageActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    paramSubAccountBackProtocData = this.a;
    AccountManageActivity.a(paramSubAccountBackProtocData, AccountManageActivity.c(paramSubAccountBackProtocData));
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    AccountManageActivity.a(this.a, false);
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    AccountManageActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.32
 * JD-Core Version:    0.7.0.1
 */