package com.tencent.biz.pubaccount.accountdetail.view;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class AccountDetailGroupListContainer$23
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$23(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if ((paramView != null) && (paramView.isShowing()) && (this.a.getWindow() != null)) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.23
 * JD-Core Version:    0.7.0.1
 */