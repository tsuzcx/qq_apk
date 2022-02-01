package com.tencent.biz.qqstory.base;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;
import wiz;

public class QQStoryFeedManager$1
  implements Runnable
{
  public QQStoryFeedManager$1(wiz paramwiz, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = wiz.a(this.this$0).a().a(this.a, 0, new int[] { -2061 }).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      wiz.a(this.this$0).a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      wiz.a(this.this$0).a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.QQStoryFeedManager.1
 * JD-Core Version:    0.7.0.1
 */