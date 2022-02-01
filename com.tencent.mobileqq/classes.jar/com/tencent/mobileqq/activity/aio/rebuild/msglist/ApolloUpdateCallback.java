package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class ApolloUpdateCallback
  implements IMsgUpdateCallback
{
  public boolean a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void b(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public void c(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    if ((!paramChatMessage.isSend()) && (paramChatMessage.msgtype == -2039))
    {
      paramAIOContext = (IApolloManagerService)paramAIOContext.a().getRuntimeService(IApolloManagerService.class, "all");
      if (!paramAIOContext.isInActionPlayList(paramChatMessage.uniseq)) {
        paramAIOContext.addToActionPlayList(paramChatMessage.uniseq);
      }
    }
  }
  
  public boolean d(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void e(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ApolloUpdateCallback
 * JD-Core Version:    0.7.0.1
 */