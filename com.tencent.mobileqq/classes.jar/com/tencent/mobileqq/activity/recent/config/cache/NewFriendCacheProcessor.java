package com.tencent.mobileqq.activity.recent.config.cache;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class NewFriendCacheProcessor
  extends AbsCacheProcessor
  implements IFilterRecentUserObserver, IUpgradeCacheObserver
{
  private void a(QQAppInterface paramQQAppInterface, List<RecentUser> paramList)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("new_friend_upgrade_pref" + paramQQAppInterface.getAccount(), 0);
    if (a(paramQQAppInterface, paramList, localSharedPreferences)) {
      return;
    }
    a(paramQQAppInterface, paramList, localSharedPreferences);
  }
  
  private void a(QQAppInterface paramQQAppInterface, List<RecentUser> paramList, SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences.getBoolean("check_newfriend_when_upgrade_V2", true))
    {
      if (paramList != null) {
        break label33;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "checkNewFriendUpgradeV2 | descRecentList == null");
      }
    }
    return;
    label33:
    Iterator localIterator = paramList.iterator();
    RecentUser localRecentUser;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localRecentUser = (RecentUser)localIterator.next();
    } while ((localRecentUser == null) || (!AppConstants.RECOMMEND_CONTACT_UIN.equals(localRecentUser.uin)) || (4000 != localRecentUser.type));
    for (;;)
    {
      if (localRecentUser != null) {
        paramList.remove(localRecentUser);
      }
      ThreadManager.getSubThreadHandler().post(new NewFriendCacheProcessor.1(this, paramQQAppInterface, paramSharedPreferences));
      return;
      localRecentUser = null;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, List<RecentUser> paramList, SharedPreferences paramSharedPreferences)
  {
    RecentUser localRecentUser;
    if (paramSharedPreferences.getBoolean("check_newfriend_when_upgrade", true))
    {
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "checkNewFriendUpgrade | descRecentList == null");
        }
        return true;
      }
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localRecentUser = (RecentUser)localIterator.next();
      } while ((localRecentUser == null) || (!AppConstants.RECOMMEND_CONTACT_UIN.equals(localRecentUser.uin)));
    }
    for (;;)
    {
      if (localRecentUser != null) {
        paramList.remove(localRecentUser);
      }
      ThreadManager.getSubThreadHandler().post(new NewFriendCacheProcessor.2(this, paramQQAppInterface, paramSharedPreferences));
      return false;
      localRecentUser = null;
    }
  }
  
  @NotNull
  String a()
  {
    return "NewFriendCacheProcessor";
  }
  
  public void a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull List<RecentUser> paramList)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramList);
    }
  }
  
  public boolean a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    return (!TextUtils.equals(paramRecentUser.uin, AppConstants.RECOMMEND_CONTACT_UIN)) || (!paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.NewFriendCacheProcessor
 * JD-Core Version:    0.7.0.1
 */