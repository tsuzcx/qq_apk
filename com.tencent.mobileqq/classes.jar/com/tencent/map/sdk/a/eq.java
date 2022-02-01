package com.tencent.map.sdk.a;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class eq
{
  public static eq a()
  {
    try
    {
      localObject1 = Class.forName("sun.misc.Unsafe");
      Object localObject2 = ((Class)localObject1).getDeclaredField("theUnsafe");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(null);
      localObject1 = new eq.1(((Class)localObject1).getMethod("allocateInstance", new Class[] { Class.class }), localObject2);
      return localObject1;
    }
    catch (Exception localException1)
    {
      Object localObject1;
      label50:
      label88:
      int i;
      label171:
      break label50;
    }
    try
    {
      localObject1 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
      ((Method)localObject1).setAccessible(true);
      localObject1 = new eq.2((Method)localObject1);
      return localObject1;
    }
    catch (Exception localException2)
    {
      break label88;
    }
    try
    {
      localObject1 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
      ((Method)localObject1).setAccessible(true);
      i = ((Integer)((Method)localObject1).invoke(null, new Object[] { Object.class })).intValue();
      localObject1 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Integer.TYPE });
      ((Method)localObject1).setAccessible(true);
      localObject1 = new eq.3((Method)localObject1, i);
      return localObject1;
    }
    catch (Exception localException3)
    {
      break label171;
    }
    return new eq.4();
  }
  
  public abstract <T> T a(Class<T> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.eq
 * JD-Core Version:    0.7.0.1
 */