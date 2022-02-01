package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class Conversation$58$1
  implements Runnable
{
  Conversation$58$1(Conversation.58 param58) {}
  
  public void run()
  {
    if (this.a.this$0.h) {}
    for (;;)
    {
      return;
      SubAccountControll localSubAccountControll = (SubAccountControll)this.a.this$0.a.getManager(QQManagerFactory.SUB_ACCOUNT_CONTROLL);
      if (localSubAccountControll != null)
      {
        ArrayList localArrayList = localSubAccountControll.a("sub.uin.all");
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)localArrayList.get(i);
          localSubAccountControll.a(this.a.this$0.a(), (BaseActivity)this.a.this$0.a(), localPair, new Conversation.58.1.1(this, localSubAccountControll, localPair));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.58.1
 * JD-Core Version:    0.7.0.1
 */