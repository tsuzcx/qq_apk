package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.recent.RecentAdapter;
import java.util.ArrayList;
import java.util.Iterator;

class Conversation$32$3
  implements Runnable
{
  Conversation$32$3(Conversation.32 param32, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.b.a.t != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.b.a.t.a(str, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.32.3
 * JD-Core Version:    0.7.0.1
 */