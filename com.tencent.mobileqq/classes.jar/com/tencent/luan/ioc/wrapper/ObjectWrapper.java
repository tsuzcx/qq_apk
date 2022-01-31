package com.tencent.luan.ioc.wrapper;

import com.tencent.luan.ioc.Injector;

public abstract interface ObjectWrapper<T>
{
  public abstract ObjectWrapper<T> combine(T paramT);
  
  public abstract ObjectHolder<T> createObjectIfAbsent(Injector paramInjector);
  
  public abstract boolean needCache();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.luan.ioc.wrapper.ObjectWrapper
 * JD-Core Version:    0.7.0.1
 */