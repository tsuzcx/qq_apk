package com.tencent.mobileqq.activity;

import acup;
import bhht;

public class AutoLoginHelper$5
  implements Runnable
{
  public AutoLoginHelper$5(acup paramacup) {}
  
  public void run()
  {
    try
    {
      if ((acup.a(this.this$0) == null) && (!acup.a(this.this$0).isFinishing()))
      {
        acup.a(this.this$0, new bhht(acup.a(this.this$0), acup.a(this.this$0).getTitleBarHeight()));
        acup.a(this.this$0).c(2131694279);
      }
      if ((acup.a(this.this$0) != null) && (!acup.a(this.this$0).isShowing())) {
        acup.a(this.this$0).show();
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