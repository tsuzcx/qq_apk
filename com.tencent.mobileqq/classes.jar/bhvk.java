import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class bhvk
  implements bhvb
{
  static final Map<Class, bhvl> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final bhvl jdField_a_of_type_Bhvl;
  private final Object jdField_a_of_type_JavaLangObject;
  
  bhvk(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Bhvl = a(this.jdField_a_of_type_JavaLangObject.getClass());
  }
  
  private static bhvl a(Class paramClass)
  {
    bhvl localbhvl = (bhvl)jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localbhvl != null) {
      return localbhvl;
    }
    return b(paramClass);
  }
  
  private void a(bhvl parambhvl, bhvg parambhvg, bhvd parambhvd)
  {
    a((List)parambhvl.jdField_a_of_type_JavaUtilMap.get(parambhvd), parambhvg, parambhvd);
    a((List)parambhvl.jdField_a_of_type_JavaUtilMap.get(bhvd.g), parambhvg, parambhvd);
  }
  
  private void a(bhvm parambhvm, bhvg parambhvg, bhvd parambhvd)
  {
    try
    {
      switch (parambhvm.jdField_a_of_type_Int)
      {
      case 0: 
        parambhvm.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[0]);
        return;
      }
    }
    catch (InvocationTargetException parambhvm)
    {
      throw new RuntimeException("Failed to call observer method", parambhvm.getCause());
      parambhvm.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { parambhvg });
      return;
    }
    catch (IllegalAccessException parambhvm)
    {
      throw new RuntimeException(parambhvm);
    }
    parambhvm.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { parambhvg, parambhvd });
    return;
  }
  
  private void a(List<bhvm> paramList, bhvg parambhvg, bhvd parambhvd)
  {
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        a((bhvm)paramList.get(i), parambhvg, parambhvd);
        i -= 1;
      }
    }
  }
  
  private static void a(Map<bhvm, bhvd> paramMap, bhvm parambhvm, bhvd parambhvd, Class paramClass)
  {
    bhvd localbhvd = (bhvd)paramMap.get(parambhvm);
    if ((localbhvd != null) && (parambhvd != localbhvd))
    {
      paramMap = parambhvm.jdField_a_of_type_JavaLangReflectMethod;
      throw new IllegalArgumentException("Method " + paramMap.getName() + " in " + paramClass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + localbhvd + ", new value " + parambhvd);
    }
    if (localbhvd == null) {
      paramMap.put(parambhvm, parambhvd);
    }
  }
  
  private static bhvl b(Class paramClass)
  {
    Object localObject2 = paramClass.getSuperclass();
    Object localObject1 = new HashMap();
    if (localObject2 != null)
    {
      localObject2 = a((Class)localObject2);
      if (localObject2 != null) {
        ((Map)localObject1).putAll(((bhvl)localObject2).b);
      }
    }
    localObject2 = paramClass.getDeclaredMethods();
    Class[] arrayOfClass = paramClass.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    Object localObject3;
    Object localObject4;
    while (i < j)
    {
      localObject3 = a(arrayOfClass[i]).b.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        a((Map)localObject1, (bhvm)((Map.Entry)localObject4).getKey(), (bhvd)((Map.Entry)localObject4).getValue(), paramClass);
      }
      i += 1;
    }
    int k = localObject2.length;
    j = 0;
    for (;;)
    {
      if (j < k)
      {
        arrayOfClass = localObject2[j];
        localObject3 = (bhvj)arrayOfClass.getAnnotation(bhvj.class);
        if (localObject3 == null)
        {
          j += 1;
        }
        else
        {
          localObject4 = arrayOfClass.getParameterTypes();
          if (localObject4.length <= 0) {
            break label349;
          }
          if (!localObject4[0].isAssignableFrom(bhvg.class)) {
            throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
          }
        }
      }
    }
    label349:
    for (i = 1;; i = 0)
    {
      int m = ((bhvj)localObject3).a();
      if (localObject4.length > 1)
      {
        if (!localObject4[1].isAssignableFrom(bhvd.class)) {
          throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
        }
        if (m != 6) {
          throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
        }
        i = 2;
      }
      if (localObject4.length > 2) {
        throw new IllegalArgumentException("cannot have more than 2 params");
      }
      a((Map)localObject1, new bhvm(i, arrayOfClass), bhvd.a(m), paramClass);
      break;
      localObject1 = new bhvl((Map)localObject1);
      jdField_a_of_type_JavaUtilMap.put(paramClass, localObject1);
      return localObject1;
    }
  }
  
  public void a(bhvg parambhvg, bhvd parambhvd)
  {
    a(this.jdField_a_of_type_Bhvl, parambhvg, parambhvd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhvk
 * JD-Core Version:    0.7.0.1
 */