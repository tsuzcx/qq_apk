package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class Conversation$41
  extends StrangerObserver
{
  Conversation$41(Conversation paramConversation) {}
  
  public void a(List<String> paramList)
  {
    RecentUserProxy localRecentUserProxy;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localRecentUserProxy = this.a.a().getRecentUserProxy();
      if (localRecentUserProxy != null) {
        break label37;
      }
      QLog.d("Q.recent", 1, "onBatchDelete, proxy == null");
    }
    for (;;)
    {
      return;
      label37:
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = localRecentUserProxy.a((String)paramList.next(), 0);
        if (localRecentUser != null) {
          localRecentUserProxy.a(localRecentUser);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.41
 * JD-Core Version:    0.7.0.1
 */