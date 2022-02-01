package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class PublicAccountDetailActivityImpl$26
  implements View.OnClickListener
{
  PublicAccountDetailActivityImpl$26(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidAppDialog;
    if ((paramView != null) && (paramView.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.26
 * JD-Core Version:    0.7.0.1
 */