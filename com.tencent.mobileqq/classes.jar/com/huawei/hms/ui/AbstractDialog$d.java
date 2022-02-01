package com.huawei.hms.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

public class AbstractDialog$d
  implements DialogInterface.OnKeyListener
{
  public AbstractDialog$d(AbstractDialog paramAbstractDialog) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (paramKeyEvent.getAction() == 1))
    {
      this.a.cancel();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.ui.AbstractDialog.d
 * JD-Core Version:    0.7.0.1
 */