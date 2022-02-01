package com.tencent.biz.pubaccount.accountdetail.handler;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class AccountDetailBaseItemClickHandler$1
  implements View.OnClickListener
{
  AccountDetailBaseItemClickHandler$1(AccountDetailBaseItemClickHandler paramAccountDetailBaseItemClickHandler, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if ((paramView != null) && (paramView.isShowing()) && (this.a.getWindow() != null)) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.handler.AccountDetailBaseItemClickHandler.1
 * JD-Core Version:    0.7.0.1
 */