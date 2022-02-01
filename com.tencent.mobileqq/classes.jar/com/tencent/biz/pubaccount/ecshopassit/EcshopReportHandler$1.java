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
    if ((localEcshopReportHandler == null) || (localEcShopAssistantManager == null)) {
      return;
    }
    paramList = new ArrayList(paramList).iterator();
    label166:
    label169:
    for (;;)
    {
      label64:
      MessageRecord localMessageRecord;
      if (paramList.hasNext())
      {
        localMessageRecord = (MessageRecord)paramList.next();
        if ((!"2".equals(localMessageRecord.getExtInfoFromExtStr("inter_num"))) && ((localMessageRecord.istroop != 1008) || (!ServiceAccountFolderManager.e(EcshopReportHandler.a(this.a), localMessageRecord.senderuin)))) {
          break label166;
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (!localEcShopAssistantManager.a(localMessageRecord.senderuin))) {
          break label169;
        }
        if (i != 0) {
          localEcshopReportHandler.a(localMessageRecord);
        }
        localEcshopReportHandler.b(localMessageRecord);
        break label64;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler.1
 * JD-Core Version:    0.7.0.1
 */