package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

class ConstructorConstructor$2
  implements ObjectConstructor<T>
{
  ConstructorConstructor$2(ConstructorConstructor paramConstructorConstructor, InstanceCreator paramInstanceCreator, Type paramType) {}
  
  public T construct()
  {
    return this.val$rawTypeCreator.createInstance(this.val$type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.google.gson.internal.ConstructorConstructor.2
 * JD-Core Version:    0.7.0.1
 */