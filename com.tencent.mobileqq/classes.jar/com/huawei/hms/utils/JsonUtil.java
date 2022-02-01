package com.huawei.hms.utils;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil
{
  protected static final int VAL_BYTE = 2;
  protected static final int VAL_ENTITY = 0;
  protected static final int VAL_LIST = 1;
  protected static final int VAL_MAP = 3;
  protected static final int VAL_NULL = -1;
  protected static final String VAL_TYPE = "_val_type_";
  
  private static Object a(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has(paramString)) {
      return paramJSONObject.get(paramString);
    }
    if ((paramJSONObject.has("header")) && (paramJSONObject.getJSONObject("header").has(paramString))) {
      return paramJSONObject.getJSONObject("header").get(paramString);
    }
    if ((paramJSONObject.has("body")) && (paramJSONObject.getJSONObject("body").has(paramString))) {
      return paramJSONObject.getJSONObject("body").get(paramString);
    }
    return null;
  }
  
  private static String a(IMessageEntity paramIMessageEntity)
  {
    Class localClass = paramIMessageEntity.getClass();
    JSONObject localJSONObject = new JSONObject();
    while (localClass != null)
    {
      Field[] arrayOfField = localClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        if (localField.isAnnotationPresent(Packed.class))
        {
          boolean bool = localField.isAccessible();
          a(localField, true);
          String str = localField.getName();
          Object localObject = localField.get(paramIMessageEntity);
          a(localField, bool);
          a(str, localObject, localJSONObject);
        }
        i += 1;
      }
      localClass = localClass.getSuperclass();
    }
    return localJSONObject.toString();
  }
  
  private static Map a(Type paramType, JSONObject paramJSONObject)
  {
    paramType = (Class)((java.lang.reflect.ParameterizedType)paramType).getActualTypeArguments()[1];
    paramJSONObject = new JSONArray(paramJSONObject.getString("_map_"));
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < paramJSONObject.length())
    {
      if ((paramType.newInstance() instanceof IMessageEntity))
      {
        IMessageEntity localIMessageEntity = jsonToEntity(paramJSONObject.getString(i + 1), (IMessageEntity)paramType.newInstance());
        localHashMap.put(paramJSONObject.get(i), localIMessageEntity);
      }
      for (;;)
      {
        i += 2;
        break;
        localHashMap.put(paramJSONObject.get(i), paramJSONObject.get(i + 1));
      }
    }
    return localHashMap;
  }
  
  private static void a(IMessageEntity paramIMessageEntity, Field paramField, JSONObject paramJSONObject)
  {
    paramJSONObject = b(paramIMessageEntity, paramField, paramJSONObject);
    if (paramJSONObject != null)
    {
      boolean bool = paramField.isAccessible();
      a(paramField, true);
      paramField.set(paramIMessageEntity, paramJSONObject);
      a(paramField, bool);
    }
  }
  
  private static void a(String paramString, List<?> paramList, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("_val_type_", 1);
    localJSONObject.put("_list_size_", paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      a("_list_item_" + i, paramList.get(i), localJSONObject);
      if ((paramList.get(i) instanceof IMessageEntity)) {
        localJSONObject.put("_val_type_", 0);
      }
      i += 1;
    }
    paramJSONObject.put(paramString, localJSONObject);
  }
  
  private static void a(String paramString, Map paramMap, JSONObject paramJSONObject)
  {
    Object localObject1 = paramMap.entrySet().iterator();
    paramMap = new JSONArray();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = ((Map.Entry)localObject3).getKey();
      localObject3 = ((Map.Entry)localObject3).getValue();
      if ((localObject2 instanceof IMessageEntity)) {
        paramMap.put(a((IMessageEntity)localObject2));
      }
      for (;;)
      {
        if (!(localObject3 instanceof IMessageEntity)) {
          break label113;
        }
        paramMap.put(a((IMessageEntity)localObject3));
        break;
        paramMap.put(localObject2);
      }
      label113:
      paramMap.put(localObject3);
    }
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("_val_type_", 3);
    ((JSONObject)localObject1).put("_map_", paramMap.toString());
    paramJSONObject.put(paramString, localObject1);
  }
  
  private static void a(String paramString, byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("_val_type_", 2);
    try
    {
      localJSONObject.put("_byte_", Base64.encode(paramArrayOfByte));
      paramJSONObject.put(paramString, localJSONObject);
      return;
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      for (;;)
      {
        HMSLog.e("JsonUtil", "writeByte failed : " + paramArrayOfByte.getMessage());
      }
    }
  }
  
  private static void a(Field paramField, boolean paramBoolean)
  {
    AccessController.doPrivileged(new JsonUtil.1(paramField, paramBoolean));
  }
  
  private static boolean a(String paramString, Object paramObject, JSONObject paramJSONObject)
  {
    boolean bool = false;
    if ((paramObject instanceof String)) {
      paramJSONObject.put(paramString, (String)paramObject);
    }
    for (;;)
    {
      bool = true;
      do
      {
        return bool;
        if ((paramObject instanceof Integer))
        {
          paramJSONObject.put(paramString, ((Integer)paramObject).intValue());
          break;
        }
        if ((paramObject instanceof Short))
        {
          paramJSONObject.put(paramString, (Short)paramObject);
          break;
        }
        if ((paramObject instanceof Long))
        {
          paramJSONObject.put(paramString, (Long)paramObject);
          break;
        }
        if ((paramObject instanceof Float))
        {
          paramJSONObject.put(paramString, (Float)paramObject);
          break;
        }
        if ((paramObject instanceof Double))
        {
          paramJSONObject.put(paramString, (Double)paramObject);
          break;
        }
        if ((paramObject instanceof Boolean))
        {
          paramJSONObject.put(paramString, (Boolean)paramObject);
          break;
        }
        if ((paramObject instanceof JSONObject))
        {
          paramJSONObject.put(paramString, (JSONObject)paramObject);
          break;
        }
        if ((paramObject instanceof byte[]))
        {
          a(paramString, (byte[])paramObject, paramJSONObject);
          break;
        }
        if ((paramObject instanceof List))
        {
          a(paramString, (List)paramObject, paramJSONObject);
          break;
        }
        if ((paramObject instanceof Map))
        {
          a(paramString, (Map)paramObject, paramJSONObject);
          break;
        }
      } while (!(paramObject instanceof IMessageEntity));
      try
      {
        paramJSONObject.put(paramString, a((IMessageEntity)paramObject));
      }
      catch (IllegalAccessException paramString)
      {
        HMSLog.e("JsonUtil", "IllegalAccessException , " + paramString);
      }
    }
    return false;
  }
  
  private static byte[] a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = Base64.decode(paramJSONObject.getString("_byte_"));
      return paramJSONObject;
    }
    catch (IllegalArgumentException paramJSONObject)
    {
      HMSLog.e("JsonUtil", "readByte failed : " + paramJSONObject.getMessage());
    }
    return null;
  }
  
  private static Object b(IMessageEntity paramIMessageEntity, Field paramField, JSONObject paramJSONObject)
  {
    paramJSONObject = a(paramField.getName(), paramJSONObject);
    if (paramJSONObject != null) {}
    try
    {
      if ((paramField.getType().getName().startsWith("com.huawei")) && ((paramField.getType().newInstance() instanceof IMessageEntity))) {
        return jsonToEntity((String)paramJSONObject, (IMessageEntity)paramField.getType().newInstance());
      }
      paramIMessageEntity = paramJSONObject;
      if ((paramJSONObject instanceof JSONObject))
      {
        paramIMessageEntity = paramJSONObject;
        if (((JSONObject)paramJSONObject).has("_val_type_"))
        {
          int i = ((JSONObject)paramJSONObject).getInt("_val_type_");
          if ((i == 1) || (i == 0)) {
            return b(paramField.getGenericType(), (JSONObject)paramJSONObject);
          }
          if (i == 2) {
            return a((JSONObject)paramJSONObject);
          }
          if (i == 3) {
            return a(paramField.getGenericType(), (JSONObject)paramJSONObject);
          }
          HMSLog.e("JsonUtil", "cannot support type : " + i);
          return null;
        }
      }
    }
    catch (InstantiationException paramIMessageEntity)
    {
      HMSLog.e("JsonUtil", "InstantiationException  ");
      paramIMessageEntity = null;
    }
    return paramIMessageEntity;
  }
  
  private static List<Object> b(Type paramType, JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("_list_size_");
    int k = paramJSONObject.getInt("_val_type_");
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    if (i < j)
    {
      Object localObject1 = paramJSONObject.get("_list_item_" + i);
      if (k == 0)
      {
        Object localObject2 = ((Class)((java.lang.reflect.ParameterizedType)paramType).getActualTypeArguments()[0]).newInstance();
        localArrayList.add(jsonToEntity((String)localObject1, (IMessageEntity)localObject2));
      }
      for (;;)
      {
        i += 1;
        break;
        if (k == 1) {
          localArrayList.add(localObject1);
        }
      }
    }
    return localArrayList;
  }
  
  public static String createJsonString(IMessageEntity paramIMessageEntity)
  {
    if (paramIMessageEntity == null)
    {
      HMSLog.e("JsonUtil", "createJsonString error, the input IMessageEntity is null");
      return "";
    }
    try
    {
      paramIMessageEntity = a(paramIMessageEntity);
      return paramIMessageEntity;
    }
    catch (IllegalAccessException paramIMessageEntity)
    {
      HMSLog.e("JsonUtil", "catch IllegalAccessException " + paramIMessageEntity.getMessage());
      return "";
    }
    catch (JSONException paramIMessageEntity)
    {
      for (;;)
      {
        HMSLog.e("JsonUtil", "catch JSONException " + paramIMessageEntity.getMessage());
      }
    }
  }
  
  public static Object getInfoFromJsonobject(String paramString1, String paramString2)
  {
    if ((paramString1.isEmpty()) || (paramString2.isEmpty())) {}
    for (;;)
    {
      return null;
      try
      {
        paramString1 = new JSONObject(paramString1);
        if (paramString1.has(paramString2))
        {
          paramString1 = paramString1.get(paramString2);
          boolean bool = paramString1 instanceof String;
          if (bool) {
            return paramString1;
          }
        }
      }
      catch (JSONException paramString1)
      {
        HMSLog.e("JsonUtil", "getInfoFromJsonobject:parser json error :" + paramString2);
      }
    }
    return null;
  }
  
  public static int getIntValue(JSONObject paramJSONObject, String paramString)
  {
    int j = -1;
    int i = j;
    if (paramJSONObject != null)
    {
      i = j;
      if (paramJSONObject.has(paramString)) {
        i = paramJSONObject.getInt(paramString);
      }
    }
    return i;
  }
  
  public static String getStringValue(JSONObject paramJSONObject, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramJSONObject != null)
    {
      localObject1 = localObject2;
      if (paramJSONObject.has(paramString)) {
        localObject1 = paramJSONObject.getString(paramString);
      }
    }
    return localObject1;
  }
  
  public static IMessageEntity jsonToEntity(String paramString, IMessageEntity paramIMessageEntity)
  {
    for (;;)
    {
      try
      {
        Object localObject = paramIMessageEntity.getClass();
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = (String)localObject;
        if (paramString != null)
        {
          localObject = paramString.getDeclaredFields();
          int j = localObject.length;
          int i = 0;
          if (i < j)
          {
            Field localField = localObject[i];
            boolean bool = localField.isAnnotationPresent(Packed.class);
            if (bool) {}
            try
            {
              a(paramIMessageEntity, localField, localJSONObject);
              i += 1;
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              HMSLog.e("JsonUtil", "jsonToEntity, set value of the field exception, field name:" + localField.getName());
              continue;
            }
          }
        }
        else
        {
          return paramIMessageEntity;
        }
      }
      catch (JSONException paramString)
      {
        HMSLog.e("JsonUtil", "catch JSONException when parse jsonString" + paramString.getMessage());
      }
      paramString = paramString.getSuperclass();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.utils.JsonUtil
 * JD-Core Version:    0.7.0.1
 */