package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AccountManageActivity$7
  implements ActionSheet.OnButtonClickListener
{
  AccountManageActivity$7(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView, int paramInt)
  {
    AccountManageActivity.c(this.a).dismiss();
    paramView = AccountManageActivity.c(this.a).getActionMenuItem(paramInt);
    if (paramView == null) {
      return;
    }
    paramInt = paramView.action;
    if (paramInt == 1)
    {
      AccountManageActivity.d(this.a);
      return;
    }
    if (paramInt == 2) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.7
 * JD-Core Version:    0.7.0.1
 */