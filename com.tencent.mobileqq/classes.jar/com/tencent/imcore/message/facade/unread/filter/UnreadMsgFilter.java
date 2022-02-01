package com.tencent.imcore.message.facade.unread.filter;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ConversationInfo;

public abstract interface UnreadMsgFilter
{
  public abstract boolean a(QQAppInterface paramQQAppInterface, ConversationInfo paramConversationInfo, QQMessageFacade paramQQMessageFacade);
  
  public abstract boolean b(QQAppInterface paramQQAppInterface, ConversationInfo paramConversationInfo, QQMessageFacade paramQQMessageFacade);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.filter.UnreadMsgFilter
 * JD-Core Version:    0.7.0.1
 */