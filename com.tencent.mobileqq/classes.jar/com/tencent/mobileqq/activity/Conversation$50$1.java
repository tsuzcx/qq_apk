package com.tencent.mobileqq.activity;

import aaxc;
import ayaq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class Conversation$50$1
  implements Runnable
{
  Conversation$50$1(Conversation.50 param50) {}
  
  public void run()
  {
    if (this.a.this$0.h) {}
    for (;;)
    {
      return;
      ayaq localayaq = (ayaq)this.a.this$0.a.getManager(62);
      if (localayaq != null)
      {
        ArrayList localArrayList = localayaq.a("sub.uin.all");
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)localArrayList.get(i);
          localayaq.a(this.a.this$0.a, this.a.this$0.a(), localPair, new aaxc(this, localayaq, localPair));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.50.1
 * JD-Core Version:    0.7.0.1
 */