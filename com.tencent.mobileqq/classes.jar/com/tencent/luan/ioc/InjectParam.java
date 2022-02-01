package com.tencent.luan.ioc;

public class InjectParam
{
  public final String name;
  public final Class<?> type;
  
  public InjectParam(Class<?> paramClass, String paramString)
  {
    this.type = paramClass;
    this.name = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.luan.ioc.InjectParam
 * JD-Core Version:    0.7.0.1
 */