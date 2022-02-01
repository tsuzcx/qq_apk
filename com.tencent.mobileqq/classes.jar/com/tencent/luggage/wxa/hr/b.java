package com.tencent.luggage.wxa.hr;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class b
{
  public static <T> T a(Class<?> paramClass)
  {
    if (paramClass == null)
    {
      com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      paramClass.setAccessible(true);
      paramClass = paramClass.newInstance(new Object[0]);
      return paramClass;
    }
    catch (InvocationTargetException paramClass)
    {
      com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      return null;
    }
    catch (NoSuchMethodException paramClass)
    {
      com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      return null;
    }
    catch (InstantiationException paramClass)
    {
      com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass });
    }
    return null;
  }
  
  public static <T> T a(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass1 == null)
    {
      com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
      return null;
    }
    if (paramClass2 == null)
    {
      com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "newInstance failed, parent class is null.", new Object[0]);
      return null;
    }
    try
    {
      if (!paramClass2.isAssignableFrom(paramClass1))
      {
        com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "%s isAssignableFrom %s return false", new Object[] { paramClass2, paramClass1 });
        return null;
      }
      paramClass1 = paramClass1.getDeclaredConstructor(new Class[0]);
      paramClass1.setAccessible(true);
      paramClass1 = paramClass1.newInstance(new Object[0]);
      return paramClass1;
    }
    catch (InvocationTargetException paramClass1)
    {
      com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      return null;
    }
    catch (NoSuchMethodException paramClass1)
    {
      com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      return null;
    }
    catch (InstantiationException paramClass1)
    {
      com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
      return null;
    }
    catch (IllegalAccessException paramClass1)
    {
      com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramClass1 });
    }
    return null;
  }
  
  public static <T> T a(String paramString, Class<?> paramClass)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramClass == null)
      {
        com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "newInstance failed, parent class is null.", new Object[0]);
        return null;
      }
      try
      {
        paramString = Class.forName(paramString);
        if (!paramClass.isAssignableFrom(paramString))
        {
          com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "%s isAssignableFrom %s return false", new Object[] { paramClass, paramString });
          return null;
        }
        paramString = paramString.getDeclaredConstructor(new Class[0]);
        paramString.setAccessible(true);
        paramString = paramString.newInstance(new Object[0]);
        return paramString;
      }
      catch (InvocationTargetException paramString)
      {
        com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
        return null;
      }
      catch (NoSuchMethodException paramString)
      {
        com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
        return null;
      }
      catch (InstantiationException paramString)
      {
        com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
        return null;
      }
      catch (IllegalAccessException paramString)
      {
        com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
        return null;
      }
      catch (ClassNotFoundException paramString)
      {
        com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "reflect error : %s", new Object[] { paramString });
        return null;
      }
    }
    com.tencent.luggage.wxa.hs.b.b("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hr.b
 * JD-Core Version:    0.7.0.1
 */