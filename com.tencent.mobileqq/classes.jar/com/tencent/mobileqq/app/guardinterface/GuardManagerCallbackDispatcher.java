package com.tencent.mobileqq.app.guardinterface;

import com.tencent.mobileqq.utils.QGuardUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class GuardManagerCallbackDispatcher
{
  static final ArrayList<IGuardInterface> a = new ArrayList();
  
  static
  {
    Iterator localIterator = GuardManagerCallbackRegister.a.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      try
      {
        a.add(localClass.newInstance());
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        QLog.e("GuardManager.GuardManagerCallbackDispatcher", 2, "GuardManagerCallbackDispatcher construct err: ", localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        QLog.e("GuardManager.GuardManagerCallbackDispatcher", 2, "GuardManagerCallbackDispatcher construct err: ", localInstantiationException);
      }
    }
  }
  
  public static void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager.GuardManagerCallbackDispatcher", 2, "dispatcherAppForeground");
      }
      try
      {
        QGuardUtils.a(new String[] { "Application is Foreground" });
        Iterator localIterator = a.iterator();
        while (localIterator.hasNext())
        {
          ((IGuardInterface)localIterator.next()).a();
          continue;
          localObject2 = finally;
        }
      }
      finally {}
    }
    finally {}
  }
  
  public static void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.GuardManagerCallbackDispatcher", 2, new Object[] { "dispatchBackgroundTimeTick: time: ", Long.valueOf(paramLong) });
    }
    try
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        ((IGuardInterface)localIterator.next()).a(paramLong);
      }
    }
    finally {}
  }
  
  public static void a(IGuardInterface paramIGuardInterface)
  {
    try
    {
      a.add(paramIGuardInterface);
      return;
    }
    finally {}
  }
  
  public static void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.GuardManagerCallbackDispatcher", 2, new Object[] { "dispatcherOnScreenChange: ", Boolean.valueOf(paramBoolean) });
    }
    try
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        ((IGuardInterface)localIterator.next()).a(paramBoolean);
      }
    }
    finally {}
  }
  
  public static void b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager.GuardManagerCallbackDispatcher", 2, "dispatchAppBackground");
      }
      try
      {
        QGuardUtils.a(new String[] { "Application is Background" });
        Iterator localIterator = a.iterator();
        while (localIterator.hasNext())
        {
          ((IGuardInterface)localIterator.next()).b();
          continue;
          localObject2 = finally;
        }
      }
      finally {}
    }
    finally {}
  }
  
  public static void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.GuardManagerCallbackDispatcher", 2, new Object[] { "dispatchAutoStartTimeTick: time: ", Long.valueOf(paramLong) });
    }
    try
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        ((IGuardInterface)localIterator.next()).b(paramLong);
      }
    }
    finally {}
  }
  
  public static void b(IGuardInterface paramIGuardInterface)
  {
    try
    {
      a.remove(paramIGuardInterface);
      return;
    }
    finally {}
  }
  
  public static void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager.GuardManagerCallbackDispatcher", 2, new Object[] { "dispatchBackgroundUnguardTimeTick: time: ", Long.valueOf(paramLong) });
    }
    try
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        ((IGuardInterface)localIterator.next()).c(paramLong);
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guardinterface.GuardManagerCallbackDispatcher
 * JD-Core Version:    0.7.0.1
 */