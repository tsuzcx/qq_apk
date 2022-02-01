package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.service.message.MessageCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PokeReadConfirmCallback
  implements IReadConfirmCallback
{
  public void a(AIOContext paramAIOContext) {}
  
  public void a(AIOContext paramAIOContext, List<ChatMessage> paramList, int paramInt)
  {
    paramList = paramAIOContext.e().b().d();
    ArrayList localArrayList = new ArrayList();
    if (paramAIOContext.O().a == 0)
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        paramInt = paramList.size() - 1;
        while (paramInt >= 0)
        {
          ChatMessage localChatMessage = (ChatMessage)paramList.get(paramInt);
          if (((localChatMessage instanceof MessageForPoke)) && (!localChatMessage.isSend())) {
            localArrayList.add((MessageForPoke)localChatMessage);
          }
          paramInt -= 1;
        }
      }
      if (localArrayList.size() > 0)
      {
        paramList = (MessageForPoke)localArrayList.get(0);
        if (!paramList.isPlayed) {
          paramAIOContext.a().getMsgCache().h.put(Long.valueOf(paramList.uniseq), paramList);
        }
      }
    }
  }
  
  public void b(AIOContext paramAIOContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.PokeReadConfirmCallback
 * JD-Core Version:    0.7.0.1
 */