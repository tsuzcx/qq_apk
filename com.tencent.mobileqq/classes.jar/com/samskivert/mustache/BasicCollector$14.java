package com.samskivert.mustache;

final class BasicCollector$14
  extends BasicCollector.ArrayHelper
{
  protected Object get(Object paramObject, int paramInt)
  {
    return Double.valueOf(((double[])(double[])paramObject)[paramInt]);
  }
  
  public int length(Object paramObject)
  {
    return ((double[])paramObject).length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.BasicCollector.14
 * JD-Core Version:    0.7.0.1
 */