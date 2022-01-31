package com.tencent.av.utils;

import android.os.Handler;
import lek;
import mwf;
import mwg;

public class SignalStrengthReport$2
  implements Runnable
{
  public SignalStrengthReport$2(mwf parammwf) {}
  
  public void run()
  {
    this.this$0.b = 0;
    if ((this.this$0.jdField_a_of_type_Int == -1) || (mwf.e() == 1)) {}
    try
    {
      String str = mwf.a(this.this$0);
      this.this$0.b = mwg.a("http://" + str);
      if (this.this$0.b < 0) {
        this.this$0.b = 0;
      }
      lek.c("SignalStrengthReport", "mPingTask gatewayIP:" + str + " | avgRtt:" + this.this$0.b);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        lek.c("SignalStrengthReport", "mPingTask e:" + localException);
      }
    }
    if (this.this$0.jdField_a_of_type_AndroidOsHandler != null) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.this$0.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.SignalStrengthReport.2
 * JD-Core Version:    0.7.0.1
 */