package com.tencent.ditto.reflect;

import java.util.Map;

class DittoFieldValue$MapValueProcessor
  extends DittoFieldValue.AbsValueProcessor
{
  private String key;
  
  public DittoFieldValue$MapValueProcessor(DittoFieldValue paramDittoFieldValue, String paramString)
  {
    super(paramDittoFieldValue, null);
    this.key = paramString;
  }
  
  public Object getObjectValue(Object paramObject)
  {
    if ((paramObject instanceof Map)) {
      return ((Map)paramObject).get(this.key);
    }
    return null;
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof Map)) {
      ((Map)paramObject1).put(this.key, paramObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoFieldValue.MapValueProcessor
 * JD-Core Version:    0.7.0.1
 */