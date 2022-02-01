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
    boolean bool = true;
    DialogBaseActivity localDialogBaseActivity = (DialogBaseActivity)this.a.get();
    if (localDialogBaseActivity == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 1: 
      int i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {}
      for (;;)
      {
        localDialogBaseActivity.a(i, bool);
        return;
        bool = false;
      }
    }
    localDialogBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity.UiHandler
 * JD-Core Version:    0.7.0.1
 */