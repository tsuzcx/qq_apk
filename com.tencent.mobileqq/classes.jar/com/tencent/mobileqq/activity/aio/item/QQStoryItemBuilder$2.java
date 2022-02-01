package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.ChatMessage;

class QQStoryItemBuilder$2
  implements DialogInterface.OnClickListener
{
  QQStoryItemBuilder$2(QQStoryItemBuilder paramQQStoryItemBuilder, Context paramContext, ChatMessage paramChatMessage) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityFacade.a(this.c.d, this.a, this.c.f, this.b.frienduin, this.b.istroop, this.b.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */