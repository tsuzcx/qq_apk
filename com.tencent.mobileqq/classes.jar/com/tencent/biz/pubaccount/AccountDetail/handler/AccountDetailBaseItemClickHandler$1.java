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
    paramView = this.jdField_a_of_type_AndroidAppDialog;
    if ((paramView != null) && (paramView.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.handler.AccountDetailBaseItemClickHandler.1
 * JD-Core Version:    0.7.0.1
 */