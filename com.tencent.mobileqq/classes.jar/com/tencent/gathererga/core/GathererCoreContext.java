package com.tencent.gathererga.core;

import android.content.Context;
import com.tencent.gathererga.core.internal.BaseContext;
import com.tencent.gathererga.core.internal.GathererConfigInternal;
import com.tencent.gathererga.core.internal.IBase;
import com.tencent.gathererga.core.internal.component.GathererCompContext;
import com.tencent.gathererga.core.internal.provider.InfoID;
import com.tencent.gathererga.core.internal.provider.ProviderDynamicProxy;
import com.tencent.gathererga.core.internal.provider.impl.AndroidInfoProviderImpl;
import com.tencent.gathererga.core.internal.provider.impl.AppInfoProviderImpl;
import com.tencent.gathererga.core.internal.provider.impl.HardwareInfoProviderImpl;
import com.tencent.gathererga.core.internal.provider.impl.UserInfoImpl;
import com.tencent.gathererga.core.internal.util.GLog;
import com.tencent.gathererga.core.internal.util.GathererExecutor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GathererCoreContext
  extends BaseContext
{
  private static final GathererCoreContext a = new GathererCoreContext();
  private static WeakReference<Context> b;
  private static final Map<Integer, GathererCoreContext.IDCache> c = new ConcurrentHashMap();
  
  static
  {
    a(UserInfoProvider.class, UserInfoImpl.class);
    a(HardwareInfoProvider.class, HardwareInfoProviderImpl.class);
    a(AndroidInfoProvider.class, AndroidInfoProviderImpl.class);
    a(AppInfoProvider.class, AppInfoProviderImpl.class);
  }
  
  public static Context a()
  {
    WeakReference localWeakReference = b;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return (Context)b.get();
    }
    return null;
  }
  
  @Deprecated
  public static Object a(int paramInt, Object... paramVarArgs)
  {
    GathererCoreContext.IDCache localIDCache = (GathererCoreContext.IDCache)c.get(Integer.valueOf(paramInt));
    Object localObject;
    Method localMethod1;
    if (localIDCache != null)
    {
      localObject = a(localIDCache.a);
      if (localObject == null) {
        return null;
      }
      Method localMethod2 = localIDCache.c;
      localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod1 = localMethod2;
        try
        {
          localMethod2 = localObject.getClass().getMethod(localIDCache.b.getName(), localIDCache.b.getParameterTypes());
          localMethod1 = localMethod2;
          localIDCache.c = localMethod2;
          localMethod1 = localMethod2;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          localNoSuchMethodException.printStackTrace();
        }
      }
      if (localMethod1 == null) {
        return null;
      }
    }
    try
    {
      paramVarArgs = localMethod1.invoke(localObject, paramVarArgs);
      return paramVarArgs;
    }
    catch (Throwable paramVarArgs) {}
    throw new IllegalStateException("not impl id...");
    return null;
  }
  
  public static <T> T a(Class<T> paramClass)
  {
    return a.b(paramClass);
  }
  
  public static void a(GathererConfigInternal paramGathererConfigInternal)
  {
    b = new WeakReference(paramGathererConfigInternal.a());
    GathererExecutor.a().a(paramGathererConfigInternal.h());
    GathererCompContext.a.a(paramGathererConfigInternal);
    c();
  }
  
  public static <T> void a(Class<T> paramClass, Class<?> paramClass1)
  {
    a.b(paramClass, paramClass1);
  }
  
  @Deprecated
  private static void c()
  {
    c.clear();
    Iterator localIterator = a.b().keySet().iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      Method[] arrayOfMethod = ((Class)a.b().get(localClass)).getMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        Object localObject = null;
        try
        {
          InfoID localInfoID = (InfoID)localMethod.getAnnotation(InfoID.class);
          localObject = localInfoID;
        }
        catch (Throwable localThrowable)
        {
          GLog.d(localThrowable.getMessage());
        }
        if (localObject != null)
        {
          if (c.get(Integer.valueOf(((InfoID)localObject).id())) != null)
          {
            localObject = (GathererCoreContext.IDCache)c.get(Integer.valueOf(((InfoID)localObject).id()));
            return;
          }
          GathererCoreContext.IDCache localIDCache = new GathererCoreContext.IDCache();
          localIDCache.a = localClass;
          localIDCache.b = localMethod;
          localIDCache.d = ((InfoID)localObject);
          c.put(Integer.valueOf(((InfoID)localObject).id()), localIDCache);
        }
        i += 1;
      }
    }
  }
  
  protected Object a(Class<?> paramClass, Object paramObject)
  {
    WeakReference localWeakReference = b;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      ((IBase)paramObject).a((Context)b.get());
      paramObject = new ProviderDynamicProxy(paramObject);
      return Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, paramObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.GathererCoreContext
 * JD-Core Version:    0.7.0.1
 */