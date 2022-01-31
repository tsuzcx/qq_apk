import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class bmdr
  implements bmdi
{
  static final Map<Class, bmds> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final bmds jdField_a_of_type_Bmds;
  private final Object jdField_a_of_type_JavaLangObject;
  
  bmdr(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Bmds = a(this.jdField_a_of_type_JavaLangObject.getClass());
  }
  
  private static bmds a(Class paramClass)
  {
    bmds localbmds = (bmds)jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localbmds != null) {
      return localbmds;
    }
    return b(paramClass);
  }
  
  private void a(bmds parambmds, bmdn parambmdn, bmdk parambmdk)
  {
    a((List)parambmds.jdField_a_of_type_JavaUtilMap.get(parambmdk), parambmdn, parambmdk);
    a((List)parambmds.jdField_a_of_type_JavaUtilMap.get(bmdk.g), parambmdn, parambmdk);
  }
  
  private void a(bmdt parambmdt, bmdn parambmdn, bmdk parambmdk)
  {
    try
    {
      switch (parambmdt.jdField_a_of_type_Int)
      {
      case 0: 
        parambmdt.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[0]);
        return;
      }
    }
    catch (InvocationTargetException parambmdt)
    {
      throw new RuntimeException("Failed to call observer method", parambmdt.getCause());
      parambmdt.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { parambmdn });
      return;
    }
    catch (IllegalAccessException parambmdt)
    {
      throw new RuntimeException(parambmdt);
    }
    parambmdt.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { parambmdn, parambmdk });
    return;
  }
  
  private void a(List<bmdt> paramList, bmdn parambmdn, bmdk parambmdk)
  {
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        a((bmdt)paramList.get(i), parambmdn, parambmdk);
        i -= 1;
      }
    }
  }
  
  private static void a(Map<bmdt, bmdk> paramMap, bmdt parambmdt, bmdk parambmdk, Class paramClass)
  {
    bmdk localbmdk = (bmdk)paramMap.get(parambmdt);
    if ((localbmdk != null) && (parambmdk != localbmdk))
    {
      paramMap = parambmdt.jdField_a_of_type_JavaLangReflectMethod;
      throw new IllegalArgumentException("Method " + paramMap.getName() + " in " + paramClass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + localbmdk + ", new value " + parambmdk);
    }
    if (localbmdk == null) {
      paramMap.put(parambmdt, parambmdk);
    }
  }
  
  private static bmds b(Class paramClass)
  {
    Object localObject2 = paramClass.getSuperclass();
    Object localObject1 = new HashMap();
    if (localObject2 != null)
    {
      localObject2 = a((Class)localObject2);
      if (localObject2 != null) {
        ((Map)localObject1).putAll(((bmds)localObject2).b);
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
        a((Map)localObject1, (bmdt)((Map.Entry)localObject4).getKey(), (bmdk)((Map.Entry)localObject4).getValue(), paramClass);
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
        localObject3 = (bmdq)arrayOfClass.getAnnotation(bmdq.class);
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
          if (!localObject4[0].isAssignableFrom(bmdn.class)) {
            throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
          }
        }
      }
    }
    label349:
    for (i = 1;; i = 0)
    {
      int m = ((bmdq)localObject3).a();
      if (localObject4.length > 1)
      {
        if (!localObject4[1].isAssignableFrom(bmdk.class)) {
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
      a((Map)localObject1, new bmdt(i, arrayOfClass), bmdk.a(m), paramClass);
      break;
      localObject1 = new bmds((Map)localObject1);
      jdField_a_of_type_JavaUtilMap.put(paramClass, localObject1);
      return localObject1;
    }
  }
  
  public void a(bmdn parambmdn, bmdk parambmdk)
  {
    a(this.jdField_a_of_type_Bmds, parambmdn, parambmdk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdr
 * JD-Core Version:    0.7.0.1
 */