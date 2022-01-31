package com.tencent.luan.ioc;

public abstract interface ProvideMethod
{
  public abstract Object provide(Injector paramInjector);
  
  public abstract InjectParam provideParam();
  
  public abstract Class<?> provider();
  
  public abstract int scope();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.ProvideMethod
 * JD-Core Version:    0.7.0.1
 */