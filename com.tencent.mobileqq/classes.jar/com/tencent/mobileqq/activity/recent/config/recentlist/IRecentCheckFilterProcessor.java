package com.tencent.mobileqq.activity.recent.config.recentlist;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.base.IRecentListBaseProcessor;
import com.tencent.mobileqq.data.RecentUser;

public abstract interface IRecentCheckFilterProcessor
  extends IRecentListBaseProcessor
{
  public abstract String a(RecentUser paramRecentUser, int paramInt);
  
  public abstract boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.IRecentCheckFilterProcessor
 * JD-Core Version:    0.7.0.1
 */