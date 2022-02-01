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
    if (e(paramObject)) {
      return g(paramObject);
    }
    if (h(paramObject)) {
      return b((MessageMicro)paramObject);
    }
    if (b(paramObject)) {
      return ((PBBytesField)paramObject).get().toStringUtf8();
    }
    if (i(paramObject)) {
      return ((ByteStringMicro)paramObject).toStringUtf8();
    }
    if (c(paramObject)) {
      return a(((PBRepeatMessageField)paramObject).get());
    }
    if (d(paramObject)) {
      return b(((PBRepeatField)paramObject).get());
    }
    if (f(paramObject)) {
      return paramObject;
    }
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
    }
    paramField = paramField.get(paramObject);
    if (paramField == null)
    {
      QLog.e("Proto2JsonUtil", 1, "getValueFromField fValue is null");
      return null;
    }
    paramField = a(paramField);
    return paramField;
    return null;
  }
  
  public static String a(MessageMicro<?> paramMessageMicro)
  {
    paramMessageMicro = b(paramMessageMicro);
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
    catch (NoSuchFieldException paramClass)
    {
      label13:
      break label13;
    }
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
      localJSONArray.put(b((MessageMicro)paramList.next()));
    }
    return localJSONArray;
  }
  
  private static void a(JSONObject paramJSONObject, Object paramObject, String paramString)
  {
    try
    {
      boolean bool = paramObject instanceof PBUInt64Field;
      if ((!bool) && (!(paramObject instanceof PBFixed64Field)) && (!(paramObject instanceof PBSInt64Field)) && (!(paramObject instanceof PBSFixed64Field)) && (!(paramObject instanceof PBInt64Field)))
      {
        if ((!(paramObject instanceof PBUInt32Field)) && (!(paramObject instanceof PBFixed32Field)) && (!(paramObject instanceof PBInt32Field)) && (!(paramObject instanceof PBSInt32Field)) && (!(paramObject instanceof PBSFixed32Field)) && (!(paramObject instanceof PBEnumField)))
        {
          if ((paramObject instanceof PBDoubleField))
          {
            double d = paramJSONObject.optDouble(paramString);
            ((PBDoubleField)paramObject).set(d);
            return;
          }
          if ((paramObject instanceof PBFloatField))
          {
            float f = (float)paramJSONObject.optDouble(paramString);
            ((PBFloatField)paramObject).set(f);
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
            bool = paramJSONObject.optBoolean(paramString);
            ((PBBoolField)paramObject).set(bool);
          }
        }
        else
        {
          paramObject.getClass().getMethod("set", new Class[] { Integer.TYPE }).invoke(paramObject, new Object[] { Integer.valueOf(paramJSONObject.optInt(paramString)) });
        }
      }
      else
      {
        paramObject.getClass().getMethod("set", new Class[] { Long.TYPE }).invoke(paramObject, new Object[] { Long.valueOf(paramJSONObject.optLong(paramString)) });
        return;
      }
    }
    catch (InvocationTargetException paramJSONObject)
    {
      QLog.d("Proto2JsonUtil", 1, "fillBasicField InvocationTargetException ", paramJSONObject);
      return;
    }
    catch (IllegalAccessException paramJSONObject)
    {
      QLog.d("Proto2JsonUtil", 1, "fillBasicField IllegalAccessException ", paramJSONObject);
      return;
    }
    catch (NoSuchMethodException paramJSONObject)
    {
      QLog.d("Proto2JsonUtil", 1, "fillBasicField NoSuchMethodException ", paramJSONObject);
    }
  }
  
  private static void a(JSONObject paramJSONObject, Field paramField, Object paramObject)
  {
    try
    {
      paramObject = paramField.get(paramObject);
      paramField = paramField.getName();
      if (h(paramObject))
      {
        b(paramJSONObject, paramObject, paramField);
        return;
      }
      if (d(paramObject))
      {
        d(paramJSONObject, paramObject, paramField);
        return;
      }
      if (c(paramObject))
      {
        c(paramJSONObject, paramObject, paramField);
        return;
      }
      if (e(paramObject))
      {
        a(paramJSONObject, paramObject, paramField);
        return;
      }
      if (b(paramObject))
      {
        ((PBBytesField)paramObject).set(ByteStringMicro.copyFromUtf8(paramJSONObject.optString(paramField)));
        return;
      }
    }
    catch (IllegalAccessException paramJSONObject)
    {
      QLog.e("Proto2JsonUtil", 1, "fillField error : ", paramJSONObject);
    }
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
    try
    {
      Field[] arrayOfField = paramMessageMicro.getClass().getFields();
      if (arrayOfField.length == 0)
      {
        QLog.d("Proto2JsonUtil", 1, "proto2Json, pb fields length is 0");
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
    catch (Exception paramJSONObject)
    {
      QLog.e("Proto2JsonUtil", 1, "json2Pb JSONException : ", paramJSONObject);
    }
    return false;
  }
  
  private static JSONArray b(List<?> paramList)
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
      localJSONArray.put(a(paramList.next()));
    }
    return localJSONArray;
  }
  
  public static JSONObject b(MessageMicro<?> paramMessageMicro)
  {
    Field[] arrayOfField = paramMessageMicro.getClass().getFields();
    if (arrayOfField.length == 0)
    {
      QLog.d("Proto2JsonUtil", 1, "proto2Json, pb fields length is 0");
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
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
    }
    return null;
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
    return paramObject instanceof PBBytesField;
  }
  
  private static <T extends MessageMicro<T>> void c(JSONObject paramJSONObject, Object paramObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject != null)
    {
      if (paramJSONObject.length() == 0) {
        return;
      }
      paramObject = (PBRepeatMessageField)paramObject;
      paramString = a(PBRepeatMessageField.class, "helper");
      if (paramString == null) {
        return;
      }
    }
    label122:
    do
    {
      for (;;)
      {
        try
        {
          paramString = (Class)paramString.get(paramObject);
          i = 0;
          if (i >= paramJSONObject.length()) {
            break label122;
          }
          localJSONObject = paramJSONObject.optJSONObject(i);
          if (localJSONObject != null) {
            break;
          }
          return;
        }
        catch (InstantiationException paramJSONObject)
        {
          int i;
          JSONObject localJSONObject;
          MessageMicro localMessageMicro;
          QLog.d("Proto2JsonUtil", 1, "fillPBRepeatMessage InstantiationException : ", paramJSONObject);
          return;
        }
        catch (IllegalAccessException paramJSONObject)
        {
          QLog.d("Proto2JsonUtil", 1, "fillPBRepeatMessage IllegalAccessException : ", paramJSONObject);
        }
        localMessageMicro = (MessageMicro)paramString.newInstance();
        a(localJSONObject, localMessageMicro);
        paramObject.add(localMessageMicro);
        i += 1;
        continue;
        return;
      }
    } while (paramString != null);
  }
  
  private static boolean c(Object paramObject)
  {
    return paramObject instanceof PBRepeatMessageField;
  }
  
  private static <T> void d(JSONObject paramJSONObject, Object paramObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject != null)
    {
      if (paramJSONObject.length() == 0) {
        return;
      }
      paramObject = (PBRepeatField)paramObject;
      int i = 0;
      while (i < paramJSONObject.length())
      {
        paramString = paramJSONObject.opt(i);
        if (paramString == null) {
          return;
        }
        paramObject.add(paramString);
        i += 1;
      }
    }
  }
  
  private static boolean d(Object paramObject)
  {
    return paramObject instanceof PBRepeatField;
  }
  
  private static boolean e(Object paramObject)
  {
    boolean bool1 = paramObject instanceof PBPrimitiveField;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (!(paramObject instanceof MessageMicro))
    {
      bool1 = bool2;
      if (!(paramObject instanceof PBBytesField)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean f(Object paramObject)
  {
    return ((paramObject instanceof String)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Long)) || ((paramObject instanceof Float)) || ((paramObject instanceof Double)) || ((paramObject instanceof Character));
  }
  
  private static Object g(Object paramObject)
  {
    try
    {
      Object localObject = paramObject.getClass().getMethod("get", new Class[0]).invoke(paramObject, new Object[0]);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      QLog.e("Proto2JsonUtil", 1, new Object[] { "fValue ", paramObject, " getBasicPbValue InvocationTargetException ", localInvocationTargetException });
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      QLog.e("Proto2JsonUtil", 1, new Object[] { "fValue ", paramObject, " getBasicPbValue IllegalAccessException ", localIllegalAccessException });
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      QLog.e("Proto2JsonUtil", 1, new Object[] { "fValue ", paramObject, " getBasicPbValue NoSuchMethodException ", localNoSuchMethodException });
    }
    return null;
  }
  
  private static boolean h(Object paramObject)
  {
    return paramObject instanceof MessageMicro;
  }
  
  private static boolean i(Object paramObject)
  {
    return paramObject instanceof ByteStringMicro;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.Proto2JsonUtil
 * JD-Core Version:    0.7.0.1
 */