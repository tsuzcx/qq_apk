package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class AlertActivity$1
  implements DialogInterface.OnDismissListener
{
  AlertActivity$1(AlertActivity paramAlertActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (AlertActivity.a(this.a) != null) {
      AlertActivity.a(this.a).onDismiss(paramDialogInterface);
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.AlertActivity.1
 * JD-Core Version:    0.7.0.1
 */