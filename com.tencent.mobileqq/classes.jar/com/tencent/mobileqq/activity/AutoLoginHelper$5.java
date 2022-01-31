package com.tencent.mobileqq.activity;

import aals;
import bcpq;

public class AutoLoginHelper$5
  implements Runnable
{
  public AutoLoginHelper$5(aals paramaals) {}
  
  public void run()
  {
    try
    {
      if ((aals.a(this.this$0) == null) && (!aals.a(this.this$0).isFinishing()))
      {
        aals.a(this.this$0, new bcpq(aals.a(this.this$0), aals.a(this.this$0).getTitleBarHeight()));
        aals.a(this.this$0).c(2131694930);
      }
      if ((aals.a(this.this$0) != null) && (!aals.a(this.this$0).isShowing())) {
        aals.a(this.this$0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper.5
 * JD-Core Version:    0.7.0.1
 */