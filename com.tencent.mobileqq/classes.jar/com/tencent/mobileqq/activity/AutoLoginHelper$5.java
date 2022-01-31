package com.tencent.mobileqq.activity;

import achb;
import bety;

public class AutoLoginHelper$5
  implements Runnable
{
  public AutoLoginHelper$5(achb paramachb) {}
  
  public void run()
  {
    try
    {
      if ((achb.a(this.this$0) == null) && (!achb.a(this.this$0).isFinishing()))
      {
        achb.a(this.this$0, new bety(achb.a(this.this$0), achb.a(this.this$0).getTitleBarHeight()));
        achb.a(this.this$0).c(2131695090);
      }
      if ((achb.a(this.this$0) != null) && (!achb.a(this.this$0).isShowing())) {
        achb.a(this.this$0).show();
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