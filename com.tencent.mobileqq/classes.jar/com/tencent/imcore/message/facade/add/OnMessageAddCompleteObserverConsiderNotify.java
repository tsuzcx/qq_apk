package com.tencent.imcore.message.facade.add;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class OnMessageAddCompleteObserverConsiderNotify
  extends OnMessageAddCompleteObserver
{
  public void a(QQMessageFacade paramQQMessageFacade, List<MessageRecord> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    MessageRecord localMessageRecord = a(paramList);
    if (localMessageRecord != null)
    {
      paramQQMessageFacade.d();
      if (paramBoolean1) {
        paramQQMessageFacade.notifyObservers(localMessageRecord);
      }
    }
    if (paramBoolean1) {
      paramQQMessageFacade.b(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.OnMessageAddCompleteObserverConsiderNotify
 * JD-Core Version:    0.7.0.1
 */