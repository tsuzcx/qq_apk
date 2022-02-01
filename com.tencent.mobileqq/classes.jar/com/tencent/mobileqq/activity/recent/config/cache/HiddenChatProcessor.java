package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class HiddenChatProcessor
  extends AbsCacheProcessor
  implements IFilterRecentUserObserver, ISaveRecentUserObserver
{
  public RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    int i = 1;
    if (((paramRecentUser.getType() == 1) || (paramRecentUser.getType() == 0)) && ((paramBaseQQAppInterface instanceof QQAppInterface)))
    {
      paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
      paramBoolean = HiddenChatHelper.a(paramRecentUser.uin, paramRecentUser.getType(), paramBaseQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "saveRecentUser user: " + paramRecentUser.uin + " type " + paramRecentUser.getType() + " isHidden " + paramBoolean + " user.isHiddenChat=" + paramRecentUser.isHiddenChat);
      }
      if (!paramBoolean) {
        break label124;
      }
    }
    for (;;)
    {
      paramRecentUser.isHiddenChat = i;
      return paramRecentUser;
      label124:
      i = 0;
    }
  }
  
  @NonNull
  String a()
  {
    return "HiddenChatTroopListProcessor";
  }
  
  public boolean a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    return paramRecentUser.isHiddenChat != 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.HiddenChatProcessor
 * JD-Core Version:    0.7.0.1
 */