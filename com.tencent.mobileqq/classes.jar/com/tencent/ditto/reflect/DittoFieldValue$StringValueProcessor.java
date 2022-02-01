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
    DittoLog.e("DITTO_UI", "trying to set value of a constant tpl:" + this.this$0.fieldName, new RuntimeException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoFieldValue.StringValueProcessor
 * JD-Core Version:    0.7.0.1
 */