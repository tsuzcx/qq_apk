package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class AutoLoginHelper$4
  implements Runnable
{
  AutoLoginHelper$4(AutoLoginHelper paramAutoLoginHelper) {}
  
  public void run()
  {
    try
    {
      if ((AutoLoginHelper.a(this.this$0) != null) && (AutoLoginHelper.a(this.this$0).isShowing()))
      {
        AutoLoginHelper.a(this.this$0).dismiss();
        AutoLoginHelper.a(this.this$0).cancel();
      }
      AutoLoginHelper.a(this.this$0, null);
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
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper.4
 * JD-Core Version:    0.7.0.1
 */