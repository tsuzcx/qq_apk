package com.tencent.av.utils;

import android.os.Handler;
import lbd;
import mut;
import muu;

public class SignalStrengthReport$2
  implements Runnable
{
  public SignalStrengthReport$2(mut parammut) {}
  
  public void run()
  {
    this.this$0.b = 0;
    if ((this.this$0.jdField_a_of_type_Int == -1) || (mut.e() == 1)) {}
    try
    {
      String str = mut.a(this.this$0);
      this.this$0.b = muu.a("http://" + str);
      if (this.this$0.b < 0) {
        this.this$0.b = 0;
      }
      lbd.f("SignalStrengthReport", "mPingTask gatewayIP:" + str + " | avgRtt:" + this.this$0.b);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        lbd.f("SignalStrengthReport", "mPingTask e:" + localException);
      }
    }
    if (this.this$0.jdField_a_of_type_AndroidOsHandler != null) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.this$0.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.utils.SignalStrengthReport.2
 * JD-Core Version:    0.7.0.1
 */