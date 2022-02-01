package com.google.gson.internal;

import java.lang.reflect.Type;

class ConstructorConstructor$14
  implements ObjectConstructor<T>
{
  private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();
  
  ConstructorConstructor$14(ConstructorConstructor paramConstructorConstructor, Class paramClass, Type paramType) {}
  
  public T construct()
  {
    try
    {
      Object localObject = this.unsafeAllocator.newInstance(this.val$rawType);
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to invoke no-args constructor for ");
      localStringBuilder.append(this.val$type);
      localStringBuilder.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
      throw new RuntimeException(localStringBuilder.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.ConstructorConstructor.14
 * JD-Core Version:    0.7.0.1
 */