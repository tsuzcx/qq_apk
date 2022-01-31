package com.tencent.biz.qqstory.utils;

import android.support.annotation.NonNull;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vym;
import vyn;

public class JsonORM
{
  private static final Map<Class, vyn[]> a = new IdentityHashMap();
  
  public static int a(Class<?> paramClass)
  {
    if (paramClass == String.class) {
      return 0;
    }
    if (paramClass == Boolean.TYPE) {
      return 1;
    }
    if (paramClass == Integer.TYPE) {
      return 2;
    }
    if (paramClass == Long.TYPE) {
      return 3;
    }
    if (paramClass == Double.TYPE) {
      return 4;
    }
    if (paramClass.isArray()) {
      return 6;
    }
    if (paramClass.isPrimitive()) {
      throw new JsonORM.JsonParseException("un-support primitive field : " + paramClass);
    }
    return 5;
  }
  
  @NonNull
  public static <T> T a(JSONObject paramJSONObject, Class<T> paramClass)
  {
    if ((paramJSONObject == null) || (paramClass == null)) {
      throw new IllegalArgumentException("both jsonObject and clazz should not be null");
    }
    Object localObject2 = (vyn[])a.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = a(paramClass);
      a.put(paramClass, localObject1);
    }
    int i;
    try
    {
      localObject2 = paramClass.newInstance();
      int j = localObject1.length;
      i = 0;
      if (i >= j) {
        break label390;
      }
      paramClass = localObject1[i];
      try
      {
        switch (paramClass.jdField_a_of_type_Int)
        {
        case 0: 
          label128:
          throw new JsonORM.JsonParseException("un-support type : " + paramClass.jdField_a_of_type_Int);
        }
      }
      catch (IllegalAccessException paramJSONObject)
      {
        throw new JsonORM.JsonParseException("access field failed : " + paramClass.jdField_a_of_type_JavaLangReflectField.getName(), paramJSONObject);
      }
      a(paramClass.jdField_a_of_type_Int, paramJSONObject, paramClass.jdField_a_of_type_JavaLangString, paramClass.jdField_a_of_type_JavaLangReflectField, localObject2);
    }
    catch (Exception paramJSONObject)
    {
      throw new JsonORM.JsonParseException("create class instance failed : " + paramClass.getName(), paramJSONObject);
    }
    break label396;
    Object localObject3 = paramJSONObject.optJSONArray(paramClass.jdField_a_of_type_JavaLangString);
    Class localClass;
    int k;
    if (localObject3 != null)
    {
      localClass = paramClass.jdField_a_of_type_JavaLangReflectField.getType().getComponentType();
      k = a(localClass);
      switch (k)
      {
      }
    }
    for (;;)
    {
      paramClass.jdField_a_of_type_JavaLangReflectField.set(localObject2, a((JSONArray)localObject3, localClass));
      break label396;
      a(k, (JSONArray)localObject3, paramClass.jdField_a_of_type_JavaLangReflectField, localObject2);
      break label396;
      localObject3 = paramJSONObject.optJSONObject(paramClass.jdField_a_of_type_JavaLangString);
      if (localObject3 != null)
      {
        paramClass.jdField_a_of_type_JavaLangReflectField.set(localObject2, a((JSONObject)localObject3, paramClass.jdField_a_of_type_JavaLangReflectField.getType()));
        break label396;
        label390:
        return localObject2;
        break label128;
      }
      label396:
      i += 1;
      break;
    }
  }
  
  public static JSONObject a(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("object should not be null");
    }
    Class localClass = paramObject.getClass();
    Object localObject2 = (vyn[])a.get(localClass);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = a(localClass);
      a.put(localClass, localObject1);
    }
    localObject2 = new JSONObject();
    int j = localObject1.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        localClass = localObject1[i];
        try
        {
          switch (localClass.jdField_a_of_type_Int)
          {
          case 1: 
            ((JSONObject)localObject2).put(localClass.jdField_a_of_type_JavaLangString, localClass.jdField_a_of_type_JavaLangReflectField.getBoolean(paramObject));
          }
        }
        catch (IllegalAccessException paramObject)
        {
          throw new JsonORM.JsonParseException("access field failed", paramObject);
          ((JSONObject)localObject2).put(localClass.jdField_a_of_type_JavaLangString, localClass.jdField_a_of_type_JavaLangReflectField.getInt(paramObject));
        }
        catch (JSONException paramObject)
        {
          throw new JsonORM.JsonParseException("operate json object error", paramObject);
        }
        ((JSONObject)localObject2).put(localClass.jdField_a_of_type_JavaLangString, localClass.jdField_a_of_type_JavaLangReflectField.getLong(paramObject));
        break label314;
        ((JSONObject)localObject2).put(localClass.jdField_a_of_type_JavaLangString, localClass.jdField_a_of_type_JavaLangReflectField.getDouble(paramObject));
        break label314;
        Object localObject3 = localClass.jdField_a_of_type_JavaLangReflectField.get(paramObject);
        if (localObject3 != null)
        {
          ((JSONObject)localObject2).put(localClass.jdField_a_of_type_JavaLangString, localObject3);
          break label314;
          localObject3 = localClass.jdField_a_of_type_JavaLangReflectField.get(paramObject);
          if (localObject3 != null) {
            ((JSONObject)localObject2).put(localClass.jdField_a_of_type_JavaLangString, a(localObject3));
          }
        }
      }
      else
      {
        return localObject2;
      }
      label314:
      i += 1;
    }
  }
  
  private static void a(int paramInt, JSONArray paramJSONArray, Field paramField, Object paramObject)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    int i1 = paramJSONArray.length();
    switch (paramInt)
    {
    default: 
      throw new JsonORM.JsonParseException("un-support array field type : " + paramInt);
    case 1: 
      localObject = new boolean[i1];
      paramInt = i;
      while (paramInt < i1)
      {
        localObject[paramInt] = paramJSONArray.optBoolean(paramInt);
        paramInt += 1;
      }
      paramField.set(paramObject, localObject);
      return;
    case 2: 
      localObject = new int[i1];
      paramInt = j;
      while (paramInt < i1)
      {
        localObject[paramInt] = paramJSONArray.optInt(paramInt);
        paramInt += 1;
      }
      paramField.set(paramObject, localObject);
      return;
    case 3: 
      localObject = new long[i1];
      paramInt = k;
      while (paramInt < i1)
      {
        localObject[paramInt] = paramJSONArray.optLong(paramInt);
        paramInt += 1;
      }
      paramField.set(paramObject, localObject);
      return;
    case 4: 
      localObject = new double[i1];
      paramInt = m;
      while (paramInt < i1)
      {
        localObject[paramInt] = paramJSONArray.optDouble(paramInt);
        paramInt += 1;
      }
      paramField.set(paramObject, localObject);
      return;
    }
    Object localObject = new String[i1];
    paramInt = n;
    while (paramInt < i1)
    {
      localObject[paramInt] = paramJSONArray.optString(paramInt);
      paramInt += 1;
    }
    paramField.set(paramObject, localObject);
  }
  
  private static void a(int paramInt, JSONObject paramJSONObject, String paramString, Field paramField, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new JsonORM.JsonParseException("un-support field type : " + paramInt);
    case 1: 
      paramField.set(paramObject, Boolean.valueOf(paramJSONObject.optBoolean(paramString)));
      return;
    case 2: 
      paramField.set(paramObject, Integer.valueOf(paramJSONObject.optInt(paramString)));
      return;
    case 3: 
      paramField.set(paramObject, Long.valueOf(paramJSONObject.optLong(paramString)));
      return;
    case 4: 
      paramField.set(paramObject, Double.valueOf(paramJSONObject.optDouble(paramString)));
      return;
    }
    paramField.set(paramObject, paramJSONObject.optString(paramString));
  }
  
  private static void a(Class<?> paramClass, ArrayList<vyn> paramArrayList)
  {
    paramClass = paramClass.getDeclaredFields();
    int i = 0;
    if (i != paramClass.length)
    {
      Field localField = paramClass[i];
      vym localvym = (vym)localField.getAnnotation(vym.class);
      if (localvym == null) {}
      for (;;)
      {
        i += 1;
        break;
        paramArrayList.add(new vyn(localvym.a(), a(localField.getType()), localField));
      }
    }
  }
  
  @NonNull
  public static <T> T[] a(JSONArray paramJSONArray, Class<T> paramClass)
  {
    if ((paramJSONArray == null) || (paramClass == null)) {
      throw new IllegalArgumentException("both jsonArray and clazz should not be null");
    }
    if (paramClass.isPrimitive()) {
      throw new JsonORM.JsonParseException("do not support primitive array field : " + paramClass);
    }
    int j = paramJSONArray.length();
    Object[] arrayOfObject = (Object[])Array.newInstance(paramClass, j);
    int i = 0;
    if (i < j)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject != null) {
        arrayOfObject[i] = a(localJSONObject, paramClass);
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfObject[i] = null;
      }
    }
    return arrayOfObject;
  }
  
  private static vyn[] a(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramClass != null)
    {
      a(paramClass, localArrayList);
      paramClass = paramClass.getSuperclass();
    }
    paramClass = new vyn[localArrayList.size()];
    localArrayList.toArray(paramClass);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.JsonORM
 * JD-Core Version:    0.7.0.1
 */