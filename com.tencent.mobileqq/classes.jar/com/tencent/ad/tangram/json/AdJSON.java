package com.tencent.ad.tangram.json;

import android.support.annotation.Keep;
import android.text.TextUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
public class AdJSON
{
  private static JSONArray fromArrayObject(Object paramObject, Set<Object> paramSet)
  {
    if (a.wrapClass(paramObject.getClass()).isArray())
    {
      if (paramSet.contains(paramObject)) {
        return null;
      }
      paramSet.add(paramObject);
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < Array.getLength(paramObject))
      {
        Object localObject = fromObject(Array.get(paramObject, i), paramSet);
        if ((localObject != null) && (!JSONObject.NULL.equals(localObject))) {
          localJSONArray.put(i, localObject);
        } else {
          localJSONArray.put(i, JSONObject.NULL);
        }
        i += 1;
      }
      paramSet.remove(paramObject);
      return localJSONArray;
    }
    paramObject = new Exception("not an array");
    for (;;)
    {
      throw paramObject;
    }
  }
  
  private static JSONObject fromClassObject(Object paramObject, Set<Object> paramSet)
  {
    if (paramSet.contains(paramObject)) {
      return null;
    }
    paramSet.add(paramObject);
    Object localObject1 = a.wrapClass(paramObject.getClass());
    JSONObject localJSONObject = new JSONObject();
    localObject1 = a.getFields((Class)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Field localField = (Field)((Iterator)localObject1).next();
      if ((!TextUtils.equals(localField.getName(), "this$0")) && (!TextUtils.equals(localField.getName(), "$change")) && (!TextUtils.equals(localField.getName(), "serialVersionUID")))
      {
        boolean bool = localField.isAccessible();
        localField.setAccessible(true);
        Object localObject2 = localField.get(paramObject);
        localField.setAccessible(bool);
        localObject2 = fromObject(localObject2, paramSet);
        if ((localObject2 != null) || (JSONObject.NULL.equals(localObject2))) {
          localJSONObject.put(localField.getName(), localObject2);
        }
      }
    }
    paramSet.remove(paramObject);
    return localJSONObject;
  }
  
  private static Object fromNumberObject(Object paramObject)
  {
    Class localClass = a.wrapClass(paramObject.getClass());
    if (a.isNumberClass(localClass))
    {
      if (localClass == Short.class) {
        return Integer.valueOf(((Short)Short.class.cast(paramObject)).shortValue());
      }
      if (localClass == Integer.class) {
        return Integer.class.cast(paramObject);
      }
      if (localClass == Long.class) {
        return paramObject.toString();
      }
      if (localClass == Float.class) {
        return Double.valueOf(((Float)Float.class.cast(paramObject)).floatValue());
      }
      if (localClass == Double.class) {
        return Double.class.cast(paramObject);
      }
      throw new Exception("not supported");
    }
    throw new Exception("not a number");
  }
  
  public static Object fromObject(Object paramObject)
  {
    return fromObject(paramObject, new HashSet());
  }
  
  private static Object fromObject(Object paramObject, Set<Object> paramSet)
  {
    if (paramObject == null) {
      return null;
    }
    if (paramSet != null)
    {
      Class localClass = a.wrapClass(paramObject.getClass());
      if (a.isPrimitiveClass(localClass)) {
        return fromPrimitiveObject(paramObject);
      }
      if (localClass == String.class) {
        return String.valueOf(paramObject);
      }
      if (localClass.isArray()) {
        return fromArrayObject(paramObject, paramSet);
      }
      return fromClassObject(paramObject, paramSet);
    }
    throw new Exception("objects can not be null");
  }
  
  private static Object fromPrimitiveObject(Object paramObject)
  {
    Class localClass = a.wrapClass(paramObject.getClass());
    if (a.isPrimitiveClass(localClass))
    {
      if (localClass == Boolean.class) {
        return Boolean.class.cast(paramObject);
      }
      if (localClass == Character.class) {
        return String.valueOf(Character.class.cast(paramObject));
      }
      if (localClass != Byte.class)
      {
        if (a.isNumberClass(localClass)) {
          return fromNumberObject(paramObject);
        }
        throw new Exception("not supported");
      }
      throw new Exception("not supported");
    }
    throw new Exception("not primitive");
  }
  
  private static Object toArrayObject(JSONArray paramJSONArray, Class paramClass)
  {
    if (paramClass.isArray())
    {
      Object localObject2 = Array.newInstance(paramClass.getComponentType(), paramJSONArray.length());
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject1 = paramJSONArray.get(i);
        if ((localObject1 != null) && (!JSONObject.NULL.equals(localObject1))) {
          localObject1 = toObject(localObject1, paramClass.getComponentType());
        } else {
          localObject1 = null;
        }
        Array.set(localObject2, i, localObject1);
        i += 1;
      }
      return localObject2;
    }
    paramJSONArray = new Exception("not an array");
    for (;;)
    {
      throw paramJSONArray;
    }
  }
  
  private static Boolean toBooleanObject(Object paramObject, Class paramClass)
  {
    if (a.wrapClass(paramClass) == Boolean.class)
    {
      if (a.wrapClass(paramObject.getClass()) == Boolean.class) {
        return (Boolean)Boolean.class.cast(paramObject);
      }
      throw new Exception("format error");
    }
    throw new Exception("not boolean");
  }
  
  private static Character toCharacterbject(Object paramObject, Class paramClass)
  {
    if (a.wrapClass(paramClass) == Character.class)
    {
      if (a.wrapClass(paramObject.getClass()) == Character.class) {
        return (Character)Character.class.cast(paramObject);
      }
      if ((paramObject instanceof String))
      {
        paramObject = (String)String.class.cast(paramObject);
        if (paramObject.length() == 0) {
          return null;
        }
        if (paramObject.length() == 1) {
          return Character.valueOf(paramObject.charAt(0));
        }
        throw new Exception("format error");
      }
      throw new Exception("format error");
    }
    throw new Exception("not a character");
  }
  
  private static Object toClassObject(JSONObject paramJSONObject, Class paramClass)
  {
    if ((!a.isPrimitiveClass(paramClass)) && (paramClass != String.class))
    {
      Object localObject2 = paramClass.newInstance();
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        Object localObject1 = (String)localIterator.next();
        Field localField = a.getField(paramClass, (String)localObject1);
        if (localField != null)
        {
          localObject1 = paramJSONObject.get((String)localObject1);
          if ((localObject1 != null) && (!JSONObject.NULL.equals(localObject1))) {
            localObject1 = toObject(localObject1, localField.getType());
          } else {
            localObject1 = null;
          }
          boolean bool = localField.isAccessible();
          localField.setAccessible(true);
          localField.set(localObject2, localObject1);
          localField.setAccessible(bool);
        }
      }
      return localObject2;
    }
    paramJSONObject = new Exception("not a class");
    for (;;)
    {
      throw paramJSONObject;
    }
  }
  
  private static Object toNumberObject(Object paramObject, Class paramClass)
  {
    paramClass = a.wrapClass(paramClass);
    if (a.isNumberClass(paramClass))
    {
      Class localClass = a.wrapClass(paramObject.getClass());
      Class[] arrayOfClass = new Class[3];
      arrayOfClass[0] = Short.class;
      arrayOfClass[1] = Integer.class;
      arrayOfClass[2] = Long.class;
      if ((a.isClass(paramClass, arrayOfClass)) && ((a.isClass(localClass, arrayOfClass)) || (localClass == String.class))) {
        return paramClass.getDeclaredMethod("valueOf", new Class[] { String.class }).invoke(paramClass, new Object[] { paramObject.toString() });
      }
      if (paramClass == Float.class)
      {
        if (localClass == Float.class) {
          return paramObject;
        }
        if (localClass == Double.class)
        {
          double d = ((Double)Double.class.cast(paramObject)).doubleValue();
          if (TextUtils.equals(String.valueOf(d), String.valueOf(1.4E-45F))) {
            return Float.valueOf(1.4E-45F);
          }
          if (TextUtils.equals(String.valueOf(d), String.valueOf(3.4028235E+38F))) {
            return Float.valueOf(3.4028235E+38F);
          }
          if ((d >= 1.401298464324817E-045D) && (d <= 3.402823466385289E+038D)) {
            return paramClass.getDeclaredMethod("valueOf", new Class[] { String.class }).invoke(paramClass, new Object[] { paramObject.toString() });
          }
          throw new Exception("out of range");
        }
        if ((localClass != String.class) && (!a.isClass(localClass, arrayOfClass))) {
          throw new Exception("format error");
        }
        return toNumberObject(Double.valueOf(paramObject.toString()), paramClass);
      }
      if (paramClass == Double.class) {
        if (!a.isClass(localClass, arrayOfClass))
        {
          if ((!a.isClass(localClass, new Class[] { Float.class, Double.class })) && (localClass != String.class)) {}
        }
        else {
          return paramClass.getDeclaredMethod("valueOf", new Class[] { String.class }).invoke(paramClass, new Object[] { paramObject.toString() });
        }
      }
      throw new Exception("format error");
    }
    throw new Exception("not a number");
  }
  
  public static Object toObject(Object paramObject, Class paramClass)
  {
    if (paramClass != null)
    {
      if (paramObject == null) {
        return null;
      }
      if (a.isPrimitiveClass(paramClass)) {
        return toPrimitiveObject(paramObject, paramClass);
      }
      if (paramClass == String.class) {
        return toStringObject(paramObject, paramClass);
      }
      if (paramClass.isArray()) {
        return toArrayObject((JSONArray)JSONArray.class.cast(paramObject), paramClass);
      }
      if (paramObject.getClass() == JSONObject.class) {
        return toClassObject((JSONObject)JSONObject.class.cast(paramObject), paramClass);
      }
      throw new Exception("format error");
    }
    throw new Exception("cls can not be null");
  }
  
  private static Object toPrimitiveObject(Object paramObject, Class paramClass)
  {
    paramClass = a.wrapClass(paramClass);
    if (a.isPrimitiveClass(paramClass))
    {
      if (paramClass == Boolean.class) {
        return toBooleanObject(paramObject, paramClass);
      }
      if (paramClass == Character.class) {
        return toCharacterbject(paramObject, paramClass);
      }
      if (paramClass != Byte.class)
      {
        if (a.isNumberClass(paramClass)) {
          return toNumberObject(paramObject, paramClass);
        }
        throw new Exception("not supported");
      }
      throw new Exception("byte is not supported");
    }
    throw new Exception("not primitive");
  }
  
  private static String toStringObject(Object paramObject, Class paramClass)
  {
    if (paramClass == String.class)
    {
      if ((paramObject instanceof String)) {
        return (String)String.class.cast(paramObject);
      }
      throw new Exception("format error");
    }
    throw new Exception("not a string");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.json.AdJSON
 * JD-Core Version:    0.7.0.1
 */