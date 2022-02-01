package com.huawei.updatesdk.a.b.d.a;

import android.util.Log;
import com.huawei.updatesdk.a.a.b.a.a.a;
import com.huawei.updatesdk.a.a.c.f;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class b
{
  private static final char COMMA = ',';
  private static final String END_FLAG = "_";
  private static final String TAG = b.class.getSimpleName();
  
  private String arrayToJson(Object paramObject)
  {
    int j = Array.getLength(paramObject);
    if (j <= 0) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int i = 0;
    while (i < j)
    {
      String str = valueToJson(Array.get(paramObject, i));
      if (str != null) {
        localStringBuilder.append(str).append(',');
      }
      i += 1;
    }
    formatJsonStr(localStringBuilder);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private void formatJsonStr(StringBuilder paramStringBuilder)
  {
    int i = paramStringBuilder.length();
    if ((i > 0) && (paramStringBuilder.charAt(i - 1) == ',')) {
      paramStringBuilder.delete(i - 1, i);
    }
  }
  
  private Object jsonBeanFromJson(Class paramClass, Object paramObject)
  {
    paramClass = (b)paramClass.newInstance();
    paramClass.fromJson((JSONObject)paramObject);
    return paramClass;
  }
  
  private String mapToJson(Map paramMap)
  {
    if (paramMap.size() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = valueToJson(((Map.Entry)localObject).getValue());
      if (localObject != null)
      {
        localStringBuilder.append("\"").append(str).append("\":");
        localStringBuilder.append((String)localObject);
      }
      if (!paramMap.hasNext()) {
        break;
      }
      if (localObject != null) {
        localStringBuilder.append(',');
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private void processValueError(Field paramField, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String))) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject = paramField.getType();
          if (((Class)localObject).isPrimitive())
          {
            localObject = ((Class)localObject).getName();
            if ("int".equals(localObject))
            {
              paramField.set(this, Integer.valueOf(Integer.parseInt((String)paramObject)));
              return;
            }
          }
        }
        catch (IllegalAccessException paramField)
        {
          a.d(TAG, "processValueError Throwable:" + paramField.getMessage());
          return;
        }
      }
      if ("float".equals(localObject))
      {
        paramField.set(this, Float.valueOf(Float.parseFloat((String)paramObject)));
        return;
      }
      if ("long".equals(localObject))
      {
        paramField.set(this, Long.valueOf(Long.parseLong((String)paramObject)));
        return;
      }
      if ("boolean".equals(localObject))
      {
        paramField.set(this, Boolean.valueOf(Boolean.parseBoolean((String)paramObject)));
        return;
      }
      if ("double".equals(localObject))
      {
        paramField.set(this, Double.valueOf(Double.parseDouble((String)paramObject)));
        return;
      }
      if ("short".equals(localObject))
      {
        paramField.set(this, Short.valueOf(Short.parseShort((String)paramObject)));
        return;
      }
      if ("byte".equals(localObject))
      {
        paramField.set(this, Byte.valueOf(Byte.parseByte((String)paramObject)));
        return;
      }
    } while (!"char".equals(localObject));
    paramField.set(this, Character.valueOf(((String)paramObject).charAt(0)));
  }
  
  private Object valueFromJson(Class paramClass1, Class paramClass2, Object paramObject)
  {
    if ((paramClass1.isPrimitive()) || (paramClass1.equals(String.class)))
    {
      paramClass2 = paramObject;
      if ("float".equals(paramClass1.getName()))
      {
        paramClass2 = paramObject;
        if ((paramObject instanceof Double)) {
          paramClass2 = Float.valueOf(((Double)paramObject).floatValue());
        }
      }
      return paramClass2;
    }
    if (List.class.isAssignableFrom(paramClass1)) {
      return listFromJson(paramClass2, paramObject);
    }
    if (b.class.isAssignableFrom(paramClass1))
    {
      if (paramClass1.equals(b.class)) {
        throw new IllegalArgumentException("error type, type:" + paramClass1);
      }
      return jsonBeanFromJson(paramClass1, paramObject);
    }
    if (Map.class.isAssignableFrom(paramClass1)) {
      return mapFromJson(paramClass2, paramObject);
    }
    throw new IllegalArgumentException("unsupport type, Type:" + paramClass1);
  }
  
  private String valueToJson(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      if ((paramObject instanceof String)) {
        return JSONObject.quote(paramObject.toString());
      }
      if (((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Float)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Character)) || ((paramObject instanceof Double)) || ((paramObject instanceof Short))) {
        return String.valueOf(paramObject);
      }
      if ((paramObject instanceof b)) {
        return ((b)paramObject).toJson();
      }
      if ((paramObject instanceof List)) {
        return listToJson((List)paramObject);
      }
      if ((paramObject instanceof Map)) {
        return mapToJson((Map)paramObject);
      }
    } while (!paramObject.getClass().isArray());
    return arrayToJson(paramObject);
  }
  
  public void fromJson(JSONObject paramJSONObject)
  {
    Field[] arrayOfField = f.a(getClass());
    Object localObject1 = null;
    int i = 0;
    if (i < arrayOfField.length)
    {
      AccessController.doPrivileged(new b.a(arrayOfField[i]));
      Object localObject2 = arrayOfField[i].getName();
      if (!((String)localObject2).endsWith("_")) {
        localObject2 = localObject1;
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        String str = ((String)localObject2).substring(0, ((String)localObject2).length() - "_".length());
        localObject2 = localObject1;
        if (paramJSONObject.has(str))
        {
          Object localObject4 = paramJSONObject.get(str);
          localObject2 = localObject1;
          if (!JSONObject.NULL.equals(localObject4)) {
            try
            {
              localObject2 = valueFromJson(arrayOfField[i].getType(), f.a(arrayOfField[i]), localObject4);
              localObject1 = localObject2;
              arrayOfField[i].set(this, localObject2);
            }
            catch (Exception localException)
            {
              Log.e(TAG, getClass().getName() + ".fromJson error, fieldName:" + str + localException.toString());
              processValueError(arrayOfField[i], localObject1);
              Object localObject3 = localObject1;
            }
          }
        }
      }
    }
  }
  
  protected Object listFromJson(Class paramClass, Object paramObject)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("generic type is null");
    }
    if (!(paramObject instanceof JSONArray)) {
      throw new IllegalArgumentException("jsonobject is not JSONArray, jsonValue:" + paramObject);
    }
    ArrayList localArrayList = new ArrayList();
    paramObject = (JSONArray)paramObject;
    int i = 0;
    if (i < paramObject.length())
    {
      Object localObject = valueFromJson(paramClass, null, paramObject.get(i));
      if (localObject != null)
      {
        if (!paramClass.equals(localObject.getClass())) {
          break label121;
        }
        localArrayList.add(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        label121:
        a.d(TAG, "listFromJson error, memberClass:" + paramClass + ", valueClass:" + localObject.getClass());
      }
    }
    return localArrayList;
  }
  
  protected String listToJson(List paramList)
  {
    if (paramList.size() <= 0) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int i = 0;
    while (i < paramList.size())
    {
      String str = valueToJson(paramList.get(i));
      if (str != null) {
        localStringBuilder.append(str).append(',');
      }
      i += 1;
    }
    formatJsonStr(localStringBuilder);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  protected Object mapFromJson(Class paramClass, Object paramObject)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("generic type is null");
    }
    if (!(paramObject instanceof JSONObject)) {
      throw new IllegalArgumentException("jsonobject is not JSONObject, jsonValue:" + paramObject);
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramObject = (JSONObject)paramObject;
    Iterator localIterator = paramObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = valueFromJson(paramClass, null, paramObject.get(str));
      if (localObject != null) {
        if (paramClass.equals(localObject.getClass())) {
          localLinkedHashMap.put(str, localObject);
        } else {
          a.d(TAG, "mapFromJson error, memberClass:" + paramClass + ", valueClass:" + localObject.getClass());
        }
      }
    }
    return localLinkedHashMap;
  }
  
  public String toJson()
  {
    Field[] arrayOfField = f.a(getClass());
    if (arrayOfField.length <= 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    int i = 0;
    if (i < arrayOfField.length)
    {
      AccessController.doPrivileged(new b.a(arrayOfField[i]));
      String str1 = arrayOfField[i].getName();
      if ((str1 == null) || (!str1.endsWith("_"))) {}
      for (;;)
      {
        i += 1;
        break;
        str1 = str1.substring(0, str1.length() - "_".length());
        String str2 = valueToJson(arrayOfField[i].get(this));
        if (str2 != null) {
          localStringBuilder.append("\"").append(str1).append("\":").append(str2).append(',');
        }
      }
    }
    formatJsonStr(localStringBuilder);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.b.d.a.b
 * JD-Core Version:    0.7.0.1
 */