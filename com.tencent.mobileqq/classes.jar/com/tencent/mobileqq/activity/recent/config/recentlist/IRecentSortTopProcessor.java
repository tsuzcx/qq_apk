package com.tencent.mobileqq.activity.recent.config.recentlist;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.base.IRecentListBaseProcessor;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;

public abstract interface IRecentSortTopProcessor
  extends IRecentListBaseProcessor
{
  public abstract boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUserBaseData paramRecentUserBaseData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.IRecentSortTopProcessor
 * JD-Core Version:    0.7.0.1
 */