package com.tencent.mobileqq.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

final class ChatActivityFacade$14
  implements Runnable
{
  ChatActivityFacade$14(ChatActivityFacade.SendMsgParams paramSendMsgParams, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    if (this.a.a) {
      this.b.getMessageFacade().s(this.c.b, this.c.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.14
 * JD-Core Version:    0.7.0.1
 */