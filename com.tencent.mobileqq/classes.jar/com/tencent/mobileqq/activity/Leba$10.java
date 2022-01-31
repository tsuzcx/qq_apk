package com.tencent.mobileqq.activity;

import agby;
import android.os.SystemClock;
import axrn;
import bbjc;
import bfnk;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

class Leba$10
  implements Runnable
{
  Leba$10(Leba paramLeba) {}
  
  public void run()
  {
    List localList = agby.a().a(this.this$0.a(), this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.this$0.jdField_a_of_type_Bfnk.post(new Leba.10.1(this, localList));
    if (Leba.a(this.this$0))
    {
      Leba.b(this.this$0, false);
      long l1 = SystemClock.uptimeMillis();
      long l2 = Leba.a(this.this$0);
      axrn.a(BaseApplication.getContext()).a(bbjc.a(), "actLebaShowTime", true, l1 - l2, 0L, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.10
 * JD-Core Version:    0.7.0.1
 */