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
    Object localObject = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("new_friend_upgrade_pref");
    localStringBuilder.append(paramQQAppInterface.getAccount());
    localObject = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    if (b(paramQQAppInterface, paramList, (SharedPreferences)localObject)) {
      return;
    }
    a(paramQQAppInterface, paramList, (SharedPreferences)localObject);
  }
  
  private void a(QQAppInterface paramQQAppInterface, List<RecentUser> paramList, SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences.getBoolean("check_newfriend_when_upgrade_V2", true))
    {
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "checkNewFriendUpgradeV2 | descRecentList == null");
        }
        return;
      }
      Object localObject2 = null;
      Iterator localIterator = paramList.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (RecentUser)localIterator.next();
      } while ((localObject1 == null) || (!AppConstants.RECOMMEND_CONTACT_UIN.equals(((RecentUser)localObject1).uin)) || (4000 != ((RecentUser)localObject1).type));
      if (localObject1 != null) {
        paramList.remove(localObject1);
      }
      ThreadManager.getSubThreadHandler().post(new NewFriendCacheProcessor.1(this, paramQQAppInterface, paramSharedPreferences));
    }
  }
  
  private boolean b(QQAppInterface paramQQAppInterface, List<RecentUser> paramList, SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences.getBoolean("check_newfriend_when_upgrade", true))
    {
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "checkNewFriendUpgrade | descRecentList == null");
        }
        return true;
      }
      Object localObject2 = null;
      Iterator localIterator = paramList.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (RecentUser)localIterator.next();
      } while ((localObject1 == null) || (!AppConstants.RECOMMEND_CONTACT_UIN.equals(((RecentUser)localObject1).uin)));
      if (localObject1 != null) {
        paramList.remove(localObject1);
      }
      ThreadManager.getSubThreadHandler().post(new NewFriendCacheProcessor.2(this, paramQQAppInterface, paramSharedPreferences));
    }
    return false;
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
  
  public boolean b(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    return (!TextUtils.equals(paramRecentUser.uin, AppConstants.RECOMMEND_CONTACT_UIN)) || (!paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.NewFriendCacheProcessor
 * JD-Core Version:    0.7.0.1
 */