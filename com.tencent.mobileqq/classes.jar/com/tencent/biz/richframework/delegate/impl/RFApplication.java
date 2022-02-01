package com.tencent.biz.richframework.delegate.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.biz.richframework.delegate.IApplicationDelegate;
import java.util.concurrent.ConcurrentHashMap;

public class RFApplication
{
  private static ConcurrentHashMap<Class, Class> mClassImplMap = new ConcurrentHashMap();
  private static volatile IApplicationDelegate sApplicationDelegate;
  private static Class<? extends IApplicationDelegate> sApplicationDelegateClass;
  
  public static Context getApplication()
  {
    if (getInstance() != null) {
      return getInstance().getApplication();
    }
    return null;
  }
  
  public static Class getDelegateImpl(Class paramClass)
  {
    ConcurrentHashMap localConcurrentHashMap = mClassImplMap;
    if (localConcurrentHashMap != null) {
      return (Class)localConcurrentHashMap.get(paramClass);
    }
    return null;
  }
  
  public static IApplicationDelegate getInstance()
  {
    if (sApplicationDelegate == null) {
      try
      {
        if (sApplicationDelegateClass != null) {
          sApplicationDelegate = (IApplicationDelegate)sApplicationDelegateClass.newInstance();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return sApplicationDelegate;
  }
  
  public static boolean isDebug()
  {
    ApplicationInfo localApplicationInfo = null;
    boolean bool = false;
    try
    {
      if (getApplication() != null) {
        localApplicationInfo = getApplication().getApplicationInfo();
      }
      int i = localApplicationInfo.flags;
      if ((i & 0x2) != 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static void setApplicationDelegate(Class<? extends IApplicationDelegate> paramClass)
  {
    sApplicationDelegateClass = paramClass;
    if (getInstance() != null) {
      mClassImplMap = getInstance().getClassImplMap();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.delegate.impl.RFApplication
 * JD-Core Version:    0.7.0.1
 */