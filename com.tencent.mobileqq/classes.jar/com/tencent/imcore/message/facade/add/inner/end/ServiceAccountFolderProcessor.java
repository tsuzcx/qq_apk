package com.tencent.imcore.message.facade.add.inner.end;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerEndProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import java.util.List;

class ServiceAccountFolderProcessor
  implements IAddMultiMessagesInnerEndProcessor<QQMessageFacade, QQAppInterface>
{
  public void a(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, List<MessageRecord> paramList, BaseMessageManager.AddMessageContext paramAddMessageContext, boolean paramBoolean)
  {
    paramQQMessageFacade = ServiceAccountFolderManager.a();
    paramAddMessageContext = (ClassicHeadActivityManager)paramQQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      paramQQMessageFacade.a(paramQQAppInterface, localMessageRecord);
      ((IVideoReporter)QRoute.api(IVideoReporter.class)).reportVideoStructMsgRecv(localMessageRecord);
      if ((paramAddMessageContext != null) && (paramAddMessageContext.a())) {
        paramAddMessageContext.b(localMessageRecord.senderuin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.end.ServiceAccountFolderProcessor
 * JD-Core Version:    0.7.0.1
 */