package com.huawei.updatesdk.a.a.c.b.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class c
  implements a
{
  private static final Object a = new Object();
  private static c b;
  
  public static c b()
  {
    synchronized (a)
    {
      if (b == null) {
        b = new c();
      }
      c localc = b;
      return localc;
    }
  }
  
  public static Object c()
  {
    try
    {
      Object localObject = Class.forName("android.telephony.MSimTelephonyManager");
      localObject = ((Class)localObject).getDeclaredMethod("getDefault", new Class[0]).invoke(localObject, new Object[0]);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("MutiCardHwImpl", " getDefaultMSimTelephonyManager wrong " + localNoSuchMethodException.toString());
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("MutiCardHwImpl", " getDefaultMSimTelephonyManager wrong " + localIllegalAccessException.toString());
      return null;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("MutiCardHwImpl", " getDefaultMSimTelephonyManager wrong " + localIllegalArgumentException.toString());
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("MutiCardHwImpl", " getDefaultMSimTelephonyManager wrong " + localInvocationTargetException.toString());
      return null;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("MutiCardHwImpl", " getDefaultMSimTelephonyManager wrong " + localClassNotFoundException.toString());
      return null;
    }
    catch (Exception localException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("MutiCardHwImpl", " getDefaultMSimTelephonyManager wrong " + localException.toString());
    }
    return null;
  }
  
  public int a()
  {
    try
    {
      Object localObject = c();
      if (localObject != null)
      {
        localObject = localObject.getClass().getMethod("getPreferredDataSubscription", new Class[0]).invoke(localObject, new Object[0]);
        if ((localObject instanceof Integer))
        {
          int i = ((Integer)localObject).intValue();
          return i;
        }
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("MutiCardHwImpl", " getPreferredDataSubscription wrong " + localNoSuchMethodException.toString());
      return -1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("MutiCardHwImpl", " getPreferredDataSubscription wrong " + localIllegalAccessException.toString());
      return -1;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("MutiCardHwImpl", " getPreferredDataSubscription wrong " + localInvocationTargetException.toString());
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.c.b.a.c
 * JD-Core Version:    0.7.0.1
 */