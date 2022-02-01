package com.tencent.mobileqq.activity.recent.config;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.config.menu.RecentMenuFlagDispatch;
import com.tencent.mobileqq.activity.recent.config.statusIcon.RecentStatusIconDispatch;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;

public class RecentConfig<T extends IMCoreAppRuntime, R extends RecentBaseData>
{
  private static final Object MENU_FLAGS_DISPATCH_LOCK = new Object();
  private static final Object STATUS_DISPATCH_LOCK = new Object();
  protected RecentMenuFlagDispatch recentMenuFlagDispatch;
  protected RecentStatusIconDispatch recentStatusIconDispatch;
  
  public RecentMenuFlagDispatch getRecentMenuFlagDispatch()
  {
    synchronized (MENU_FLAGS_DISPATCH_LOCK)
    {
      if (this.recentMenuFlagDispatch == null) {
        recentMenuFlagDispatchRegister();
      }
      return this.recentMenuFlagDispatch;
    }
  }
  
  public RecentStatusIconDispatch getRecentStatusIconDispatch()
  {
    synchronized (STATUS_DISPATCH_LOCK)
    {
      if (this.recentStatusIconDispatch == null) {
        recentStatusIconRegister();
      }
      return this.recentStatusIconDispatch;
    }
  }
  
  protected void recentMenuFlagDispatchRegister()
  {
    this.recentMenuFlagDispatch = new RecentMenuFlagDispatch();
    this.recentMenuFlagDispatch.prepare();
  }
  
  protected void recentStatusIconRegister()
  {
    this.recentStatusIconDispatch = new RecentStatusIconDispatch();
    this.recentStatusIconDispatch.prepare();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.RecentConfig
 * JD-Core Version:    0.7.0.1
 */