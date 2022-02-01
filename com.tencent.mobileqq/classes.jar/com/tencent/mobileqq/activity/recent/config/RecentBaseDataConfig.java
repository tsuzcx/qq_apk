package com.tencent.mobileqq.activity.recent.config;

import com.tencent.mobileqq.activity.recent.config.menu.AbsMenuFlag;
import com.tencent.mobileqq.activity.recent.config.menu.RecentMenuFlagDispatch;
import com.tencent.mobileqq.activity.recent.config.statusIcon.AbsRecentStatus;
import com.tencent.mobileqq.activity.recent.config.statusIcon.RecentStatusIconDispatch;
import com.tencent.mobileqq.imcore.config.extension.RecentCustomizedProcessorRegister;
import java.util.ArrayList;
import java.util.Iterator;

public class RecentBaseDataConfig
{
  protected static RecentStatusIconDispatch a;
  protected static RecentMenuFlagDispatch b;
  private static final Object c = new Object();
  private static final Object d = new Object();
  
  public static RecentStatusIconDispatch a()
  {
    synchronized (c)
    {
      if (a == null)
      {
        a = new RecentStatusIconDispatch();
        Iterator localIterator = RecentCustomizedProcessorRegister.b.iterator();
        while (localIterator.hasNext())
        {
          Class localClass = (Class)localIterator.next();
          if ((localClass != null) && (AbsRecentStatus.class.isAssignableFrom(localClass))) {
            a.a(localClass);
          }
        }
        a.b();
      }
      return a;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static RecentMenuFlagDispatch b()
  {
    synchronized (d)
    {
      if (b == null)
      {
        b = new RecentMenuFlagDispatch();
        Iterator localIterator = RecentCustomizedProcessorRegister.b.iterator();
        while (localIterator.hasNext())
        {
          Class localClass = (Class)localIterator.next();
          if ((localClass != null) && (AbsMenuFlag.class.isAssignableFrom(localClass))) {
            b.a(localClass);
          }
        }
        b.b();
      }
      return b;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.RecentBaseDataConfig
 * JD-Core Version:    0.7.0.1
 */