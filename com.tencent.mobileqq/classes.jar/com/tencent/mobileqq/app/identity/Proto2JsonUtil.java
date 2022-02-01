package com.tencent.mobileqq.app.identity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFixed64Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBPrimitiveField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSFixed32Field;
import com.tencent.mobileqq.pb.PBSFixed64Field;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBSInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Proto2JsonUtil
{
  private static Object a(Object paramObject)
  {
    Object localObject;
    if (d(paramObject)) {
      localObject = b(paramObject);
    }
    do
    {
      return localObject;
      if (f(paramObject)) {
        return a((MessageMicro)paramObject);
      }
      if (a(paramObject)) {
        return ((PBBytesField)paramObject).get().toStringUtf8();
      }
      if (g(paramObject)) {
        return ((ByteStringMicro)paramObject).toStringUtf8();
      }
      if (b(paramObject)) {
        return a(((PBRepeatMessageField)paramObject).get());
      }
      if (c(paramObject)) {
        return b(((PBRepeatField)paramObject).get());
      }
      localObject = paramObject;
    } while (e(paramObject));
    return null;
  }
  
  private static Object a(Field paramField, Object paramObject)
  {
    if (paramField == null) {}
    try
    {
      QLog.e("Proto2JsonUtil", 1, "getValueFromField f is null");
      return null;
    }
    catch (IllegalAccessException paramField)
    {
      QLog.e("Proto2JsonUtil", 1, "getValueFromField IllegalAccessException, ", paramField);
      return null;
    }
    paramField = paramField.get(paramObject);
    if (paramField == null)
    {
      QLog.e("Proto2JsonUtil", 1, "getValueFromField fValue is null");
      return null;
    }
    paramField = a(paramField);
    return paramField;
  }
  
  public static String a(MessageMicro<?> paramMessageMicro)
  {
    paramMessageMicro = a(paramMessageMicro);
    if (paramMessageMicro == null) {
      return null;
    }
    return paramMessageMicro.toString();
  }
  
  private static Field a(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass) {}
    return null;
  }
  
  private static JSONArray a(List<? extends MessageMicro<?>> paramList)
  {
    if (paramList == null)
    {
      QLog.e("Proto2JsonUtil", 1, "protoList2String, list is null");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    if (paramList.size() == 0) {
      return localJSONArray;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put(a((MessageMicro)paramList.next()));
    }
    return localJSONArray;
  }
  
  public static JSONObject a(MessageMicro<?> paramMessageMicro)
  {
    Field[] arrayOfField = paramMessageMicro.getClass().getFields();
    if (arrayOfField.length == 0)
    {
      QLog.d("Proto2JsonUtil", 1, "proto2Json, pb fields length is 0");
      return null;
    }
    localJSONObject = new JSONObject();
    try
    {
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        localJSONObject.put(localField.getName(), a(localField, paramMessageMicro));
        i += 1;
      }
      return localJSONObject;
    }
    catch (JSONException paramMessageMicro)
    {
      QLog.d("Proto2JsonUtil", 1, "proto2Json error : ", paramMessageMicro);
      return null;
    }
  }
  
  private static void a(JSONObject paramJSONObject, Object paramObject, String paramString)
  {
    try
    {
      if (((paramObject instanceof PBUInt64Field)) || ((paramObject instanceof PBFixed64Field)) || ((paramObject instanceof PBSInt64Field)) || ((paramObject instanceof PBSFixed64Field)) || ((paramObject instanceof PBInt64Field)))
      {
        paramObject.getClass().getMethod("set", new Class[] { Long.TYPE }).invoke(paramObject, new Object[] { Long.valueOf(paramJSONObject.optLong(paramString)) });
        return;
      }
      if (((paramObject instanceof PBUInt32Field)) || ((paramObject instanceof PBFixed32Field)) || ((paramObject instanceof PBInt32Field)) || ((paramObject instanceof PBSInt32Field)) || ((paramObject instanceof PBSFixed32Field)) || ((paramObject instanceof PBEnumField)))
      {
        paramObject.getClass().getMethod("set", new Class[] { Integer.TYPE }).invoke(paramObject, new Object[] { Integer.valueOf(paramJSONObject.optInt(paramString)) });
        return;
      }
    }
    catch (NoSuchMethodException paramJSONObject)
    {
      QLog.d("Proto2JsonUtil", 1, "fillBasicField NoSuchMethodException ", paramJSONObject);
      return;
      if ((paramObject instanceof PBDoubleField))
      {
        double d = paramJSONObject.optDouble(paramString);
        ((PBDoubleField)paramObject).set(d);
        return;
      }
    }
    catch (IllegalAccessException paramJSONObject)
    {
      QLog.d("Proto2JsonUtil", 1, "fillBasicField IllegalAccessException ", paramJSONObject);
      return;
      if ((paramObject instanceof PBFloatField))
      {
        float f = (float)paramJSONObject.optDouble(paramString);
        ((PBFloatField)paramObject).set(f);
        return;
      }
    }
    catch (InvocationTargetException paramJSONObject)
    {
      QLog.d("Proto2JsonUtil", 1, "fillBasicField InvocationTargetException ", paramJSONObject);
      return;
    }
    if ((paramObject instanceof PBStringField))
    {
      paramJSONObject = paramJSONObject.optString(paramString);
      ((PBStringField)paramObject).set(paramJSONObject);
      return;
    }
    if ((paramObject instanceof PBBoolField))
    {
      boolean bool = paramJSONObject.optBoolean(paramString);
      ((PBBoolField)paramObject).set(bool);
    }
  }
  
  private static void a(JSONObject paramJSONObject, Field paramField, Object paramObject)
  {
    try
    {
      paramObject = paramField.get(paramObject);
      paramField = paramField.getName();
      if (f(paramObject))
      {
        b(paramJSONObject, paramObject, paramField);
        return;
      }
      if (c(paramObject))
      {
        d(paramJSONObject, paramObject, paramField);
        return;
      }
    }
    catch (IllegalAccessException paramJSONObject)
    {
      QLog.e("Proto2JsonUtil", 1, "fillField error : ", paramJSONObject);
      return;
    }
    if (b(paramObject))
    {
      c(paramJSONObject, paramObject, paramField);
      return;
    }
    if (d(paramObject))
    {
      a(paramJSONObject, paramObject, paramField);
      return;
    }
    if (a(paramObject)) {
      ((PBBytesField)paramObject).set(ByteStringMicro.copyFromUtf8(paramJSONObject.optString(paramField)));
    }
  }
  
  private static boolean a(Object paramObject)
  {
    return paramObject instanceof PBBytesField;
  }
  
  public static boolean a(String paramString, MessageMicro<?> paramMessageMicro)
  {
    try
    {
      boolean bool = a(new JSONObject(paramString), paramMessageMicro);
      return bool;
    }
    catch (JSONException paramString)
    {
      QLog.e("Proto2JsonUtil", 1, "json2Pb JSONException : ", paramString);
    }
    return false;
  }
  
  public static boolean a(JSONObject paramJSONObject, MessageMicro<?> paramMessageMicro)
  {
    if (paramJSONObject == null)
    {
      QLog.e("Proto2JsonUtil", 1, "jsonObj2Pb json obj is null");
      return false;
    }
    Field[] arrayOfField;
    try
    {
      arrayOfField = paramMessageMicro.getClass().getFields();
      if (arrayOfField.length == 0)
      {
        QLog.d("Proto2JsonUtil", 1, "proto2Json, pb fields length is 0");
        return false;
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("Proto2JsonUtil", 1, "json2Pb JSONException : ", paramJSONObject);
      return false;
    }
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      a(paramJSONObject, arrayOfField[i], paramMessageMicro);
      i += 1;
    }
    return true;
  }
  
  private static Object b(Object paramObject)
  {
    try
    {
      Object localObject = paramObject.getClass().getMethod("get", new Class[0]).invoke(paramObject, new Object[0]);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      QLog.e("Proto2JsonUtil", 1, new Object[] { "fValue ", paramObject, " getBasicPbValue NoSuchMethodException ", localNoSuchMethodException });
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      QLog.e("Proto2JsonUtil", 1, new Object[] { "fValue ", paramObject, " getBasicPbValue IllegalAccessException ", localIllegalAccessException });
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      QLog.e("Proto2JsonUtil", 1, new Object[] { "fValue ", paramObject, " getBasicPbValue InvocationTargetException ", localInvocationTargetException });
    }
    return null;
  }
  
  private static JSONArray b(List<?> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      QLog.e("Proto2JsonUtil", 1, "protoList2String, list is null");
      localObject = null;
    }
    JSONArray localJSONArray;
    do
    {
      return localObject;
      localJSONArray = new JSONArray();
      localObject = localJSONArray;
    } while (paramList.size() == 0);
    paramList = paramList.iterator();
    for (;;)
    {
      localObject = localJSONArray;
      if (!paramList.hasNext()) {
        break;
      }
      localJSONArray.put(a(paramList.next()));
    }
  }
  
  private static void b(JSONObject paramJSONObject, Object paramObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONObject(paramString);
    if (paramJSONObject == null) {
      return;
    }
    a(paramJSONObject, (MessageMicro)paramObject);
  }
  
  private static boolean b(Object paramObject)
  {
    return paramObject instanceof PBRepeatMessageField;
  }
  
  private static <T extends MessageMicro<T>> void c(JSONObject paramJSONObject, Object paramObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {}
    for (;;)
    {
      return;
      paramObject = (PBRepeatMessageField)paramObject;
      paramString = a(PBRepeatMessageField.class, "helper");
      if (paramString == null) {
        continue;
      }
      try
      {
        paramString = (Class)paramString.get(paramObject);
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
          if ((localJSONObject == null) || (paramString == null)) {
            break;
          }
          MessageMicro localMessageMicro = (MessageMicro)paramString.newInstance();
          a(localJSONObject, localMessageMicro);
          paramObject.add(localMessageMicro);
          i += 1;
        }
        return;
      }
      catch (IllegalAccessException paramJSONObject)
      {
        QLog.d("Proto2JsonUtil", 1, "fillPBRepeatMessage IllegalAccessException : ", paramJSONObject);
        return;
      }
      catch (InstantiationException paramJSONObject)
      {
        QLog.d("Proto2JsonUtil", 1, "fillPBRepeatMessage InstantiationException : ", paramJSONObject);
      }
    }
  }
  
  private static boolean c(Object paramObject)
  {
    return paramObject instanceof PBRepeatField;
  }
  
  private static <T> void d(JSONObject paramJSONObject, Object paramObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {}
    label53:
    for (;;)
    {
      return;
      paramObject = (PBRepeatField)paramObject;
      int i = 0;
      for (;;)
      {
        if (i >= paramJSONObject.length()) {
          break label53;
        }
        paramString = paramJSONObject.opt(i);
        if (paramString == null) {
          break;
        }
        paramObject.add(paramString);
        i += 1;
      }
    }
  }
  
  private static boolean d(Object paramObject)
  {
    if (!(paramObject instanceof PBPrimitiveField)) {}
    while (((paramObject instanceof MessageMicro)) || ((paramObject instanceof PBBytesField))) {
      return false;
    }
    return true;
  }
  
  private static boolean e(Object paramObject)
  {
    return ((paramObject instanceof String)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Long)) || ((paramObject instanceof Float)) || ((paramObject instanceof Double)) || ((paramObject instanceof Character));
  }
  
  private static boolean f(Object paramObject)
  {
    return paramObject instanceof MessageMicro;
  }
  
  private static boolean g(Object paramObject)
  {
    return paramObject instanceof ByteStringMicro;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.Proto2JsonUtil
 * JD-Core Version:    0.7.0.1
 */