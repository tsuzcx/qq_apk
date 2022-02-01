package com.huawei.updatesdk.a.a.c.b.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class d
  implements a
{
  private static final Object a = new Object();
  private static d b;
  
  public static d b()
  {
    synchronized (a)
    {
      if (b == null) {
        b = new d();
      }
      d locald = b;
      return locald;
    }
  }
  
  private static Object c()
  {
    try
    {
      Object localObject = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
      localObject = ((Class)localObject).getDeclaredMethod("getDefault", new Class[0]).invoke(localObject, new Object[0]);
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardMTKImpl", " getDefaultTelephonyManagerEx wrong " + localClassNotFoundException.toString());
      return null;
    }
    catch (SecurityException localSecurityException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardMTKImpl", " getDefaultTelephonyManagerEx wrong " + localSecurityException.toString());
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardMTKImpl", " getDefaultTelephonyManagerEx wrong " + localNoSuchMethodException.toString());
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardMTKImpl", " getDefaultTelephonyManagerEx wrong " + localIllegalAccessException.toString());
      return null;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardMTKImpl", " getDefaultTelephonyManagerEx wrong " + localIllegalArgumentException.toString());
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardMTKImpl", " getDefaultTelephonyManagerEx wrong " + localInvocationTargetException.toString());
      return null;
    }
    catch (Exception localException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardMTKImpl", " getDefaultTelephonyManagerEx wrong " + localException.toString());
    }
    return null;
  }
  
  public int a()
  {
    Object localObject = c();
    if (localObject != null) {
      try
      {
        localObject = localObject.getClass().getMethod("getPreferredDataSubscription", new Class[0]).invoke(localObject, new Object[0]);
        if ((localObject instanceof Integer))
        {
          int i = ((Integer)localObject).intValue();
          return i;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardMTKImpl", " getPreferredDataSubscription wrong " + localNoSuchMethodException.toString());
        return -1;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardMTKImpl", " getPreferredDataSubscription wrong " + localInvocationTargetException.toString());
        return -1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardMTKImpl", " getPreferredDataSubscription wrong " + localIllegalAccessException.toString());
        return -1;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.c.b.a.d
 * JD-Core Version:    0.7.0.1
 */