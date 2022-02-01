package com.tencent.mobileqq.activity.phone;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;

class BindNumberActivity$4
  extends ContactBindObserver
{
  BindNumberActivity$4(BindNumberActivity paramBindNumberActivity) {}
  
  protected void onCancelBind(boolean paramBoolean)
  {
    super.onCancelBind(paramBoolean);
    if (paramBoolean)
    {
      BindNumberActivity.c(this.a).sendEmptyMessage(3);
    }
    else
    {
      this.a.dismissProgressDialog();
      this.a.showToast(2131915700);
    }
    this.a.app.unRegistObserver(this.a.g);
    this.a.g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity.4
 * JD-Core Version:    0.7.0.1
 */