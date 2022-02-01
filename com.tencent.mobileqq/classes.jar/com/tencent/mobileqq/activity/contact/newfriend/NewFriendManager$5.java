package com.tencent.mobileqq.activity.contact.newfriend;

import aiyr;
import aiyx;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$5
  implements Runnable
{
  public NewFriendManager$5(aiyr paramaiyr, int paramInt) {}
  
  public void run()
  {
    synchronized (aiyr.a(this.this$0))
    {
      Iterator localIterator = aiyr.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((aiyx)localIterator.next()).j_(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.5
 * JD-Core Version:    0.7.0.1
 */