package com.huawei.agconnect.core;

public class Service
{
  private Class<?> a;
  private Class<?> b;
  private boolean c;
  
  private Service(Class<?> paramClass1, Class<?> paramClass2)
  {
    this.a = paramClass1;
    this.b = paramClass2;
  }
  
  public static Service.Builder builder(Class<?> paramClass)
  {
    return new Service.Builder(paramClass, paramClass, null);
  }
  
  public static Service.Builder builder(Class<?> paramClass1, Class<?> paramClass2)
  {
    return new Service.Builder(paramClass1, paramClass2, null);
  }
  
  public Class<?> getInterface()
  {
    return this.a;
  }
  
  public Class<?> getType()
  {
    return this.b;
  }
  
  public boolean isSingleton()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.core.Service
 * JD-Core Version:    0.7.0.1
 */