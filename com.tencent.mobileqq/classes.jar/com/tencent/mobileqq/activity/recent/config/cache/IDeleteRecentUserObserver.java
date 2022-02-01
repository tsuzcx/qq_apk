package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public abstract interface IDeleteRecentUserObserver
{
  public abstract void a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.IDeleteRecentUserObserver
 * JD-Core Version:    0.7.0.1
 */