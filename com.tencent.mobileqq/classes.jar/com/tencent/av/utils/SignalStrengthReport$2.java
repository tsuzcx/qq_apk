package com.tencent.av.utils;

import android.os.Handler;
import lcg;
import mtl;
import mtm;

public class SignalStrengthReport$2
  implements Runnable
{
  public SignalStrengthReport$2(mtl parammtl) {}
  
  public void run()
  {
    this.this$0.b = 0;
    if ((this.this$0.jdField_a_of_type_Int == -1) || (mtl.e() == 1)) {}
    try
    {
      String str = mtl.a(this.this$0);
      this.this$0.b = mtm.a("http://" + str);
      if (this.this$0.b < 0) {
        this.this$0.b = 0;
      }
      lcg.c("SignalStrengthReport", "mPingTask gatewayIP:" + str + " | avgRtt:" + this.this$0.b);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        lcg.c("SignalStrengthReport", "mPingTask e:" + localException);
      }
    }
    if (this.this$0.jdField_a_of_type_AndroidOsHandler != null) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.this$0.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.utils.SignalStrengthReport.2
 * JD-Core Version:    0.7.0.1
 */