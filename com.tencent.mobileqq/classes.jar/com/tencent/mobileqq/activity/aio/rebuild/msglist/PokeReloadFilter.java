package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IReloadFilter;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class PokeReloadFilter
  implements IReloadFilter
{
  public List<ChatMessage> a(AIOContext paramAIOContext, List<ChatMessage> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      Object localObject = paramAIOContext.O();
      QQAppInterface localQQAppInterface = paramAIOContext.a();
      ChatMessage localChatMessage = (ChatMessage)paramList.get(paramList.size() - 1);
      if ((!localChatMessage.isSend()) && (((BaseSessionInfo)localObject).a == 0) && (!((FullScreenInputHelper)paramAIOContext.a(24)).e())) {
        if ((localChatMessage instanceof MessageForPoke))
        {
          paramAIOContext = (MessageForPoke)localChatMessage;
          if (!paramAIOContext.isPlayed)
          {
            PokeItemAnimationManager.c().a(localQQAppInterface, ((BaseSessionInfo)localObject).b, paramAIOContext.interactType, 0, paramAIOContext.strength);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("receive PokeMsg strength:");
              ((StringBuilder)localObject).append(paramAIOContext.strength);
              ((StringBuilder)localObject).append(".");
              ((StringBuilder)localObject).append(localChatMessage);
              QLog.d("PokeMsg", 2, ((StringBuilder)localObject).toString());
              return paramList;
            }
          }
        }
        else
        {
          PokeItemAnimationManager.c().a(localQQAppInterface, ((BaseSessionInfo)localObject).b, -1, 0, -1);
          if (QLog.isColorLevel())
          {
            paramAIOContext = new StringBuilder();
            paramAIOContext.append("receive unPokeMsg strength:-1.");
            paramAIOContext.append(localChatMessage);
            QLog.d("PokeMsg", 2, paramAIOContext.toString());
          }
        }
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.PokeReloadFilter
 * JD-Core Version:    0.7.0.1
 */