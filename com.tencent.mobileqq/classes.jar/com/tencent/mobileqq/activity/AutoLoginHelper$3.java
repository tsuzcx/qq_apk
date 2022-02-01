package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class AutoLoginHelper$3
  implements Runnable
{
  AutoLoginHelper$3(AutoLoginHelper paramAutoLoginHelper) {}
  
  public void run()
  {
    try
    {
      if ((AutoLoginHelper.d(this.this$0) == null) && (!AutoLoginHelper.a(this.this$0).isFinishing()))
      {
        AutoLoginHelper.a(this.this$0, new QQProgressDialog(AutoLoginHelper.a(this.this$0), AutoLoginHelper.a(this.this$0).getTitleBarHeight()));
        AutoLoginHelper.d(this.this$0).c(2131892360);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if ((AutoLoginHelper.d(this.this$0) != null) && (!AutoLoginHelper.d(this.this$0).isShowing())) {
      AutoLoginHelper.d(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper.3
 * JD-Core Version:    0.7.0.1
 */