package com.tencent.mobileqq.app.hiddenchat;

import android.os.Message;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;

class HiddenChatFragment$1
  implements Runnable
{
  HiddenChatFragment$1(HiddenChatFragment paramHiddenChatFragment) {}
  
  public void run()
  {
    Object localObject1 = HiddenChatFragment.a(this.this$0).getProxyManager().g().c();
    HiddenChatFragment.b(this.this$0).a((List)localObject1);
    Object localObject2 = HiddenChatFragment.a((List)localObject1, TroopAssistantManager.a().o(HiddenChatFragment.a(this.this$0)));
    localObject1 = new ArrayList(((List)localObject2).size());
    ConversationDataFactory.a((List)localObject2, HiddenChatFragment.a(this.this$0), this.this$0.getBaseActivity(), (List)localObject1, ((List)localObject2).size());
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("data|size");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      QLog.i("tag_hidden_chat", 2, ((StringBuilder)localObject2).toString());
    }
    try
    {
      Collections.sort((List)localObject1, HiddenChatFragment.b(this.this$0));
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(RecentDataListManager.a, 2, "Comparator Exception: ", localException);
      }
    }
    if (HiddenChatFragment.c(this.this$0) != null)
    {
      Message localMessage = HiddenChatFragment.c(this.this$0).obtainMessage(2);
      localMessage.obj = localObject1;
      HiddenChatFragment.c(this.this$0).removeMessages(2);
      HiddenChatFragment.c(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment.1
 * JD-Core Version:    0.7.0.1
 */