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
    int i;
    boolean bool;
    if ((paramType2 instanceof Class))
    {
      Class localClass = (Class)paramType2;
      if ((Modifier.isStatic(localClass.getModifiers())) || (localClass.getEnclosingClass() == null))
      {
        i = 1;
        if ((paramType1 == null) && (i == 0)) {
          break label160;
        }
        bool = true;
        label54:
        .Gson.Preconditions.checkArgument(bool);
      }
    }
    else
    {
      if (paramType1 != null) {
        break label166;
      }
    }
    label160:
    label166:
    for (paramType1 = null;; paramType1 = .Gson.Types.canonicalize(paramType1))
    {
      this.ownerType = paramType1;
      this.rawType = .Gson.Types.canonicalize(paramType2);
      this.typeArguments = ((Type[])paramVarArgs.clone());
      int k = this.typeArguments.length;
      i = j;
      while (i < k)
      {
        .Gson.Preconditions.checkNotNull(this.typeArguments[i]);
        .Gson.Types.checkNotPrimitive(this.typeArguments[i]);
        this.typeArguments[i] = .Gson.Types.canonicalize(this.typeArguments[i]);
        i += 1;
      }
      i = 0;
      break;
      bool = false;
      break label54;
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
    localStringBuilder.append(.Gson.Types.typeToString(this.rawType)).append("<").append(.Gson.Types.typeToString(this.typeArguments[0]));
    int i = 1;
    while (i < j)
    {
      localStringBuilder.append(", ").append(.Gson.Types.typeToString(this.typeArguments[i]));
      i += 1;
    }
    return ">";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal..Gson.Types.ParameterizedTypeImpl
 * JD-Core Version:    0.7.0.1
 */