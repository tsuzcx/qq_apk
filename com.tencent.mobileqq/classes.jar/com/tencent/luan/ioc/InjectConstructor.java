package com.tencent.luan.ioc;

import com.tencent.luan.ioc.wrapper.ObjectWrapper;

public abstract interface InjectConstructor<T>
{
  public abstract boolean needInject();
  
  public abstract T newInstance(Injector paramInjector);
  
  public abstract String uniqueKey();
  
  public abstract ObjectWrapper<T> wrapper();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.luan.ioc.InjectConstructor
 * JD-Core Version:    0.7.0.1
 */