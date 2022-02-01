package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountManageActivity$10
  implements View.OnClickListener
{
  AccountManageActivity$10(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    AccountManageActivity.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.10
 * JD-Core Version:    0.7.0.1
 */