package com.tencent.mobileqq.activity;

import adlb;
import bisl;

public class AutoLoginHelper$5
  implements Runnable
{
  public AutoLoginHelper$5(adlb paramadlb) {}
  
  public void run()
  {
    try
    {
      if ((adlb.a(this.this$0) == null) && (!adlb.a(this.this$0).isFinishing()))
      {
        adlb.a(this.this$0, new bisl(adlb.a(this.this$0), adlb.a(this.this$0).getTitleBarHeight()));
        adlb.a(this.this$0).c(2131694477);
      }
      if ((adlb.a(this.this$0) != null) && (!adlb.a(this.this$0).isShowing())) {
        adlb.a(this.this$0).show();
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