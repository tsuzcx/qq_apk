package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ChatActivityUtils$5
  implements DialogInterface.OnClickListener
{
  ChatActivityUtils$5(ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.StartVideoListener localStartVideoListener = this.a;
    if (localStartVideoListener != null) {
      localStartVideoListener.a();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.5
 * JD-Core Version:    0.7.0.1
 */