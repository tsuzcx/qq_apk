package com.tencent.mobileqq.app.message.messageclean;

import amhq;
import amhy;
import java.util.Iterator;
import java.util.List;

public class MessageCleanManager$4
  implements Runnable
{
  public MessageCleanManager$4(amhy paramamhy, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      amhq localamhq = (amhq)localIterator.next();
      amhy.a(this.this$0, localamhq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.4
 * JD-Core Version:    0.7.0.1
 */