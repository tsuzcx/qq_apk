package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class PublicAccountProcessor
  extends AbsCacheProcessor
  implements IFilterRecentUserObserver, ISaveRecentUserObserver
{
  @Nullable
  public RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    return paramRecentUser;
  }
  
  @NonNull
  String a()
  {
    return "PublicAccountProcessor";
  }
  
  public boolean a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (BaseApplicationImpl.isInActionS) {
      QLog.d(this.a, 1, "ignore during boot");
    }
    do
    {
      do
      {
        return true;
      } while ((!paramBoolean) || (paramRecentUser.getType() != 1008) || (!(paramBaseQQAppInterface instanceof QQAppInterface)) || (!ServiceAccountFolderManager.b((QQAppInterface)paramBaseQQAppInterface, paramRecentUser.uin)));
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "shouldAddToList: " + paramRecentUser.uin + "|" + paramRecentUser.type);
      }
    } while (!paramBoolean);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.PublicAccountProcessor
 * JD-Core Version:    0.7.0.1
 */