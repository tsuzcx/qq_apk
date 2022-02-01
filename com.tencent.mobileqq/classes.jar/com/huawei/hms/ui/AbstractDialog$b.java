package com.huawei.hms.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class AbstractDialog$b
  implements DialogInterface.OnClickListener
{
  public AbstractDialog$b(AbstractDialog paramAbstractDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.ui.AbstractDialog.b
 * JD-Core Version:    0.7.0.1
 */