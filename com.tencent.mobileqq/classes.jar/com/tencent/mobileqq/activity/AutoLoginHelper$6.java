package com.tencent.mobileqq.activity;

import aabz;
import bbms;

public class AutoLoginHelper$6
  implements Runnable
{
  public AutoLoginHelper$6(aabz paramaabz) {}
  
  public void run()
  {
    try
    {
      if ((aabz.a(this.this$0) != null) && (aabz.a(this.this$0).isShowing()))
      {
        aabz.a(this.this$0).dismiss();
        aabz.a(this.this$0).cancel();
      }
      aabz.a(this.this$0, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper.6
 * JD-Core Version:    0.7.0.1
 */