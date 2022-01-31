package com.tencent.mobileqq.activity;

import aanr;
import axam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class Conversation$53$1
  implements Runnable
{
  Conversation$53$1(Conversation.53 param53) {}
  
  public void run()
  {
    if (this.a.this$0.h) {}
    for (;;)
    {
      return;
      axam localaxam = (axam)this.a.this$0.a.getManager(62);
      if (localaxam != null)
      {
        ArrayList localArrayList = localaxam.a("sub.uin.all");
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)localArrayList.get(i);
          localaxam.a(this.a.this$0.a, this.a.this$0.a(), localPair, new aanr(this, localaxam, localPair));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.53.1
 * JD-Core Version:    0.7.0.1
 */