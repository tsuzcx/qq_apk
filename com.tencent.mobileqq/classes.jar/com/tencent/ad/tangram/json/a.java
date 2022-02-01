package com.tencent.ad.tangram.json;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class a
{
  private static Map<Class, Class> PRIMITIVE_CLASSES = new a.1();
  
  public static Field getField(Class paramClass, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramClass = getFields(paramClass).iterator();
    while (paramClass.hasNext())
    {
      Field localField = (Field)paramClass.next();
      if (TextUtils.equals(localField.getName(), paramString)) {
        return localField;
      }
    }
    return null;
  }
  
  public static Set<Field> getFields(Class paramClass)
  {
    Object localObject = new HashSet();
    for (;;)
    {
      if ((paramClass == null) || (paramClass == Object.class) || (paramClass.getName().indexOf("android") == 0) || (paramClass.getName().indexOf("java") == 0))
      {
        paramClass = new HashSet();
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Field localField = (Field)((Iterator)localObject).next();
          if (!Modifier.isFinal(localField.getModifiers())) {
            paramClass.add(localField);
          }
        }
      }
      ((Set)localObject).addAll(Arrays.asList(paramClass.getDeclaredFields()));
      paramClass = paramClass.getSuperclass();
    }
    return paramClass;
  }
  
  public static boolean isClass(Type paramType, Class[] paramArrayOfClass)
  {
    if (!(paramType instanceof Class)) {
      return false;
    }
    paramType = (Class)Class.class.cast(paramType);
    int j = paramArrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      if (TextUtils.equals(paramArrayOfClass[i].getName(), paramType.getName())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isNumberClass(Class paramClass)
  {
    paramClass = wrapClass(paramClass);
    return (paramClass == Short.class) || (paramClass == Integer.class) || (paramClass == Long.class) || (paramClass == Float.class) || (paramClass == Double.class);
  }
  
  public static boolean isPrimitiveClass(Class paramClass)
  {
    Iterator localIterator = PRIMITIVE_CLASSES.keySet().iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      if ((paramClass == localClass) || (paramClass == PRIMITIVE_CLASSES.get(localClass))) {
        return true;
      }
    }
    return false;
  }
  
  public static Class wrapClass(Class paramClass)
  {
    Class localClass = (Class)PRIMITIVE_CLASSES.get(paramClass);
    if (localClass != null) {
      return localClass;
    }
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.json.a
 * JD-Core Version:    0.7.0.1
 */