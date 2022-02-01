package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class AlertActivity$2
  implements DialogInterface.OnCancelListener
{
  AlertActivity$2(AlertActivity paramAlertActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (AlertActivity.b(this.a) != null) {
      AlertActivity.b(this.a).onCancel(paramDialogInterface);
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.AlertActivity.2
 * JD-Core Version:    0.7.0.1
 */