package com.tencent.mobileqq.activity.miniaio;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.replymsg.ForwardMsgManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class MiniMultiForwardFragment$1
  implements Runnable
{
  MiniMultiForwardFragment$1(MiniMultiForwardFragment paramMiniMultiForwardFragment) {}
  
  public void run()
  {
    Object localObject = new ArrayList();
    if (MiniMultiForwardFragment.a(this.this$0) == 3)
    {
      ChatMessage localChatMessage = ((ForwardMsgManager)this.this$0.c.getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).a(MiniMultiForwardFragment.b(this.this$0));
      if (localChatMessage != null)
      {
        localObject = new ArrayList(1);
        ((ArrayList)localObject).add(localChatMessage);
        localObject = MiniMultiForwardFragment.a(this.this$0, (ArrayList)localObject);
      }
    }
    else if (MiniMultiForwardFragment.a(this.this$0) == 2)
    {
      localObject = MiniMultiForwardFragment.c(this.this$0);
      MiniMultiForwardFragment.b(this.this$0, (ArrayList)localObject);
    }
    else if (MiniMultiForwardFragment.a(this.this$0) == 1)
    {
      localObject = MiniMultiForwardFragment.a(this.this$0, MultiMsgManager.a().c);
    }
    else if (MiniMultiForwardFragment.a(this.this$0) == 4)
    {
      localObject = this.this$0;
      localObject = MiniMultiForwardFragment.a((MiniMultiForwardFragment)localObject, ((MiniMultiForwardFragment)localObject).e);
    }
    else
    {
      QLog.e("MiniMultiForwardPreviewFragment", 2, "Forward type unknown");
    }
    if (localObject != null) {
      ThreadManager.getUIHandler().post(new MiniMultiForwardFragment.1.1(this, (ArrayList)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment.1
 * JD-Core Version:    0.7.0.1
 */