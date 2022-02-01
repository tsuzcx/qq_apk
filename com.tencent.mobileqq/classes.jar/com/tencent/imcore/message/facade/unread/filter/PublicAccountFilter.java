package com.tencent.imcore.message.facade.unread.filter;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ConversationInfo;

public class PublicAccountFilter
  implements UnreadMsgFilter
{
  public boolean a(QQAppInterface paramQQAppInterface, ConversationInfo paramConversationInfo, QQMessageFacade paramQQMessageFacade)
  {
    return (paramConversationInfo.type == 1008) && (!ServiceAccountFolderManager.b(paramQQAppInterface, paramConversationInfo.uin));
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, ConversationInfo paramConversationInfo, QQMessageFacade paramQQMessageFacade)
  {
    return (ServiceAccountFolderManager.n()) && (paramConversationInfo.type == 1008) && (ServiceAccountFolderManager.c(paramConversationInfo.uin));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.filter.PublicAccountFilter
 * JD-Core Version:    0.7.0.1
 */