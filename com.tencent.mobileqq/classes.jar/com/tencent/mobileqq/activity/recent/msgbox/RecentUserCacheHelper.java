package com.tencent.mobileqq.activity.recent.msgbox;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class RecentUserCacheHelper
{
  private void a(RecentUserProxy paramRecentUserProxy, AppInterface paramAppInterface)
  {
    RecentUser localRecentUser = paramRecentUserProxy.b(AppConstants.TEMP_MSG_BOX_UIN, 10011);
    Object localObject = ((ITempMsgBoxManager)paramAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers();
    if (((List)localObject).isEmpty())
    {
      QLog.e("RecentUserCacheHelper", 1, "update: msgBoxRecentUsers.isEmpty()");
      return;
    }
    paramAppInterface = (RecentUser)((List)localObject).get(0);
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (RecentUser)localIterator.next();
      if (Math.max(((RecentUser)localObject).lastmsgtime, ((RecentUser)localObject).lastmsgdrafttime) > Math.max(paramAppInterface.lastmsgtime, paramAppInterface.lastmsgdrafttime)) {
        paramAppInterface = (AppInterface)localObject;
      }
    }
    localRecentUser.uin = AppConstants.TEMP_MSG_BOX_UIN;
    localRecentUser.setType(10011);
    localRecentUser.lastmsgtime = paramAppInterface.lastmsgtime;
    localRecentUser.lastmsgdrafttime = paramAppInterface.lastmsgdrafttime;
    localRecentUser.opTime = paramAppInterface.opTime;
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("createMsgBox: ");
    paramAppInterface.append(localRecentUser.uin);
    QLog.i("RecentUserCacheHelper", 1, paramAppInterface.toString());
    if ((paramRecentUserProxy instanceof FullCache)) {
      ((FullCache)paramRecentUserProxy).addCache(localRecentUser);
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initMsgBox() called with: app = [");
    localStringBuilder.append(paramAppInterface);
    localStringBuilder.append("]");
    QLog.i("RecentUserCacheHelper", 2, localStringBuilder.toString());
    a(((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache(), paramAppInterface);
  }
  
  public void a(RecentUser paramRecentUser, boolean paramBoolean, AppInterface paramAppInterface)
  {
    ITempMsgBoxManager localITempMsgBoxManager = (ITempMsgBoxManager)paramAppInterface.getRuntimeService(ITempMsgBoxManager.class, "");
    if (localITempMsgBoxManager.isBelongToFilterBox(paramRecentUser.uin, paramRecentUser.getType())) {
      ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).removeFilterBoxIfNecessary(paramAppInterface, paramBoolean);
    }
    if (localITempMsgBoxManager.isBelongToMsgBox(paramRecentUser.uin, paramRecentUser.getType())) {
      ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).removeMsgBoxIfNecessary(paramAppInterface, paramBoolean);
    }
  }
  
  public void a(RecentUser paramRecentUser, boolean paramBoolean, RecentUserProxy paramRecentUserProxy, AppInterface paramAppInterface)
  {
    Object localObject1 = (ITempMsgBoxManager)paramAppInterface.getRuntimeService(ITempMsgBoxManager.class, "");
    Object localObject2;
    if (((ITempMsgBoxManager)localObject1).isBelongToFilterBox(paramRecentUser.uin, paramRecentUser.getType()))
    {
      localObject2 = paramRecentUserProxy.b(AppConstants.FILTER_MSG_UIN, 10012);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onSaveRecentUser: ToFilterBox ");
      ((StringBuilder)localObject3).append(paramRecentUser);
      QLog.i("RecentUserCacheHelper", 1, ((StringBuilder)localObject3).toString());
      localObject3 = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getFilterBoxRecentUsers(paramAppInterface);
      ((RecentUser)localObject2).lastmsgtime = paramRecentUser.lastmsgtime;
      if (!((List)localObject3).isEmpty())
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
          if (localRecentUser.lastmsgtime > ((RecentUser)localObject2).lastmsgtime) {
            ((RecentUser)localObject2).lastmsgtime = localRecentUser.lastmsgtime;
          }
        }
      }
      paramRecentUserProxy.b((RecentUser)localObject2);
    }
    if (((ITempMsgBoxManager)localObject1).isBelongToMsgBox(paramRecentUser.uin, paramRecentUser.getType()))
    {
      localObject1 = paramRecentUserProxy.b(AppConstants.TEMP_MSG_BOX_UIN, 10011);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onSaveRecentUser: ToMsgBox ");
      ((StringBuilder)localObject2).append(paramRecentUser);
      QLog.i("RecentUserCacheHelper", 1, ((StringBuilder)localObject2).toString());
      ((RecentUser)localObject1).lastmsgtime = paramRecentUser.lastmsgtime;
      paramRecentUserProxy.b((RecentUser)localObject1);
    }
    ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).removeFilterBoxIfNecessary(paramAppInterface, true);
    ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).removeMsgBoxIfNecessary(paramAppInterface, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.RecentUserCacheHelper
 * JD-Core Version:    0.7.0.1
 */