package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public class CMGameProcessor
  extends AbsCacheProcessor
  implements ISaveRecentUserObserver
{
  @Nullable
  public RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (paramRecentUser.getType() == 1036) {
      return null;
    }
    return paramRecentUser;
  }
  
  @NonNull
  String a()
  {
    return "CMGameProcessor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.CMGameProcessor
 * JD-Core Version:    0.7.0.1
 */