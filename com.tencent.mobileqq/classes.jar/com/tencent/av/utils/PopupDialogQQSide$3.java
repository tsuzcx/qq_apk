package com.tencent.av.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;

class PopupDialogQQSide$3
  implements DialogInterface.OnDismissListener
{
  PopupDialogQQSide$3(PopupDialogQQSide paramPopupDialogQQSide) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().doOnBackPressed();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialogQQSide.3
 * JD-Core Version:    0.7.0.1
 */