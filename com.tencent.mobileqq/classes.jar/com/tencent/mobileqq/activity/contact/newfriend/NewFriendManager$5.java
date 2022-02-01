package com.tencent.mobileqq.activity.contact.newfriend;

import ajka;
import ajkg;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$5
  implements Runnable
{
  public NewFriendManager$5(ajka paramajka, int paramInt) {}
  
  public void run()
  {
    synchronized (ajka.a(this.this$0))
    {
      Iterator localIterator = ajka.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((ajkg)localIterator.next()).j_(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.5
 * JD-Core Version:    0.7.0.1
 */