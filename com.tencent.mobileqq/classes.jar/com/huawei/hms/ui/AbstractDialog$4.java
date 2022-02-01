package com.huawei.hms.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class AbstractDialog$4
  implements DialogInterface.OnKeyListener
{
  AbstractDialog$4(AbstractDialog paramAbstractDialog) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.ui.AbstractDialog.4
 * JD-Core Version:    0.7.0.1
 */