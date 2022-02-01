package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.List;

public class KandianMergeProcessor
  extends AbsCacheProcessor
  implements IFilterRecentUserObserver, ISaveRecentUserObserver, IUpgradeCacheObserver
{
  private void a(QQAppInterface paramQQAppInterface, List<RecentUser> paramList)
  {
    if (paramList == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "checkKandianUpgrade | descRecentList == null");
      }
    }
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if ((!ReadInJoyHelper.a(paramQQAppInterface)) && (localRecentUser.getType() == 7220))
        {
          paramList.remove();
          if (QLog.isColorLevel()) {
            QLog.d(this.a, 2, "remove kandian merge");
          }
        }
        if ((ReadInJoyHelper.a(paramQQAppInterface)) && (((localRecentUser.getType() == 1008) && (TextUtils.equals(localRecentUser.uin, AppConstants.NEW_KANDIAN_UIN))) || (localRecentUser.getType() == 7210)))
        {
          paramList.remove();
          if (QLog.isColorLevel()) {
            QLog.d(this.a, 2, "remove troop_bar_assist or kandian uin:" + localRecentUser.uin);
          }
        }
      }
    }
  }
  
  public RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    if ((paramRecentUser.getType() == 7220) && ((paramBaseQQAppInterface instanceof QQAppInterface)) && (!((QQAppInterface)paramBaseQQAppInterface).getRecentUserProxy().a(paramRecentUser)))
    {
      paramBaseQQAppInterface = (KandianMergeManager)paramBaseQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (paramBaseQQAppInterface.a != -1) {
        if (paramBaseQQAppInterface.a != 1) {
          break label77;
        }
      }
    }
    label77:
    for (long l = System.currentTimeMillis() / 1000L;; l = 0L)
    {
      paramRecentUser.showUpTime = l;
      return paramRecentUser;
    }
  }
  
  @NonNull
  String a()
  {
    return null;
  }
  
  public void a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull List<RecentUser> paramList)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramList);
    }
  }
  
  public boolean a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    if ((TextUtils.equals(paramRecentUser.uin, AppConstants.NEW_KANDIAN_UIN)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.TROOP_BAR_ASSISTANT_UIN)))
    {
      if ((!(paramBaseQQAppInterface instanceof QQAppInterface)) || (!ReadInJoyHelper.a((QQAppInterface)paramBaseQQAppInterface))) {}
    }
    else {
      while ((TextUtils.equals(paramRecentUser.uin, AppConstants.KANDIAN_MERGE_UIN)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.KANDIAN_SUBSCRIBE_UIN)) || (((TextUtils.equals(paramRecentUser.uin, AppConstants.KANDIAN_SUBSCRIBE_UIN)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.KANDIAN_DAILY_UIN))) && (!ReadInJoyHelper.b(paramRecentUser.uin)))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.KandianMergeProcessor
 * JD-Core Version:    0.7.0.1
 */