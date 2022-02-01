package com.tencent.imcore.message.facade.unread.filter;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.Registry;
import com.tencent.imcore.message.core.GetUnreadMsgNumCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ConversationInfo;
import java.util.Iterator;
import java.util.List;

class DefaultFilter
  implements UnreadMsgFilter
{
  private boolean a(ConversationInfo paramConversationInfo, boolean[] paramArrayOfBoolean, Registry paramRegistry, QQAppInterface paramQQAppInterface)
  {
    paramRegistry = paramRegistry.d().iterator();
    while (paramRegistry.hasNext()) {
      if (((GetUnreadMsgNumCallback)paramRegistry.next()).a(paramConversationInfo, paramArrayOfBoolean, paramQQAppInterface)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, ConversationInfo paramConversationInfo, QQMessageFacade paramQQMessageFacade)
  {
    return true;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, ConversationInfo paramConversationInfo, QQMessageFacade paramQQMessageFacade)
  {
    boolean[] arrayOfBoolean = new boolean[1];
    boolean bool = a(paramConversationInfo, arrayOfBoolean, paramQQMessageFacade.a(), paramQQAppInterface);
    int i = 0;
    if (bool) {
      i = arrayOfBoolean[0];
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.filter.DefaultFilter
 * JD-Core Version:    0.7.0.1
 */