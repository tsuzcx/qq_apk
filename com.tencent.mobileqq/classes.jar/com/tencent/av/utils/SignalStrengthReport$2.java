package com.tencent.av.utils;

import android.os.Handler;
import com.tencent.av.AVLog;

class SignalStrengthReport$2
  implements Runnable
{
  SignalStrengthReport$2(SignalStrengthReport paramSignalStrengthReport) {}
  
  public void run()
  {
    this.this$0.b = 0;
    if ((this.this$0.jdField_a_of_type_Int == -1) || (SignalStrengthReport.e() == 1)) {}
    try
    {
      String str = SignalStrengthReport.a(this.this$0);
      this.this$0.b = SignalStrengthReport.PingUtil.a("http://" + str);
      if (this.this$0.b < 0) {
        this.this$0.b = 0;
      }
      AVLog.printColorLog("SignalStrengthReport", "mPingTask gatewayIP:" + str + " | avgRtt:" + this.this$0.b);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AVLog.printColorLog("SignalStrengthReport", "mPingTask e:" + localException);
      }
    }
    if (this.this$0.jdField_a_of_type_AndroidOsHandler != null) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.this$0.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.SignalStrengthReport.2
 * JD-Core Version:    0.7.0.1
 */