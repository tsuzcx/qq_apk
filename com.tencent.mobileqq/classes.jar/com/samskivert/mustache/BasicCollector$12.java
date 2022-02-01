package com.samskivert.mustache;

final class BasicCollector$12
  extends BasicCollector.ArrayHelper
{
  protected Object get(Object paramObject, int paramInt)
  {
    return Long.valueOf(((long[])(long[])paramObject)[paramInt]);
  }
  
  public int length(Object paramObject)
  {
    return ((long[])paramObject).length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.BasicCollector.12
 * JD-Core Version:    0.7.0.1
 */