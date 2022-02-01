package com.tencent.mobileqq.app.message.messageclean;

import aoqb;
import aoqj;
import java.util.Iterator;
import java.util.List;

public class MessageCleanManager$4
  implements Runnable
{
  public MessageCleanManager$4(aoqj paramaoqj, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      aoqb localaoqb = (aoqb)localIterator.next();
      aoqj.a(this.this$0, localaoqb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.4
 * JD-Core Version:    0.7.0.1
 */