package com.tencent.biz.qqstory.boundaries.implement;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import nbj;

public class NullableObjectFactoryImplement
{
  public static Set a = Collections.synchronizedSet(new HashSet());
  
  public static Class a(Class paramClass)
  {
    return paramClass;
  }
  
  public static Object a(Class paramClass)
  {
    if (paramClass.isInterface())
    {
      ClassLoader localClassLoader = NullableObjectFactoryImplement.class.getClassLoader();
      nbj localnbj = new nbj();
      return Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, localnbj);
    }
    throw new IllegalArgumentException(paramClass.getName() + " should be an interface!", new Throwable());
  }
  
  public static Object a(Class paramClass, Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass1 = a(paramArrayOfObject);
    if (arrayOfClass1 == null) {}
    Constructor localConstructor;
    for (int j = 0;; j = arrayOfClass1.length)
    {
      Constructor[] arrayOfConstructor;
      try
      {
        localConstructor = paramClass.getConstructor(arrayOfClass1);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        arrayOfConstructor = paramClass.getConstructors();
        if (arrayOfConstructor != null) {
          break;
        }
      }
      try
      {
        paramArrayOfObject = paramClass.cast(localConstructor.newInstance(paramArrayOfObject));
        return paramArrayOfObject;
      }
      catch (InstantiationException paramArrayOfObject)
      {
        int k;
        Class[] arrayOfClass2;
        throw new IllegalStateException(paramClass.getName() + "(" + Arrays.toString(arrayOfClass1) + ")的构造函数执行异常", paramArrayOfObject);
      }
      catch (IllegalAccessException paramArrayOfObject)
      {
        throw new IllegalStateException(paramClass.getName() + "(" + Arrays.toString(arrayOfClass1) + ")的构造函数无法访问", paramArrayOfObject);
      }
      catch (InvocationTargetException paramArrayOfObject)
      {
        throw new IllegalArgumentException(paramClass.getName() + "(" + Arrays.toString(arrayOfClass1) + ") InvocationTargetException", paramArrayOfObject);
      }
    }
    for (k = 0;; k = arrayOfConstructor.length)
    {
      int m = 0;
      for (;;)
      {
        if (m >= k) {
          break label482;
        }
        localConstructor = arrayOfConstructor[m];
        arrayOfClass2 = localConstructor.getParameterTypes();
        if (j == arrayOfClass2.length) {
          break;
        }
        label88:
        m += 1;
      }
    }
    int i = 0;
    label107:
    if (i < j) {
      if (arrayOfClass1[i] == null)
      {
        if (!arrayOfClass2[i].isPrimitive()) {
          break label287;
        }
        i = 0;
        if (i == 0) {
          break label480;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        label131:
        if (localConstructor != null) {
          break label294;
        }
        throw new IllegalStateException("找不到对应类型" + paramClass.getName() + "(" + Arrays.toString(arrayOfClass1) + ")的构造函数", localNoSuchMethodException);
        if (arrayOfClass2[i].isPrimitive()) {
          if (arrayOfClass1[i] == null)
          {
            i = 0;
            break;
          }
        }
        try
        {
          Class localClass = (Class)arrayOfClass1[i].getField("TYPE").get(null);
          boolean bool = arrayOfClass2[i].equals(localClass);
          if (!bool) {
            i = 0;
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
          if (!arrayOfClass2[i].isAssignableFrom(arrayOfClass1[i])) {
            i = 0;
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          for (;;)
          {
            localNoSuchFieldException.printStackTrace();
          }
        }
      }
      label287:
      i += 1;
      break label107;
      label294:
      SLog.e("NullableObjectFactoryImplement", "虽然不是直接匹配, 但是还是找到了" + paramClass.getName() + "(" + Arrays.toString(arrayOfClass1) + ")的构造函数");
      break;
      i = 1;
      break label131;
      label480:
      break label88;
      label482:
      localConstructor = null;
    }
  }
  
  public static Class[] a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      if (paramArrayOfObject[i] == null) {}
      for (Class localClass = null;; localClass = paramArrayOfObject[i].getClass())
      {
        arrayOfClass[i] = localClass;
        i += 1;
        break;
      }
    }
    return arrayOfClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.implement.NullableObjectFactoryImplement
 * JD-Core Version:    0.7.0.1
 */