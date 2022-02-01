package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountManageActivity$20
  implements View.OnClickListener
{
  AccountManageActivity$20(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (AccountManageActivity.a(this.a) == null)
    {
      AccountManageActivity.a(this.a, (ImageView)paramView);
      AccountManageActivity.a(this.a, paramView);
      if (AppSetting.d) {
        paramView.setContentDescription(this.a.getString(2131691195));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AccountManageActivity.a(this.a) == paramView)
      {
        AccountManageActivity.b(this.a, paramView);
        AccountManageActivity.a(this.a, null);
        if (AppSetting.d) {
          paramView.setContentDescription(this.a.getString(2131691207));
        }
      }
      else
      {
        AccountManageActivity.b(this.a, AccountManageActivity.a(this.a));
        AccountManageActivity.a(this.a, paramView);
        AccountManageActivity.a(this.a, (ImageView)paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.20
 * JD-Core Version:    0.7.0.1
 */