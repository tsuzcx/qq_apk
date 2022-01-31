package com.tencent.luan.ioc.wrapper;

public class ObjectHolder<T>
{
  public final boolean needInject;
  public final T object;
  
  ObjectHolder(T paramT, boolean paramBoolean)
  {
    this.object = paramT;
    this.needInject = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.luan.ioc.wrapper.ObjectHolder
 * JD-Core Version:    0.7.0.1
 */