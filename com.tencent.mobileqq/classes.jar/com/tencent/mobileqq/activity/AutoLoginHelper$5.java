package com.tencent.mobileqq.activity;

import adxp;
import bjbs;

public class AutoLoginHelper$5
  implements Runnable
{
  public AutoLoginHelper$5(adxp paramadxp) {}
  
  public void run()
  {
    try
    {
      if ((adxp.a(this.this$0) == null) && (!adxp.a(this.this$0).isFinishing()))
      {
        adxp.a(this.this$0, new bjbs(adxp.a(this.this$0), adxp.a(this.this$0).getTitleBarHeight()));
        adxp.a(this.this$0).c(2131694176);
      }
      if ((adxp.a(this.this$0) != null) && (!adxp.a(this.this$0).isShowing())) {
        adxp.a(this.this$0).show();
      }
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
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper.5
 * JD-Core Version:    0.7.0.1
 */