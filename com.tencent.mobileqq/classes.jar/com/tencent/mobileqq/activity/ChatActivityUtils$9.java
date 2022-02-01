package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;

final class ChatActivityUtils$9
  implements DialogInterface.OnClickListener
{
  ChatActivityUtils$9(long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString, boolean paramBoolean1, ChatActivityUtils.StartVideoListener paramStartVideoListener, Bundle paramBundle, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ChatActivityUtils.a(this.a, this.b);
    if (paramInt == 1)
    {
      ChatActivityUtils.a(this.c, paramDialogInterface, this.d, this.e, false, this.f, this.g, this.h);
      return;
    }
    ChatActivityUtils.a(paramDialogInterface, true ^ this.i, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.9
 * JD-Core Version:    0.7.0.1
 */