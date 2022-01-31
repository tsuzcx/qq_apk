package com.tencent.mobileqq.activity.phone;

import agko;
import android.widget.Button;
import bbev;
import com.tencent.mobileqq.app.QQAppInterface;

public class PhoneLaunchActivity$1
  implements Runnable
{
  PhoneLaunchActivity$1(PhoneLaunchActivity paramPhoneLaunchActivity) {}
  
  public void run()
  {
    if (!bbev.d(this.this$0))
    {
      this.this$0.b(2131694672);
      PhoneLaunchActivity.a(this.this$0).setEnabled(true);
      return;
    }
    if (this.this$0.a == null)
    {
      this.this$0.a = new agko(this);
      this.this$0.app.registObserver(this.this$0.a);
    }
    this.this$0.app.a(new PhoneLaunchActivity.1.2(this));
    this.this$0.a(2131719281, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchActivity.1
 * JD-Core Version:    0.7.0.1
 */