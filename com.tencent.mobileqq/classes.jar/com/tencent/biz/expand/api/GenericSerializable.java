package com.tencent.biz.expand.api;

import java.io.Serializable;

public class GenericSerializable<T>
  implements Serializable
{
  private T serializable;
  
  public T get()
  {
    return this.serializable;
  }
  
  public void set(T paramT)
  {
    this.serializable = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.api.GenericSerializable
 * JD-Core Version:    0.7.0.1
 */