package com.tencent.mobileqq.activity.recent.config.recentlist;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.recentlist.base.IRecentListBaseProcessor;
import com.tencent.mobileqq.data.RecentUser;

public abstract interface IRecentDataConvertProcessor
  extends IRecentListBaseProcessor
{
  public abstract RecentBaseData a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.IRecentDataConvertProcessor
 * JD-Core Version:    0.7.0.1
 */