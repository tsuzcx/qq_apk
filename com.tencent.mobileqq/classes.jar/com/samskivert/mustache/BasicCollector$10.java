package com.samskivert.mustache;

final class BasicCollector$10
  extends BasicCollector.ArrayHelper
{
  protected Object get(Object paramObject, int paramInt)
  {
    return Short.valueOf(((short[])(short[])paramObject)[paramInt]);
  }
  
  public int length(Object paramObject)
  {
    return ((short[])paramObject).length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.BasicCollector.10
 * JD-Core Version:    0.7.0.1
 */