package com.tencent.mm.ui.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.ViewTreeObserver;

class MMHalfBottomDialog$2
  implements DialogInterface.OnDismissListener
{
  MMHalfBottomDialog$2(MMHalfBottomDialog paramMMHalfBottomDialog) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (MMHalfBottomDialog.a(this.a) != null)
    {
      if (!MMHalfBottomDialog.a(this.a).isAlive())
      {
        paramDialogInterface = this.a;
        MMHalfBottomDialog.a(paramDialogInterface, MMHalfBottomDialog.b(paramDialogInterface).getViewTreeObserver());
      }
      MMHalfBottomDialog.a(this.a).removeGlobalOnLayoutListener(this.a);
      MMHalfBottomDialog.a(this.a, null);
    }
    if (!MMHalfBottomDialog.c(this.a)) {
      MMHalfBottomDialog.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMHalfBottomDialog.2
 * JD-Core Version:    0.7.0.1
 */