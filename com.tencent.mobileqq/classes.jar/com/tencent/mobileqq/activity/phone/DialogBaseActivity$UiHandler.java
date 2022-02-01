package com.tencent.mobileqq.activity.phone;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class DialogBaseActivity$UiHandler
  extends Handler
{
  private WeakReference<DialogBaseActivity> a;
  
  public DialogBaseActivity$UiHandler(DialogBaseActivity paramDialogBaseActivity)
  {
    this.a = new WeakReference(paramDialogBaseActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (DialogBaseActivity)this.a.get();
    if (localObject == null) {
      return;
    }
    int i = paramMessage.what;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 2)
      {
        ((DialogBaseActivity)localObject).finish();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unknown message: ");
      ((StringBuilder)localObject).append(paramMessage.what);
      throw new RuntimeException(((StringBuilder)localObject).toString());
    }
    i = paramMessage.arg1;
    if (paramMessage.arg2 != 1) {
      bool = false;
    }
    ((DialogBaseActivity)localObject).doShowProgressDialog(i, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity.UiHandler
 * JD-Core Version:    0.7.0.1
 */