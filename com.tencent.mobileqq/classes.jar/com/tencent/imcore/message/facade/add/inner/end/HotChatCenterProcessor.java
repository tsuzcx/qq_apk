package com.tencent.imcore.message.facade.add.inner.end;

import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerEndProcessor;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class HotChatCenterProcessor
  implements IAddMultiMessagesInnerEndProcessor<QQMessageFacade, QQAppInterface>
{
  public void a(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, List<MessageRecord> paramList, BaseMessageManager.AddMessageContext paramAddMessageContext, boolean paramBoolean)
  {
    paramQQMessageFacade = (HotChatCenterManager)paramQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER);
    paramQQAppInterface = paramAddMessageContext.c.keySet().iterator();
    while (paramQQAppInterface.hasNext())
    {
      paramList = (String)paramQQAppInterface.next();
      paramQQMessageFacade.a((MessageRecord)paramAddMessageContext.c.get(paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.end.HotChatCenterProcessor
 * JD-Core Version:    0.7.0.1
 */