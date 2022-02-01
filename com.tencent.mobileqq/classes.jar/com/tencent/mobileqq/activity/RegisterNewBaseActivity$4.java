package com.tencent.mobileqq.activity;

import android.app.Dialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;

class RegisterNewBaseActivity$4
  implements Runnable
{
  RegisterNewBaseActivity$4(RegisterNewBaseActivity paramRegisterNewBaseActivity, int paramInt) {}
  
  public void run()
  {
    try
    {
      this.this$0.dialog = DialogUtil.b(this.this$0, this.a);
      this.this$0.dialog.show();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("RegisterNewBaseActivity", 1, "createWaitingDialog error", localOutOfMemoryError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterNewBaseActivity.4
 * JD-Core Version:    0.7.0.1
 */