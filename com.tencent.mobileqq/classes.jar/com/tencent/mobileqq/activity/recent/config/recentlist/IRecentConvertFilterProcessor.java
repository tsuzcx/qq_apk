package com.tencent.mobileqq.activity.recent.config.recentlist;

import com.tencent.mobileqq.activity.recent.config.recentlist.base.IRecentListBaseProcessor;
import com.tencent.mobileqq.data.RecentUser;

public abstract interface IRecentConvertFilterProcessor
  extends IRecentListBaseProcessor
{
  public abstract boolean a(RecentUser paramRecentUser, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.IRecentConvertFilterProcessor
 * JD-Core Version:    0.7.0.1
 */