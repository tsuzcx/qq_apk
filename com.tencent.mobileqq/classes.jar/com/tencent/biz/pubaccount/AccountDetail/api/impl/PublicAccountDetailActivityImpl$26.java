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
    paramView = this.a;
    if ((paramView != null) && (paramView.isShowing()) && (this.a.getWindow() != null)) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.26
 * JD-Core Version:    0.7.0.1
 */