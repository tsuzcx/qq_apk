package com.tencent.mobileqq.activity.home;

import ajcv;
import bcqk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class Conversation$54$1
  implements Runnable
{
  Conversation$54$1(Conversation.54 param54) {}
  
  public void run()
  {
    if (this.a.this$0.h) {}
    for (;;)
    {
      return;
      bcqk localbcqk = (bcqk)this.a.this$0.a.getManager(62);
      if (localbcqk != null)
      {
        ArrayList localArrayList = localbcqk.a("sub.uin.all");
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)localArrayList.get(i);
          localbcqk.a(this.a.this$0.a, this.a.this$0.a(), localPair, new ajcv(this, localbcqk, localPair));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.54.1
 * JD-Core Version:    0.7.0.1
 */