package com.tencent.mobileqq.apollo.utils;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/Dispatcher;", "T", "", "()V", "mRoutes", "", "", "Lcom/tencent/mobileqq/apollo/utils/Dispatcher$MethodHolder;", "dispatchEvent", "", "key", "params", "(Ljava/lang/String;Ljava/lang/Object;)Z", "getRoute", "registerRoute", "", "clazz", "Ljava/lang/Class;", "obj", "Companion", "MethodHolder", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class Dispatcher<T>
{
  public static final Dispatcher.Companion a = new Dispatcher.Companion(null);
  private final Map<String, Dispatcher.MethodHolder<T>> b = (Map)new HashMap();
  
  private final Dispatcher.MethodHolder<T> a(String paramString)
  {
    return (Dispatcher.MethodHolder)this.b.get(paramString);
  }
  
  public final void a(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    try
    {
      paramClass = paramClass.newInstance();
    }
    catch (Exception paramClass)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registerRoute new instance error: ");
      localStringBuilder.append(paramClass);
      QLog.e("Dispatcher", 1, localStringBuilder.toString());
      paramClass = null;
    }
    a(paramClass);
  }
  
  public final void a(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    Method[] arrayOfMethod = paramObject.getClass().getDeclaredMethods();
    if (arrayOfMethod != null)
    {
      int j = arrayOfMethod.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfMethod[i];
        if (((Method)localObject).isAnnotationPresent(RequestRoute.class))
        {
          RequestRoute localRequestRoute = (RequestRoute)((Method)localObject).getAnnotation(RequestRoute.class);
          if (localRequestRoute != null)
          {
            Intrinsics.checkExpressionValueIsNotNull(localObject, "m");
            ((Method)localObject).setAccessible(true);
            if (this.b.containsKey(localRequestRoute.a()))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("registerRoute already has method with key: ");
              ((StringBuilder)localObject).append(localRequestRoute.a());
              ((StringBuilder)localObject).append(' ');
              QLog.e("Dispatcher", 1, ((StringBuilder)localObject).toString());
            }
            else
            {
              this.b.put(localRequestRoute.a(), new Dispatcher.MethodHolder((Method)localObject, paramObject));
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public final boolean a(@Nullable String paramString, T paramT)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString.a(paramT);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.Dispatcher
 * JD-Core Version:    0.7.0.1
 */