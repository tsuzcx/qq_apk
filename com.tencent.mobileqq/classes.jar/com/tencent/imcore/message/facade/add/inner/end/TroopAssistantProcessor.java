package com.tencent.imcore.message.facade.add.inner.end;

import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerEndProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TroopAssistantProcessor
  implements IAddMultiMessagesInnerEndProcessor<QQMessageFacade, QQAppInterface>
{
  public void a(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, List<MessageRecord> paramList, BaseMessageManager.AddMessageContext paramAddMessageContext, boolean paramBoolean)
  {
    paramQQMessageFacade = paramAddMessageContext.b.keySet().iterator();
    while (paramQQMessageFacade.hasNext())
    {
      paramList = (String)paramQQMessageFacade.next();
      TroopAssistantManager.a().a((MessageRecord)paramAddMessageContext.b.get(paramList), paramQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.end.TroopAssistantProcessor
 * JD-Core Version:    0.7.0.1
 */