package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentDataListManagerInjector
{
  public static void a(QQAppInterface paramQQAppInterface, List<RecentUser> paramList)
  {
    TraceUtils.traceBegin("splitRecents");
    ArrayList localArrayList1 = new ArrayList(4);
    ArrayList localArrayList2 = new ArrayList(4);
    ArrayList localArrayList3 = new ArrayList(4);
    localArrayList1.add(paramQQAppInterface.getCurrentAccountUin());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      int i = localRecentUser.getType();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 3000) {
            localArrayList3.add(localRecentUser.uin);
          }
        }
        else {
          localArrayList2.add(localRecentUser.uin);
        }
      }
      else {
        localArrayList1.add(localRecentUser.uin);
      }
    }
    TraceUtils.traceEnd();
    if (localArrayList1.size() > 2) {
      ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(localArrayList1);
    }
    if (localArrayList3.size() > 2) {
      ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(localArrayList3);
    }
    if (localArrayList2.size() > 2) {
      ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(localArrayList2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentDataListManagerInjector
 * JD-Core Version:    0.7.0.1
 */