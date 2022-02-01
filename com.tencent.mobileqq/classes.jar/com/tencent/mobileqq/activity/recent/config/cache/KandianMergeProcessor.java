package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class KandianMergeProcessor
  extends AbsCacheProcessor
  implements IFilterRecentUserObserver, ISaveRecentUserObserver, IUpgradeCacheObserver
{
  private void a(QQAppInterface paramQQAppInterface, List<RecentUser> paramList)
  {
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "checkKandianUpgrade | descRecentList == null");
      }
      return;
    }
    paramQQAppInterface = paramList.iterator();
    while (paramQQAppInterface.hasNext())
    {
      paramList = (RecentUser)paramQQAppInterface.next();
      if ((!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle()) && (paramList.getType() == 7220))
      {
        paramQQAppInterface.remove();
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "remove kandian merge");
        }
      }
      if ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle()) && (((paramList.getType() == 1008) && (TextUtils.equals(paramList.uin, AppConstants.NEW_KANDIAN_UIN))) || (paramList.getType() == 7210)))
      {
        paramQQAppInterface.remove();
        if (QLog.isColorLevel())
        {
          String str = this.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("remove troop_bar_assist or kandian uin:");
          localStringBuilder.append(paramList.uin);
          QLog.d(str, 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    if ((paramRecentUser.getType() == 7220) && ((paramBaseQQAppInterface instanceof QQAppInterface)) && (!((QQAppInterface)paramBaseQQAppInterface).getRecentUserProxy().a(paramRecentUser)))
    {
      int i = ((IKanDianMergeManager)paramBaseQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).getStickyStatus();
      if (i != -1)
      {
        long l;
        if (i == 1) {
          l = System.currentTimeMillis() / 1000L;
        } else {
          l = 0L;
        }
        paramRecentUser.showUpTime = l;
      }
    }
    return paramRecentUser;
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
    if ((!TextUtils.equals(paramRecentUser.uin, AppConstants.NEW_KANDIAN_UIN)) && (!TextUtils.equals(paramRecentUser.uin, AppConstants.TROOP_BAR_ASSISTANT_UIN)))
    {
      if (TextUtils.equals(paramRecentUser.uin, AppConstants.KANDIAN_MERGE_UIN)) {
        return false;
      }
      if (TextUtils.equals(paramRecentUser.uin, AppConstants.KANDIAN_SUBSCRIBE_UIN)) {
        return false;
      }
      if ((TextUtils.equals(paramRecentUser.uin, AppConstants.KANDIAN_SUBSCRIBE_UIN)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.KANDIAN_DAILY_UIN))) {
        ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).canInMessageList(paramRecentUser.uin);
      }
      return true;
    }
    return ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.KandianMergeProcessor
 * JD-Core Version:    0.7.0.1
 */