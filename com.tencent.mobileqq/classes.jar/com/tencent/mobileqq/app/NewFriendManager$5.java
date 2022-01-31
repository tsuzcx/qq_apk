package com.tencent.mobileqq.app;

import akbo;
import akbu;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$5
  implements Runnable
{
  public NewFriendManager$5(akbo paramakbo, int paramInt) {}
  
  public void run()
  {
    synchronized (akbo.a(this.this$0))
    {
      Iterator localIterator = akbo.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((akbu)localIterator.next()).i_(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NewFriendManager.5
 * JD-Core Version:    0.7.0.1
 */