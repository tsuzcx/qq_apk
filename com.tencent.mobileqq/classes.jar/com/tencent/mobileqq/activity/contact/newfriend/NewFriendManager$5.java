package com.tencent.mobileqq.activity.contact.newfriend;

import aiej;
import aiep;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$5
  implements Runnable
{
  public NewFriendManager$5(aiej paramaiej, int paramInt) {}
  
  public void run()
  {
    synchronized (aiej.a(this.this$0))
    {
      Iterator localIterator = aiej.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((aiep)localIterator.next()).j_(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.5
 * JD-Core Version:    0.7.0.1
 */