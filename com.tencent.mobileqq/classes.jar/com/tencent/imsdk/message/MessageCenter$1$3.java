package com.tencent.imsdk.message;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class MessageCenter$1$3
  implements Runnable
{
  MessageCenter$1$3(MessageCenter.1 param1, List paramList) {}
  
  public void run()
  {
    synchronized (MessageCenter.access$100(this.this$1.this$0))
    {
      Iterator localIterator = MessageCenter.access$200(this.this$1.this$0).iterator();
      while (localIterator.hasNext()) {
        ((MessageListener)localIterator.next()).onReceiveMessageRevoked(this.val$keyList);
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.MessageCenter.1.3
 * JD-Core Version:    0.7.0.1
 */