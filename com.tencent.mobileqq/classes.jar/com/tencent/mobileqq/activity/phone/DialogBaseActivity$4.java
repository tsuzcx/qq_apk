package com.tencent.mobileqq.activity.phone;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.widget.QQProgressDialog;

class DialogBaseActivity$4
  implements DialogInterface.OnDismissListener
{
  DialogBaseActivity$4(DialogBaseActivity paramDialogBaseActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a != null) {
      this.a.a.setOnDismissListener(null);
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity.4
 * JD-Core Version:    0.7.0.1
 */