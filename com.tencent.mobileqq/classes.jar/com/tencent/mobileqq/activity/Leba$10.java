package com.tencent.mobileqq.activity;

import aieq;
import android.os.SystemClock;
import azri;
import bdmh;
import bhsl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

class Leba$10
  implements Runnable
{
  Leba$10(Leba paramLeba) {}
  
  public void run()
  {
    List localList = aieq.a().a(this.this$0.a(), this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.this$0.jdField_a_of_type_Bhsl.post(new Leba.10.1(this, localList));
    if (Leba.a(this.this$0))
    {
      Leba.b(this.this$0, false);
      long l1 = SystemClock.uptimeMillis();
      long l2 = Leba.a(this.this$0);
      azri.a(BaseApplication.getContext()).a(bdmh.a(), "actLebaShowTime", true, l1 - l2, 0L, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.10
 * JD-Core Version:    0.7.0.1
 */