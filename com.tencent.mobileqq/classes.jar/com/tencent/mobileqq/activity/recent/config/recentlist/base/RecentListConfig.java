package com.tencent.mobileqq.activity.recent.config.recentlist.base;

import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentCheckFilterProcessor;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentConvertFilterProcessor;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentDataConvertProcessor;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentSortTopProcessor;
import com.tencent.mobileqq.activity.recent.config.recentlist.IRecentSortValueProcessor;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentCheckFilterDispatcher;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentConvertFilterDispatcher;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentDataConvertDispatcher;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentSortTopDispatcher;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentSortValueDispatcher;
import com.tencent.mobileqq.imcore.config.extension.RecentCustomizedProcessorRegister;
import java.util.Iterator;
import java.util.List;

public class RecentListConfig
{
  protected static volatile RecentCheckFilterDispatcher a;
  protected static volatile RecentDataConvertDispatcher b;
  protected static volatile RecentSortTopDispatcher c;
  protected static volatile RecentSortValueDispatcher d;
  protected static volatile RecentConvertFilterDispatcher e;
  private static final Object f = new Object();
  private static final Object g = new Object();
  private static final Object h = new Object();
  private static final Object i = new Object();
  private static final Object j = new Object();
  private static final Object k = new Object();
  private static List<Class<? extends IRecentListBaseProcessor>> l;
  
  public static RecentCheckFilterDispatcher a()
  {
    if (a == null) {
      synchronized (g)
      {
        if (a == null)
        {
          a = new RecentCheckFilterDispatcher();
          Iterator localIterator = f().iterator();
          while (localIterator.hasNext())
          {
            Class localClass = (Class)localIterator.next();
            if (IRecentCheckFilterProcessor.class.isAssignableFrom(localClass)) {
              a.a(localClass);
            }
          }
          a.a();
        }
      }
    }
    return a;
  }
  
  public static RecentDataConvertDispatcher b()
  {
    if (b == null) {
      synchronized (h)
      {
        if (b == null)
        {
          b = new RecentDataConvertDispatcher();
          Iterator localIterator = f().iterator();
          while (localIterator.hasNext())
          {
            Class localClass = (Class)localIterator.next();
            if (IRecentDataConvertProcessor.class.isAssignableFrom(localClass)) {
              b.a(localClass);
            }
          }
          b.a();
        }
      }
    }
    return b;
  }
  
  public static RecentSortTopDispatcher c()
  {
    if (c == null) {
      synchronized (i)
      {
        if (c == null)
        {
          c = new RecentSortTopDispatcher();
          Iterator localIterator = f().iterator();
          while (localIterator.hasNext())
          {
            Class localClass = (Class)localIterator.next();
            if (IRecentSortTopProcessor.class.isAssignableFrom(localClass)) {
              c.a(localClass);
            }
          }
          c.a();
        }
      }
    }
    return c;
  }
  
  public static RecentSortValueDispatcher d()
  {
    if (d == null) {
      synchronized (j)
      {
        if (d == null)
        {
          d = new RecentSortValueDispatcher();
          Iterator localIterator = f().iterator();
          while (localIterator.hasNext())
          {
            Class localClass = (Class)localIterator.next();
            if (IRecentSortValueProcessor.class.isAssignableFrom(localClass)) {
              d.a(localClass);
            }
          }
          d.a();
        }
      }
    }
    return d;
  }
  
  public static RecentConvertFilterDispatcher e()
  {
    if (e == null) {
      synchronized (k)
      {
        if (e == null)
        {
          e = new RecentConvertFilterDispatcher();
          Iterator localIterator = f().iterator();
          while (localIterator.hasNext())
          {
            Class localClass = (Class)localIterator.next();
            if (IRecentConvertFilterProcessor.class.isAssignableFrom(localClass)) {
              e.a(localClass);
            }
          }
          e.a();
        }
      }
    }
    return e;
  }
  
  private static List<Class<? extends IRecentListBaseProcessor>> f()
  {
    if (l == null) {
      synchronized (f)
      {
        if (l == null) {
          l = RecentCustomizedProcessorRegister.c;
        }
      }
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.base.RecentListConfig
 * JD-Core Version:    0.7.0.1
 */