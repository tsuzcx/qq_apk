package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgHelper;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class DeprecatedLogicProcessor
  extends AbsCacheProcessor
  implements ISaveRecentUserObserver, IUpgradeCacheObserver
{
  private void a(QQAppInterface paramQQAppInterface, List<RecentUser> paramList)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if (localRecentUser != null) {
        if ((localObject3 == null) && (AppConstants.SYSTEM_MSG_UIN.equals(localRecentUser.uin)))
        {
          localObject3 = localRecentUser;
        }
        else if ((localObject1 == null) && ((AppConstants.RECOMMEND_CONTACT_UIN.equals(localRecentUser.uin)) || (4000 == localRecentUser.getType())))
        {
          if ((localRecentUser.msg == null) && (localRecentUser.msgData != null)) {
            localRecentUser.doParse();
          }
          if ((localRecentUser.msg != null) && (!(localRecentUser.msg instanceof String))) {
            localObject1 = localRecentUser;
          }
        }
        else if ((localObject2 == null) && (AppConstants.QZONE_PHOTO_ASSISTANT_UIN.equals(localRecentUser.uin)))
        {
          localObject2 = localRecentUser;
        }
      }
    }
    if (localObject3 != null) {
      paramList.remove(localObject3);
    }
    if (localObject2 != null) {
      paramList.remove(localObject2);
    }
    if (localObject1 != null)
    {
      paramList.remove(localObject1);
      paramQQAppInterface.execute(new DeprecatedLogicProcessor.1(this, paramQQAppInterface, localObject1.getId()));
    }
  }
  
  public RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (((paramBaseQQAppInterface instanceof QQAppInterface)) && (MsgHelper.a((QQAppInterface)paramBaseQQAppInterface, paramRecentUser.uin, paramRecentUser.getType())))
    {
      paramBaseQQAppInterface = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("find save invalid user:");
      localStringBuilder.append(paramRecentUser.uin);
      localStringBuilder.append(" type:");
      localStringBuilder.append(paramRecentUser.getType());
      QLog.d(paramBaseQQAppInterface, 1, localStringBuilder.toString(), new RuntimeException("invalid user"));
      MsgHelper.a(paramRecentUser.uin);
    }
    return paramRecentUser;
  }
  
  @NonNull
  String a()
  {
    return "DeprecatedLogicProcessor";
  }
  
  public void a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull List<RecentUser> paramList)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.DeprecatedLogicProcessor
 * JD-Core Version:    0.7.0.1
 */