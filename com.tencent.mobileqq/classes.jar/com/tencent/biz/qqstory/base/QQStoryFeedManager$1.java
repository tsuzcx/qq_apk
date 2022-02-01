package com.tencent.biz.qqstory.base;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;

class QQStoryFeedManager$1
  implements Runnable
{
  QQStoryFeedManager$1(QQStoryFeedManager paramQQStoryFeedManager, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = QQStoryFeedManager.a(this.this$0).getMessageFacade().a(this.a, 0, new int[] { -2061 }).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      QQStoryFeedManager.a(this.this$0).getMessageFacade().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      QQStoryFeedManager.a(this.this$0).getMessageFacade().h(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.QQStoryFeedManager.1
 * JD-Core Version:    0.7.0.1
 */