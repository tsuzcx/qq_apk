package com.google.gson.internal;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

class ConstructorConstructor$5
  implements ObjectConstructor<T>
{
  ConstructorConstructor$5(ConstructorConstructor paramConstructorConstructor, Type paramType) {}
  
  public T construct()
  {
    Object localObject = this.val$type;
    if ((localObject instanceof ParameterizedType))
    {
      localObject = ((ParameterizedType)localObject).getActualTypeArguments()[0];
      if ((localObject instanceof Class)) {
        return EnumSet.noneOf((Class)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid EnumSet type: ");
      ((StringBuilder)localObject).append(this.val$type.toString());
      throw new JsonIOException(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid EnumSet type: ");
    ((StringBuilder)localObject).append(this.val$type.toString());
    throw new JsonIOException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal.ConstructorConstructor.5
 * JD-Core Version:    0.7.0.1
 */