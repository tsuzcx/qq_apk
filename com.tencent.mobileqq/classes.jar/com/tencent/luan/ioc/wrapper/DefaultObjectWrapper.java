package com.tencent.luan.ioc.wrapper;

import com.tencent.luan.ioc.InjectConstructor;
import com.tencent.luan.ioc.Injector;

public class DefaultObjectWrapper<T>
  implements ObjectWrapper<T>
{
  private final InjectConstructor<T> constructor;
  
  public DefaultObjectWrapper(InjectConstructor<T> paramInjectConstructor)
  {
    this.constructor = paramInjectConstructor;
  }
  
  public ObjectWrapper<T> combine(T paramT)
  {
    return new FixObjectWrapper(paramT);
  }
  
  public ObjectHolder<T> createObjectIfAbsent(Injector paramInjector)
  {
    return new ObjectHolder(this.constructor.newInstance(paramInjector), this.constructor.needInject());
  }
  
  public boolean needCache()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.luan.ioc.wrapper.DefaultObjectWrapper
 * JD-Core Version:    0.7.0.1
 */