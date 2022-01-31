package com.tencent.mobileqq.activity;

import acsp;
import bacu;
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
      bacu localbacu = (bacu)this.a.this$0.a.getManager(62);
      if (localbacu != null)
      {
        ArrayList localArrayList = localbacu.a("sub.uin.all");
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)localArrayList.get(i);
          localbacu.a(this.a.this$0.a, this.a.this$0.a(), localPair, new acsp(this, localbacu, localPair));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.50.1
 * JD-Core Version:    0.7.0.1
 */