package com.tencent.mobileqq.app.message.messageclean;

import akda;
import akdi;
import java.util.Iterator;
import java.util.List;

public class MessageCleanManager$4
  implements Runnable
{
  public MessageCleanManager$4(akdi paramakdi, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      akda localakda = (akda)localIterator.next();
      akdi.a(this.this$0, localakda);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.4
 * JD-Core Version:    0.7.0.1
 */