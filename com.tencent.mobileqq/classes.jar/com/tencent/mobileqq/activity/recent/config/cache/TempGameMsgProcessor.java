package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.asyncdb.cache.BaseRecentUserCache;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
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
      if ((paramRecentUser.getType() == 10007) && (GameMsgUtil.a((QQAppInterface)localObject)) && (GameMsgManager.a()))
      {
        paramBaseQQAppInterface = ((QQAppInterface)localObject).getRecentUserProxy();
        localObject = (GameMsgManager)((QQAppInterface)localObject).getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
        if (((GameMsgManager)localObject).d())
        {
          localObject = ((GameMsgManager)localObject).a();
          if ((!paramBaseQQAppInterface.b(BaseRecentUserCache.a("2747277822", 10007))) && (localObject != null) && (!((List)localObject).isEmpty()))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.a, 1, "addCache ##--10007");
            }
            if ((paramBaseQQAppInterface instanceof FullCache)) {
              ((FullCache)paramBaseQQAppInterface).addCache(paramBaseQQAppInterface.a("2747277822", 1008));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.TempGameMsgProcessor
 * JD-Core Version:    0.7.0.1
 */