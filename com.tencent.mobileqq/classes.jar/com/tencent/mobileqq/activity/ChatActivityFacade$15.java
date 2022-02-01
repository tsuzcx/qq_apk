package com.tencent.mobileqq.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

final class ChatActivityFacade$15
  implements Runnable
{
  ChatActivityFacade$15(ChatActivityFacade.SendMsgParams paramSendMsgParams, QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo) {}
  
  public void run()
  {
    if (this.a.a) {
      this.b.getMessageFacade().s(this.c.b, this.c.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.15
 * JD-Core Version:    0.7.0.1
 */