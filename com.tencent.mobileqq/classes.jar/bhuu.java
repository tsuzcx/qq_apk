import android.support.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class bhuu
{
  static bhuu jdField_a_of_type_Bhuu = new bhuu();
  private final Map<Class, bhuv> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final Map<Class, Boolean> b = new HashMap();
  
  private bhuv a(Class paramClass, @Nullable Method[] paramArrayOfMethod)
  {
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = a((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(((bhuv)localObject1).b);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = a(localObject1[i]).b.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        a(localHashMap, (bhuw)((Map.Entry)localObject3).getKey(), (bhvd)((Map.Entry)localObject3).getValue(), paramClass);
      }
      i += 1;
    }
    if (paramArrayOfMethod != null) {}
    boolean bool;
    for (;;)
    {
      int k = paramArrayOfMethod.length;
      j = 0;
      bool = false;
      for (;;)
      {
        if (j >= k) {
          break label347;
        }
        localObject1 = paramArrayOfMethod[j];
        localObject2 = (bhvj)((Method)localObject1).getAnnotation(bhvj.class);
        if (localObject2 != null) {
          break;
        }
        j += 1;
      }
      paramArrayOfMethod = a(paramClass);
    }
    Object localObject3 = ((Method)localObject1).getParameterTypes();
    if (localObject3.length > 0) {
      if (!localObject3[0].isAssignableFrom(bhvg.class)) {
        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
      }
    }
    for (i = 1;; i = 0)
    {
      int m = ((bhvj)localObject2).a();
      if (localObject3.length > 1)
      {
        if (!localObject3[1].isAssignableFrom(bhvd.class)) {
          throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
        }
        if (m != 6) {
          throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
        }
        i = 2;
      }
      if (localObject3.length > 2) {
        throw new IllegalArgumentException("cannot have more than 2 params");
      }
      a(localHashMap, new bhuw(i, (Method)localObject1), bhvd.a(m), paramClass);
      bool = true;
      break;
      label347:
      paramArrayOfMethod = new bhuv(localHashMap);
      this.jdField_a_of_type_JavaUtilMap.put(paramClass, paramArrayOfMethod);
      this.b.put(paramClass, Boolean.valueOf(bool));
      return paramArrayOfMethod;
    }
  }
  
  private void a(Map<bhuw, bhvd> paramMap, bhuw parambhuw, bhvd parambhvd, Class paramClass)
  {
    bhvd localbhvd = (bhvd)paramMap.get(parambhuw);
    if ((localbhvd != null) && (parambhvd != localbhvd))
    {
      paramMap = parambhuw.a;
      throw new IllegalArgumentException("Method " + paramMap.getName() + " in " + paramClass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + localbhvd + ", new value " + parambhvd);
    }
    if (localbhvd == null) {
      paramMap.put(parambhuw, parambhvd);
    }
  }
  
  private Method[] a(Class paramClass)
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
  
  bhuv a(Class paramClass)
  {
    bhuv localbhuv = (bhuv)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localbhuv != null) {
      return localbhuv;
    }
    return a(paramClass, null);
  }
  
  boolean a(Class paramClass)
  {
    if (this.b.containsKey(paramClass)) {
      return ((Boolean)this.b.get(paramClass)).booleanValue();
    }
    Method[] arrayOfMethod = a(paramClass);
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      if ((bhvj)arrayOfMethod[i].getAnnotation(bhvj.class) != null)
      {
        a(paramClass, arrayOfMethod);
        return true;
      }
      i += 1;
    }
    this.b.put(paramClass, Boolean.valueOf(false));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhuu
 * JD-Core Version:    0.7.0.1
 */