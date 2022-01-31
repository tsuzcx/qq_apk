package com.tencent.mobileqq.activity;

import agca;
import android.os.SystemClock;
import axrl;
import bbio;
import bfmt;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

class Leba$10
  implements Runnable
{
  Leba$10(Leba paramLeba) {}
  
  public void run()
  {
    List localList = agca.a().a(this.this$0.a(), this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.this$0.jdField_a_of_type_Bfmt.post(new Leba.10.1(this, localList));
    if (Leba.a(this.this$0))
    {
      Leba.b(this.this$0, false);
      long l1 = SystemClock.uptimeMillis();
      long l2 = Leba.a(this.this$0);
      axrl.a(BaseApplication.getContext()).a(bbio.a(), "actLebaShowTime", true, l1 - l2, 0L, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.10
 * JD-Core Version:    0.7.0.1
 */