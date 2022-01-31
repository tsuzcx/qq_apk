package com.tencent.mobileqq.activity;

import accm;
import bepp;

public class AutoLoginHelper$6
  implements Runnable
{
  public AutoLoginHelper$6(accm paramaccm) {}
  
  public void run()
  {
    try
    {
      if ((accm.a(this.this$0) != null) && (accm.a(this.this$0).isShowing()))
      {
        accm.a(this.this$0).dismiss();
        accm.a(this.this$0).cancel();
      }
      accm.a(this.this$0, null);
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