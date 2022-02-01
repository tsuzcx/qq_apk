package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountManageActivity$3
  implements View.OnClickListener
{
  AccountManageActivity$3(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    AccountManageActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.3
 * JD-Core Version:    0.7.0.1
 */