package com.tencent.mobileqq.activity.phone;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

class PhoneMatchView$1
  implements Runnable
{
  PhoneMatchView$1(PhoneMatchView paramPhoneMatchView) {}
  
  public void run()
  {
    this.this$0.a(2131916272, 1000L, true);
    PhoneMatchView.a(this.this$0).sendEmptyMessageDelayed(0, 15000L);
    if (this.this$0.l == null)
    {
      this.this$0.l = new PhoneMatchView.1.1(this);
      this.this$0.a.registObserver(this.this$0.l);
    }
    ThreadManager.excute(new PhoneMatchView.1.2(this), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchView.1
 * JD-Core Version:    0.7.0.1
 */