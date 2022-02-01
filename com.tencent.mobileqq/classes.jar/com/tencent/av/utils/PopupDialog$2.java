package com.tencent.av.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class PopupDialog$2
  implements DialogInterface.OnClickListener
{
  PopupDialog$2(PopupDialog paramPopupDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (PopupDialog.a.a != null) {
      PopupDialog.a.a.onClick(paramDialogInterface, paramInt);
    }
    paramDialogInterface.dismiss();
    PopupDialog.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialog.2
 * JD-Core Version:    0.7.0.1
 */