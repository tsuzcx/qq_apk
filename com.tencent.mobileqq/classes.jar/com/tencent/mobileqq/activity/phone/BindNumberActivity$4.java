package com.tencent.mobileqq.activity.phone;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class BindNumberActivity$4
  extends ContactBindObserver
{
  BindNumberActivity$4(BindNumberActivity paramBindNumberActivity) {}
  
  public void onCancelBind(boolean paramBoolean)
  {
    super.onCancelBind(paramBoolean);
    if (paramBoolean) {
      BindNumberActivity.a(this.a).sendEmptyMessage(3);
    }
    for (;;)
    {
      this.a.app.unRegistObserver(this.a.b);
      this.a.b = null;
      return;
      this.a.b();
      this.a.a(2131718550);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity.4
 * JD-Core Version:    0.7.0.1
 */