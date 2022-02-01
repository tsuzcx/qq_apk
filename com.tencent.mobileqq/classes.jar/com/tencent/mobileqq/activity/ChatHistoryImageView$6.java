package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ChatHistoryImageView$6
  implements DialogInterface.OnClickListener
{
  ChatHistoryImageView$6(ChatHistoryImageView paramChatHistoryImageView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.k != null) && (this.a.k.isShowing()))
    {
      this.a.k.cancel();
      if (this.a.x != null) {
        this.a.x.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView.6
 * JD-Core Version:    0.7.0.1
 */