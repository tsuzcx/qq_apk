package com.tencent.mobileqq.activity;

import adlb;
import bisl;

public class AutoLoginHelper$6
  implements Runnable
{
  public AutoLoginHelper$6(adlb paramadlb) {}
  
  public void run()
  {
    try
    {
      if ((adlb.a(this.this$0) != null) && (adlb.a(this.this$0).isShowing()))
      {
        adlb.a(this.this$0).dismiss();
        adlb.a(this.this$0).cancel();
      }
      adlb.a(this.this$0, null);
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