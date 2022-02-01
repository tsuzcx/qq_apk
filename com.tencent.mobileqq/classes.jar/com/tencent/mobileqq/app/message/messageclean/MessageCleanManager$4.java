package com.tencent.mobileqq.app.message.messageclean;

import aoui;
import aouq;
import java.util.Iterator;
import java.util.List;

public class MessageCleanManager$4
  implements Runnable
{
  public MessageCleanManager$4(aouq paramaouq, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      aoui localaoui = (aoui)localIterator.next();
      aouq.a(this.this$0, localaoui);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.4
 * JD-Core Version:    0.7.0.1
 */