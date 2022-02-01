package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.asyncdb.cache.BaseRecentUserCache;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TempGameMsgProcessor
  extends AbsCacheProcessor
  implements IFilterRecentUserObserver, ISaveRecentUserObserver
{
  public RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface))
    {
      Object localObject = (QQAppInterface)paramBaseQQAppInterface;
      paramBaseQQAppInterface = (IGameMsgManagerService)((QQAppInterface)localObject).getRuntimeService(IGameMsgManagerService.class, "");
      if ((paramRecentUser.getType() == 10007) && (((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).isPubAccountReceiveMsg((AppInterface)localObject)) && (paramBaseQQAppInterface.isInited()))
      {
        localObject = ((QQAppInterface)localObject).getRecentUserProxy();
        if (paramBaseQQAppInterface.isGrayOpen())
        {
          paramBaseQQAppInterface = paramBaseQQAppInterface.getSessionInfoList();
          if ((!((RecentUserProxy)localObject).b(BaseRecentUserCache.a("2747277822", 10007))) && (paramBaseQQAppInterface != null) && (!paramBaseQQAppInterface.isEmpty()))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.a, 1, "addCache ##--10007");
            }
            if ((localObject instanceof FullCache)) {
              ((FullCache)localObject).addCache(((RecentUserProxy)localObject).a("2747277822", 1008));
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
  
  public boolean a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    return (paramRecentUser.getType() != 10007) || (!paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.TempGameMsgProcessor
 * JD-Core Version:    0.7.0.1
 */