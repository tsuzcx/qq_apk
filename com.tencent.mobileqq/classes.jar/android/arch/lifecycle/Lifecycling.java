package android.arch.lifecycle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class Lifecycling
{
  private static final int GENERATED_CALLBACK = 2;
  private static final int REFLECTIVE_CALLBACK = 1;
  private static Map<Class, Integer> sCallbackCache = new HashMap();
  private static Map<Class, List<Constructor<? extends GeneratedAdapter>>> sClassToAdapters = new HashMap();
  
  private static GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> paramConstructor, Object paramObject)
  {
    try
    {
      paramConstructor = (GeneratedAdapter)paramConstructor.newInstance(new Object[] { paramObject });
      return paramConstructor;
    }
    catch (InvocationTargetException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InstantiationException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (IllegalAccessException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
  }
  
  @Nullable
  private static Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> paramClass)
  {
    try
    {
      Object localObject = paramClass.getPackage();
      String str = paramClass.getCanonicalName();
      if (localObject != null) {
        localObject = ((Package)localObject).getName();
      } else {
        localObject = "";
      }
      if (!((String)localObject).isEmpty()) {
        str = str.substring(((String)localObject).length() + 1);
      }
      str = getAdapterName(str);
      if (((String)localObject).isEmpty())
      {
        localObject = str;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(".");
        localStringBuilder.append(str);
        localObject = localStringBuilder.toString();
      }
      paramClass = Class.forName((String)localObject).getDeclaredConstructor(new Class[] { paramClass });
      if (!paramClass.isAccessible()) {
        paramClass.setAccessible(true);
      }
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      throw new RuntimeException(paramClass);
      return null;
    }
    catch (ClassNotFoundException paramClass)
    {
      label135:
      break label135;
    }
  }
  
  public static String getAdapterName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.replace(".", "_"));
    localStringBuilder.append("_LifecycleAdapter");
    return localStringBuilder.toString();
  }
  
  @NonNull
  static GenericLifecycleObserver getCallback(Object paramObject)
  {
    if ((paramObject instanceof FullLifecycleObserver)) {
      return new FullLifecycleObserverAdapter((FullLifecycleObserver)paramObject);
    }
    if ((paramObject instanceof GenericLifecycleObserver)) {
      return (GenericLifecycleObserver)paramObject;
    }
    Object localObject = paramObject.getClass();
    if (getObserverConstructorType((Class)localObject) == 2)
    {
      localObject = (List)sClassToAdapters.get(localObject);
      int j = ((List)localObject).size();
      int i = 0;
      if (j == 1) {
        return new SingleGeneratedAdapterObserver(createGeneratedAdapter((Constructor)((List)localObject).get(0), paramObject));
      }
      GeneratedAdapter[] arrayOfGeneratedAdapter = new GeneratedAdapter[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfGeneratedAdapter[i] = createGeneratedAdapter((Constructor)((List)localObject).get(i), paramObject);
        i += 1;
      }
      return new CompositeGeneratedAdaptersObserver(arrayOfGeneratedAdapter);
    }
    return new ReflectiveGenericLifecycleObserver(paramObject);
  }
  
  private static int getObserverConstructorType(Class<?> paramClass)
  {
    if (sCallbackCache.containsKey(paramClass)) {
      return ((Integer)sCallbackCache.get(paramClass)).intValue();
    }
    int i = resolveObserverCallbackType(paramClass);
    sCallbackCache.put(paramClass, Integer.valueOf(i));
    return i;
  }
  
  private static boolean isLifecycleParent(Class<?> paramClass)
  {
    return (paramClass != null) && (LifecycleObserver.class.isAssignableFrom(paramClass));
  }
  
  private static int resolveObserverCallbackType(Class<?> paramClass)
  {
    if (paramClass.getCanonicalName() == null) {
      return 1;
    }
    Object localObject1 = generatedConstructor(paramClass);
    if (localObject1 != null)
    {
      sClassToAdapters.put(paramClass, Collections.singletonList(localObject1));
      return 2;
    }
    if (ClassesInfoCache.sInstance.hasLifecycleMethods(paramClass)) {
      return 1;
    }
    Object localObject2 = paramClass.getSuperclass();
    localObject1 = null;
    if (isLifecycleParent((Class)localObject2))
    {
      if (getObserverConstructorType((Class)localObject2) == 1) {
        return 1;
      }
      localObject1 = new ArrayList((Collection)sClassToAdapters.get(localObject2));
    }
    Class[] arrayOfClass = paramClass.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      if (isLifecycleParent(localClass))
      {
        if (getObserverConstructorType(localClass) == 1) {
          return 1;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).addAll((Collection)sClassToAdapters.get(localClass));
        localObject1 = localObject2;
      }
      i += 1;
    }
    if (localObject1 != null)
    {
      sClassToAdapters.put(paramClass, localObject1);
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.arch.lifecycle.Lifecycling
 * JD-Core Version:    0.7.0.1
 */