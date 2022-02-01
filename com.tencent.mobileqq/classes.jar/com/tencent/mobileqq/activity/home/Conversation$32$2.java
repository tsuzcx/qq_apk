package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.recent.RecentAdapter;
import java.util.HashSet;
import java.util.Iterator;

class Conversation$32$2
  implements Runnable
{
  Conversation$32$2(Conversation.32 param32, HashSet paramHashSet) {}
  
  public void run()
  {
    if (this.b.a.t != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.b.a.t.a(str, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.32.2
 * JD-Core Version:    0.7.0.1
 */