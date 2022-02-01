package com.tencent.ditto.reflect;

public class DittoConditionOperatorValue
  extends DittoValue
{
  DittoValue conditionValue = null;
  DittoValue falseValue = null;
  DittoValue trueValue = null;
  
  private DittoValue getResultField(Object paramObject)
  {
    boolean bool = true;
    paramObject = this.conditionValue.getValue(paramObject);
    if ((paramObject instanceof Boolean)) {
      bool = ((Boolean)paramObject).booleanValue();
    }
    while (bool)
    {
      return this.trueValue;
      if ((paramObject instanceof Number))
      {
        if (((Number)paramObject).floatValue() != 0.0F) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else if (paramObject == null) {
        for (;;)
        {
          bool = false;
        }
      }
    }
    return this.falseValue;
  }
  
  public Object getValue(Object paramObject)
  {
    return getResultField(paramObject).getValue(paramObject);
  }
  
  public void setValue(Object paramObject, String paramString)
  {
    getResultField(paramObject).setValue(paramObject, paramString);
  }
  
  public void setValue(Object paramObject, boolean paramBoolean)
  {
    getResultField(paramObject).setValue(paramObject, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoConditionOperatorValue
 * JD-Core Version:    0.7.0.1
 */