package com.tencent.imcore.message.facade.add;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class OnMessageAddCompleteObserverDirect
  extends OnMessageAddCompleteObserver
{
  public void a(QQMessageFacade paramQQMessageFacade, List<MessageRecord> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    MessageRecord localMessageRecord = a(paramList);
    if (localMessageRecord != null)
    {
      paramQQMessageFacade.f();
      paramQQMessageFacade.notifyObservers(localMessageRecord);
    }
    paramQQMessageFacade.b(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.OnMessageAddCompleteObserverDirect
 * JD-Core Version:    0.7.0.1
 */