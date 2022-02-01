package com.tencent.mobileqq.activity.miniaio;

import axpf;
import bbdj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class MiniMultiForwardFragment$1
  implements Runnable
{
  MiniMultiForwardFragment$1(MiniMultiForwardFragment paramMiniMultiForwardFragment) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (MiniMultiForwardFragment.a(this.this$0) == 3)
    {
      ChatMessage localChatMessage = ((bbdj)this.this$0.a.getManager(340)).a(MiniMultiForwardFragment.a(this.this$0));
      if (localChatMessage == null) {
        break label161;
      }
      localArrayList = new ArrayList(1);
      localArrayList.add(localChatMessage);
      localArrayList = MiniMultiForwardFragment.a(this.this$0, localArrayList);
    }
    label161:
    for (;;)
    {
      if (localArrayList != null) {
        ThreadManager.getUIHandler().post(new MiniMultiForwardFragment.1.1(this, localArrayList));
      }
      return;
      if (MiniMultiForwardFragment.a(this.this$0) == 2)
      {
        localArrayList = MiniMultiForwardFragment.a(this.this$0);
        MiniMultiForwardFragment.a(this.this$0, localArrayList);
      }
      else if (MiniMultiForwardFragment.a(this.this$0) == 1)
      {
        localArrayList = MiniMultiForwardFragment.a(this.this$0, axpf.a().a);
      }
      else
      {
        QLog.e("MiniMultiForwardPreviewFragment", 2, "Forward type unknown");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment.1
 * JD-Core Version:    0.7.0.1
 */