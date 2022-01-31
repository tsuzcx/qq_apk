package com.tencent.mobileqq.activity;

import aabz;
import bbms;

public class AutoLoginHelper$5
  implements Runnable
{
  public AutoLoginHelper$5(aabz paramaabz) {}
  
  public void run()
  {
    try
    {
      if ((aabz.a(this.this$0) == null) && (!aabz.a(this.this$0).isFinishing()))
      {
        aabz.a(this.this$0, new bbms(aabz.a(this.this$0), aabz.a(this.this$0).getTitleBarHeight()));
        aabz.a(this.this$0).c(2131629253);
      }
      if ((aabz.a(this.this$0) != null) && (!aabz.a(this.this$0).isShowing())) {
        aabz.a(this.this$0).show();
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