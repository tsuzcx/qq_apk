package com.tencent.mobileqq.app;

import akbn;
import akbt;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$5
  implements Runnable
{
  public NewFriendManager$5(akbn paramakbn, int paramInt) {}
  
  public void run()
  {
    synchronized (akbn.a(this.this$0))
    {
      Iterator localIterator = akbn.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((akbt)localIterator.next()).i_(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NewFriendManager.5
 * JD-Core Version:    0.7.0.1
 */