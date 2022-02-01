package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatManager;

public class FlashChatMsgUpdateCallback
  implements IMsgUpdateCallback
{
  public boolean a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void b(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    if ((!paramChatMessage.isread) && (!paramChatMessage.isSend()) && ((paramChatMessage instanceof MessageForArkFlashChat)) && (!((FullScreenInputHelper)paramAIOContext.a(24)).e())) {
      ((FlashChatManager)paramAIOContext.a().getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a((MessageForArkFlashChat)paramChatMessage);
    }
  }
  
  public void c(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public boolean d(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void e(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForArkFlashChat)) {
      ((FlashChatManager)paramAIOContext.a().getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a((MessageForArkFlashChat)paramChatMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.FlashChatMsgUpdateCallback
 * JD-Core Version:    0.7.0.1
 */