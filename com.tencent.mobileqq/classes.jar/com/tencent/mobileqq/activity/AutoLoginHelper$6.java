package com.tencent.mobileqq.activity;

import aals;
import bcpq;

public class AutoLoginHelper$6
  implements Runnable
{
  public AutoLoginHelper$6(aals paramaals) {}
  
  public void run()
  {
    try
    {
      if ((aals.a(this.this$0) != null) && (aals.a(this.this$0).isShowing()))
      {
        aals.a(this.this$0).dismiss();
        aals.a(this.this$0).cancel();
      }
      aals.a(this.this$0, null);
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