package com.tencent.mobileqq.activity.phone;

import aine;
import android.widget.Button;
import bdin;
import com.tencent.mobileqq.app.QQAppInterface;

public class PhoneLaunchActivity$1
  implements Runnable
{
  PhoneLaunchActivity$1(PhoneLaunchActivity paramPhoneLaunchActivity) {}
  
  public void run()
  {
    if (!bdin.d(this.this$0))
    {
      this.this$0.b(2131694831);
      PhoneLaunchActivity.a(this.this$0).setEnabled(true);
      return;
    }
    if (this.this$0.a == null)
    {
      this.this$0.a = new aine(this);
      this.this$0.app.registObserver(this.this$0.a);
    }
    this.this$0.app.a(new PhoneLaunchActivity.1.2(this));
    this.this$0.a(2131719785, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchActivity.1
 * JD-Core Version:    0.7.0.1
 */