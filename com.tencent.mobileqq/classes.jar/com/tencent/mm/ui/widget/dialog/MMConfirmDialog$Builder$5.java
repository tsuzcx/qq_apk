package com.tencent.mm.ui.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MMConfirmDialog$Builder$5
  implements DialogInterface.OnClickListener
{
  MMConfirmDialog$Builder$5(MMConfirmDialog.Builder paramBuilder, MMConfirmDialog.IOnCheckBoxDialogClick paramIOnCheckBoxDialogClick) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.onDialogClick(true, MMConfirmDialog.Builder.b(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMConfirmDialog.Builder.5
 * JD-Core Version:    0.7.0.1
 */