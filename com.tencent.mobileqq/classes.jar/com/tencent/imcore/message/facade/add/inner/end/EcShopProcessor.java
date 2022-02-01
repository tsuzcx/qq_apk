package com.tencent.imcore.message.facade.add.inner.end;

import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerEndProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class EcShopProcessor
  implements IAddMultiMessagesInnerEndProcessor<QQMessageFacade, QQAppInterface>
{
  public void a(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, List<MessageRecord> paramList, BaseMessageManager.AddMessageContext paramAddMessageContext, boolean paramBoolean)
  {
    paramQQMessageFacade = paramAddMessageContext.g.keySet().iterator();
    while (paramQQMessageFacade.hasNext())
    {
      Object localObject = (String)paramQQMessageFacade.next();
      paramList = (EcShopAssistantManager)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      localObject = (List)paramAddMessageContext.g.get(localObject);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramList.a((MessageRecord)((Iterator)localObject).next(), paramQQAppInterface);
        }
      }
    }
    paramAddMessageContext.g.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.end.EcShopProcessor
 * JD-Core Version:    0.7.0.1
 */