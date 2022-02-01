package com.tencent.imcore.message.facade.unread.count;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.Registry;
import com.tencent.imcore.message.core.GetUnreadMsgNumCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

class MsgCallbackUnreadCountCalculateStrategy
  implements UnreadCountCalculateStrategy
{
  public int a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, StringBuilder paramStringBuilder)
  {
    paramQQMessageFacade = paramQQMessageFacade.c().j().iterator();
    int i = 0;
    while (paramQQMessageFacade.hasNext()) {
      i += ((GetUnreadMsgNumCallback)paramQQMessageFacade.next()).a("(%s,%d,%d) ", paramStringBuilder, paramQQAppInterface);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.count.MsgCallbackUnreadCountCalculateStrategy
 * JD-Core Version:    0.7.0.1
 */