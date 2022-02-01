package com.tencent.mobileqq.activity;

import aeja;
import bdwt;
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
      bdwt localbdwt = (bdwt)this.a.this$0.a.getManager(62);
      if (localbdwt != null)
      {
        ArrayList localArrayList = localbdwt.a("sub.uin.all");
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)localArrayList.get(i);
          localbdwt.a(this.a.this$0.a, this.a.this$0.a(), localPair, new aeja(this, localbdwt, localPair));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.53.1
 * JD-Core Version:    0.7.0.1
 */