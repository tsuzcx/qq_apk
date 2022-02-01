package com.samskivert.mustache;

final class BasicCollector$7
  extends BasicCollector.ArrayHelper
{
  protected Object get(Object paramObject, int paramInt)
  {
    return Boolean.valueOf(((boolean[])(boolean[])paramObject)[paramInt]);
  }
  
  public int length(Object paramObject)
  {
    return ((boolean[])paramObject).length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.BasicCollector.7
 * JD-Core Version:    0.7.0.1
 */