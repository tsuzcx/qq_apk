package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public abstract interface ISaveRecentUserObserver
{
  @Nullable
  public abstract RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.ISaveRecentUserObserver
 * JD-Core Version:    0.7.0.1
 */