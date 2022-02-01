package com.tencent.ditto.reflect;

public class DittoConditionOperatorValue
  extends DittoValue
{
  DittoValue conditionValue = null;
  DittoValue falseValue = null;
  DittoValue trueValue = null;
  
  private DittoValue getResultField(Object paramObject)
  {
    paramObject = this.conditionValue.getValue(paramObject);
    boolean bool;
    if ((paramObject instanceof Boolean))
    {
      bool = ((Boolean)paramObject).booleanValue();
    }
    else
    {
      if ((paramObject instanceof Number)) {
        if (((Number)paramObject).floatValue() == 0.0F) {}
      }
      for (;;)
      {
        bool = true;
        break;
        do
        {
          bool = false;
          break;
        } while (paramObject == null);
      }
    }
    if (bool) {
      return this.trueValue;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoConditionOperatorValue
 * JD-Core Version:    0.7.0.1
 */