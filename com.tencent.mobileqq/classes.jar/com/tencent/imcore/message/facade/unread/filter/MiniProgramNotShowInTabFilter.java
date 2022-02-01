package com.tencent.imcore.message.facade.unread.filter;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ConversationInfo;

class MiniProgramNotShowInTabFilter
  implements UnreadMsgFilter
{
  public boolean a(QQAppInterface paramQQAppInterface, ConversationInfo paramConversationInfo, QQMessageFacade paramQQMessageFacade)
  {
    int i = paramConversationInfo.type;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 1038)
    {
      bool1 = bool2;
      if (!AppletsFolderManager.a(false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, ConversationInfo paramConversationInfo, QQMessageFacade paramQQMessageFacade)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.filter.MiniProgramNotShowInTabFilter
 * JD-Core Version:    0.7.0.1
 */