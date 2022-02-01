package com.tencent.mobileqq.activity.phone;

import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;

class PhoneLaunchActivity$1
  implements Runnable
{
  PhoneLaunchActivity$1(PhoneLaunchActivity paramPhoneLaunchActivity) {}
  
  public void run()
  {
    if (!NetworkUtil.isNetSupport(this.this$0))
    {
      this.this$0.showToast(2131694475);
      PhoneLaunchActivity.a(this.this$0).setEnabled(true);
      return;
    }
    if (this.this$0.a == null)
    {
      this.this$0.a = new PhoneLaunchActivity.1.1(this);
      this.this$0.app.registObserver(this.this$0.a);
    }
    this.this$0.app.execute(new PhoneLaunchActivity.1.2(this));
    this.this$0.showProgressDialog(2131718766, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchActivity.1
 * JD-Core Version:    0.7.0.1
 */