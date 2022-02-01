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
  
  public boolean b(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (BaseApplicationImpl.isInActionS) {
      return true;
    }
    if ((paramBoolean) && (paramRecentUser.getType() == 1008) && ((paramBaseQQAppInterface instanceof QQAppInterface)) && (ServiceAccountFolderManager.b((QQAppInterface)paramBaseQQAppInterface, paramRecentUser.uin)))
    {
      if (QLog.isColorLevel())
      {
        paramBaseQQAppInterface = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("shouldAddToList: ");
        localStringBuilder.append(paramRecentUser.uin);
        localStringBuilder.append("|");
        localStringBuilder.append(paramRecentUser.type);
        QLog.d(paramBaseQQAppInterface, 2, localStringBuilder.toString());
      }
      return paramBoolean ^ true;
    }
    return (!ServiceAccountFolderManager.n()) || (!paramBoolean) || (paramRecentUser.getType() != 1008) || (!ServiceAccountFolderManager.c(paramRecentUser.uin));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.PublicAccountProcessor
 * JD-Core Version:    0.7.0.1
 */