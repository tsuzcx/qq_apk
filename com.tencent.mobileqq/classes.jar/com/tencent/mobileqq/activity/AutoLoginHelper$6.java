package com.tencent.mobileqq.activity;

import aalo;
import bcqf;

public class AutoLoginHelper$6
  implements Runnable
{
  public AutoLoginHelper$6(aalo paramaalo) {}
  
  public void run()
  {
    try
    {
      if ((aalo.a(this.this$0) != null) && (aalo.a(this.this$0).isShowing()))
      {
        aalo.a(this.this$0).dismiss();
        aalo.a(this.this$0).cancel();
      }
      aalo.a(this.this$0, null);
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