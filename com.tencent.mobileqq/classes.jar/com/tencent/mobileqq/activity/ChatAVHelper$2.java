package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ChatAVHelper$2
  implements DialogInterface.OnClickListener
{
  ChatAVHelper$2(ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.StartVideoListener localStartVideoListener = this.a;
    if (localStartVideoListener != null) {
      localStartVideoListener.a();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.2
 * JD-Core Version:    0.7.0.1
 */