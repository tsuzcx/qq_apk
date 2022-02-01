package com.tencent.mm.ui.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MMConfirmDialog$Builder$4
  implements DialogInterface.OnClickListener
{
  MMConfirmDialog$Builder$4(MMConfirmDialog.Builder paramBuilder, MMConfirmDialog.IOnDialogClick paramIOnDialogClick) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null)
    {
      if (paramDialogInterface == null) {
        paramDialogInterface = null;
      } else {
        paramDialogInterface = ((MMAlertDialog)paramDialogInterface).getEditTextValue();
      }
      this.a.onDialogClick(true, paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMConfirmDialog.Builder.4
 * JD-Core Version:    0.7.0.1
 */