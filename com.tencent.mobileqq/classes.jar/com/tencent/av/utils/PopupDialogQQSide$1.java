package com.tencent.av.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.ResultReceiver;

class PopupDialogQQSide$1
  implements DialogInterface.OnClickListener
{
  PopupDialogQQSide$1(PopupDialogQQSide paramPopupDialogQQSide, ResultReceiver paramResultReceiver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ResultReceiver localResultReceiver = this.a;
    if (localResultReceiver != null) {
      localResultReceiver.send(0, this.b.getArguments());
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialogQQSide.1
 * JD-Core Version:    0.7.0.1
 */