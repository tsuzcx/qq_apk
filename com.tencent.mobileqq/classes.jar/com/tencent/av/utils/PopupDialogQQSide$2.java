package com.tencent.av.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.ResultReceiver;

class PopupDialogQQSide$2
  implements DialogInterface.OnClickListener
{
  PopupDialogQQSide$2(PopupDialogQQSide paramPopupDialogQQSide, ResultReceiver paramResultReceiver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ResultReceiver localResultReceiver = this.jdField_a_of_type_AndroidOsResultReceiver;
    if (localResultReceiver != null) {
      localResultReceiver.send(1, this.jdField_a_of_type_ComTencentAvUtilsPopupDialogQQSide.getArguments());
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialogQQSide.2
 * JD-Core Version:    0.7.0.1
 */