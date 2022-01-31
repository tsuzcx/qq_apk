import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class bjnf
  implements bjmw
{
  static final Map<Class, bjng> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final bjng jdField_a_of_type_Bjng;
  private final Object jdField_a_of_type_JavaLangObject;
  
  bjnf(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Bjng = a(this.jdField_a_of_type_JavaLangObject.getClass());
  }
  
  private static bjng a(Class paramClass)
  {
    bjng localbjng = (bjng)jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localbjng != null) {
      return localbjng;
    }
    return b(paramClass);
  }
  
  private void a(bjng parambjng, bjnb parambjnb, bjmy parambjmy)
  {
    a((List)parambjng.jdField_a_of_type_JavaUtilMap.get(parambjmy), parambjnb, parambjmy);
    a((List)parambjng.jdField_a_of_type_JavaUtilMap.get(bjmy.g), parambjnb, parambjmy);
  }
  
  private void a(bjnh parambjnh, bjnb parambjnb, bjmy parambjmy)
  {
    try
    {
      switch (parambjnh.jdField_a_of_type_Int)
      {
      case 0: 
        parambjnh.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[0]);
        return;
      }
    }
    catch (InvocationTargetException parambjnh)
    {
      throw new RuntimeException("Failed to call observer method", parambjnh.getCause());
      parambjnh.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { parambjnb });
      return;
    }
    catch (IllegalAccessException parambjnh)
    {
      throw new RuntimeException(parambjnh);
    }
    parambjnh.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { parambjnb, parambjmy });
    return;
  }
  
  private void a(List<bjnh> paramList, bjnb parambjnb, bjmy parambjmy)
  {
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        a((bjnh)paramList.get(i), parambjnb, parambjmy);
        i -= 1;
      }
    }
  }
  
  private static void a(Map<bjnh, bjmy> paramMap, bjnh parambjnh, bjmy parambjmy, Class paramClass)
  {
    bjmy localbjmy = (bjmy)paramMap.get(parambjnh);
    if ((localbjmy != null) && (parambjmy != localbjmy))
    {
      paramMap = parambjnh.jdField_a_of_type_JavaLangReflectMethod;
      throw new IllegalArgumentException("Method " + paramMap.getName() + " in " + paramClass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + localbjmy + ", new value " + parambjmy);
    }
    if (localbjmy == null) {
      paramMap.put(parambjnh, parambjmy);
    }
  }
  
  private static bjng b(Class paramClass)
  {
    Object localObject2 = paramClass.getSuperclass();
    Object localObject1 = new HashMap();
    if (localObject2 != null)
    {
      localObject2 = a((Class)localObject2);
      if (localObject2 != null) {
        ((Map)localObject1).putAll(((bjng)localObject2).b);
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
        a((Map)localObject1, (bjnh)((Map.Entry)localObject4).getKey(), (bjmy)((Map.Entry)localObject4).getValue(), paramClass);
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
        localObject3 = (bjne)arrayOfClass.getAnnotation(bjne.class);
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
          if (!localObject4[0].isAssignableFrom(bjnb.class)) {
            throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
          }
        }
      }
    }
    label349:
    for (i = 1;; i = 0)
    {
      int m = ((bjne)localObject3).a();
      if (localObject4.length > 1)
      {
        if (!localObject4[1].isAssignableFrom(bjmy.class)) {
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
      a((Map)localObject1, new bjnh(i, arrayOfClass), bjmy.a(m), paramClass);
      break;
      localObject1 = new bjng((Map)localObject1);
      jdField_a_of_type_JavaUtilMap.put(paramClass, localObject1);
      return localObject1;
    }
  }
  
  public void a(bjnb parambjnb, bjmy parambjmy)
  {
    a(this.jdField_a_of_type_Bjng, parambjnb, parambjmy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnf
 * JD-Core Version:    0.7.0.1
 */