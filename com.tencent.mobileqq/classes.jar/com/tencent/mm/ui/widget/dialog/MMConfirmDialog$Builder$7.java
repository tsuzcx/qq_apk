package com.tencent.mm.ui.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;

class MMConfirmDialog$Builder$7
  implements DialogInterface.OnClickListener
{
  MMConfirmDialog$Builder$7(MMConfirmDialog.Builder paramBuilder, MMConfirmDialog.IIOnDialogClick paramIIOnDialogClick) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null)
    {
      String str;
      if (paramDialogInterface == null) {
        str = null;
      } else {
        str = ((MMAlertDialog)paramDialogInterface).getEditTextValue();
      }
      boolean bool;
      if (paramDialogInterface == null) {
        bool = false;
      } else {
        bool = ((MMAlertDialog)paramDialogInterface).getmCheckBox().isChecked();
      }
      this.a.onDialogClick(true, str, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMConfirmDialog.Builder.7
 * JD-Core Version:    0.7.0.1
 */