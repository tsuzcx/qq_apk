package com.tencent.mobileqq.activity.aio.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.service.message.MessageRecordFactory;

class ArkFlashChatItemBubbleBuilder$4
  implements DialogInterface.OnClickListener
{
  ArkFlashChatItemBubbleBuilder$4(ArkFlashChatItemBubbleBuilder paramArkFlashChatItemBubbleBuilder, MessageForArkFlashChat paramMessageForArkFlashChat) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (MessageForArkFlashChat)MessageRecordFactory.a(this.a);
    if (paramDialogInterface.msgData == null)
    {
      if (paramDialogInterface.ark_app_message == null)
      {
        ArkAppCenter.a("ArkApp", String.format("resendMessage, msgData and ark_app_message are null", new Object[0]));
        return;
      }
      paramDialogInterface.msgData = paramDialogInterface.ark_app_message.toBytes();
    }
    if (this.b.f != null)
    {
      this.b.d.getMessageFacade().h(this.b.f.b, this.b.f.a, this.a.uniseq);
      this.b.d.getMessageFacade().a(paramDialogInterface, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatItemBubbleBuilder.4
 * JD-Core Version:    0.7.0.1
 */