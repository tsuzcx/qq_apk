package com.tencent.mobileqq.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

final class ChatActivityFacade$16
  implements Runnable
{
  ChatActivityFacade$16(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    this.a.getMessageFacade().a(this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.16
 * JD-Core Version:    0.7.0.1
 */