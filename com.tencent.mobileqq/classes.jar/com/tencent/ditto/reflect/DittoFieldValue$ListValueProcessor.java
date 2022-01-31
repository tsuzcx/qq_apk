package com.tencent.ditto.reflect;

import java.util.List;

class DittoFieldValue$ListValueProcessor
  extends DittoFieldValue.AbsValueProcessor
{
  private Integer idx;
  
  public DittoFieldValue$ListValueProcessor(DittoFieldValue paramDittoFieldValue, Integer paramInteger)
  {
    super(paramDittoFieldValue, null);
    this.idx = paramInteger;
  }
  
  public Object getObjectValue(Object paramObject)
  {
    if (((paramObject instanceof List)) && (this.idx.intValue() < ((List)paramObject).size()) && (this.idx.intValue() >= 0)) {
      return ((List)paramObject).get(this.idx.intValue());
    }
    return null;
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof List)) && (this.idx.intValue() < ((List)paramObject1).size()) && (this.idx.intValue() >= 0)) {
      ((List)paramObject1).set(this.idx.intValue(), paramObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoFieldValue.ListValueProcessor
 * JD-Core Version:    0.7.0.1
 */