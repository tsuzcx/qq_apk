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

public class JsonORM
{
  private static final Map<Class, JsonORM.ColumnInfo[]> a = new IdentityHashMap();
  
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
    if (!paramClass.isPrimitive()) {
      return 5;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("un-support primitive field : ");
    localStringBuilder.append(paramClass);
    throw new JsonORM.JsonParseException(localStringBuilder.toString());
  }
  
  @NonNull
  public static <T> T a(JSONObject paramJSONObject, Class<T> paramClass)
  {
    Object localObject2;
    Object localObject1;
    if ((paramJSONObject != null) && (paramClass != null))
    {
      localObject2 = (JsonORM.ColumnInfo[])a.get(paramClass);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = b(paramClass);
        a.put(paramClass, localObject1);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject2 = paramClass.newInstance();
        int j = localObject1.length;
        i = 0;
        if (i < j)
        {
          paramClass = localObject1[i];
          try
          {
            Object localObject3;
            switch (paramClass.b)
            {
            case 6: 
              continue;
              localObject3 = paramJSONObject.optJSONArray(paramClass.a);
              if (localObject3 == null) {
                break label424;
              }
              Class localClass = paramClass.c.getType().getComponentType();
              int k = a(localClass);
              if ((k != 0) && (k != 1) && (k != 2) && (k != 3) && (k != 4)) {
                paramClass.c.set(localObject2, a((JSONArray)localObject3, localClass));
              } else {
                a(k, (JSONArray)localObject3, paramClass.c, localObject2);
              }
              break;
            case 5: 
              localObject3 = paramJSONObject.optJSONObject(paramClass.a);
              if (localObject3 == null) {
                break label424;
              }
              paramClass.c.set(localObject2, a((JSONObject)localObject3, paramClass.c.getType()));
              break;
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
              a(paramClass.b, paramJSONObject, paramClass.a, paramClass.c, localObject2);
              break label424;
              paramJSONObject = new StringBuilder();
              paramJSONObject.append("un-support type : ");
              paramJSONObject.append(paramClass.b);
              throw new JsonORM.JsonParseException(paramJSONObject.toString());
            }
          }
          catch (IllegalAccessException paramJSONObject)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("access field failed : ");
            ((StringBuilder)localObject1).append(paramClass.c.getName());
            throw new JsonORM.JsonParseException(((StringBuilder)localObject1).toString(), paramJSONObject);
          }
        }
        return localObject2;
      }
      catch (Exception paramJSONObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("create class instance failed : ");
        ((StringBuilder)localObject1).append(paramClass.getName());
        throw new JsonORM.JsonParseException(((StringBuilder)localObject1).toString(), paramJSONObject);
      }
      paramJSONObject = new IllegalArgumentException("both jsonObject and clazz should not be null");
      for (;;)
      {
        throw paramJSONObject;
      }
      continue;
      label424:
      i += 1;
    }
  }
  
  public static JSONObject a(Object paramObject)
  {
    if (paramObject != null)
    {
      Class localClass = paramObject.getClass();
      Object localObject2 = (JsonORM.ColumnInfo[])a.get(localClass);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = b(localClass);
        a.put(localClass, localObject1);
      }
      localObject2 = new JSONObject();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localClass = localObject1[i];
        try
        {
          int k = localClass.b;
          Object localObject3;
          if (k != 0)
          {
            if (k != 1)
            {
              if (k != 2)
              {
                if (k != 3)
                {
                  if (k != 4)
                  {
                    if (k == 5)
                    {
                      localObject3 = localClass.c.get(paramObject);
                      if (localObject3 != null) {
                        ((JSONObject)localObject2).put(localClass.a, a(localObject3));
                      }
                    }
                  }
                  else {
                    ((JSONObject)localObject2).put(localClass.a, localClass.c.getDouble(paramObject));
                  }
                }
                else {
                  ((JSONObject)localObject2).put(localClass.a, localClass.c.getLong(paramObject));
                }
              }
              else {
                ((JSONObject)localObject2).put(localClass.a, localClass.c.getInt(paramObject));
              }
            }
            else {
              ((JSONObject)localObject2).put(localClass.a, localClass.c.getBoolean(paramObject));
            }
          }
          else
          {
            localObject3 = localClass.c.get(paramObject);
            if (localObject3 != null) {
              ((JSONObject)localObject2).put(localClass.a, localObject3);
            }
          }
          i += 1;
        }
        catch (JSONException paramObject)
        {
          throw new JsonORM.JsonParseException("operate json object error", paramObject);
        }
        catch (IllegalAccessException paramObject)
        {
          throw new JsonORM.JsonParseException("access field failed", paramObject);
        }
      }
      return localObject2;
    }
    paramObject = new IllegalArgumentException("object should not be null");
    for (;;)
    {
      throw paramObject;
    }
  }
  
  private static void a(int paramInt, JSONArray paramJSONArray, Field paramField, Object paramObject)
  {
    int i1 = paramJSONArray.length();
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4)
            {
              localObject = new double[i1];
              paramInt = i;
              while (paramInt < i1)
              {
                localObject[paramInt] = paramJSONArray.optDouble(paramInt);
                paramInt += 1;
              }
              paramField.set(paramObject, localObject);
              return;
            }
            paramJSONArray = new StringBuilder();
            paramJSONArray.append("un-support array field type : ");
            paramJSONArray.append(paramInt);
            throw new JsonORM.JsonParseException(paramJSONArray.toString());
          }
          localObject = new long[i1];
          paramInt = j;
          while (paramInt < i1)
          {
            localObject[paramInt] = paramJSONArray.optLong(paramInt);
            paramInt += 1;
          }
          paramField.set(paramObject, localObject);
          return;
        }
        localObject = new int[i1];
        paramInt = k;
        while (paramInt < i1)
        {
          localObject[paramInt] = paramJSONArray.optInt(paramInt);
          paramInt += 1;
        }
        paramField.set(paramObject, localObject);
        return;
      }
      localObject = new boolean[i1];
      paramInt = m;
      while (paramInt < i1)
      {
        localObject[paramInt] = paramJSONArray.optBoolean(paramInt);
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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4)
            {
              paramField.set(paramObject, Double.valueOf(paramJSONObject.optDouble(paramString)));
              return;
            }
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("un-support field type : ");
            paramJSONObject.append(paramInt);
            throw new JsonORM.JsonParseException(paramJSONObject.toString());
          }
          paramField.set(paramObject, Long.valueOf(paramJSONObject.optLong(paramString)));
          return;
        }
        paramField.set(paramObject, Integer.valueOf(paramJSONObject.optInt(paramString)));
        return;
      }
      paramField.set(paramObject, Boolean.valueOf(paramJSONObject.optBoolean(paramString)));
      return;
    }
    paramField.set(paramObject, paramJSONObject.optString(paramString));
  }
  
  private static void a(Class<?> paramClass, ArrayList<JsonORM.ColumnInfo> paramArrayList)
  {
    paramClass = paramClass.getDeclaredFields();
    int i = 0;
    while (i != paramClass.length)
    {
      Field localField = paramClass[i];
      JsonORM.Column localColumn = (JsonORM.Column)localField.getAnnotation(JsonORM.Column.class);
      if (localColumn != null) {
        paramArrayList.add(new JsonORM.ColumnInfo(localColumn.a(), a(localField.getType()), localField));
      }
      i += 1;
    }
  }
  
  @NonNull
  public static <T> T[] a(JSONArray paramJSONArray, Class<T> paramClass)
  {
    if ((paramJSONArray != null) && (paramClass != null))
    {
      if (!paramClass.isPrimitive())
      {
        int j = paramJSONArray.length();
        Object[] arrayOfObject = (Object[])Array.newInstance(paramClass, j);
        int i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
          if (localJSONObject != null) {
            arrayOfObject[i] = a(localJSONObject, paramClass);
          } else {
            arrayOfObject[i] = null;
          }
          i += 1;
        }
        return arrayOfObject;
      }
      paramJSONArray = new StringBuilder();
      paramJSONArray.append("do not support primitive array field : ");
      paramJSONArray.append(paramClass);
      throw new JsonORM.JsonParseException(paramJSONArray.toString());
    }
    paramJSONArray = new IllegalArgumentException("both jsonArray and clazz should not be null");
    for (;;)
    {
      throw paramJSONArray;
    }
  }
  
  private static JsonORM.ColumnInfo[] b(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramClass != null)
    {
      a(paramClass, localArrayList);
      paramClass = paramClass.getSuperclass();
    }
    paramClass = new JsonORM.ColumnInfo[localArrayList.size()];
    localArrayList.toArray(paramClass);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.JsonORM
 * JD-Core Version:    0.7.0.1
 */