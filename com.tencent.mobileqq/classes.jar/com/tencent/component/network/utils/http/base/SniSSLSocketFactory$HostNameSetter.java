package com.tencent.component.network.utils.http.base;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSocket;

public class SniSSLSocketFactory$HostNameSetter
{
  private static final AtomicReference jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference();
  private final WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final WeakReference b;
  
  private SniSSLSocketFactory$HostNameSetter(Class paramClass, Method paramMethod)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramClass);
    if (paramMethod == null) {}
    for (paramClass = null;; paramClass = new WeakReference(paramMethod))
    {
      this.b = paramClass;
      return;
    }
  }
  
  private static Method a(Class paramClass)
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
        a(localSecurityException);
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        a(localNoSuchMethodException);
      }
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(new HostNameSetter(paramClass, localObject));
    return localObject;
  }
  
  private static void a(Exception paramException) {}
  
  public static void a(String paramString, SSLSocket paramSSLSocket)
  {
    Object localObject = paramSSLSocket.getClass();
    HostNameSetter localHostNameSetter = (HostNameSetter)jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
    if (localHostNameSetter == null) {}
    for (localObject = a((Class)localObject);; localObject = localHostNameSetter.b((Class)localObject))
    {
      if (localObject != null) {}
      try
      {
        ((Method)localObject).invoke(paramSSLSocket, new Object[] { paramString });
        return;
      }
      catch (IllegalArgumentException paramString)
      {
        b(paramString);
        return;
      }
      catch (IllegalAccessException paramString)
      {
        b(paramString);
        return;
      }
      catch (InvocationTargetException paramString)
      {
        b(paramString);
      }
    }
  }
  
  private Method b(Class paramClass)
  {
    int j = 1;
    int i;
    Method localMethod;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != paramClass)
    {
      i = 1;
      if (i == 0) {
        break label33;
      }
      localMethod = a(paramClass);
    }
    for (;;)
    {
      return localMethod;
      i = 0;
      break;
      label33:
      if (this.b == null) {}
      for (i = 1; i != 0; i = 0) {
        return null;
      }
      localMethod = (Method)this.b.get();
      if (localMethod == null) {}
      for (i = j; i != 0; i = 0) {
        return a(paramClass);
      }
    }
  }
  
  private static void b(Exception paramException) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.base.SniSSLSocketFactory.HostNameSetter
 * JD-Core Version:    0.7.0.1
 */