package com.tencent.gdtad.json;

import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GdtJsonPbUtil
{
  private static MessageMicro a(MessageMicro paramMessageMicro, JSONObject paramJSONObject)
  {
    if ((paramMessageMicro != null) && (d(paramMessageMicro.getClass())) && (paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject))) {
      try
      {
        paramMessageMicro = paramMessageMicro.getClass().newInstance();
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          Object localObject2 = (String)String.class.cast(localIterator.next());
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            GdtLog.d("GdtJsonPbUtil", "pbMessageFromJsonObject error");
          } else {
            try
            {
              Object localObject1 = paramJSONObject.get((String)localObject2);
              if ((localObject1 != null) && (!JSONObject.NULL.equals(localObject1))) {
                try
                {
                  Field localField = paramMessageMicro.getClass().getDeclaredField((String)localObject2);
                  boolean bool = localField.isAccessible();
                  localField.setAccessible(true);
                  localObject2 = localField.get(paramMessageMicro);
                  localField.setAccessible(bool);
                  if (!(localObject2 instanceof PBField))
                  {
                    GdtLog.d("GdtJsonPbUtil", "pbMessageFromJsonObject error");
                  }
                  else
                  {
                    localObject1 = a((PBField)PBField.class.cast(localObject2), localObject1);
                    if (localObject1 == null) {
                      GdtLog.d("GdtJsonPbUtil", "pbMessageFromJsonObject error");
                    } else {
                      a(localObject2, a(localObject1), a(localObject2.getClass()));
                    }
                  }
                }
                catch (IllegalAccessException localIllegalAccessException)
                {
                  GdtLog.d("GdtJsonPbUtil", "pbMessageFromJsonObject", localIllegalAccessException);
                }
                catch (NoSuchFieldException localNoSuchFieldException)
                {
                  GdtLog.d("GdtJsonPbUtil", "pbMessageFromJsonObject", localNoSuchFieldException);
                }
              }
            }
            catch (JSONException localJSONException)
            {
              GdtLog.d("GdtJsonPbUtil", "pbMessageFromJsonObject", localJSONException);
            }
          }
        }
        if ((paramMessageMicro instanceof MessageMicro)) {
          return (MessageMicro)MessageMicro.class.cast(paramMessageMicro);
        }
        GdtLog.d("GdtJsonPbUtil", "pbMessageFromJsonObject error");
        return null;
      }
      catch (IllegalAccessException paramMessageMicro)
      {
        GdtLog.d("GdtJsonPbUtil", "pbMessageFromJsonObject", paramMessageMicro);
        return null;
      }
      catch (InstantiationException paramMessageMicro)
      {
        GdtLog.d("GdtJsonPbUtil", "pbMessageFromJsonObject", paramMessageMicro);
        return null;
      }
    }
    GdtLog.d("GdtJsonPbUtil", "pbFromJsonPrimitive error");
    return null;
  }
  
  public static PBField a(PBField paramPBField, Object paramObject)
  {
    if ((paramPBField != null) && (paramPBField.getClass() != PBBytesField.class) && (paramObject != null) && (!JSONObject.NULL.equals(paramObject)))
    {
      if (b(paramPBField.getClass())) {
        return a((PBPrimitiveField)PBPrimitiveField.class.cast(paramPBField), paramObject);
      }
      if ((c(paramPBField.getClass())) && ((paramObject instanceof JSONArray))) {
        return a(paramPBField, (JSONArray)JSONArray.class.cast(paramObject));
      }
      if ((d(paramPBField.getClass())) && ((paramObject instanceof JSONObject))) {
        return a((MessageMicro)MessageMicro.class.cast(paramPBField), (JSONObject)JSONObject.class.cast(paramObject));
      }
      GdtLog.d("GdtJsonPbUtil", "pbFromJson error");
      return null;
    }
    GdtLog.d("GdtJsonPbUtil", "pbFromJson error");
    return null;
  }
  
  private static PBField a(PBField paramPBField, JSONArray paramJSONArray)
  {
    if ((paramPBField != null) && (paramJSONArray != null) && (!JSONObject.NULL.equals(paramJSONArray)))
    {
      try
      {
        Field localField = paramPBField.getClass().getDeclaredField("helper");
        boolean bool = localField.isAccessible();
        localField.setAccessible(true);
        paramPBField = localField.get(paramPBField);
        try
        {
          localField.setAccessible(bool);
        }
        catch (IllegalAccessException localIllegalAccessException1) {}catch (NoSuchFieldException localNoSuchFieldException1) {}
        GdtLog.d("GdtJsonPbUtil", "getClassOfPBArray", localNoSuchFieldException2);
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        paramPBField = null;
        GdtLog.d("GdtJsonPbUtil", "getClassOfPBArray", localIllegalAccessException2);
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        paramPBField = null;
      }
      if ((paramPBField instanceof PBField))
      {
        paramPBField = (PBField)PBField.class.cast(paramPBField);
      }
      else
      {
        if (((paramPBField instanceof Class)) && (((Class)paramPBField).getSuperclass() == MessageMicro.class))
        {
          try
          {
            paramPBField = ((Class)Class.class.cast(paramPBField)).newInstance();
          }
          catch (IllegalAccessException paramPBField)
          {
            GdtLog.d("GdtJsonPbUtil", "getClassOfPBArray", paramPBField);
          }
          catch (InstantiationException paramPBField)
          {
            GdtLog.d("GdtJsonPbUtil", "getClassOfPBArray", paramPBField);
          }
          paramPBField = null;
          if ((paramPBField instanceof MessageMicro))
          {
            paramPBField = (PBField)MessageMicro.class.cast(paramPBField);
            break label199;
          }
        }
        paramPBField = null;
      }
      label199:
      if (paramPBField == null)
      {
        GdtLog.d("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
        return null;
      }
      if (b(paramPBField.getClass()))
      {
        try
        {
          Object localObject1 = paramPBField.getClass().getField("__repeatHelper__").get(paramPBField);
        }
        catch (IllegalAccessException localIllegalAccessException3)
        {
          GdtLog.d("GdtJsonPbUtil", "pbRepeatFromJsonArray", localIllegalAccessException3);
        }
        catch (NoSuchFieldException localNoSuchFieldException3)
        {
          GdtLog.d("GdtJsonPbUtil", "pbRepeatFromJsonArray", localNoSuchFieldException3);
        }
        localObject2 = null;
        if ((localObject2 instanceof PBField))
        {
          localObject2 = PBField.initRepeat((PBField)PBField.class.cast(localObject2));
          break label327;
        }
      }
      else if (d(paramPBField.getClass()))
      {
        localObject2 = PBField.initRepeatMessage(((MessageMicro)MessageMicro.class.cast(paramPBField)).getClass());
        break label327;
      }
      Object localObject2 = null;
      label327:
      if (localObject2 == null)
      {
        GdtLog.d("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
        return null;
      }
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          Object localObject3 = paramJSONArray.get(i);
          if ((localObject3 != null) && (!JSONObject.NULL.equals(localObject3))) {
            a(localObject2, a(a(paramPBField, localObject3)));
          }
        }
        catch (JSONException localJSONException)
        {
          GdtLog.d("GdtJsonPbUtil", "pbRepeatFromJsonArray", localJSONException);
        }
        i += 1;
      }
      return localObject2;
    }
    GdtLog.d("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
    return null;
  }
  
  private static PBPrimitiveField a(PBPrimitiveField paramPBPrimitiveField, Object paramObject)
  {
    if ((paramPBPrimitiveField != null) && (b(paramPBPrimitiveField.getClass())) && (paramObject != null) && (!JSONObject.NULL.equals(paramObject)))
    {
      try
      {
        if ((paramPBPrimitiveField instanceof PBBoolField)) {
          paramObject = PBField.initBool(Boolean.parseBoolean(paramObject.toString()));
        } else if ((paramPBPrimitiveField instanceof PBDoubleField)) {
          paramObject = PBField.initDouble(Double.parseDouble(paramObject.toString()));
        } else if ((paramPBPrimitiveField instanceof PBEnumField)) {
          paramObject = PBField.initEnum(Integer.parseInt(paramObject.toString()));
        } else if ((paramPBPrimitiveField instanceof PBFixed32Field)) {
          paramObject = PBField.initFixed32(Integer.parseInt(paramObject.toString()));
        } else if ((paramPBPrimitiveField instanceof PBFixed64Field)) {
          paramObject = PBField.initFixed64(Long.parseLong(paramObject.toString()));
        } else if ((paramPBPrimitiveField instanceof PBFloatField)) {
          paramObject = PBField.initFloat(Float.parseFloat(paramObject.toString()));
        } else if ((paramPBPrimitiveField instanceof PBInt32Field)) {
          paramObject = PBField.initInt32(Integer.parseInt(paramObject.toString()));
        } else if ((paramPBPrimitiveField instanceof PBInt64Field)) {
          paramObject = PBField.initInt64(Long.parseLong(paramObject.toString()));
        } else if ((paramPBPrimitiveField instanceof PBSFixed32Field)) {
          paramObject = PBField.initSFixed32(Integer.parseInt(paramObject.toString()));
        } else if ((paramPBPrimitiveField instanceof PBSFixed64Field)) {
          paramObject = PBField.initSFixed64(Long.parseLong(paramObject.toString()));
        } else if ((paramPBPrimitiveField instanceof PBSInt32Field)) {
          paramObject = PBField.initSInt32(Integer.parseInt(paramObject.toString()));
        } else if ((paramPBPrimitiveField instanceof PBSInt64Field)) {
          paramObject = PBField.initSInt64(Long.parseLong(paramObject.toString()));
        } else if (((paramPBPrimitiveField instanceof PBStringField)) && (paramObject.getClass() == String.class)) {
          paramObject = PBField.initString((String)String.class.cast(paramObject));
        } else if ((paramPBPrimitiveField instanceof PBUInt32Field)) {
          paramObject = PBField.initUInt32(Integer.parseInt(paramObject.toString()));
        } else if ((paramPBPrimitiveField instanceof PBUInt64Field)) {
          paramObject = PBField.initUInt64(Long.parseLong(paramObject.toString()));
        }
      }
      catch (Throwable paramObject)
      {
        GdtLog.d("GdtJsonPbUtil", "pbFromJsonPrimitive", paramObject);
        paramObject = null;
      }
      if ((paramObject != null) && (paramObject.getClass() == paramPBPrimitiveField.getClass())) {
        return paramObject;
      }
      GdtLog.d("GdtJsonPbUtil", "pbFromJsonPrimitive error");
      return null;
    }
    GdtLog.d("GdtJsonPbUtil", "pbFromJsonPrimitive error");
    return null;
  }
  
  private static Class a(Class paramClass)
  {
    if (paramClass == null)
    {
      GdtLog.d("GdtJsonPbUtil", "getValueClassOfPBField error");
      return null;
    }
    try
    {
      paramClass = paramClass.getMethod("get", null).getReturnType();
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      GdtLog.d("GdtJsonPbUtil", "getValueClassOfPBField", paramClass);
    }
    return null;
  }
  
  public static Object a(PBField paramPBField)
  {
    if (paramPBField == null)
    {
      GdtLog.d("GdtJsonPbUtil", "pbToJson error");
      return null;
    }
    if (b(paramPBField.getClass())) {
      return a((PBPrimitiveField)PBPrimitiveField.class.cast(paramPBField));
    }
    if (c(paramPBField.getClass())) {
      return b(paramPBField);
    }
    if (d(paramPBField.getClass())) {
      return a((MessageMicro)MessageMicro.class.cast(paramPBField));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pbToJson error, ");
    localStringBuilder.append(paramPBField.getClass().getName());
    localStringBuilder.append(" is not supported");
    GdtLog.d("GdtJsonPbUtil", localStringBuilder.toString());
    return null;
  }
  
  private static Object a(PBPrimitiveField<?> paramPBPrimitiveField)
  {
    if ((paramPBPrimitiveField != null) && (!(paramPBPrimitiveField instanceof PBBytesField)) && (paramPBPrimitiveField.has()))
    {
      Object localObject = a(paramPBPrimitiveField);
      if ((!(paramPBPrimitiveField instanceof PBFixed64Field)) && (!(paramPBPrimitiveField instanceof PBInt64Field)) && (!(paramPBPrimitiveField instanceof PBSFixed64Field)) && (!(paramPBPrimitiveField instanceof PBSInt64Field)) && (!(paramPBPrimitiveField instanceof PBUInt64Field))) {
        return localObject;
      }
      if (localObject == null) {
        return "";
      }
      try
      {
        paramPBPrimitiveField = String.valueOf(localObject);
        return paramPBPrimitiveField;
      }
      catch (Throwable paramPBPrimitiveField)
      {
        GdtLog.d("GdtJsonPbUtil", "pbPrimitiveFieldToJson", paramPBPrimitiveField);
        return "";
      }
    }
    return null;
  }
  
  private static Object a(Object paramObject)
  {
    if (paramObject == null)
    {
      GdtLog.d("GdtJsonPbUtil", "getOfPB error");
      return null;
    }
    try
    {
      paramObject = paramObject.getClass().getMethod("get", new Class[0]).invoke(paramObject, new Object[0]);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      GdtLog.d("GdtJsonPbUtil", "getOfPB", paramObject);
    }
    return null;
  }
  
  private static JSONObject a(MessageMicro paramMessageMicro)
  {
    if (paramMessageMicro == null) {
      return null;
    }
    Field[] arrayOfField = paramMessageMicro.getClass().getDeclaredFields();
    if (arrayOfField == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = arrayOfField[i];
      if (Modifier.isPublic(((Field)localObject1).getModifiers()))
      {
        boolean bool = ((Field)localObject1).isAccessible();
        ((Field)localObject1).setAccessible(true);
        String str = ((Field)localObject1).getName();
        try
        {
          Object localObject2 = ((Field)localObject1).get(paramMessageMicro);
          ((Field)localObject1).setAccessible(bool);
          if (((!Modifier.isStatic(((Field)localObject1).getModifiers())) && (!Modifier.isFinal(((Field)localObject1).getModifiers()))) || (localObject2 == null) || ((localObject2.getClass() != Integer.TYPE) && (localObject2.getClass() != Integer.class))) {
            if (!(localObject2 instanceof PBField))
            {
              GdtLog.d("GdtJsonPbUtil", "pbMessagebToJson error");
            }
            else
            {
              localObject1 = a((PBField)PBField.class.cast(localObject2));
              if ((localObject1 != null) && (!JSONObject.NULL.equals(localObject1))) {
                try
                {
                  localJSONObject.put(str, localObject1);
                }
                catch (JSONException localJSONException)
                {
                  GdtLog.d("GdtJsonPbUtil", "pbMessagebToJson", localJSONException);
                }
              }
            }
          }
          i += 1;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          GdtLog.d("GdtJsonPbUtil", "pbMessagebToJson", localIllegalAccessException);
        }
      }
    }
    return localJSONObject;
  }
  
  private static void a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != null) && (paramObject2 != null))
    {
      Method localMethod = null;
      try
      {
        boolean bool = paramObject1 instanceof PBRepeatMessageField;
        if (bool) {
          localMethod = PBRepeatMessageField.class.getDeclaredMethod("add", new Class[] { MessageMicro.class });
        } else if ((paramObject1 instanceof PBRepeatField)) {
          localMethod = PBRepeatField.class.getDeclaredMethod("add", new Class[] { Object.class });
        }
        if (localMethod == null)
        {
          GdtLog.d("GdtJsonPbUtil", "addOfPB error");
          return;
        }
        localMethod.invoke(paramObject1, new Object[] { paramObject2 });
        return;
      }
      catch (Throwable paramObject1)
      {
        GdtLog.d("GdtJsonPbUtil", "addOfPB", paramObject1);
        return;
      }
    }
    GdtLog.d("GdtJsonPbUtil", "addOfPB error");
  }
  
  private static void a(Object paramObject1, Object paramObject2, Class paramClass)
  {
    if ((paramObject1 != null) && (paramObject2 != null) && (paramClass != null)) {
      try
      {
        paramObject1.getClass().getMethod("set", new Class[] { paramClass }).invoke(paramObject1, new Object[] { paramObject2 });
        return;
      }
      catch (Throwable paramObject1)
      {
        GdtLog.d("GdtJsonPbUtil", "setOfPB", paramObject1);
        return;
      }
    }
    GdtLog.d("GdtJsonPbUtil", "setOfPB error");
  }
  
  private static JSONArray b(PBField paramPBField)
  {
    Object localObject = null;
    if (paramPBField != null)
    {
      if (!c(paramPBField.getClass())) {
        return null;
      }
      paramPBField = a(paramPBField);
      if (paramPBField == null) {
        return null;
      }
      if (!(paramPBField instanceof List))
      {
        GdtLog.d("GdtJsonPbUtil", "pbRepeatToJson error");
        return null;
      }
      paramPBField = (List)List.class.cast(paramPBField);
      if (paramPBField == null)
      {
        GdtLog.d("GdtJsonPbUtil", "pbRepeatToJson error");
        return null;
      }
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramPBField.iterator();
      for (;;)
      {
        localObject = localJSONArray;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
        paramPBField = localObject;
        if ((localObject instanceof PBField)) {
          paramPBField = a((PBField)PBField.class.cast(localObject));
        }
        if ((paramPBField != null) && (!JSONObject.NULL.equals(paramPBField))) {
          localJSONArray.put(paramPBField);
        }
      }
    }
    return localObject;
  }
  
  private static boolean b(Class paramClass)
  {
    return (paramClass == PBBoolField.class) || (paramClass == PBDoubleField.class) || (paramClass == PBEnumField.class) || (paramClass == PBFixed32Field.class) || (paramClass == PBFixed64Field.class) || (paramClass == PBFloatField.class) || (paramClass == PBInt32Field.class) || (paramClass == PBInt64Field.class) || (paramClass == PBSFixed32Field.class) || (paramClass == PBSFixed64Field.class) || (paramClass == PBSInt32Field.class) || (paramClass == PBSInt64Field.class) || (paramClass == PBStringField.class) || (paramClass == PBUInt32Field.class) || (paramClass == PBUInt64Field.class);
  }
  
  private static boolean c(Class paramClass)
  {
    return (paramClass == PBRepeatField.class) || (paramClass == PBRepeatMessageField.class);
  }
  
  private static boolean d(Class paramClass)
  {
    return (paramClass != null) && (paramClass.getSuperclass() == MessageMicro.class) && (!c(paramClass));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.json.GdtJsonPbUtil
 * JD-Core Version:    0.7.0.1
 */