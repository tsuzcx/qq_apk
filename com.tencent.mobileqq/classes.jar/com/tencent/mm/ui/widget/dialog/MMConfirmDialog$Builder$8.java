package com.tencent.mm.ui.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;

class MMConfirmDialog$Builder$8
  implements DialogInterface.OnClickListener
{
  MMConfirmDialog$Builder$8(MMConfirmDialog.Builder paramBuilder, MMConfirmDialog.IIOnDialogClick paramIIOnDialogClick) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null)
    {
      boolean bool;
      if (paramDialogInterface == null) {
        bool = false;
      } else {
        bool = ((MMAlertDialog)paramDialogInterface).getmCheckBox().isChecked();
      }
      this.a.onDialogClick(false, null, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMConfirmDialog.Builder.8
 * JD-Core Version:    0.7.0.1
 */