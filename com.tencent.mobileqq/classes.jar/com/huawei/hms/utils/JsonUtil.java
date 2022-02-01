package com.huawei.hms.utils;

import android.text.TextUtils;
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
  private static final String BYTE_BYTE = "_byte_";
  private static final String LIST_FIELD_VALUE = "_value_";
  private static final String LIST_ITEM_VALUE = "_list_item_";
  private static final String LIST_SIZE = "_list_size_";
  private static final String MAP_MAP = "_map_";
  private static final String NEXT_ITEM = "_next_item_";
  private static final String PRE_PKG = "com.huawei";
  private static final String TAG = "JsonUtil";
  protected static final int VAL_BYTE = 2;
  protected static final int VAL_ENTITY = 0;
  protected static final int VAL_LIST = 1;
  protected static final int VAL_MAP = 3;
  protected static final int VAL_NULL = -1;
  protected static final String VAL_TYPE = "_val_type_";
  
  private static String createInnerJsonString(IMessageEntity paramIMessageEntity)
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
          setAccessible(localField, true);
          String str = localField.getName();
          Object localObject = localField.get(paramIMessageEntity);
          setAccessible(localField, bool);
          disposeType(str, localObject, localJSONObject);
        }
        i += 1;
      }
      localClass = localClass.getSuperclass();
    }
    return localJSONObject.toString();
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
      paramIMessageEntity = createInnerJsonString(paramIMessageEntity);
      return paramIMessageEntity;
    }
    catch (JSONException paramIMessageEntity)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("catch JSONException ");
      localStringBuilder.append(paramIMessageEntity.getMessage());
      HMSLog.e("JsonUtil", localStringBuilder.toString());
      return "";
    }
    catch (IllegalAccessException paramIMessageEntity)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("catch IllegalAccessException ");
      localStringBuilder.append(paramIMessageEntity.getMessage());
      HMSLog.e("JsonUtil", localStringBuilder.toString());
    }
    return "";
  }
  
  private static boolean disposeType(String paramString, Object paramObject, JSONObject paramJSONObject)
  {
    if ((paramObject instanceof String)) {
      paramJSONObject.put(paramString, (String)paramObject);
    } else if ((paramObject instanceof Integer)) {
      paramJSONObject.put(paramString, ((Integer)paramObject).intValue());
    } else if ((paramObject instanceof Short)) {
      paramJSONObject.put(paramString, (Short)paramObject);
    } else if ((paramObject instanceof Long)) {
      paramJSONObject.put(paramString, (Long)paramObject);
    } else if ((paramObject instanceof Float)) {
      paramJSONObject.put(paramString, (Float)paramObject);
    } else if ((paramObject instanceof Double)) {
      paramJSONObject.put(paramString, (Double)paramObject);
    } else if ((paramObject instanceof Boolean)) {
      paramJSONObject.put(paramString, (Boolean)paramObject);
    } else if ((paramObject instanceof JSONObject)) {
      paramJSONObject.put(paramString, (JSONObject)paramObject);
    } else if ((paramObject instanceof byte[])) {
      writeByte(paramString, (byte[])paramObject, paramJSONObject);
    } else if ((paramObject instanceof List)) {
      writeList(paramString, (List)paramObject, paramJSONObject);
    } else if ((paramObject instanceof Map)) {
      writeMap(paramString, (Map)paramObject, paramJSONObject);
    } else {
      if (!(paramObject instanceof IMessageEntity)) {
        break label273;
      }
    }
    try
    {
      paramJSONObject.put(paramString, createInnerJsonString((IMessageEntity)paramObject));
      return true;
    }
    catch (IllegalAccessException paramString)
    {
      paramObject = new StringBuilder();
      paramObject.append("IllegalAccessException , ");
      paramObject.append(paramString);
      HMSLog.e("JsonUtil", paramObject.toString());
    }
    label273:
    return false;
  }
  
  public static Object getInfoFromJsonobject(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
    }
    try
    {
      paramString1 = new JSONObject(paramString1);
      if (!paramString1.has(paramString2)) {
        return null;
      }
      paramString1 = paramString1.get(paramString2);
      boolean bool = paramString1 instanceof String;
      if (!bool) {
        break label82;
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      label52:
      break label52;
    }
    paramString1 = new StringBuilder();
    paramString1.append("getInfoFromJsonobject:parser json error :");
    paramString1.append(paramString2);
    HMSLog.e("JsonUtil", paramString1.toString());
    label82:
    return null;
  }
  
  public static int getIntValue(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      return paramJSONObject.getInt(paramString);
    }
    return -1;
  }
  
  private static Object getObjectValue(String paramString, JSONObject paramJSONObject)
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
  
  public static String getStringValue(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      return paramJSONObject.getString(paramString);
    }
    return null;
  }
  
  public static IMessageEntity jsonToEntity(String paramString, IMessageEntity paramIMessageEntity)
  {
    for (;;)
    {
      int i;
      try
      {
        localObject = paramIMessageEntity.getClass();
        localJSONObject = new JSONObject(paramString);
        paramString = (String)localObject;
        if (paramString != null)
        {
          localObject = paramString.getDeclaredFields();
          int j = localObject.length;
          i = 0;
          if (i < j)
          {
            localField = localObject[i];
            boolean bool = localField.isAnnotationPresent(Packed.class);
            if (!bool) {
              break label165;
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        JSONObject localJSONObject;
        Field localField;
        StringBuilder localStringBuilder;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("catch JSONException when parse jsonString");
        ((StringBuilder)localObject).append(paramString.getMessage());
        HMSLog.e("JsonUtil", ((StringBuilder)localObject).toString());
      }
      try
      {
        readFiled(paramIMessageEntity, localField, localJSONObject);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        continue;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("jsonToEntity, set value of the field exception, field name:");
      localStringBuilder.append(localField.getName());
      HMSLog.e("JsonUtil", localStringBuilder.toString());
      break label165;
      paramString = paramString.getSuperclass();
      continue;
      return paramIMessageEntity;
      label165:
      i += 1;
    }
  }
  
  private static byte[] readByte(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = Base64.decode(paramJSONObject.getString("_byte_"));
      return paramJSONObject;
    }
    catch (IllegalArgumentException paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readByte failed : ");
      localStringBuilder.append(paramJSONObject.getMessage());
      HMSLog.e("JsonUtil", localStringBuilder.toString());
    }
    return null;
  }
  
  private static void readFiled(IMessageEntity paramIMessageEntity, Field paramField, JSONObject paramJSONObject)
  {
    paramJSONObject = readJson(paramIMessageEntity, paramField, paramJSONObject);
    if (paramJSONObject != null)
    {
      boolean bool = paramField.isAccessible();
      setAccessible(paramField, true);
      paramField.set(paramIMessageEntity, paramJSONObject);
      setAccessible(paramField, bool);
    }
  }
  
  private static Object readJson(IMessageEntity paramIMessageEntity, Field paramField, JSONObject paramJSONObject)
  {
    paramIMessageEntity = getObjectValue(paramField.getName(), paramJSONObject);
    if (paramIMessageEntity != null) {}
    try
    {
      if ((paramField.getType().getName().startsWith("com.huawei")) && ((paramField.getType().newInstance() instanceof IMessageEntity))) {
        return jsonToEntity((String)paramIMessageEntity, (IMessageEntity)paramField.getType().newInstance());
      }
      if (((paramIMessageEntity instanceof JSONObject)) && (((JSONObject)paramIMessageEntity).has("_val_type_")))
      {
        int i = ((JSONObject)paramIMessageEntity).getInt("_val_type_");
        if ((i != 1) && (i != 0))
        {
          if (i == 2) {
            return readByte((JSONObject)paramIMessageEntity);
          }
          if (i == 3) {
            return readMap(paramField.getGenericType(), (JSONObject)paramIMessageEntity);
          }
          paramIMessageEntity = new StringBuilder();
          paramIMessageEntity.append("cannot support type : ");
          paramIMessageEntity.append(i);
          HMSLog.e("JsonUtil", paramIMessageEntity.toString());
          return null;
        }
        paramIMessageEntity = readList(paramField.getGenericType(), (JSONObject)paramIMessageEntity);
        return paramIMessageEntity;
      }
      return paramIMessageEntity;
    }
    catch (InstantiationException paramIMessageEntity)
    {
      label179:
      break label179;
    }
    HMSLog.e("JsonUtil", "InstantiationException  ");
    return null;
  }
  
  private static List<Object> readList(Type paramType, JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("_list_size_");
    int k = paramJSONObject.getInt("_val_type_");
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("_list_item_");
      ((StringBuilder)localObject1).append(i);
      localObject1 = paramJSONObject.get(((StringBuilder)localObject1).toString());
      if (k == 0)
      {
        Object localObject2 = ((Class)((java.lang.reflect.ParameterizedType)paramType).getActualTypeArguments()[0]).newInstance();
        localArrayList.add(jsonToEntity((String)localObject1, (IMessageEntity)localObject2));
      }
      else if (k == 1)
      {
        localArrayList.add(localObject1);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static Map readMap(Type paramType, JSONObject paramJSONObject)
  {
    paramType = (Class)((java.lang.reflect.ParameterizedType)paramType).getActualTypeArguments()[1];
    paramJSONObject = new JSONArray(paramJSONObject.getString("_map_"));
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramJSONObject.length())
    {
      if ((paramType.newInstance() instanceof IMessageEntity))
      {
        IMessageEntity localIMessageEntity = jsonToEntity(paramJSONObject.getString(i + 1), (IMessageEntity)paramType.newInstance());
        localHashMap.put(paramJSONObject.get(i), localIMessageEntity);
      }
      else
      {
        localHashMap.put(paramJSONObject.get(i), paramJSONObject.get(i + 1));
      }
      i += 2;
    }
    return localHashMap;
  }
  
  private static void setAccessible(Field paramField, boolean paramBoolean)
  {
    AccessController.doPrivileged(new JsonUtil.1(paramField, paramBoolean));
  }
  
  private static void writeByte(String paramString, byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("_val_type_", 2);
    try
    {
      localJSONObject.put("_byte_", Base64.encode(paramArrayOfByte));
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("writeByte failed : ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      HMSLog.e("JsonUtil", localStringBuilder.toString());
    }
    paramJSONObject.put(paramString, localJSONObject);
  }
  
  private static void writeList(String paramString, List<?> paramList, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("_val_type_", 1);
    localJSONObject.put("_list_size_", paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("_list_item_");
      localStringBuilder.append(i);
      disposeType(localStringBuilder.toString(), paramList.get(i), localJSONObject);
      if ((paramList.get(i) instanceof IMessageEntity)) {
        localJSONObject.put("_val_type_", 0);
      }
      i += 1;
    }
    paramJSONObject.put(paramString, localJSONObject);
  }
  
  private static void writeMap(String paramString, Map paramMap, JSONObject paramJSONObject)
  {
    Object localObject1 = paramMap.entrySet().iterator();
    paramMap = new JSONArray();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = ((Map.Entry)localObject3).getKey();
      localObject3 = ((Map.Entry)localObject3).getValue();
      if ((localObject2 instanceof IMessageEntity)) {
        paramMap.put(createInnerJsonString((IMessageEntity)localObject2));
      } else {
        paramMap.put(localObject2);
      }
      if ((localObject3 instanceof IMessageEntity)) {
        paramMap.put(createInnerJsonString((IMessageEntity)localObject3));
      } else {
        paramMap.put(localObject3);
      }
    }
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("_val_type_", 3);
    ((JSONObject)localObject1).put("_map_", paramMap.toString());
    paramJSONObject.put(paramString, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.utils.JsonUtil
 * JD-Core Version:    0.7.0.1
 */