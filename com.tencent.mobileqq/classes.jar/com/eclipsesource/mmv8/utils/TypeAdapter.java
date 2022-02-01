package com.eclipsesource.mmv8.utils;

public abstract interface TypeAdapter
{
  public static final Object DEFAULT = new Object();
  
  public abstract Object adapt(int paramInt, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.TypeAdapter
 * JD-Core Version:    0.7.0.1
 */