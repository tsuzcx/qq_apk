package com.tencent.mobileqq.app.message.messageclean;

import java.util.Iterator;
import java.util.List;

class MessageCleanManager$4
  implements Runnable
{
  MessageCleanManager$4(MessageCleanManager paramMessageCleanManager, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      CleanMessageItemInfo localCleanMessageItemInfo = (CleanMessageItemInfo)localIterator.next();
      MessageCleanManager.a(this.this$0, localCleanMessageItemInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.4
 * JD-Core Version:    0.7.0.1
 */