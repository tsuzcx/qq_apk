package com.tencent.ditto.reflect;

import com.tencent.ditto.utils.DittoLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class DittoFieldValue$FieldValueProcessor
  extends DittoFieldValue.AbsValueProcessor
{
  private String innerFieldName;
  
  public DittoFieldValue$FieldValueProcessor(DittoFieldValue paramDittoFieldValue, String paramString)
  {
    super(paramDittoFieldValue, null);
    this.innerFieldName = paramString;
  }
  
  public Object getObjectValue(Object paramObject)
  {
    if ("GLOBAL".equals(this.innerFieldName)) {
      return DittoValue.GLOBAL.getInstance();
    }
    try
    {
      try
      {
        localObject = paramObject.getClass().getDeclaredField(this.innerFieldName);
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(paramObject);
        return localObject;
      }
      catch (Exception paramObject) {}catch (NullPointerException paramObject)
      {
        break label121;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Object localObject;
      label49:
      break label49;
    }
    localObject = paramObject.getClass().getDeclaredMethod(this.innerFieldName, new Class[0]);
    ((Method)localObject).setAccessible(true);
    paramObject = ((Method)localObject).invoke(paramObject, new Object[0]);
    return paramObject;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mvc err, getting:");
    ((StringBuilder)localObject).append(this.this$0.fieldName);
    DittoLog.e("DITTO_UI", ((StringBuilder)localObject).toString(), paramObject);
    return null;
    label121:
    throw paramObject;
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    if ("GLOBAL".equals(this.innerFieldName))
    {
      paramObject1 = new StringBuilder();
      paramObject1.append("trying to set value of a constant tpl:");
      paramObject1.append(this.this$0.fieldName);
      DittoLog.e("DITTO_UI", paramObject1.toString(), new RuntimeException());
      return;
    }
    try
    {
      Field localField = paramObject1.getClass().getDeclaredField(this.innerFieldName);
      localField.setAccessible(true);
      localField.set(paramObject1, paramObject2);
      return;
    }
    catch (Exception paramObject1)
    {
      paramObject2 = new StringBuilder();
      paramObject2.append("mvc err, getting:");
      paramObject2.append(this.this$0.fieldName);
      DittoLog.e("DITTO_UI", paramObject2.toString(), paramObject1);
      return;
    }
    catch (NullPointerException paramObject1)
    {
      throw paramObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoFieldValue.FieldValueProcessor
 * JD-Core Version:    0.7.0.1
 */