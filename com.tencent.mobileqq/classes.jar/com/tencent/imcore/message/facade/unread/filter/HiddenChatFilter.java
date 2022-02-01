package com.tencent.imcore.message.facade.unread.filter;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ConversationInfo;

class HiddenChatFilter
  implements UnreadMsgFilter
{
  public boolean a(QQAppInterface paramQQAppInterface, ConversationInfo paramConversationInfo, QQMessageFacade paramQQMessageFacade)
  {
    return paramQQMessageFacade.b(paramConversationInfo);
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, ConversationInfo paramConversationInfo, QQMessageFacade paramQQMessageFacade)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.filter.HiddenChatFilter
 * JD-Core Version:    0.7.0.1
 */