package com.tencent.biz.qqstory.utils;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
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
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBSInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PBUtils
{
  public static String a(MessageMicro paramMessageMicro)
  {
    return a(paramMessageMicro).toString();
  }
  
  private static String a(PBPrimitiveField paramPBPrimitiveField)
  {
    if ((paramPBPrimitiveField instanceof PBBytesField)) {
      return ((PBBytesField)paramPBPrimitiveField).get().toStringUtf8();
    }
    if ((paramPBPrimitiveField instanceof PBStringField)) {
      return ((PBStringField)paramPBPrimitiveField).get();
    }
    if ((paramPBPrimitiveField instanceof PBBoolField)) {
      return String.valueOf(((PBBoolField)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBFixed32Field)) {
      return String.valueOf(((PBFixed32Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBFixed64Field)) {
      return String.valueOf(((PBFixed64Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBFloatField)) {
      return String.valueOf(((PBFloatField)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBInt32Field)) {
      return String.valueOf(((PBInt32Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBInt64Field)) {
      return String.valueOf(((PBInt64Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBSFixed32Field)) {
      return String.valueOf(((PBSFixed32Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBSInt32Field)) {
      return String.valueOf(((PBSInt32Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBSInt64Field)) {
      return String.valueOf(((PBSInt64Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBUInt32Field)) {
      return String.valueOf(((PBUInt32Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBUInt64Field)) {
      return String.valueOf(((PBUInt64Field)paramPBPrimitiveField).get());
    }
    if ((paramPBPrimitiveField instanceof PBEnumField)) {
      return String.valueOf(((PBEnumField)paramPBPrimitiveField).get());
    }
    return "(null)";
  }
  
  public static JSONObject a(MessageMicro paramMessageMicro)
  {
    JSONObject localJSONObject = new JSONObject();
    a(paramMessageMicro, localJSONObject);
    return localJSONObject;
  }
  
  private static void a(MessageMicro paramMessageMicro, JSONObject paramJSONObject)
  {
    Field[] arrayOfField = paramMessageMicro.getClass().getDeclaredFields();
    for (;;)
    {
      int i;
      Object localObject1;
      String str;
      try
      {
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          localObject1 = arrayOfField[i];
          str = ((Field)localObject1).getName();
          if (!Modifier.isPublic(((Field)localObject1).getModifiers())) {
            break label343;
          }
          localObject1 = ((Field)localObject1).get(paramMessageMicro);
          if ((!(localObject1 instanceof MessageMicro)) || (!((MessageMicro)localObject1).has())) {
            break label98;
          }
          paramJSONObject.put(str, a((MessageMicro)localObject1));
        }
      }
      catch (Exception paramMessageMicro)
      {
        paramMessageMicro.printStackTrace();
      }
      return;
      label98:
      if (((localObject1 instanceof PBPrimitiveField)) && (((PBPrimitiveField)localObject1).has()))
      {
        paramJSONObject.put(str, a((PBPrimitiveField)localObject1));
      }
      else
      {
        Object localObject2;
        if ((localObject1 instanceof PBRepeatField))
        {
          localObject2 = ((PBRepeatField)localObject1).get();
          localObject1 = new JSONArray();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = ((Iterator)localObject2).next();
            if ((localObject3 instanceof PBPrimitiveField)) {
              ((JSONArray)localObject1).put(a((PBPrimitiveField)localObject3));
            } else if ((localObject3 instanceof ByteStringMicro)) {
              ((JSONArray)localObject1).put(((ByteStringMicro)localObject3).toStringUtf8());
            } else {
              ((JSONArray)localObject1).put(String.valueOf(localObject3));
            }
          }
          paramJSONObject.put(str, localObject1);
        }
        else if ((localObject1 instanceof PBRepeatMessageField))
        {
          localObject2 = ((PBRepeatMessageField)localObject1).get();
          localObject1 = new JSONArray();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((JSONArray)localObject1).put(a((MessageMicro)((Iterator)localObject2).next()));
          }
          paramJSONObject.put(str, localObject1);
        }
      }
      label343:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PBUtils
 * JD-Core Version:    0.7.0.1
 */