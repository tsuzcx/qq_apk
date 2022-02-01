package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EcshopReportHandler$1
  extends MessageObserver
{
  EcshopReportHandler$1(EcshopReportHandler paramEcshopReportHandler) {}
  
  public void onMessageRecordAdded(List<MessageRecord> paramList)
  {
    super.onMessageRecordAdded(paramList);
    EcshopReportHandler localEcshopReportHandler = (EcshopReportHandler)EcshopReportHandler.a(this.a).getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)EcshopReportHandler.a(this.a).getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (localEcshopReportHandler != null)
    {
      if (localEcShopAssistantManager == null) {
        return;
      }
      paramList = new ArrayList(paramList).iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        int i;
        if ((!"2".equals(localMessageRecord.getExtInfoFromExtStr("inter_num"))) && ((localMessageRecord.istroop != 1008) || (!ServiceAccountFolderManager.c(EcshopReportHandler.a(this.a), localMessageRecord.senderuin)))) {
          i = 0;
        } else {
          i = 1;
        }
        if ((i != 0) || (localEcShopAssistantManager.a(localMessageRecord.senderuin)))
        {
          if (i != 0) {
            localEcshopReportHandler.a(localMessageRecord);
          }
          localEcshopReportHandler.b(localMessageRecord);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler.1
 * JD-Core Version:    0.7.0.1
 */