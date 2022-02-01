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
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static ArrayList<IUpgradeCacheObserver> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static ArrayList<IFilterRecentUserObserver> b = new ArrayList();
  private static ArrayList<IDeleteRecentUserObserver> c = new ArrayList();
  private static ArrayList<ISaveRecentUserObserver> d = new ArrayList();
  
  public static RecentUser a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    Iterator localIterator = d.iterator();
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
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentUserCacheConfig", 2, new Object[] { "call init from ", MobileQQ.processName, " init = ", Boolean.valueOf(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) });
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        return;
      }
      b();
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
  }
  
  public static void a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      ((IDeleteRecentUserObserver)localIterator.next()).a(paramBaseQQAppInterface, paramRecentUser, paramBoolean);
    }
  }
  
  public static void a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull List<RecentUser> paramList)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IUpgradeCacheObserver)localIterator.next()).a(paramBaseQQAppInterface, paramList);
    }
  }
  
  public static boolean a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, @NonNull RecentUser paramRecentUser, boolean paramBoolean)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      if (!((IFilterRecentUserObserver)localIterator.next()).a(paramBaseQQAppInterface, paramRecentUser, paramBoolean)) {
        return false;
      }
    }
    return true;
  }
  
  private static void b()
  {
    if (RecentCustomizedProcessorRegister.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = RecentCustomizedProcessorRegister.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsCacheProcessor)((Class)localObject).newInstance();
          if ((localObject instanceof IUpgradeCacheObserver)) {
            jdField_a_of_type_JavaUtilArrayList.add((IUpgradeCacheObserver)localObject);
          }
          if ((localObject instanceof IFilterRecentUserObserver)) {
            b.add((IFilterRecentUserObserver)localObject);
          }
          if ((localObject instanceof IDeleteRecentUserObserver)) {
            c.add((IDeleteRecentUserObserver)localObject);
          }
          if ((localObject instanceof ISaveRecentUserObserver)) {
            d.add((ISaveRecentUserObserver)localObject);
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("RecentUserCacheConfig", 1, "Init Fail,", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.RecentUserCacheConfig
 * JD-Core Version:    0.7.0.1
 */