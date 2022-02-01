package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import java.util.List;

public abstract interface IUpgradeCacheObserver
{
  public abstract void a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull List<RecentUser> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.IUpgradeCacheObserver
 * JD-Core Version:    0.7.0.1
 */