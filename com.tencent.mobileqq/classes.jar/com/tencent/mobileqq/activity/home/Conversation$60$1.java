package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class Conversation$60$1
  implements Runnable
{
  Conversation$60$1(Conversation.60 param60) {}
  
  public void run()
  {
    if (this.a.this$0.F) {
      return;
    }
    ISubAccountControlService localISubAccountControlService = (ISubAccountControlService)this.a.this$0.aF.getRuntimeService(ISubAccountControlService.class, "");
    if (localISubAccountControlService != null)
    {
      ArrayList localArrayList = localISubAccountControlService.popWaittingHintPair("sub.uin.all");
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        Pair localPair = (Pair)localArrayList.get(i);
        localISubAccountControlService.showHintDialog(this.a.this$0.s(), (BaseActivity)this.a.this$0.P(), localPair, new Conversation.60.1.1(this, localISubAccountControlService, localPair));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.60.1
 * JD-Core Version:    0.7.0.1
 */