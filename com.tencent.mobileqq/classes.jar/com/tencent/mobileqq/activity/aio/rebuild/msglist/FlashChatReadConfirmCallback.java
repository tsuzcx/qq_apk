package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import java.util.List;

public class FlashChatReadConfirmCallback
  implements IReadConfirmCallback
{
  public void a(AIOContext paramAIOContext) {}
  
  public void a(AIOContext paramAIOContext, List<ChatMessage> paramList, int paramInt)
  {
    if (paramList.size() > 0)
    {
      paramList = (ChatMessage)paramList.get(paramList.size() - 1);
      ((FlashChatManager)paramAIOContext.a().getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(paramList);
    }
  }
  
  public void b(AIOContext paramAIOContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.FlashChatReadConfirmCallback
 * JD-Core Version:    0.7.0.1
 */