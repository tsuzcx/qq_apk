package com.tencent.mobileqq.activity.phone;

import akiw;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;

public class PhoneLaunchActivity$1
  implements Runnable
{
  PhoneLaunchActivity$1(PhoneLaunchActivity paramPhoneLaunchActivity) {}
  
  public void run()
  {
    if (!NetworkUtil.isNetSupport(this.this$0))
    {
      this.this$0.a(2131694305);
      PhoneLaunchActivity.a(this.this$0).setEnabled(true);
      return;
    }
    if (this.this$0.a == null)
    {
      this.this$0.a = new akiw(this);
      this.this$0.app.registObserver(this.this$0.a);
    }
    this.this$0.app.execute(new PhoneLaunchActivity.1.2(this));
    this.this$0.a(2131718527, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchActivity.1
 * JD-Core Version:    0.7.0.1
 */