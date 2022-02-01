package com.tencent.luan.ioc;

import com.tencent.luan.ioc.wrapper.DefaultObjectWrapper;
import com.tencent.luan.ioc.wrapper.GlobalSingletonObjectWrapper;
import com.tencent.luan.ioc.wrapper.ObjectWrapper;
import com.tencent.luan.ioc.wrapper.PrototypeObjectWrapper;

public abstract class AbstractInjectConstructor<T>
  implements InjectConstructor<T>
{
  private final String uniqueKey;
  private final ObjectWrapper<T> wrapper;
  
  protected AbstractInjectConstructor(int paramInt, String paramString)
  {
    this.uniqueKey = paramString;
    this.wrapper = getWrapperByScope(paramInt);
  }
  
  protected AbstractInjectConstructor(Class<T> paramClass, int paramInt)
  {
    this(paramInt, localStringBuilder.toString());
  }
  
  private ObjectWrapper<T> getWrapperByScope(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return new DefaultObjectWrapper(this);
      }
      return new PrototypeObjectWrapper(this);
    }
    return GlobalSingletonObjectWrapper.getInstanceByConstructor(this);
  }
  
  public boolean needInject()
  {
    return true;
  }
  
  public String uniqueKey()
  {
    return this.uniqueKey;
  }
  
  public ObjectWrapper<T> wrapper()
  {
    return this.wrapper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luan.ioc.AbstractInjectConstructor
 * JD-Core Version:    0.7.0.1
 */