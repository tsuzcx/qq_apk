package com.samskivert.mustache;

final class BasicCollector$8
  extends BasicCollector.ArrayHelper
{
  protected Object get(Object paramObject, int paramInt)
  {
    return Byte.valueOf(((byte[])(byte[])paramObject)[paramInt]);
  }
  
  public int length(Object paramObject)
  {
    return ((byte[])paramObject).length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.BasicCollector.8
 * JD-Core Version:    0.7.0.1
 */