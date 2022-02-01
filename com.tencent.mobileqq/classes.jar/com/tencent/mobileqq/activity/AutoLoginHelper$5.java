package com.tencent.mobileqq.activity;

import adoo;
import biau;

public class AutoLoginHelper$5
  implements Runnable
{
  public AutoLoginHelper$5(adoo paramadoo) {}
  
  public void run()
  {
    try
    {
      if ((adoo.a(this.this$0) == null) && (!adoo.a(this.this$0).isFinishing()))
      {
        adoo.a(this.this$0, new biau(adoo.a(this.this$0), adoo.a(this.this$0).getTitleBarHeight()));
        adoo.a(this.this$0).c(2131694158);
      }
      if ((adoo.a(this.this$0) != null) && (!adoo.a(this.this$0).isShowing())) {
        adoo.a(this.this$0).show();
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