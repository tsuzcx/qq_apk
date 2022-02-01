package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;

public class ReflectionUtils
{
  private static final String TAG = "ReflectionUtils";
  
  public static boolean checkCompatible(String paramString)
  {
    try
    {
      tryLoadClass(paramString);
      return true;
    }
    catch (Exception localException)
    {
      label6:
      StringBuilder localStringBuilder;
      break label6;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("ClassNotFoundException");
    Logger.w("ReflectionUtils", localStringBuilder.toString());
    return false;
  }
  
  private static Class<?> getClass(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString) {}
    return null;
  }
  
  public static Object getFieldObj(Object paramObject, String paramString)
  {
    if (paramObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      Class localClass = paramObject.getClass();
      try
      {
        paramString = localClass.getDeclaredField(paramString);
        AccessController.doPrivileged(new ReflectionUtils.1(paramString));
        paramObject = paramString.get(paramObject);
        return paramObject;
      }
      catch (SecurityException paramObject)
      {
        paramString = "not security int method getStaticFieldObj,SecurityException:";
      }
      catch (NoSuchFieldException paramObject)
      {
        paramString = "Exception in getFieldObj :: NoSuchFieldException:";
      }
      catch (IllegalArgumentException paramObject)
      {
        paramString = "Exception in getFieldObj :: IllegalArgumentException:";
      }
      catch (IllegalAccessException paramObject)
      {
        paramString = "Exception in getFieldObj :: IllegalAccessException:";
      }
      Logger.e("ReflectionUtils", paramString, paramObject);
    }
    return null;
  }
  
  private static Method getMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    if ((paramClass != null) && (paramString != null))
    {
      try
      {
        paramClass = paramClass.getDeclaredMethod(paramString, paramVarArgs);
        return paramClass;
      }
      catch (NoSuchMethodException paramClass)
      {
        paramString = "NoSuchMethodException:";
      }
      catch (SecurityException paramClass)
      {
        paramString = "SecurityException:";
      }
      Logger.e("ReflectionUtils", paramString, paramClass);
      return null;
    }
    Logger.w("ReflectionUtils", "targetClass is  null pr name is null:");
    return null;
  }
  
  public static Object getStaticFieldObj(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    paramString1 = getClass(paramString1);
    if (paramString1 != null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      try
      {
        paramString2 = paramString1.getDeclaredField(paramString2);
        AccessController.doPrivileged(new ReflectionUtils.2(paramString2));
        paramString1 = paramString2.get(paramString1);
        return paramString1;
      }
      catch (SecurityException paramString1)
      {
        paramString2 = "not security int method getStaticFieldObj,SecurityException:";
      }
      catch (NoSuchFieldException paramString1)
      {
        paramString2 = "Exception in getFieldObj :: NoSuchFieldException:";
      }
      catch (IllegalArgumentException paramString1)
      {
        paramString2 = "Exception in getFieldObj :: IllegalArgumentException:";
      }
      catch (IllegalAccessException paramString1)
      {
        paramString2 = "Exception in getFieldObj :: IllegalAccessException:";
      }
      Logger.e("ReflectionUtils", paramString2, paramString1);
    }
    return null;
  }
  
  private static Object invoke(Object paramObject, Method paramMethod, Object... paramVarArgs)
  {
    if (paramMethod == null) {
      return null;
    }
    try
    {
      paramObject = paramMethod.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramMethod = "Exception in invoke:";
    }
    catch (RuntimeException paramObject)
    {
      paramMethod = "RuntimeException in invoke:";
    }
    Logger.e("ReflectionUtils", paramMethod, paramObject);
    return null;
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    paramString1 = getMethod(getClass(paramString1), paramString2, paramArrayOfClass);
    if (paramString1 == null) {
      return null;
    }
    return invoke(null, paramString1, paramVarArgs);
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      Class[] arrayOfClass2 = new Class[j];
      int i = 0;
      for (;;)
      {
        arrayOfClass1 = arrayOfClass2;
        if (i >= j) {
          break;
        }
        setClassType(arrayOfClass2, paramVarArgs[i], i);
        i += 1;
      }
    }
    Class[] arrayOfClass1 = null;
    paramString1 = getMethod(getClass(paramString1), paramString2, arrayOfClass1);
    if (paramString1 == null) {
      return null;
    }
    return invoke(null, paramString1, paramVarArgs);
  }
  
  private static void setClassType(Class<?>[] paramArrayOfClass, Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramArrayOfClass[paramInt] = Integer.TYPE;
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramArrayOfClass[paramInt] = Long.TYPE;
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramArrayOfClass[paramInt] = Double.TYPE;
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramArrayOfClass[paramInt] = Float.TYPE;
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramArrayOfClass[paramInt] = Boolean.TYPE;
      return;
    }
    if ((paramObject instanceof Character))
    {
      paramArrayOfClass[paramInt] = Character.TYPE;
      return;
    }
    if ((paramObject instanceof Byte))
    {
      paramArrayOfClass[paramInt] = Byte.TYPE;
      return;
    }
    if ((paramObject instanceof Void))
    {
      paramArrayOfClass[paramInt] = Void.TYPE;
      return;
    }
    if ((paramObject instanceof Short))
    {
      paramArrayOfClass[paramInt] = Short.TYPE;
      return;
    }
    paramArrayOfClass[paramInt] = paramObject.getClass();
  }
  
  private static void tryLoadClass(String paramString)
  {
    ClassLoader localClassLoader = ReflectionUtils.class.getClassLoader();
    if (localClassLoader != null)
    {
      localClassLoader.loadClass(paramString);
      return;
    }
    throw new ClassNotFoundException("not found classloader");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.ReflectionUtils
 * JD-Core Version:    0.7.0.1
 */