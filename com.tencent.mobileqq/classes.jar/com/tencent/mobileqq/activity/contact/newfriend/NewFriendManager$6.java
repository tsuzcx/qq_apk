package com.tencent.mobileqq.activity.contact.newfriend;

import java.util.Iterator;
import java.util.LinkedList;

class NewFriendManager$6
  implements Runnable
{
  NewFriendManager$6(NewFriendManager paramNewFriendManager, int paramInt) {}
  
  public void run()
  {
    synchronized (NewFriendManager.a(this.this$0))
    {
      Iterator localIterator = NewFriendManager.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((NewFriendManager.INewFriendListener)localIterator.next()).k_(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.6
 * JD-Core Version:    0.7.0.1
 */