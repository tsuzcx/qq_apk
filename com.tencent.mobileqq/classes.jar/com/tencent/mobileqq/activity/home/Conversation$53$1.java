package com.tencent.mobileqq.activity.home;

import ajyj;
import bdxj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
      bdxj localbdxj = (bdxj)this.a.this$0.a.getManager(QQManagerFactory.SUB_ACCOUNT_CONTROLL);
      if (localbdxj != null)
      {
        ArrayList localArrayList = localbdxj.a("sub.uin.all");
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)localArrayList.get(i);
          localbdxj.a(this.a.this$0.a, this.a.this$0.a(), localPair, new ajyj(this, localbdxj, localPair));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.53.1
 * JD-Core Version:    0.7.0.1
 */