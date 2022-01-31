package com.tencent.luan.ioc;

public abstract interface Injector
{
  public abstract Object getOrCreateObject(Class<?> paramClass);
  
  public abstract Object getOrCreateObject(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.Injector
 * JD-Core Version:    0.7.0.1
 */