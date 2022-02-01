package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopProcessor
  extends AbsCacheProcessor
  implements IFilterRecentUserObserver, ISaveRecentUserObserver
{
  public RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (TextUtils.equals(paramRecentUser.uin, AppConstants.TROOP_SUSPICIOUS_MSG_UIN))
    {
      paramBaseQQAppInterface = this.a;
      paramRecentUser = new StringBuilder();
      paramRecentUser.append("已过滤群通知被过滤 stack: ");
      paramRecentUser.append(QLog.getStackTraceString(new Throwable()));
      QLog.e(paramBaseQQAppInterface, 1, paramRecentUser.toString());
      return null;
    }
    if ((paramBaseQQAppInterface instanceof QQAppInterface))
    {
      paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
      if (paramRecentUser.getType() == 1)
      {
        paramBaseQQAppInterface = ((TroopManager)paramBaseQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).n(paramRecentUser.uin);
        if (paramBaseQQAppInterface != null) {
          paramRecentUser.showUpTime = paramBaseQQAppInterface.addedTimestamp;
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
    if (TextUtils.equals(paramRecentUser.uin, String.valueOf(9915)))
    {
      if (QLog.isColorLevel())
      {
        paramBaseQQAppInterface = new StringBuilder();
        paramBaseQQAppInterface.append(" Filtered troop notifications(uin is 9915) had be Add in recentCache,type:");
        paramBaseQQAppInterface.append(paramRecentUser.type);
        QLog.e("TroopProcessor", 1, paramBaseQQAppInterface.toString());
      }
      return false;
    }
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      if (paramRecentUser.getType() == 1)
      {
        if (TroopBlockUtils.a((QQAppInterface)paramBaseQQAppInterface, paramRecentUser.uin)) {
          return false;
        }
      }
      else if ((paramRecentUser.getType() == 9000) && (TroopNotificationUtils.b((QQAppInterface)paramBaseQQAppInterface))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.TroopProcessor
 * JD-Core Version:    0.7.0.1
 */