package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class $Gson$Types$ParameterizedTypeImpl
  implements Serializable, ParameterizedType
{
  private static final long serialVersionUID = 0L;
  private final Type ownerType;
  private final Type rawType;
  private final Type[] typeArguments;
  
  public $Gson$Types$ParameterizedTypeImpl(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    boolean bool1 = paramType2 instanceof Class;
    int j = 0;
    if (bool1)
    {
      Class localClass = (Class)paramType2;
      bool1 = Modifier.isStatic(localClass.getModifiers());
      boolean bool2 = true;
      if ((!bool1) && (localClass.getEnclosingClass() != null)) {
        i = 0;
      } else {
        i = 1;
      }
      bool1 = bool2;
      if (paramType1 == null) {
        if (i != 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      .Gson.Preconditions.checkArgument(bool1);
    }
    if (paramType1 == null) {
      paramType1 = null;
    } else {
      paramType1 = .Gson.Types.canonicalize(paramType1);
    }
    this.ownerType = paramType1;
    this.rawType = .Gson.Types.canonicalize(paramType2);
    this.typeArguments = ((Type[])paramVarArgs.clone());
    int k = this.typeArguments.length;
    int i = j;
    while (i < k)
    {
      .Gson.Preconditions.checkNotNull(this.typeArguments[i]);
      .Gson.Types.checkNotPrimitive(this.typeArguments[i]);
      paramType1 = this.typeArguments;
      paramType1[i] = .Gson.Types.canonicalize(paramType1[i]);
      i += 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ParameterizedType)) && (.Gson.Types.equals(this, (ParameterizedType)paramObject));
  }
  
  public Type[] getActualTypeArguments()
  {
    return (Type[])this.typeArguments.clone();
  }
  
  public Type getOwnerType()
  {
    return this.ownerType;
  }
  
  public Type getRawType()
  {
    return this.rawType;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ .Gson.Types.hashCodeOrZero(this.ownerType);
  }
  
  public String toString()
  {
    int j = this.typeArguments.length;
    if (j == 0) {
      return .Gson.Types.typeToString(this.rawType);
    }
    StringBuilder localStringBuilder = new StringBuilder((j + 1) * 30);
    localStringBuilder.append(.Gson.Types.typeToString(this.rawType));
    localStringBuilder.append("<");
    localStringBuilder.append(.Gson.Types.typeToString(this.typeArguments[0]));
    int i = 1;
    while (i < j)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(.Gson.Types.typeToString(this.typeArguments[i]));
      i += 1;
    }
    localStringBuilder.append(">");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.internal..Gson.Types.ParameterizedTypeImpl
 * JD-Core Version:    0.7.0.1
 */