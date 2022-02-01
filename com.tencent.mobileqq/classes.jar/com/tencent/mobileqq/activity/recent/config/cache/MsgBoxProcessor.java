package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.msgbox.RecentUserCacheHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public class MsgBoxProcessor
  extends AbsCacheProcessor
  implements IDeleteRecentUserObserver, IFilterRecentUserObserver, ISaveRecentUserObserver
{
  public RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      new RecentUserCacheHelper().a(paramRecentUser, paramBoolean, ((QQAppInterface)paramBaseQQAppInterface).getRecentUserProxy(), (QQAppInterface)paramBaseQQAppInterface);
    }
    return paramRecentUser;
  }
  
  @NonNull
  String a()
  {
    return "MsgBoxProcessor";
  }
  
  public void a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      new RecentUserCacheHelper().a(paramRecentUser, paramBoolean, (QQAppInterface)paramBaseQQAppInterface);
    }
  }
  
  public boolean a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    return ((!TextUtils.equals(paramRecentUser.uin, AppConstants.FILTER_MSG_UIN)) && (!TextUtils.equals(paramRecentUser.uin, AppConstants.TEMP_MSG_BOX_UIN))) || (!paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.MsgBoxProcessor
 * JD-Core Version:    0.7.0.1
 */