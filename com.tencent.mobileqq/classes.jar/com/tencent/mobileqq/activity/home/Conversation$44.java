package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.stranger.observer.StrangerObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class Conversation$44
  extends StrangerObserver
{
  Conversation$44(Conversation paramConversation) {}
  
  public void a(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      RecentUserProxy localRecentUserProxy = this.a.s().getRecentUserProxy();
      if (localRecentUserProxy == null)
      {
        QLog.d("Q.recent", 1, "onBatchDelete, proxy == null");
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = localRecentUserProxy.b((String)paramList.next(), 0);
        if (localRecentUser != null) {
          localRecentUserProxy.a(localRecentUser);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.44
 * JD-Core Version:    0.7.0.1
 */