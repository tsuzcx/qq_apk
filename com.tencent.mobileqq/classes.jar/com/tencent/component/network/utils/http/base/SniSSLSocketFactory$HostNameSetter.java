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
    if (paramMethod == null) {
      paramClass = null;
    } else {
      paramClass = new WeakReference(paramMethod);
    }
    this.setter = paramClass;
  }
  
  private static Method init(Class<?> paramClass)
  {
    try
    {
      Method localMethod1 = paramClass.getMethod("setHostname", new Class[] { String.class });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      initFail(localNoSuchMethodException);
    }
    catch (SecurityException localSecurityException)
    {
      initFail(localSecurityException);
    }
    Method localMethod2 = null;
    CURRENT.set(new HostNameSetter(paramClass, localMethod2));
    return localMethod2;
  }
  
  private static void initFail(Exception paramException) {}
  
  private Method reuse(Class<?> paramClass)
  {
    Object localObject = this.cls.get();
    int j = 1;
    int i;
    if (localObject != paramClass) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return init(paramClass);
    }
    if (this.setter == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    localObject = (Method)this.setter.get();
    if (localObject == null) {
      i = j;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject = init(paramClass);
    }
    return localObject;
  }
  
  public static void setServerNameIndication(String paramString, SSLSocket paramSSLSocket)
  {
    Object localObject = paramSSLSocket.getClass();
    HostNameSetter localHostNameSetter = (HostNameSetter)CURRENT.get();
    if (localHostNameSetter == null) {
      localObject = init((Class)localObject);
    } else {
      localObject = localHostNameSetter.reuse((Class)localObject);
    }
    if (localObject != null) {
      try
      {
        ((Method)localObject).invoke(paramSSLSocket, new Object[] { paramString });
        return;
      }
      catch (InvocationTargetException paramString)
      {
        setServerNameIndicationFail(paramString);
        return;
      }
      catch (IllegalAccessException paramString)
      {
        setServerNameIndicationFail(paramString);
        return;
      }
      catch (IllegalArgumentException paramString)
      {
        setServerNameIndicationFail(paramString);
      }
    }
  }
  
  private static void setServerNameIndicationFail(Exception paramException) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.http.base.SniSSLSocketFactory.HostNameSetter
 * JD-Core Version:    0.7.0.1
 */