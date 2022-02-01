package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AccountManageActivity$8
  implements ActionSheet.OnButtonClickListener
{
  AccountManageActivity$8(AccountManageActivity paramAccountManageActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    AccountManageActivity.a(this.a).dismiss();
    paramView = AccountManageActivity.a(this.a).getActionMenuItem(paramInt);
    if (paramView == null) {}
    do
    {
      return;
      paramInt = paramView.action;
      if (paramInt == 1)
      {
        AccountManageActivity.c(this.a);
        return;
      }
    } while (paramInt != 2);
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.8
 * JD-Core Version:    0.7.0.1
 */