package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.SessionInfo;
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
    SessionInfo localSessionInfo;
    QQAppInterface localQQAppInterface;
    ChatMessage localChatMessage;
    if ((paramList != null) && (paramList.size() != 0))
    {
      localSessionInfo = paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      localQQAppInterface = paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localChatMessage = (ChatMessage)paramList.get(paramList.size() - 1);
      if ((!localChatMessage.isSend()) && (localSessionInfo.jdField_a_of_type_Int == 0) && (!((FullScreenInputHelper)paramAIOContext.a(24)).b()))
      {
        if (!(localChatMessage instanceof MessageForPoke)) {
          break label166;
        }
        if (!((MessageForPoke)localChatMessage).isPlayed)
        {
          paramAIOContext = (MessageForPoke)localChatMessage;
          PokeItemAnimationManager.a().a(localQQAppInterface, localSessionInfo.jdField_a_of_type_JavaLangString, paramAIOContext.interactType, 0, paramAIOContext.strength);
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "receive PokeMsg strength:" + paramAIOContext.strength + "." + localChatMessage);
          }
        }
      }
    }
    label166:
    do
    {
      return paramList;
      PokeItemAnimationManager.a().a(localQQAppInterface, localSessionInfo.jdField_a_of_type_JavaLangString, -1, 0, -1);
    } while (!QLog.isColorLevel());
    QLog.d("PokeMsg", 2, "receive unPokeMsg strength:-1." + localChatMessage);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.PokeReloadFilter
 * JD-Core Version:    0.7.0.1
 */