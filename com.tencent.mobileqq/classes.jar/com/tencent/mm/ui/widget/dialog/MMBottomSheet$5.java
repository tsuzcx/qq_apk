package com.tencent.mm.ui.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.ViewTreeObserver;

class MMBottomSheet$5
  implements DialogInterface.OnDismissListener
{
  MMBottomSheet$5(MMBottomSheet paramMMBottomSheet) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (MMBottomSheet.m(this.a) != null)
    {
      if (!MMBottomSheet.m(this.a).isAlive())
      {
        paramDialogInterface = this.a;
        MMBottomSheet.a(paramDialogInterface, MMBottomSheet.n(paramDialogInterface).getViewTreeObserver());
      }
      MMBottomSheet.m(this.a).removeGlobalOnLayoutListener(this.a);
      MMBottomSheet.a(this.a, null);
    }
    if (!MMBottomSheet.o(this.a)) {
      MMBottomSheet.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMBottomSheet.5
 * JD-Core Version:    0.7.0.1
 */