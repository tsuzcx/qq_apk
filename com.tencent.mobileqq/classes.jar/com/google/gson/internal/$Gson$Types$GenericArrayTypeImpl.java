package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class $Gson$Types$GenericArrayTypeImpl
  implements Serializable, GenericArrayType
{
  private static final long serialVersionUID = 0L;
  private final Type componentType;
  
  public $Gson$Types$GenericArrayTypeImpl(Type paramType)
  {
    this.componentType = .Gson.Types.canonicalize(paramType);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof GenericArrayType)) && (.Gson.Types.equals(this, (GenericArrayType)paramObject));
  }
  
  public Type getGenericComponentType()
  {
    return this.componentType;
  }
  
  public int hashCode()
  {
    return this.componentType.hashCode();
  }
  
  public String toString()
  {
    return .Gson.Types.typeToString(this.componentType) + "[]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.gson.internal..Gson.Types.GenericArrayTypeImpl
 * JD-Core Version:    0.7.0.1
 */