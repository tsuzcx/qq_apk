package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;

class ChatHistory$1$1
  implements DialogInterface.OnCancelListener
{
  ChatHistory$1$1(ChatHistory.1 param1) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.a.w != null) {
      this.a.a.w.dismiss();
    }
    this.a.a.m.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.1.1
 * JD-Core Version:    0.7.0.1
 */