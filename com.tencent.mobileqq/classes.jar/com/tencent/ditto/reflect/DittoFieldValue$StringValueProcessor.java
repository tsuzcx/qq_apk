package com.tencent.ditto.reflect;

import com.tencent.ditto.utils.DittoLog;

class DittoFieldValue$StringValueProcessor
  extends DittoFieldValue.AbsValueProcessor
{
  private String value;
  
  public DittoFieldValue$StringValueProcessor(DittoFieldValue paramDittoFieldValue, String paramString)
  {
    super(paramDittoFieldValue, null);
    this.value = paramString;
  }
  
  public Object getObjectValue(Object paramObject)
  {
    return this.value;
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    paramObject1 = new StringBuilder();
    paramObject1.append("trying to set value of a constant tpl:");
    paramObject1.append(this.this$0.fieldName);
    DittoLog.e("DITTO_UI", paramObject1.toString(), new RuntimeException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoFieldValue.StringValueProcessor
 * JD-Core Version:    0.7.0.1
 */