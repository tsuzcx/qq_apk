package com.huawei.hms.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class AbstractDialog$3
  implements DialogInterface.OnCancelListener
{
  AbstractDialog$3(AbstractDialog paramAbstractDialog) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.fireCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.ui.AbstractDialog.3
 * JD-Core Version:    0.7.0.1
 */