package com.tencent.mobileqq.activity.contacts.troop;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class ContactsTroopAdapter$LoadTroopDiscussInfoSubRunnable
  implements Runnable
{
  TroopManager a;
  RecentUserProxy b;
  
  private ContactsTroopAdapter$LoadTroopDiscussInfoSubRunnable(ContactsTroopAdapter paramContactsTroopAdapter) {}
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.this$0.a.getManager(QQManagerFactory.TROOP_MANAGER);
    RecentUserProxy localRecentUserProxy = this.this$0.a.getProxyManager().g();
    ArrayList localArrayList1 = localTroopManager.h();
    Object localObject1 = ((DiscussionManager)this.this$0.a.getManager(QQManagerFactory.DISCUSSION_MANAGER)).b();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = ((List)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject2).next();
      if ((localDiscussionInfo != null) && (!TextUtils.isEmpty(localDiscussionInfo.uin)))
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("load data asyncLoadTroopListAndNotifyUi discussion : ");
          localStringBuilder.append(localDiscussionInfo);
          QLog.d("ContactsTroopAdapter", 2, localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty(localDiscussionInfo.discussionName))
        {
          localArrayList2.add(localDiscussionInfo);
        }
        else if (i >= 40)
        {
          localArrayList2.add(localDiscussionInfo);
        }
        else if (this.this$0.m.c(localDiscussionInfo.uin) > 0)
        {
          localArrayList2.add(localDiscussionInfo);
          i += 1;
        }
        else
        {
          i += 1;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("load data asyncLoadTroopListAndNotifyUi discussion skiped : ");
          localStringBuilder.append(localDiscussionInfo);
          QLog.d("ContactsTroopAdapter", 1, localStringBuilder.toString());
        }
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("load data asyncLoadTroopListAndNotifyUi count: ");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("  org_discussions.size:");
    ((StringBuilder)localObject2).append(((List)localObject1).size());
    ((StringBuilder)localObject2).append("  discussions.size:");
    ((StringBuilder)localObject2).append(localArrayList2.size());
    QLog.d("ContactsTroopAdapter", 1, ((StringBuilder)localObject2).toString());
    localObject1 = new ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable(this.this$0);
    ((ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable)localObject1).a = localTroopManager;
    ((ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable)localObject1).b = localRecentUserProxy;
    ((ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable)localObject1).c = localArrayList1;
    ((ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable)localObject1).d = localArrayList2;
    ThreadManager.getUIHandler().post((Runnable)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter.LoadTroopDiscussInfoSubRunnable
 * JD-Core Version:    0.7.0.1
 */