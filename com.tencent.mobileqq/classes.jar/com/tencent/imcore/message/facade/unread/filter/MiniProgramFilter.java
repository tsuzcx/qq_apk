package com.tencent.imcore.message.facade.unread.filter;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

class MiniProgramFilter
  implements UnreadMsgFilter
{
  public boolean a(QQAppInterface paramQQAppInterface, ConversationInfo paramConversationInfo, QQMessageFacade paramQQMessageFacade)
  {
    return paramConversationInfo.type == 1038;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, ConversationInfo paramConversationInfo, QQMessageFacade paramQQMessageFacade)
  {
    RecentUser localRecentUser = paramQQAppInterface.getProxyManager().g().c(paramConversationInfo.uin, paramConversationInfo.type);
    paramQQMessageFacade = paramQQMessageFacade.getLastMessage(paramConversationInfo.uin, paramConversationInfo.type);
    if (((AppletsFolderManager)paramQQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).a(paramQQMessageFacade, localRecentUser) == 1)
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getUnreadMsgsNum appletsaccount info.uin=");
        paramQQAppInterface.append(paramConversationInfo.uin);
        paramQQAppInterface.append("  info.type=");
        paramQQAppInterface.append(paramConversationInfo.type);
        QLog.d("MiniProgramFilter", 2, paramQQAppInterface.toString());
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.filter.MiniProgramFilter
 * JD-Core Version:    0.7.0.1
 */