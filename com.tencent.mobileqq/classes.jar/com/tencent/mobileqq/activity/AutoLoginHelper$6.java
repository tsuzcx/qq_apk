package com.tencent.mobileqq.activity;

import acup;
import bhht;

public class AutoLoginHelper$6
  implements Runnable
{
  public AutoLoginHelper$6(acup paramacup) {}
  
  public void run()
  {
    try
    {
      if ((acup.a(this.this$0) != null) && (acup.a(this.this$0).isShowing()))
      {
        acup.a(this.this$0).dismiss();
        acup.a(this.this$0).cancel();
      }
      acup.a(this.this$0, null);
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