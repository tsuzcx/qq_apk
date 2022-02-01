package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

final class ChatActivityUtils$19
  implements DialogInterface.OnCancelListener
{
  ChatActivityUtils$19(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramDialogInterface, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.19
 * JD-Core Version:    0.7.0.1
 */