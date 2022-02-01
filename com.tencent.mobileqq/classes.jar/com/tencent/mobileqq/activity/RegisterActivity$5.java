package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class RegisterActivity$5
  implements DialogInterface.OnKeyListener
{
  RegisterActivity$5(RegisterActivity paramRegisterActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
    {
      RegisterActivity.b(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity.5
 * JD-Core Version:    0.7.0.1
 */