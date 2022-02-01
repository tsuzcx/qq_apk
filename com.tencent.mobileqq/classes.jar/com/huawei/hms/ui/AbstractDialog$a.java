package com.huawei.hms.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class AbstractDialog$a
  implements DialogInterface.OnClickListener
{
  public AbstractDialog$a(AbstractDialog paramAbstractDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.fireDoWork();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.ui.AbstractDialog.a
 * JD-Core Version:    0.7.0.1
 */