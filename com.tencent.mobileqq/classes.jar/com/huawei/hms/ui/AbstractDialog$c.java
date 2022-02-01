package com.huawei.hms.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public class AbstractDialog$c
  implements DialogInterface.OnCancelListener
{
  public AbstractDialog$c(AbstractDialog paramAbstractDialog) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.fireCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.ui.AbstractDialog.c
 * JD-Core Version:    0.7.0.1
 */