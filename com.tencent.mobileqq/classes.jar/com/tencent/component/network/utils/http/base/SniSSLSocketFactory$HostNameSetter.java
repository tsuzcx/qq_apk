package com.tencent.component.network.utils.http.base;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSocket;

public class SniSSLSocketFactory$HostNameSetter
{
  private static final AtomicReference<HostNameSetter> CURRENT = new AtomicReference();
  private final WeakReference<Class<?>> cls;
  private final WeakReference<Method> setter;
  
  private SniSSLSocketFactory$HostNameSetter(Class<?> paramClass, Method paramMethod)
  {
    this.cls = new WeakReference(paramClass);
    if (paramMethod == null) {}
    for (paramClass = null;; paramClass = new WeakReference(paramMethod))
    {
      this.setter = paramClass;
      return;
    }
  }
  
  private static Method init(Class<?> paramClass)
  {
    Object localObject = null;
    try
    {
      Method localMethod = paramClass.getMethod("setHostname", new Class[] { String.class });
      localObject = localMethod;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        initFail(localSecurityException);
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        initFail(localNoSuchMethodException);
      }
    }
    CURRENT.set(new HostNameSetter(paramClass, localObject));
    return localObject;
  }
  
  private static void initFail(Exception paramException) {}
  
  private Method reuse(Class<?> paramClass)
  {
    int j = 1;
    int i;
    Method localMethod;
    if (this.cls.get() != paramClass)
    {
      i = 1;
      if (i == 0) {
        break label33;
      }
      localMethod = init(paramClass);
    }
    for (;;)
    {
      return localMethod;
      i = 0;
      break;
      label33:
      if (this.setter == null) {}
      for (i = 1; i != 0; i = 0) {
        return null;
      }
      localMethod = (Method)this.setter.get();
      if (localMethod == null) {}
      for (i = j; i != 0; i = 0) {
        return init(paramClass);
      }
    }
  }
  
  public static void setServerNameIndication(String paramString, SSLSocket paramSSLSocket)
  {
    Object localObject = paramSSLSocket.getClass();
    HostNameSetter localHostNameSetter = (HostNameSetter)CURRENT.get();
    if (localHostNameSetter == null) {}
    for (localObject = init((Class)localObject);; localObject = localHostNameSetter.reuse((Class)localObject))
    {
      if (localObject != null) {}
      try
      {
        ((Method)localObject).invoke(paramSSLSocket, new Object[] { paramString });
        return;
      }
      catch (IllegalArgumentException paramString)
      {
        setServerNameIndicationFail(paramString);
        return;
      }
      catch (IllegalAccessException paramString)
      {
        setServerNameIndicationFail(paramString);
        return;
      }
      catch (InvocationTargetException paramString)
      {
        setServerNameIndicationFail(paramString);
      }
    }
  }
  
  private static void setServerNameIndicationFail(Exception paramException) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.http.base.SniSSLSocketFactory.HostNameSetter
 * JD-Core Version:    0.7.0.1
 */