package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;

public class AIOSpreadMsgUpdateCallback
  implements IMsgUpdateCallback
{
  public boolean a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void b(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public void c(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForText)) {
      ((AIOMessageSpreadManager)paramAIOContext.a().getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a(paramChatMessage);
    }
  }
  
  public boolean d(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForText)) {
      ((AIOMessageSpreadManager)paramAIOContext.a().getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a(paramChatMessage);
    }
    return false;
  }
  
  public void e(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.AIOSpreadMsgUpdateCallback
 * JD-Core Version:    0.7.0.1
 */