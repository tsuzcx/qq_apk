package com.tencent.mobileqq.activity.recent.config;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public abstract interface IRecentDispatch<T>
{
  public abstract void prepare();
  
  public abstract void processor(IMCoreAppRuntime paramIMCoreAppRuntime, RecentBaseData paramRecentBaseData);
  
  public abstract void register(Class<? extends T> paramClass);
  
  public abstract void registerCoreProcessor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.IRecentDispatch
 * JD-Core Version:    0.7.0.1
 */