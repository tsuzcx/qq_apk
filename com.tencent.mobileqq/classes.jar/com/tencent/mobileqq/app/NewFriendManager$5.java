package com.tencent.mobileqq.app;

import ajnf;
import ajnk;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$5
  implements Runnable
{
  public NewFriendManager$5(ajnf paramajnf, int paramInt) {}
  
  public void run()
  {
    synchronized (ajnf.a(this.this$0))
    {
      Iterator localIterator = ajnf.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((ajnk)localIterator.next()).i_(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NewFriendManager.5
 * JD-Core Version:    0.7.0.1
 */