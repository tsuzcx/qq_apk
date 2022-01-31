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

public class bdyp
{
  public static Object a(PBField paramPBField)
  {
    if (paramPBField == null)
    {
      bdnw.d("GdtJsonPbUtil", "pbToJson error");
      return null;
    }
    if (a(paramPBField.getClass())) {
      return a((PBPrimitiveField)PBPrimitiveField.class.cast(paramPBField));
    }
    if (b(paramPBField.getClass())) {
      return a(paramPBField);
    }
    if (c(paramPBField.getClass())) {
      return a((MessageMicro)MessageMicro.class.cast(paramPBField));
    }
    bdnw.d("GdtJsonPbUtil", "pbToJson error, " + paramPBField.getClass().getName() + " is not supported");
    return null;
  }
  
  private static Object a(PBPrimitiveField<?> paramPBPrimitiveField)
  {
    Object localObject1;
    if ((paramPBPrimitiveField == null) || ((paramPBPrimitiveField instanceof PBBytesField)) || (!paramPBPrimitiveField.has())) {
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = a(paramPBPrimitiveField);
      if (((paramPBPrimitiveField instanceof PBFixed64Field)) || ((paramPBPrimitiveField instanceof PBInt64Field)) || ((paramPBPrimitiveField instanceof PBSFixed64Field)) || ((paramPBPrimitiveField instanceof PBSInt64Field))) {
        break;
      }
      localObject1 = localObject2;
    } while (!(paramPBPrimitiveField instanceof PBUInt64Field));
    if (localObject2 == null) {
      return "";
    }
    try
    {
      paramPBPrimitiveField = String.valueOf(localObject2);
      return paramPBPrimitiveField;
    }
    catch (Throwable paramPBPrimitiveField)
    {
      bdnw.d("GdtJsonPbUtil", "pbPrimitiveFieldToJson", paramPBPrimitiveField);
    }
    return "";
  }
  
  private static Object a(Object paramObject)
  {
    if (paramObject == null)
    {
      bdnw.d("GdtJsonPbUtil", "getOfPB error");
      return null;
    }
    try
    {
      paramObject = paramObject.getClass().getMethod("get", new Class[] { Void.class }).invoke(paramObject, new Object[0]);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      bdnw.d("GdtJsonPbUtil", "getOfPB", paramObject);
    }
    return null;
  }
  
  private static JSONArray a(PBField paramPBField)
  {
    if ((paramPBField == null) || (!b(paramPBField.getClass()))) {
      return null;
    }
    paramPBField = a(paramPBField);
    if (paramPBField == null) {
      return null;
    }
    if (!(paramPBField instanceof List))
    {
      bdnw.d("GdtJsonPbUtil", "pbRepeatToJson error");
      return null;
    }
    paramPBField = (List)List.class.cast(paramPBField);
    if (paramPBField == null)
    {
      bdnw.d("GdtJsonPbUtil", "pbRepeatToJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramPBField.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      paramPBField = localObject;
      if ((localObject instanceof PBField)) {
        paramPBField = a((PBField)PBField.class.cast(localObject));
      }
      if ((paramPBField != null) && (paramPBField != JSONObject.NULL)) {
        localJSONArray.put(paramPBField);
      }
    }
    return localJSONArray;
  }
  
  private static JSONObject a(MessageMicro paramMessageMicro)
  {
    if (paramMessageMicro == null) {}
    Field[] arrayOfField;
    do
    {
      return null;
      arrayOfField = paramMessageMicro.getClass().getDeclaredFields();
    } while (arrayOfField == null);
    JSONObject localJSONObject = new JSONObject();
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      Object localObject1 = arrayOfField[i];
      if (!Modifier.isPublic(((Field)localObject1).getModifiers())) {}
      for (;;)
      {
        i += 1;
        break;
        boolean bool = ((Field)localObject1).isAccessible();
        ((Field)localObject1).setAccessible(true);
        String str = ((Field)localObject1).getName();
        Object localObject2;
        try
        {
          localObject2 = ((Field)localObject1).get(paramMessageMicro);
          ((Field)localObject1).setAccessible(bool);
          if (((Modifier.isStatic(((Field)localObject1).getModifiers())) || (Modifier.isFinal(((Field)localObject1).getModifiers()))) && (localObject2 != null) && ((localObject2.getClass() == Integer.TYPE) || (localObject2.getClass() == Integer.class))) {
            continue;
          }
          if ((localObject2 instanceof PBField)) {
            break label177;
          }
          bdnw.d("GdtJsonPbUtil", "pbMessagebToJson error");
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          bdnw.d("GdtJsonPbUtil", "pbMessagebToJson", localIllegalAccessException);
        }
        continue;
        label177:
        localObject1 = a((PBField)PBField.class.cast(localObject2));
        if ((localObject1 != null) && (localObject1 != JSONObject.NULL)) {
          try
          {
            localJSONObject.put(localIllegalAccessException, localObject1);
          }
          catch (JSONException localJSONException)
          {
            bdnw.d("GdtJsonPbUtil", "pbMessagebToJson", localJSONException);
          }
        }
      }
    }
    return localJSONObject;
  }
  
  private static boolean a(Class paramClass)
  {
    return (paramClass == PBBoolField.class) || (paramClass == PBDoubleField.class) || (paramClass == PBEnumField.class) || (paramClass == PBFixed32Field.class) || (paramClass == PBFixed64Field.class) || (paramClass == PBFloatField.class) || (paramClass == PBInt32Field.class) || (paramClass == PBInt64Field.class) || (paramClass == PBSFixed32Field.class) || (paramClass == PBSFixed64Field.class) || (paramClass == PBSInt32Field.class) || (paramClass == PBSInt64Field.class) || (paramClass == PBStringField.class) || (paramClass == PBUInt32Field.class) || (paramClass == PBUInt64Field.class);
  }
  
  private static boolean b(Class paramClass)
  {
    return (paramClass == PBRepeatField.class) || (paramClass == PBRepeatMessageField.class);
  }
  
  private static boolean c(Class paramClass)
  {
    return (paramClass != null) && (paramClass.getSuperclass() == MessageMicro.class) && (!b(paramClass));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdyp
 * JD-Core Version:    0.7.0.1
 */