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
  private static final GathererCoreContext jdField_a_of_type_ComTencentGatherergaCoreGathererCoreContext = new GathererCoreContext();
  private static WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private static final Map<Integer, GathererCoreContext.IDCache> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  static
  {
    a(UserInfoProvider.class, UserInfoImpl.class);
    a(HardwareInfoProvider.class, HardwareInfoProviderImpl.class);
    a(AndroidInfoProvider.class, AndroidInfoProviderImpl.class);
    a(AppInfoProvider.class, AppInfoProviderImpl.class);
  }
  
  public static Context a()
  {
    WeakReference localWeakReference = jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return (Context)jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  @Deprecated
  public static Object a(int paramInt, Object... paramVarArgs)
  {
    GathererCoreContext.IDCache localIDCache = (GathererCoreContext.IDCache)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    Object localObject;
    Method localMethod1;
    if (localIDCache != null)
    {
      localObject = a(localIDCache.jdField_a_of_type_JavaLangClass);
      if (localObject == null) {
        return null;
      }
      Method localMethod2 = localIDCache.b;
      localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod1 = localMethod2;
        try
        {
          localMethod2 = localObject.getClass().getMethod(localIDCache.jdField_a_of_type_JavaLangReflectMethod.getName(), localIDCache.jdField_a_of_type_JavaLangReflectMethod.getParameterTypes());
          localMethod1 = localMethod2;
          localIDCache.b = localMethod2;
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
    return jdField_a_of_type_ComTencentGatherergaCoreGathererCoreContext.b(paramClass);
  }
  
  @Deprecated
  private static void a()
  {
    jdField_a_of_type_JavaUtilMap.clear();
    Object localObject2 = jdField_a_of_type_ComTencentGatherergaCoreGathererCoreContext.a().keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Class localClass = (Class)((Iterator)localObject2).next();
      Method[] arrayOfMethod = ((Class)jdField_a_of_type_ComTencentGatherergaCoreGathererCoreContext.a().get(localClass)).getMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      Method localMethod;
      Object localObject1;
      while (i < j)
      {
        localMethod = arrayOfMethod[i];
        localObject1 = null;
        try
        {
          InfoID localInfoID = (InfoID)localMethod.getAnnotation(InfoID.class);
          localObject1 = localInfoID;
        }
        catch (Throwable localThrowable)
        {
          GLog.d(localThrowable.getMessage());
        }
        if (localObject1 != null)
        {
          if (jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(localObject1.id())) != null) {
            break label186;
          }
          localIDCache = new GathererCoreContext.IDCache();
          localIDCache.jdField_a_of_type_JavaLangClass = localClass;
          localIDCache.jdField_a_of_type_JavaLangReflectMethod = localMethod;
          localIDCache.jdField_a_of_type_ComTencentGatherergaCoreInternalProviderInfoID = localObject1;
          jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(localObject1.id()), localIDCache);
        }
        i += 1;
      }
      continue;
      label186:
      GathererCoreContext.IDCache localIDCache = (GathererCoreContext.IDCache)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(localObject1.id()));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("already impl id ");
      ((StringBuilder)localObject2).append(localObject1.id());
      ((StringBuilder)localObject2).append(" on : class ");
      ((StringBuilder)localObject2).append(localIDCache.jdField_a_of_type_JavaLangClass);
      ((StringBuilder)localObject2).append(" , method ");
      ((StringBuilder)localObject2).append(localIDCache.jdField_a_of_type_JavaLangReflectMethod.getName());
      ((StringBuilder)localObject2).append(" ; conflict on : class ");
      ((StringBuilder)localObject2).append(localClass);
      ((StringBuilder)localObject2).append(" , method ");
      ((StringBuilder)localObject2).append(localMethod.getName());
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
  }
  
  public static void a(GathererConfigInternal paramGathererConfigInternal)
  {
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramGathererConfigInternal.a());
    GathererExecutor.a().a(paramGathererConfigInternal.a());
    GathererCompContext.a.a(paramGathererConfigInternal);
    a();
  }
  
  public static <T> void a(Class<T> paramClass, Class<?> paramClass1)
  {
    jdField_a_of_type_ComTencentGatherergaCoreGathererCoreContext.b(paramClass, paramClass1);
  }
  
  protected Object a(Class<?> paramClass, Object paramObject)
  {
    WeakReference localWeakReference = jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      ((IBase)paramObject).a((Context)jdField_a_of_type_JavaLangRefWeakReference.get());
      paramObject = new ProviderDynamicProxy(paramObject);
      return Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, paramObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.GathererCoreContext
 * JD-Core Version:    0.7.0.1
 */