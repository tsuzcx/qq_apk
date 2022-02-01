package com.huawei.updatesdk.a.a.c;

import com.huawei.updatesdk.a.a.b.a.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class f
{
  private static final String a = f.class.getSimpleName();
  
  public static Class a(Field paramField)
  {
    Class localClass = null;
    if (Map.class.isAssignableFrom(paramField.getType())) {
      localClass = a(paramField, 1);
    }
    while (!List.class.isAssignableFrom(paramField.getType())) {
      return localClass;
    }
    return a(paramField, 0);
  }
  
  private static Class a(Field paramField, int paramInt)
  {
    paramField = paramField.getGenericType();
    if ((paramField instanceof ParameterizedType))
    {
      paramField = ((ParameterizedType)paramField).getActualTypeArguments();
      if ((paramField == null) || (paramField.length <= paramInt)) {}
    }
    label129:
    for (;;)
    {
      try
      {
        if ((paramField[paramInt] instanceof Class)) {
          return (Class)paramField[paramInt];
        }
        paramField = paramField[paramInt].toString();
        paramInt = paramField.indexOf("class ");
        if (paramInt >= 0) {
          break label129;
        }
        paramInt = 0;
        int j = paramField.indexOf("<");
        int i = j;
        if (j < 0) {
          i = paramField.length();
        }
        paramField = Class.forName(paramField.substring(paramInt, i));
        return paramField;
      }
      catch (ClassNotFoundException paramField)
      {
        a.d(a, "getType exception!" + paramField.getMessage());
      }
      return null;
    }
  }
  
  public static Field[] a(Class paramClass)
  {
    Object localObject1 = null;
    if (paramClass.getSuperclass() != null) {
      localObject1 = a(paramClass.getSuperclass());
    }
    paramClass = paramClass.getDeclaredFields();
    Object localObject2;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject2 = new Field[paramClass.length + localObject1.length];
      System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
      System.arraycopy(paramClass, 0, localObject2, localObject1.length, paramClass.length);
      paramClass = (Class)localObject2;
    }
    for (;;)
    {
      localObject2 = new ArrayList();
      int j = paramClass.length;
      int i = 0;
      while (i < j)
      {
        localObject1 = paramClass[i];
        if (((Field)localObject1).getName().indexOf("$") < 0) {
          ((List)localObject2).add(localObject1);
        }
        i += 1;
      }
    }
    localObject1 = paramClass;
    if (((List)localObject2).size() != paramClass.length)
    {
      localObject1 = new Field[((List)localObject2).size()];
      ((List)localObject2).toArray((Object[])localObject1);
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.c.f
 * JD-Core Version:    0.7.0.1
 */