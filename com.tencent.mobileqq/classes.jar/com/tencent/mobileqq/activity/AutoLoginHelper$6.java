package com.tencent.mobileqq.activity;

import adoo;
import biau;

public class AutoLoginHelper$6
  implements Runnable
{
  public AutoLoginHelper$6(adoo paramadoo) {}
  
  public void run()
  {
    try
    {
      if ((adoo.a(this.this$0) != null) && (adoo.a(this.this$0).isShowing()))
      {
        adoo.a(this.this$0).dismiss();
        adoo.a(this.this$0).cancel();
      }
      adoo.a(this.this$0, null);
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