package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopProcessor
  extends AbsCacheProcessor
  implements IFilterRecentUserObserver, ISaveRecentUserObserver
{
  public RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    RecentUser localRecentUser;
    if (TextUtils.equals(paramRecentUser.uin, AppConstants.TROOP_SUSPICIOUS_MSG_UIN))
    {
      QLog.e(this.a, 1, "已过滤群通知被过滤 stack: " + QLog.getStackTraceString(new Throwable()));
      localRecentUser = null;
    }
    do
    {
      do
      {
        do
        {
          return localRecentUser;
          localRecentUser = paramRecentUser;
        } while (!(paramBaseQQAppInterface instanceof QQAppInterface));
        paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
        localRecentUser = paramRecentUser;
      } while (paramRecentUser.getType() != 1);
      paramBaseQQAppInterface = ((TroopManager)paramBaseQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramRecentUser.uin);
      localRecentUser = paramRecentUser;
    } while (paramBaseQQAppInterface == null);
    paramRecentUser.showUpTime = paramBaseQQAppInterface.addedTimestamp;
    return paramRecentUser;
  }
  
  @NonNull
  String a()
  {
    return "TroopProcessor";
  }
  
  public boolean a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (TextUtils.equals(paramRecentUser.uin, String.valueOf(9915))) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopProcessor", 1, " Filtered troop notifications(uin is 9915) had be Add in recentCache,type:" + paramRecentUser.type);
      }
    }
    do
    {
      return false;
      if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
        break;
      }
      if (paramRecentUser.getType() != 1) {
        break label83;
      }
    } while (TroopBlockUtils.a((QQAppInterface)paramBaseQQAppInterface, paramRecentUser.uin));
    label83:
    while ((paramRecentUser.getType() != 9000) || (!TroopNotificationUtils.a((QQAppInterface)paramBaseQQAppInterface))) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.TroopProcessor
 * JD-Core Version:    0.7.0.1
 */