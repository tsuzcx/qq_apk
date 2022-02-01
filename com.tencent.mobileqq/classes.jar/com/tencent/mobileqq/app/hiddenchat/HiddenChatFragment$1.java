package com.tencent.mobileqq.app.hiddenchat;

import akju;
import android.os.Message;
import anjh;
import anuz;
import avnu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
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
    Object localObject1 = HiddenChatFragment.a(this.this$0).getProxyManager().a().a();
    HiddenChatFragment.a(this.this$0).a((List)localObject1);
    Object localObject2 = HiddenChatFragment.a((List)localObject1, avnu.a().c(HiddenChatFragment.a(this.this$0)));
    localObject1 = new ArrayList(((List)localObject2).size());
    akju.a((List)localObject2, HiddenChatFragment.a(this.this$0), this.this$0.getActivity(), (List)localObject1, ((List)localObject2).size());
    if (QLog.isColorLevel()) {
      QLog.i("tag_hidden_chat", 2, "data|size" + ((List)localObject1).size());
    }
    try
    {
      Collections.sort((List)localObject1, HiddenChatFragment.a(this.this$0));
      if (HiddenChatFragment.a(this.this$0) != null)
      {
        localObject2 = HiddenChatFragment.a(this.this$0).obtainMessage(2);
        ((Message)localObject2).obj = localObject1;
        HiddenChatFragment.a(this.this$0).removeMessages(2);
        HiddenChatFragment.a(this.this$0).sendMessage((Message)localObject2);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentDataListManager", 2, "Comparator Exception: ", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment.1
 * JD-Core Version:    0.7.0.1
 */