package com.tencent.mm.ui.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class MMBottomSheet$7
  implements DialogInterface.OnDismissListener
{
  MMBottomSheet$7(MMBottomSheet paramMMBottomSheet) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!MMBottomSheet.r(this.a)) {
      this.a.a.onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMBottomSheet.7
 * JD-Core Version:    0.7.0.1
 */