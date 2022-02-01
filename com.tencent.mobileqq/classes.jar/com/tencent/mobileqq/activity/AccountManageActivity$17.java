package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountManageActivity$17
  implements View.OnClickListener
{
  AccountManageActivity$17(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (AccountManageActivity.i(this.a) == null)
    {
      AccountManageActivity.a(this.a, (ImageView)paramView);
      AccountManageActivity.a(this.a, paramView);
      if (AppSetting.e) {
        paramView.setContentDescription(this.a.getString(2131888062));
      }
    }
    else if (AccountManageActivity.i(this.a) == paramView)
    {
      AccountManageActivity.b(this.a, paramView);
      AccountManageActivity.a(this.a, null);
      if (AppSetting.e) {
        paramView.setContentDescription(this.a.getString(2131888074));
      }
    }
    else
    {
      AccountManageActivity localAccountManageActivity = this.a;
      AccountManageActivity.b(localAccountManageActivity, AccountManageActivity.i(localAccountManageActivity));
      AccountManageActivity.a(this.a, paramView);
      AccountManageActivity.a(this.a, (ImageView)paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.17
 * JD-Core Version:    0.7.0.1
 */