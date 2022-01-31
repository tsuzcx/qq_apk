package com.tencent.mobileqq.activity;

import accm;
import bepp;

public class AutoLoginHelper$5
  implements Runnable
{
  public AutoLoginHelper$5(accm paramaccm) {}
  
  public void run()
  {
    try
    {
      if ((accm.a(this.this$0) == null) && (!accm.a(this.this$0).isFinishing()))
      {
        accm.a(this.this$0, new bepp(accm.a(this.this$0), accm.a(this.this$0).getTitleBarHeight()));
        accm.a(this.this$0).c(2131695088);
      }
      if ((accm.a(this.this$0) != null) && (!accm.a(this.this$0).isShowing())) {
        accm.a(this.this$0).show();
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