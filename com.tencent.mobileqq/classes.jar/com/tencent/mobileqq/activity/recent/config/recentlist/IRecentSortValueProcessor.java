package com.tencent.mobileqq.activity.recent.config.recentlist;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.base.IRecentListBaseProcessor;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;

public abstract interface IRecentSortValueProcessor
  extends IRecentListBaseProcessor
{
  public abstract int a(BaseQQAppInterface paramBaseQQAppInterface, RecentUserBaseData paramRecentUserBaseData, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.IRecentSortValueProcessor
 * JD-Core Version:    0.7.0.1
 */