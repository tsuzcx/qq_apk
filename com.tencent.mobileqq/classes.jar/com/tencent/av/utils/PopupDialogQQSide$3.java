package com.tencent.av.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.QBaseActivity;

class PopupDialogQQSide$3
  implements DialogInterface.OnDismissListener
{
  PopupDialogQQSide$3(PopupDialogQQSide paramPopupDialogQQSide) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
    if (this.a.getQBaseActivity() != null)
    {
      this.a.getQBaseActivity().doOnBackPressed();
      this.a.getQBaseActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialogQQSide.3
 * JD-Core Version:    0.7.0.1
 */