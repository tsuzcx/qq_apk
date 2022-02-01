package com.tencent.mobileqq.activity.recent.config;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public abstract interface IRecentBaseDataProcessor
  extends Comparable<IRecentBaseDataProcessor>
{
  public abstract int a();
  
  public abstract boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentBaseData paramRecentBaseData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.IRecentBaseDataProcessor
 * JD-Core Version:    0.7.0.1
 */