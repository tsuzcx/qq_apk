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
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (RecentUser)localIterator.next();
      if (localObject2 == null) {
        break label229;
      }
      if ((localObject3 == null) && (AppConstants.SYSTEM_MSG_UIN.equals(((RecentUser)localObject2).uin)))
      {
        localObject3 = localObject2;
      }
      else if ((localObject4 == null) && ((AppConstants.RECOMMEND_CONTACT_UIN.equals(((RecentUser)localObject2).uin)) || (4000 == ((RecentUser)localObject2).getType())))
      {
        if ((((RecentUser)localObject2).msg == null) && (((RecentUser)localObject2).msgData != null)) {
          ((RecentUser)localObject2).doParse();
        }
        if ((((RecentUser)localObject2).msg != null) && (!(((RecentUser)localObject2).msg instanceof String))) {
          localObject4 = localObject2;
        }
      }
      else
      {
        if ((localObject1 != null) || (!AppConstants.QZONE_PHOTO_ASSISTANT_UIN.equals(((RecentUser)localObject2).uin))) {
          break label229;
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      break;
      if (localObject3 != null) {
        paramList.remove(localObject3);
      }
      if (localObject1 != null) {
        paramList.remove(localObject1);
      }
      if (localObject4 != null)
      {
        paramList.remove(localObject4);
        paramQQAppInterface.execute(new DeprecatedLogicProcessor.1(this, paramQQAppInterface, localObject4.getId()));
      }
      return;
      label229:
      localObject2 = localObject1;
    }
  }
  
  public RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (((paramBaseQQAppInterface instanceof QQAppInterface)) && (MsgHelper.a((QQAppInterface)paramBaseQQAppInterface, paramRecentUser.uin, paramRecentUser.getType())))
    {
      QLog.d(this.a, 1, "find save invalid user:" + paramRecentUser.uin + " type:" + paramRecentUser.getType(), new RuntimeException("invalid user"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.DeprecatedLogicProcessor
 * JD-Core Version:    0.7.0.1
 */