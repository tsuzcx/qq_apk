package com.tencent.mobileqq.activity;

import aalo;
import bcqf;

public class AutoLoginHelper$5
  implements Runnable
{
  public AutoLoginHelper$5(aalo paramaalo) {}
  
  public void run()
  {
    try
    {
      if ((aalo.a(this.this$0) == null) && (!aalo.a(this.this$0).isFinishing()))
      {
        aalo.a(this.this$0, new bcqf(aalo.a(this.this$0), aalo.a(this.this$0).getTitleBarHeight()));
        aalo.a(this.this$0).c(2131694931);
      }
      if ((aalo.a(this.this$0) != null) && (!aalo.a(this.this$0).isShowing())) {
        aalo.a(this.this$0).show();
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