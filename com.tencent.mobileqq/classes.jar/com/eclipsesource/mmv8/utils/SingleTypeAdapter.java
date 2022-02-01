package com.eclipsesource.mmv8.utils;

public abstract class SingleTypeAdapter
  implements TypeAdapter
{
  private int typeToAdapt;
  
  public SingleTypeAdapter(int paramInt)
  {
    this.typeToAdapt = paramInt;
  }
  
  public Object adapt(int paramInt, Object paramObject)
  {
    if (paramInt == this.typeToAdapt) {
      return adapt(paramObject);
    }
    return TypeAdapter.DEFAULT;
  }
  
  public abstract Object adapt(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.SingleTypeAdapter
 * JD-Core Version:    0.7.0.1
 */