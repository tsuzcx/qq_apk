package com.tencent.mobileqq.activity.phone;

import akpl;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class PhoneMatchView$1
  implements Runnable
{
  PhoneMatchView$1(PhoneMatchView paramPhoneMatchView) {}
  
  public void run()
  {
    this.this$0.a(2131717902, 1000L, true);
    PhoneMatchView.a(this.this$0).sendEmptyMessageDelayed(0, 15000L);
    if (this.this$0.jdField_a_of_type_Azov == null)
    {
      this.this$0.jdField_a_of_type_Azov = new akpl(this);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.this$0.jdField_a_of_type_Azov);
    }
    ThreadManager.excute(new PhoneMatchView.1.2(this), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchView.1
 * JD-Core Version:    0.7.0.1
 */