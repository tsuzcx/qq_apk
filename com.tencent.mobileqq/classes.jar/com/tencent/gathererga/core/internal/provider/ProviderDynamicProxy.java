package com.tencent.gathererga.core.internal.provider;

import com.tencent.gathererga.core.GathererCoreContext;
import com.tencent.gathererga.core.ProviderMethodPriority;
import com.tencent.gathererga.core.ProviderResult;
import com.tencent.gathererga.core.internal.component.GathererCompContext;
import com.tencent.gathererga.core.internal.component.cache.ProviderResultCache;
import com.tencent.gathererga.core.internal.component.cloudconf.IDConfigManager;
import com.tencent.gathererga.core.internal.component.cloudconf.IDConfigManagerImpl;
import com.tencent.gathererga.core.internal.util.GLog;
import com.tencent.gathererga.core.internal.util.PermissionUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ProviderDynamicProxy
  implements InvocationHandler
{
  private Object a;
  
  public ProviderDynamicProxy(Object paramObject)
  {
    this.a = paramObject;
  }
  
  private static ProviderMethodPriority a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      if (paramArrayOfObject.length < 1) {
        return null;
      }
      paramArrayOfObject = paramArrayOfObject[0];
      if (paramArrayOfObject == null) {
        return null;
      }
      if (!(paramArrayOfObject instanceof ProviderMethodPriority)) {
        return null;
      }
      return (ProviderMethodPriority)paramArrayOfObject;
    }
    return null;
  }
  
  private static ProviderResult a(Method paramMethod, Object[] paramArrayOfObject, InfoID paramInfoID, int paramInt, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4) {
          return ProviderResultImpl.a(-1L);
        }
        paramArrayOfObject = new StringBuilder();
        paramArrayOfObject.append(paramMethod.getName());
        paramArrayOfObject.append(" try get from cache");
        GLog.b(paramArrayOfObject.toString());
        paramArrayOfObject = GathererCompContext.a.a();
        if (paramArrayOfObject == null) {
          return ProviderResultImpl.a(-11L);
        }
        paramArrayOfObject = paramArrayOfObject.a(paramInfoID.id());
        if (paramArrayOfObject != null)
        {
          paramInfoID = new StringBuilder();
          paramInfoID.append(paramMethod.getName());
          paramInfoID.append(" try get from cache succeeded");
          GLog.b(paramInfoID.toString());
          return ProviderResultImpl.a(paramArrayOfObject, 4);
        }
        return ProviderResultImpl.a(-11L);
      }
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append(paramMethod.getName());
      paramArrayOfObject.append(" try get from file");
      GLog.b(paramArrayOfObject.toString());
      paramArrayOfObject = GathererCompContext.a.a();
      if (paramArrayOfObject == null) {
        return ProviderResultImpl.a(-12L);
      }
      paramArrayOfObject = paramArrayOfObject.b(paramInfoID.id());
      if (paramArrayOfObject != null)
      {
        paramInfoID = new StringBuilder();
        paramInfoID.append(paramMethod.getName());
        paramInfoID.append(" try get from file succeeded");
        GLog.b(paramInfoID.toString());
        return ProviderResultImpl.a(paramArrayOfObject, 2);
      }
      return ProviderResultImpl.a(-12L);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMethod.getName());
    localStringBuilder.append(" try get from interface");
    GLog.b(localStringBuilder.toString());
    paramInfoID = PermissionUtil.a(GathererCoreContext.a(), paramInfoID.permissions());
    if ((paramInfoID != null) && (paramInfoID.length > 0))
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append(paramMethod.getName());
      paramArrayOfObject.append(" without permsssion : ");
      paramArrayOfObject.append(Arrays.asList(paramInfoID));
      GLog.b(paramArrayOfObject.toString());
      return ProviderResultImpl.a(-888L, paramInfoID);
    }
    try
    {
      long l = System.currentTimeMillis();
      paramMethod = (ProviderResult)paramMethod.invoke(paramObject, paramArrayOfObject);
      if (paramMethod != null) {
        paramMethod.a(System.currentTimeMillis() - l);
      }
      return paramMethod;
    }
    catch (Throwable paramMethod) {}
    return ProviderResultImpl.a(-13L, paramMethod);
  }
  
  private static ProviderResult a(Method paramMethod, Object[] paramArrayOfObject, InfoID paramInfoID, ProviderMethodPriority paramProviderMethodPriority, Object paramObject)
  {
    ProviderResult localProviderResult = a(paramMethod, paramArrayOfObject, paramInfoID, paramProviderMethodPriority.a(), paramObject);
    if (localProviderResult.a()) {
      return localProviderResult;
    }
    if (paramProviderMethodPriority.b() == 0) {
      return localProviderResult;
    }
    localProviderResult = a(paramMethod, paramArrayOfObject, paramInfoID, paramProviderMethodPriority.b(), paramObject);
    if (localProviderResult.a()) {
      return localProviderResult;
    }
    if (paramProviderMethodPriority.c() == 0) {
      return localProviderResult;
    }
    return a(paramMethod, paramArrayOfObject, paramInfoID, paramProviderMethodPriority.c(), paramObject);
  }
  
  private boolean a(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return true;
    }
    if ((paramObject instanceof Integer)) {
      return true;
    }
    return (paramObject instanceof Long);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Object localObject = this.a.getClass().getMethod(paramMethod.getName(), paramMethod.getParameterTypes());
    Annotation localAnnotation = ((Method)localObject).getAnnotation(InfoID.class);
    if (localAnnotation == null) {
      return ((Method)localObject).invoke(this.a, paramArrayOfObject);
    }
    if (!paramMethod.getReturnType().equals(ProviderResult.class)) {
      return ((Method)localObject).invoke(this.a, paramArrayOfObject);
    }
    paramObject = a(paramArrayOfObject);
    if (paramObject == null) {
      return ((Method)localObject).invoke(this.a, paramArrayOfObject);
    }
    localObject = (InfoID)localAnnotation;
    if (!IDConfigManagerImpl.a().a(((InfoID)localObject).id())) {
      return ProviderResultImpl.a(-999L);
    }
    paramMethod = a(paramMethod, paramArrayOfObject, (InfoID)localObject, paramObject, this.a);
    if ((paramMethod.a()) && (paramObject.b()))
    {
      paramArrayOfObject = GathererCompContext.a.a();
      if (paramArrayOfObject == null) {
        return paramMethod;
      }
      int i = ((InfoID)localObject).id();
      localObject = paramMethod.a();
      boolean bool;
      if ((paramObject.a()) && (a(paramMethod.a()))) {
        bool = true;
      } else {
        bool = false;
      }
      paramArrayOfObject.a(i, localObject, bool);
    }
    return paramMethod;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.provider.ProviderDynamicProxy
 * JD-Core Version:    0.7.0.1
 */