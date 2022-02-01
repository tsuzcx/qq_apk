package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

final class ChatActivityUtils$20
  implements DialogInterface.OnCancelListener
{
  ChatActivityUtils$20(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a != null) {
      this.a.onClick(paramDialogInterface, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.20
 * JD-Core Version:    0.7.0.1
 */