package com.tencent.imcore.message.facade.add.inner.end;

import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerEndProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TroopBarAssistantProcessor
  implements IAddMultiMessagesInnerEndProcessor<QQMessageFacade, QQAppInterface>
{
  public void a(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, List<MessageRecord> paramList, BaseMessageManager.AddMessageContext paramAddMessageContext, boolean paramBoolean)
  {
    paramQQMessageFacade = paramAddMessageContext.f.keySet().iterator();
    while (paramQQMessageFacade.hasNext())
    {
      paramList = (String)paramQQMessageFacade.next();
      paramList = (List)paramAddMessageContext.f.get(paramList);
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramList.next();
          TroopBarAssistantManager.a().a(localMessageRecord, paramQQAppInterface);
        }
      }
    }
    paramAddMessageContext.f.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.end.TroopBarAssistantProcessor
 * JD-Core Version:    0.7.0.1
 */