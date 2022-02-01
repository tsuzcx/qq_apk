package com.tencent.mobileqq.activity;

import adxp;
import bjbs;

public class AutoLoginHelper$6
  implements Runnable
{
  public AutoLoginHelper$6(adxp paramadxp) {}
  
  public void run()
  {
    try
    {
      if ((adxp.a(this.this$0) != null) && (adxp.a(this.this$0).isShowing()))
      {
        adxp.a(this.this$0).dismiss();
        adxp.a(this.this$0).cancel();
      }
      adxp.a(this.this$0, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper.6
 * JD-Core Version:    0.7.0.1
 */