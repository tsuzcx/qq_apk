package com.tencent.imcore.message.facade.add;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import java.util.List;
import mqq.app.MobileQQ;

class OnMessageAddCompleteObserverNotifyDirectWithQAV
  extends OnMessageAddCompleteObserver
{
  public void a(QQMessageFacade paramQQMessageFacade, List<MessageRecord> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    MessageRecord localMessageRecord = a(paramList);
    if (localMessageRecord != null)
    {
      paramQQMessageFacade.f();
      paramQQMessageFacade.notifyObservers(localMessageRecord);
      QAVHrMeeting.a(localQQAppInterface, localMessageRecord);
    }
    paramQQMessageFacade.b(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.OnMessageAddCompleteObserverNotifyDirectWithQAV
 * JD-Core Version:    0.7.0.1
 */