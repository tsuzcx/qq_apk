package com.tencent.luan.ioc.wrapper;

import com.tencent.luan.ioc.InjectConstructor;
import com.tencent.luan.ioc.Injector;

public class SingletonObjectWrapper<T>
  implements ObjectWrapper<T>
{
  private final InjectConstructor<T> constructor;
  private volatile T object;
  
  public SingletonObjectWrapper(InjectConstructor<T> paramInjectConstructor)
  {
    this.constructor = paramInjectConstructor;
  }
  
  public ObjectWrapper<T> combine(T paramT)
  {
    return this;
  }
  
  public ObjectHolder<T> createObjectIfAbsent(Injector paramInjector)
  {
    if (this.object != null) {
      return new ObjectHolder(this.object, false);
    }
    try
    {
      if (this.object != null)
      {
        paramInjector = new ObjectHolder(this.object, false);
        return paramInjector;
      }
      this.object = this.constructor.newInstance(paramInjector);
      return new ObjectHolder(this.object, this.constructor.needInject());
    }
    finally {}
  }
  
  public boolean needCache()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.luan.ioc.wrapper.SingletonObjectWrapper
 * JD-Core Version:    0.7.0.1
 */