package com.tencent.mobileqq.activity;

import achb;
import bety;

public class AutoLoginHelper$6
  implements Runnable
{
  public AutoLoginHelper$6(achb paramachb) {}
  
  public void run()
  {
    try
    {
      if ((achb.a(this.this$0) != null) && (achb.a(this.this$0).isShowing()))
      {
        achb.a(this.this$0).dismiss();
        achb.a(this.this$0).cancel();
      }
      achb.a(this.this$0, null);
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