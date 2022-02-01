package com.tencent.mobileqq.activity.recent.msgbox;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class RecentUserCacheHelper
{
  private void a(List<RecentUser> paramList, RecentUserProxy paramRecentUserProxy, QQAppInterface paramQQAppInterface)
  {
    RecentUser localRecentUser = paramRecentUserProxy.a(AppConstants.TEMP_MSG_BOX_UIN, 10011);
    paramQQAppInterface = ((TempMsgBoxManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(paramQQAppInterface);
    if (paramQQAppInterface.isEmpty())
    {
      QLog.e("RecentUserCacheHelper", 1, "update: msgBoxRecentUsers.isEmpty()");
      return;
    }
    paramList = (RecentUser)paramQQAppInterface.get(0);
    Iterator localIterator = paramQQAppInterface.iterator();
    label66:
    if (localIterator.hasNext())
    {
      paramQQAppInterface = (RecentUser)localIterator.next();
      if (Math.max(paramQQAppInterface.lastmsgtime, paramQQAppInterface.lastmsgdrafttime) <= Math.max(paramList.lastmsgtime, paramList.lastmsgdrafttime)) {
        break label207;
      }
      paramList = paramQQAppInterface;
    }
    label207:
    for (;;)
    {
      break label66;
      localRecentUser.uin = AppConstants.TEMP_MSG_BOX_UIN;
      localRecentUser.setType(10011);
      localRecentUser.lastmsgtime = paramList.lastmsgtime;
      localRecentUser.lastmsgdrafttime = paramList.lastmsgdrafttime;
      localRecentUser.opTime = paramList.opTime;
      QLog.i("RecentUserCacheHelper", 1, "createMsgBox: " + localRecentUser.uin);
      if (!(paramRecentUserProxy instanceof FullCache)) {
        break;
      }
      ((FullCache)paramRecentUserProxy).addCache(localRecentUser);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    QLog.i("RecentUserCacheHelper", 2, "initMsgBox() called with: app = [" + paramQQAppInterface + "]");
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getRecentUserProxy();
    a(localRecentUserProxy.a(true, false), localRecentUserProxy, paramQQAppInterface);
  }
  
  public void a(RecentUser paramRecentUser, boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    TempMsgBoxManager localTempMsgBoxManager = (TempMsgBoxManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX);
    if (localTempMsgBoxManager.a(paramRecentUser.uin, paramRecentUser.getType())) {
      FilterMsgBoxRecentUserUtil.a(paramQQAppInterface, paramBoolean);
    }
    if (localTempMsgBoxManager.b(paramRecentUser.uin, paramRecentUser.getType())) {
      TempMsgBoxManager.a(paramQQAppInterface, paramBoolean);
    }
  }
  
  public void a(RecentUser paramRecentUser, boolean paramBoolean, RecentUserProxy paramRecentUserProxy, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = (TempMsgBoxManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX);
    if (((TempMsgBoxManager)localObject1).a(paramRecentUser.uin, paramRecentUser.getType()))
    {
      RecentUser localRecentUser1 = paramRecentUserProxy.a(AppConstants.FILTER_MSG_UIN, 10012);
      QLog.i("RecentUserCacheHelper", 1, "onSaveRecentUser: ToFilterBox " + paramRecentUser);
      Object localObject2 = FilterMsgBoxRecentUserUtil.a(paramQQAppInterface);
      localRecentUser1.lastmsgtime = paramRecentUser.lastmsgtime;
      if (!((List)localObject2).isEmpty())
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentUser localRecentUser2 = (RecentUser)((Iterator)localObject2).next();
          if (localRecentUser2.lastmsgtime > localRecentUser1.lastmsgtime) {
            localRecentUser1.lastmsgtime = localRecentUser2.lastmsgtime;
          }
        }
      }
      paramRecentUserProxy.b(localRecentUser1);
    }
    if (((TempMsgBoxManager)localObject1).b(paramRecentUser.uin, paramRecentUser.getType()))
    {
      localObject1 = paramRecentUserProxy.a(AppConstants.TEMP_MSG_BOX_UIN, 10011);
      QLog.i("RecentUserCacheHelper", 1, "onSaveRecentUser: ToMsgBox " + paramRecentUser);
      ((RecentUser)localObject1).lastmsgtime = paramRecentUser.lastmsgtime;
      paramRecentUserProxy.b((RecentUser)localObject1);
    }
    FilterMsgBoxRecentUserUtil.a(paramQQAppInterface, true);
    TempMsgBoxManager.a(paramQQAppInterface, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.RecentUserCacheHelper
 * JD-Core Version:    0.7.0.1
 */