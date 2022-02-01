package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

final class ChatAVHelper$13
  implements DialogInterface.OnClickListener
{
  ChatAVHelper$13(ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.VideoCheckFlag localVideoCheckFlag = this.a;
    localVideoCheckFlag.k = false;
    localVideoCheckFlag.l = false;
    ChatActivityUtils.a(this.b, this.c, this.d, this.e, localVideoCheckFlag);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.13
 * JD-Core Version:    0.7.0.1
 */