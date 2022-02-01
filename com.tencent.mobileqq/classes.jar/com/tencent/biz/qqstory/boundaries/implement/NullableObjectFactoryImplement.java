package com.tencent.biz.qqstory.boundaries.implement;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NullableObjectFactoryImplement
{
  public static Set<Class<?>> a = Collections.synchronizedSet(new HashSet());
  
  public static <I> I a(Class<I> paramClass)
  {
    if (paramClass.isInterface())
    {
      localObject = NullableObjectFactoryImplement.class.getClassLoader();
      NullableObjectFactoryImplement.1 local1 = new NullableObjectFactoryImplement.1();
      return Proxy.newProxyInstance((ClassLoader)localObject, new Class[] { paramClass }, local1);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramClass.getName());
    ((StringBuilder)localObject).append(" should be an interface!");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString(), new Throwable());
  }
  
  public static <T> T a(Class<T> paramClass, Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass1 = a(paramArrayOfObject);
    int i;
    if (arrayOfClass1 == null) {
      i = 0;
    } else {
      i = arrayOfClass1.length;
    }
    Object localObject;
    try
    {
      localObject = paramClass.getConstructor(arrayOfClass1);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Constructor[] arrayOfConstructor = paramClass.getConstructors();
      int j;
      if (arrayOfConstructor == null) {
        j = 0;
      } else {
        j = arrayOfConstructor.length;
      }
      int k = 0;
      while (k < j)
      {
        localObject = arrayOfConstructor[k];
        Class[] arrayOfClass2 = ((Constructor)localObject).getParameterTypes();
        if (i == arrayOfClass2.length)
        {
          int m = 0;
          while (m < i)
          {
            if (arrayOfClass1[m] == null)
            {
              if (!arrayOfClass2[m].isPrimitive()) {}
            }
            else {
              do
              {
                for (;;)
                {
                  m = 0;
                  break label229;
                  if (arrayOfClass2[m].isPrimitive())
                  {
                    if (arrayOfClass1[m] == null) {
                      continue;
                    }
                    try
                    {
                      Class localClass = (Class)arrayOfClass1[m].getField("TYPE").get(null);
                      boolean bool = arrayOfClass2[m].equals(localClass);
                      if (bool) {
                        break label217;
                      }
                    }
                    catch (NoSuchFieldException localNoSuchFieldException)
                    {
                      localNoSuchFieldException.printStackTrace();
                    }
                    catch (IllegalAccessException localIllegalAccessException)
                    {
                      localIllegalAccessException.printStackTrace();
                    }
                  }
                }
              } while (!arrayOfClass2[m].isAssignableFrom(arrayOfClass1[m]));
            }
            label217:
            m += 1;
          }
          m = 1;
          label229:
          if (m != 0) {
            break label249;
          }
        }
        k += 1;
      }
      localObject = null;
      label249:
      if (localObject == null) {
        break label520;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("虽然不是直接匹配, 但是还是找到了");
    localStringBuilder.append(paramClass.getName());
    localStringBuilder.append("(");
    localStringBuilder.append(Arrays.toString(arrayOfClass1));
    localStringBuilder.append(")的构造函数");
    SLog.e("NullableObjectFactoryImplement", localStringBuilder.toString());
    try
    {
      paramArrayOfObject = paramClass.cast(((Constructor)localObject).newInstance(paramArrayOfObject));
      return paramArrayOfObject;
    }
    catch (InvocationTargetException paramArrayOfObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramClass.getName());
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(Arrays.toString(arrayOfClass1));
      ((StringBuilder)localObject).append(") InvocationTargetException");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString(), paramArrayOfObject);
    }
    catch (IllegalAccessException paramArrayOfObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramClass.getName());
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(Arrays.toString(arrayOfClass1));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131905496));
      throw new IllegalStateException(((StringBuilder)localObject).toString(), paramArrayOfObject);
    }
    catch (InstantiationException paramArrayOfObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramClass.getName());
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(Arrays.toString(arrayOfClass1));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131905495));
      throw new IllegalStateException(((StringBuilder)localObject).toString(), paramArrayOfObject);
    }
    label520:
    paramArrayOfObject = new StringBuilder();
    paramArrayOfObject.append(HardCodeUtil.a(2131905494));
    paramArrayOfObject.append(paramClass.getName());
    paramArrayOfObject.append("(");
    paramArrayOfObject.append(Arrays.toString(arrayOfClass1));
    paramArrayOfObject.append(HardCodeUtil.a(2131905497));
    paramClass = new IllegalStateException(paramArrayOfObject.toString(), localStringBuilder);
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public static Class<?>[] a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      Class localClass;
      if (paramArrayOfObject[i] == null) {
        localClass = null;
      } else {
        localClass = paramArrayOfObject[i].getClass();
      }
      arrayOfClass[i] = localClass;
      i += 1;
    }
    return arrayOfClass;
  }
  
  public static <T> Class<T> b(Class<?> paramClass)
  {
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.implement.NullableObjectFactoryImplement
 * JD-Core Version:    0.7.0.1
 */