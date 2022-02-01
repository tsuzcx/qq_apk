package com.tencent.biz.pubaccount;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountSettingFragment$1
  implements View.OnClickListener
{
  AccountSettingFragment$1(AccountSettingFragment paramAccountSettingFragment) {}
  
  public void onClick(View paramView)
  {
    AccountSettingFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */