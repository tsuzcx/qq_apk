import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class bjnw
  implements bjnn
{
  static final Map<Class, bjnx> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final bjnx jdField_a_of_type_Bjnx;
  private final Object jdField_a_of_type_JavaLangObject;
  
  bjnw(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Bjnx = a(this.jdField_a_of_type_JavaLangObject.getClass());
  }
  
  private static bjnx a(Class paramClass)
  {
    bjnx localbjnx = (bjnx)jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localbjnx != null) {
      return localbjnx;
    }
    return b(paramClass);
  }
  
  private void a(bjnx parambjnx, bjns parambjns, bjnp parambjnp)
  {
    a((List)parambjnx.jdField_a_of_type_JavaUtilMap.get(parambjnp), parambjns, parambjnp);
    a((List)parambjnx.jdField_a_of_type_JavaUtilMap.get(bjnp.g), parambjns, parambjnp);
  }
  
  private void a(bjny parambjny, bjns parambjns, bjnp parambjnp)
  {
    try
    {
      switch (parambjny.jdField_a_of_type_Int)
      {
      case 0: 
        parambjny.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[0]);
        return;
      }
    }
    catch (InvocationTargetException parambjny)
    {
      throw new RuntimeException("Failed to call observer method", parambjny.getCause());
      parambjny.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { parambjns });
      return;
    }
    catch (IllegalAccessException parambjny)
    {
      throw new RuntimeException(parambjny);
    }
    parambjny.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { parambjns, parambjnp });
    return;
  }
  
  private void a(List<bjny> paramList, bjns parambjns, bjnp parambjnp)
  {
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        a((bjny)paramList.get(i), parambjns, parambjnp);
        i -= 1;
      }
    }
  }
  
  private static void a(Map<bjny, bjnp> paramMap, bjny parambjny, bjnp parambjnp, Class paramClass)
  {
    bjnp localbjnp = (bjnp)paramMap.get(parambjny);
    if ((localbjnp != null) && (parambjnp != localbjnp))
    {
      paramMap = parambjny.jdField_a_of_type_JavaLangReflectMethod;
      throw new IllegalArgumentException("Method " + paramMap.getName() + " in " + paramClass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + localbjnp + ", new value " + parambjnp);
    }
    if (localbjnp == null) {
      paramMap.put(parambjny, parambjnp);
    }
  }
  
  private static bjnx b(Class paramClass)
  {
    Object localObject2 = paramClass.getSuperclass();
    Object localObject1 = new HashMap();
    if (localObject2 != null)
    {
      localObject2 = a((Class)localObject2);
      if (localObject2 != null) {
        ((Map)localObject1).putAll(((bjnx)localObject2).b);
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
        a((Map)localObject1, (bjny)((Map.Entry)localObject4).getKey(), (bjnp)((Map.Entry)localObject4).getValue(), paramClass);
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
        localObject3 = (bjnv)arrayOfClass.getAnnotation(bjnv.class);
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
          if (!localObject4[0].isAssignableFrom(bjns.class)) {
            throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
          }
        }
      }
    }
    label349:
    for (i = 1;; i = 0)
    {
      int m = ((bjnv)localObject3).a();
      if (localObject4.length > 1)
      {
        if (!localObject4[1].isAssignableFrom(bjnp.class)) {
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
      a((Map)localObject1, new bjny(i, arrayOfClass), bjnp.a(m), paramClass);
      break;
      localObject1 = new bjnx((Map)localObject1);
      jdField_a_of_type_JavaUtilMap.put(paramClass, localObject1);
      return localObject1;
    }
  }
  
  public void a(bjns parambjns, bjnp parambjnp)
  {
    a(this.jdField_a_of_type_Bjnx, parambjns, parambjnp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnw
 * JD-Core Version:    0.7.0.1
 */