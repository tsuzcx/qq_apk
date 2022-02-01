package com.tencent.ditto.reflect;

public abstract class DittoValue
{
  public abstract Object getValue(Object paramObject);
  
  public abstract void setValue(Object paramObject, String paramString);
  
  public abstract void setValue(Object paramObject, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoValue
 * JD-Core Version:    0.7.0.1
 */