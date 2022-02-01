package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.RecentItemHelper;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.asyncdb.cache.BaseRecentUserCache;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TempGameMsgProcessor
  extends AbsCacheProcessor
  implements IFilterRecentUserObserver, ISaveRecentUserObserver
{
  private boolean c(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (paramRecentUser.getType() != 10015) {
      return true;
    }
    boolean bool = false;
    if (!paramBoolean) {
      return false;
    }
    paramBoolean = bool;
    if (((IGameMsgBoxRuntimeService)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).getDataReady())
    {
      paramBoolean = bool;
      if (!((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  public RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    Object localObject = (IGameMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxManager.class, "");
    if ((paramBaseQQAppInterface instanceof QQAppInterface))
    {
      if ((((IGameMsgBoxABTestApi)QRoute.api(IGameMsgBoxABTestApi.class)).isGameMsgAddTab()) && (((IGameMsgBoxManager)localObject).isGameInGameBox(paramBaseQQAppInterface, paramRecentUser.uin)))
      {
        RecentItemHelper.a(paramRecentUser, ((QQAppInterface)paramBaseQQAppInterface).getRecentUserProxy(), paramBaseQQAppInterface);
        return paramRecentUser;
      }
      localObject = (QQAppInterface)paramBaseQQAppInterface;
      paramBaseQQAppInterface = (IGameMsgManagerService)((QQAppInterface)localObject).getRuntimeService(IGameMsgManagerService.class, "");
      if ((paramRecentUser.getType() == 10007) && (((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).isPubAccountReceiveMsg((AppInterface)localObject)) && (paramBaseQQAppInterface.isInited()))
      {
        localObject = ((QQAppInterface)localObject).getRecentUserProxy();
        if (paramBaseQQAppInterface.isGrayOpen())
        {
          paramBaseQQAppInterface = paramBaseQQAppInterface.getSessionInfoList();
          if ((!((RecentUserProxy)localObject).c(BaseRecentUserCache.d("2747277822", 10007))) && (paramBaseQQAppInterface != null) && (!paramBaseQQAppInterface.isEmpty()))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.a, 1, "addCache ##--10007");
            }
            if ((localObject instanceof FullCache)) {
              ((FullCache)localObject).addCache(((RecentUserProxy)localObject).b("2747277822", 1008));
            }
          }
        }
      }
    }
    return paramRecentUser;
  }
  
  @NonNull
  String a()
  {
    return "TroopProcessor";
  }
  
  public boolean b(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    boolean bool = ((IGameMsgBoxABTestApi)QRoute.api(IGameMsgBoxABTestApi.class)).isGameMsgAddTab();
    if (paramRecentUser.getType() == 10007) {
      if (!bool)
      {
        if (paramBoolean) {
          return false;
        }
      }
      else {
        return true;
      }
    }
    return c(paramBaseQQAppInterface, paramRecentUser, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.TempGameMsgProcessor
 * JD-Core Version:    0.7.0.1
 */