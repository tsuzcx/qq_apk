package androidx.lifecycle;

import androidx.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ClassesInfoCache
{
  private static final int CALL_TYPE_NO_ARG = 0;
  private static final int CALL_TYPE_PROVIDER = 1;
  private static final int CALL_TYPE_PROVIDER_WITH_EVENT = 2;
  static ClassesInfoCache sInstance = new ClassesInfoCache();
  private final Map<Class<?>, ClassesInfoCache.CallbackInfo> mCallbackMap = new HashMap();
  private final Map<Class<?>, Boolean> mHasLifecycleMethods = new HashMap();
  
  private ClassesInfoCache.CallbackInfo createInfo(Class<?> paramClass, @Nullable Method[] paramArrayOfMethod)
  {
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = getInfo((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(((ClassesInfoCache.CallbackInfo)localObject1).mHandlerToEvent);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (i < j)
    {
      localObject2 = getInfo(localObject1[i]).mHandlerToEvent.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        verifyAndPutHandler(localHashMap, (ClassesInfoCache.MethodReference)((Map.Entry)localObject3).getKey(), (Lifecycle.Event)((Map.Entry)localObject3).getValue(), paramClass);
      }
      i += 1;
    }
    if (paramArrayOfMethod == null) {
      paramArrayOfMethod = getDeclaredMethods(paramClass);
    }
    int k = paramArrayOfMethod.length;
    j = 0;
    boolean bool = false;
    while (j < k)
    {
      localObject1 = paramArrayOfMethod[j];
      localObject3 = (OnLifecycleEvent)((Method)localObject1).getAnnotation(OnLifecycleEvent.class);
      if (localObject3 != null)
      {
        localObject2 = ((Method)localObject1).getParameterTypes();
        if (localObject2.length > 0)
        {
          if (localObject2[0].isAssignableFrom(LifecycleOwner.class)) {
            i = 1;
          } else {
            throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
          }
        }
        else {
          i = 0;
        }
        localObject3 = ((OnLifecycleEvent)localObject3).value();
        if (localObject2.length > 1) {
          if (localObject2[1].isAssignableFrom(Lifecycle.Event.class))
          {
            if (localObject3 == Lifecycle.Event.ON_ANY) {
              i = 2;
            } else {
              throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
            }
          }
          else {
            throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
          }
        }
        if (localObject2.length <= 2)
        {
          verifyAndPutHandler(localHashMap, new ClassesInfoCache.MethodReference(i, (Method)localObject1), (Lifecycle.Event)localObject3, paramClass);
          bool = true;
        }
      }
      else
      {
        j += 1;
        continue;
      }
      throw new IllegalArgumentException("cannot have more than 2 params");
    }
    paramArrayOfMethod = new ClassesInfoCache.CallbackInfo(localHashMap);
    this.mCallbackMap.put(paramClass, paramArrayOfMethod);
    this.mHasLifecycleMethods.put(paramClass, Boolean.valueOf(bool));
    return paramArrayOfMethod;
  }
  
  private Method[] getDeclaredMethods(Class<?> paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethods();
      return paramClass;
    }
    catch (NoClassDefFoundError paramClass)
    {
      throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
    }
  }
  
  private void verifyAndPutHandler(Map<ClassesInfoCache.MethodReference, Lifecycle.Event> paramMap, ClassesInfoCache.MethodReference paramMethodReference, Lifecycle.Event paramEvent, Class<?> paramClass)
  {
    Lifecycle.Event localEvent = (Lifecycle.Event)paramMap.get(paramMethodReference);
    if ((localEvent != null) && (paramEvent != localEvent))
    {
      paramMap = paramMethodReference.mMethod;
      paramMethodReference = new StringBuilder();
      paramMethodReference.append("Method ");
      paramMethodReference.append(paramMap.getName());
      paramMethodReference.append(" in ");
      paramMethodReference.append(paramClass.getName());
      paramMethodReference.append(" already declared with different @OnLifecycleEvent value: previous value ");
      paramMethodReference.append(localEvent);
      paramMethodReference.append(", new value ");
      paramMethodReference.append(paramEvent);
      throw new IllegalArgumentException(paramMethodReference.toString());
    }
    if (localEvent == null) {
      paramMap.put(paramMethodReference, paramEvent);
    }
  }
  
  ClassesInfoCache.CallbackInfo getInfo(Class<?> paramClass)
  {
    ClassesInfoCache.CallbackInfo localCallbackInfo = (ClassesInfoCache.CallbackInfo)this.mCallbackMap.get(paramClass);
    if (localCallbackInfo != null) {
      return localCallbackInfo;
    }
    return createInfo(paramClass, null);
  }
  
  boolean hasLifecycleMethods(Class<?> paramClass)
  {
    Object localObject = (Boolean)this.mHasLifecycleMethods.get(paramClass);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    localObject = getDeclaredMethods(paramClass);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if ((OnLifecycleEvent)localObject[i].getAnnotation(OnLifecycleEvent.class) != null)
      {
        createInfo(paramClass, (Method[])localObject);
        return true;
      }
      i += 1;
    }
    this.mHasLifecycleMethods.put(paramClass, Boolean.valueOf(false));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.ClassesInfoCache
 * JD-Core Version:    0.7.0.1
 */