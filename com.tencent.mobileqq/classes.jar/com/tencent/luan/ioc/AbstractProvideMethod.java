package com.tencent.luan.ioc;

public abstract class AbstractProvideMethod
  implements ProvideMethod
{
  private final InjectParam provideParam;
  private final Class<?> provider;
  private final int scope;
  
  protected AbstractProvideMethod(Class<?> paramClass, InjectParam paramInjectParam, int paramInt)
  {
    this.provider = paramClass;
    this.provideParam = paramInjectParam;
    this.scope = paramInt;
  }
  
  public InjectParam provideParam()
  {
    return this.provideParam;
  }
  
  public Class<?> provider()
  {
    return this.provider;
  }
  
  public int scope()
  {
    return this.scope;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.AbstractProvideMethod
 * JD-Core Version:    0.7.0.1
 */