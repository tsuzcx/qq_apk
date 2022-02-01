package com.tencent.mobileqq.activity.recent.config.cache;

import android.support.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.config.extension.RecentCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public final class RecentUserCacheConfig
{
  private static AtomicBoolean a = new AtomicBoolean(false);
  private static final Object b = new Object();
  private static ArrayList<IUpgradeCacheObserver> c = new ArrayList();
  private static ArrayList<IFilterRecentUserObserver> d = new ArrayList();
  private static ArrayList<IDeleteRecentUserObserver> e = new ArrayList();
  private static ArrayList<ISaveRecentUserObserver> f = new ArrayList();
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentUserCacheConfig", 2, new Object[] { "call init from ", MobileQQ.processName, " init = ", Boolean.valueOf(a.get()) });
    }
    synchronized (b)
    {
      if (a.get()) {
        return;
      }
      b();
      a.set(true);
      return;
    }
  }
  
  public static void a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull List<RecentUser> paramList)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((IUpgradeCacheObserver)localIterator.next()).a(paramBaseQQAppInterface, paramList);
    }
  }
  
  public static boolean a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext()) {
      if (!((IFilterRecentUserObserver)localIterator.next()).b(paramBaseQQAppInterface, paramRecentUser, paramBoolean)) {
        return false;
      }
    }
    return true;
  }
  
  private static void b()
  {
    if (RecentCustomizedProcessorRegister.a != null)
    {
      Iterator localIterator = RecentCustomizedProcessorRegister.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsCacheProcessor)((Class)localObject).newInstance();
          if ((localObject instanceof IUpgradeCacheObserver)) {
            c.add((IUpgradeCacheObserver)localObject);
          }
          if ((localObject instanceof IFilterRecentUserObserver)) {
            d.add((IFilterRecentUserObserver)localObject);
          }
          if ((localObject instanceof IDeleteRecentUserObserver)) {
            e.add((IDeleteRecentUserObserver)localObject);
          }
          if ((localObject instanceof ISaveRecentUserObserver)) {
            f.add((ISaveRecentUserObserver)localObject);
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("RecentUserCacheConfig", 1, "Init Fail,", localThrowable);
        }
      }
    }
  }
  
  public static void b(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    Iterator localIterator = e.iterator();
    while (localIterator.hasNext()) {
      ((IDeleteRecentUserObserver)localIterator.next()).c(paramBaseQQAppInterface, paramRecentUser, paramBoolean);
    }
  }
  
  public static RecentUser c(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    Iterator localIterator = f.iterator();
    ISaveRecentUserObserver localISaveRecentUserObserver;
    RecentUser localRecentUser;
    do
    {
      localObject = paramRecentUser;
      if (!localIterator.hasNext()) {
        break;
      }
      localISaveRecentUserObserver = (ISaveRecentUserObserver)localIterator.next();
      localRecentUser = localISaveRecentUserObserver.a(paramBaseQQAppInterface, paramRecentUser, paramBoolean);
      paramRecentUser = localRecentUser;
    } while (localRecentUser != null);
    Object localObject = localRecentUser;
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("observer.");
      paramBaseQQAppInterface.append(localISaveRecentUserObserver.getClass().getName());
      paramBaseQQAppInterface.append(" ");
      QLog.d("RecentUserCacheConfig", 2, paramBaseQQAppInterface.toString());
      localObject = localRecentUser;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.RecentUserCacheConfig
 * JD-Core Version:    0.7.0.1
 */