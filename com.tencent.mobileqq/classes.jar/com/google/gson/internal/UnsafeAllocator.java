package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class UnsafeAllocator
{
  static void assertInstantiable(Class<?> paramClass)
  {
    int i = paramClass.getModifiers();
    if (!Modifier.isInterface(i))
    {
      if (!Modifier.isAbstract(i)) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Abstract class can't be instantiated! Class name: ");
      localStringBuilder.append(paramClass.getName());
      throw new UnsupportedOperationException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Interface can't be instantiated! Interface name: ");
    localStringBuilder.append(paramClass.getName());
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public static UnsafeAllocator create()
  {
    try
    {
      localObject1 = Class.forName("sun.misc.Unsafe");
      Object localObject2 = ((Class)localObject1).getDeclaredField("theUnsafe");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(null);
      localObject1 = new UnsafeAllocator.1(((Class)localObject1).getMethod("allocateInstance", new Class[] { Class.class }), localObject2);
      return localObject1;
    }
    catch (Exception localException1)
    {
      Object localObject1;
      label50:
      int i;
      label133:
      label171:
      break label50;
    }
    try
    {
      localObject1 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
      ((Method)localObject1).setAccessible(true);
      i = ((Integer)((Method)localObject1).invoke(null, new Object[] { Object.class })).intValue();
      localObject1 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Integer.TYPE });
      ((Method)localObject1).setAccessible(true);
      localObject1 = new UnsafeAllocator.2((Method)localObject1, i);
      return localObject1;
    }
    catch (Exception localException2)
    {
      break label133;
    }
    try
    {
      localObject1 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
      ((Method)localObject1).setAccessible(true);
      localObject1 = new UnsafeAllocator.3((Method)localObject1);
      return localObject1;
    }
    catch (Exception localException3)
    {
      break label171;
    }
    return new UnsafeAllocator.4();
  }
  
  public abstract <T> T newInstance(Class<T> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal.UnsafeAllocator
 * JD-Core Version:    0.7.0.1
 */