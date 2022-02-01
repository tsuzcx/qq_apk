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
      Object localObject = paramObject.getClass().getDeclaredField(this.innerFieldName);
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramObject);
      return localObject;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Method localMethod = paramObject.getClass().getDeclaredMethod(this.innerFieldName, new Class[0]);
      localMethod.setAccessible(true);
      paramObject = localMethod.invoke(paramObject, new Object[0]);
      return paramObject;
    }
    catch (NullPointerException paramObject)
    {
      throw paramObject;
    }
    catch (Exception paramObject)
    {
      DittoLog.e("DITTO_UI", "mvc err, getting:" + this.this$0.fieldName, paramObject);
    }
    return null;
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    if ("GLOBAL".equals(this.innerFieldName))
    {
      DittoLog.e("DITTO_UI", "trying to set value of a constant tpl:" + this.this$0.fieldName, new RuntimeException());
      return;
    }
    try
    {
      Field localField = paramObject1.getClass().getDeclaredField(this.innerFieldName);
      localField.setAccessible(true);
      localField.set(paramObject1, paramObject2);
      return;
    }
    catch (NullPointerException paramObject1)
    {
      throw paramObject1;
    }
    catch (Exception paramObject1)
    {
      DittoLog.e("DITTO_UI", "mvc err, getting:" + this.this$0.fieldName, paramObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoFieldValue.FieldValueProcessor
 * JD-Core Version:    0.7.0.1
 */