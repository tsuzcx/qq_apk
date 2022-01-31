import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class blzf
  implements blyw
{
  static final Map<Class, blzg> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final blzg jdField_a_of_type_Blzg;
  private final Object jdField_a_of_type_JavaLangObject;
  
  blzf(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Blzg = a(this.jdField_a_of_type_JavaLangObject.getClass());
  }
  
  private static blzg a(Class paramClass)
  {
    blzg localblzg = (blzg)jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localblzg != null) {
      return localblzg;
    }
    return b(paramClass);
  }
  
  private void a(blzg paramblzg, blzb paramblzb, blyy paramblyy)
  {
    a((List)paramblzg.jdField_a_of_type_JavaUtilMap.get(paramblyy), paramblzb, paramblyy);
    a((List)paramblzg.jdField_a_of_type_JavaUtilMap.get(blyy.g), paramblzb, paramblyy);
  }
  
  private void a(blzh paramblzh, blzb paramblzb, blyy paramblyy)
  {
    try
    {
      switch (paramblzh.jdField_a_of_type_Int)
      {
      case 0: 
        paramblzh.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[0]);
        return;
      }
    }
    catch (InvocationTargetException paramblzh)
    {
      throw new RuntimeException("Failed to call observer method", paramblzh.getCause());
      paramblzh.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramblzb });
      return;
    }
    catch (IllegalAccessException paramblzh)
    {
      throw new RuntimeException(paramblzh);
    }
    paramblzh.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramblzb, paramblyy });
    return;
  }
  
  private void a(List<blzh> paramList, blzb paramblzb, blyy paramblyy)
  {
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        a((blzh)paramList.get(i), paramblzb, paramblyy);
        i -= 1;
      }
    }
  }
  
  private static void a(Map<blzh, blyy> paramMap, blzh paramblzh, blyy paramblyy, Class paramClass)
  {
    blyy localblyy = (blyy)paramMap.get(paramblzh);
    if ((localblyy != null) && (paramblyy != localblyy))
    {
      paramMap = paramblzh.jdField_a_of_type_JavaLangReflectMethod;
      throw new IllegalArgumentException("Method " + paramMap.getName() + " in " + paramClass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + localblyy + ", new value " + paramblyy);
    }
    if (localblyy == null) {
      paramMap.put(paramblzh, paramblyy);
    }
  }
  
  private static blzg b(Class paramClass)
  {
    Object localObject2 = paramClass.getSuperclass();
    Object localObject1 = new HashMap();
    if (localObject2 != null)
    {
      localObject2 = a((Class)localObject2);
      if (localObject2 != null) {
        ((Map)localObject1).putAll(((blzg)localObject2).b);
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
        a((Map)localObject1, (blzh)((Map.Entry)localObject4).getKey(), (blyy)((Map.Entry)localObject4).getValue(), paramClass);
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
        localObject3 = (blze)arrayOfClass.getAnnotation(blze.class);
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
          if (!localObject4[0].isAssignableFrom(blzb.class)) {
            throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
          }
        }
      }
    }
    label349:
    for (i = 1;; i = 0)
    {
      int m = ((blze)localObject3).a();
      if (localObject4.length > 1)
      {
        if (!localObject4[1].isAssignableFrom(blyy.class)) {
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
      a((Map)localObject1, new blzh(i, arrayOfClass), blyy.a(m), paramClass);
      break;
      localObject1 = new blzg((Map)localObject1);
      jdField_a_of_type_JavaUtilMap.put(paramClass, localObject1);
      return localObject1;
    }
  }
  
  public void a(blzb paramblzb, blyy paramblyy)
  {
    a(this.jdField_a_of_type_Blzg, paramblzb, paramblyy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzf
 * JD-Core Version:    0.7.0.1
 */