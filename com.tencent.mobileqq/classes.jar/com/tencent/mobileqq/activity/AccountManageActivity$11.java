package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountManageActivity$11
  implements View.OnClickListener
{
  AccountManageActivity$11(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.h();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.11
 * JD-Core Version:    0.7.0.1
 */