package com.tencent.mobileqq.activity.recent.config;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public abstract interface IRecentProcessor
  extends Comparable<IRecentProcessor>
{
  public abstract boolean handleBusiness(IMCoreAppRuntime paramIMCoreAppRuntime, RecentBaseData paramRecentBaseData);
  
  public abstract int priority();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.IRecentProcessor
 * JD-Core Version:    0.7.0.1
 */