package com.tencent.luan.ioc.wrapper;

import com.tencent.luan.ioc.InjectConstructor;
import com.tencent.luan.ioc.Injector;

public class PrototypeObjectWrapper<T>
  implements ObjectWrapper<T>
{
  private final InjectConstructor<T> constructor;
  
  public PrototypeObjectWrapper(InjectConstructor<T> paramInjectConstructor)
  {
    this.constructor = paramInjectConstructor;
  }
  
  public ObjectWrapper<T> combine(T paramT)
  {
    return this;
  }
  
  public ObjectHolder<T> createObjectIfAbsent(Injector paramInjector)
  {
    return new ObjectHolder(this.constructor.newInstance(paramInjector), this.constructor.needInject());
  }
  
  public boolean needCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.luan.ioc.wrapper.PrototypeObjectWrapper
 * JD-Core Version:    0.7.0.1
 */