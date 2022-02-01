package com.tencent.kapalaiadapter;

import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ServiceManager
{
  private static Method mAddServiceMethod;
  private static Method mCheckServiceMethod;
  private static Method mGetServiceMethod;
  private static Method mListServiceMethod;
  private static Class<?> mServiceManagerClass;
  
  static
  {
    try
    {
      mServiceManagerClass = Class.forName("android.os.ServiceManager");
      mGetServiceMethod = mServiceManagerClass.getDeclaredMethod("getService", new Class[] { String.class });
      mAddServiceMethod = mServiceManagerClass.getDeclaredMethod("addService", new Class[] { String.class, IBinder.class });
      mCheckServiceMethod = mServiceManagerClass.getDeclaredMethod("checkService", new Class[] { String.class });
      mListServiceMethod = mServiceManagerClass.getDeclaredMethod("listServices", new Class[0]);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
  }
  
  public static void addService(String paramString, IBinder paramIBinder)
  {
    invoke(mAddServiceMethod, new Object[] { paramString, paramIBinder });
  }
  
  public static IBinder checkService(String paramString)
  {
    return (IBinder)invoke(mCheckServiceMethod, new Object[] { paramString });
  }
  
  public static IBinder getService(String paramString)
  {
    return (IBinder)invoke(mGetServiceMethod, new Object[] { paramString });
  }
  
  private static Object invoke(Method paramMethod, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(null, paramVarArgs);
      return paramMethod;
    }
    catch (IllegalArgumentException paramMethod)
    {
      paramMethod.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramMethod)
    {
      paramMethod.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod.printStackTrace();
    }
    return null;
  }
  
  public static String[] listService()
  {
    return (String[])invoke(mListServiceMethod, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.kapalaiadapter.ServiceManager
 * JD-Core Version:    0.7.0.1
 */