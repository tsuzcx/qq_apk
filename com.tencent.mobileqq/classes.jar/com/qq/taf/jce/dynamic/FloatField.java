package com.qq.taf.jce.dynamic;

public class FloatField
  extends NumberField
{
  private float data;
  
  FloatField(float paramFloat, int paramInt)
  {
    super(paramInt);
    this.data = paramFloat;
  }
  
  public float get()
  {
    return this.data;
  }
  
  public Number getNumber()
  {
    return Float.valueOf(this.data);
  }
  
  public void set(float paramFloat)
  {
    this.data = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.FloatField
 * JD-Core Version:    0.7.0.1
 */