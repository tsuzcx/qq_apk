import android.support.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class blyp
{
  static blyp jdField_a_of_type_Blyp = new blyp();
  private final Map<Class, blyq> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final Map<Class, Boolean> b = new HashMap();
  
  private blyq a(Class paramClass, @Nullable Method[] paramArrayOfMethod)
  {
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = a((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(((blyq)localObject1).b);
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
        a(localHashMap, (blyr)((Map.Entry)localObject3).getKey(), (blyy)((Map.Entry)localObject3).getValue(), paramClass);
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
        localObject2 = (blze)((Method)localObject1).getAnnotation(blze.class);
        if (localObject2 != null) {
          break;
        }
        j += 1;
      }
      paramArrayOfMethod = a(paramClass);
    }
    Object localObject3 = ((Method)localObject1).getParameterTypes();
    if (localObject3.length > 0) {
      if (!localObject3[0].isAssignableFrom(blzb.class)) {
        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
      }
    }
    for (i = 1;; i = 0)
    {
      int m = ((blze)localObject2).a();
      if (localObject3.length > 1)
      {
        if (!localObject3[1].isAssignableFrom(blyy.class)) {
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
      a(localHashMap, new blyr(i, (Method)localObject1), blyy.a(m), paramClass);
      bool = true;
      break;
      label347:
      paramArrayOfMethod = new blyq(localHashMap);
      this.jdField_a_of_type_JavaUtilMap.put(paramClass, paramArrayOfMethod);
      this.b.put(paramClass, Boolean.valueOf(bool));
      return paramArrayOfMethod;
    }
  }
  
  private void a(Map<blyr, blyy> paramMap, blyr paramblyr, blyy paramblyy, Class paramClass)
  {
    blyy localblyy = (blyy)paramMap.get(paramblyr);
    if ((localblyy != null) && (paramblyy != localblyy))
    {
      paramMap = paramblyr.a;
      throw new IllegalArgumentException("Method " + paramMap.getName() + " in " + paramClass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + localblyy + ", new value " + paramblyy);
    }
    if (localblyy == null) {
      paramMap.put(paramblyr, paramblyy);
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
  
  blyq a(Class paramClass)
  {
    blyq localblyq = (blyq)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localblyq != null) {
      return localblyq;
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
      if ((blze)arrayOfMethod[i].getAnnotation(blze.class) != null)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyp
 * JD-Core Version:    0.7.0.1
 */