package com.tencent.mobileqq.activity;

import abai;
import afqa;
import android.os.SystemClock;
import awrn;
import bahj;
import beez;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class Leba$10
  implements Runnable
{
  public Leba$10(abai paramabai) {}
  
  public void run()
  {
    List localList = afqa.a().a(this.this$0.a(), this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.this$0.jdField_a_of_type_Beez.post(new Leba.10.1(this, localList));
    if (abai.a(this.this$0))
    {
      abai.b(this.this$0, false);
      long l1 = SystemClock.uptimeMillis();
      long l2 = abai.a(this.this$0);
      awrn.a(BaseApplication.getContext()).a(bahj.a(), "actLebaShowTime", true, l1 - l2, 0L, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.10
 * JD-Core Version:    0.7.0.1
 */