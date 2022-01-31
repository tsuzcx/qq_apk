package com.tencent.map.sdk.a;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class eh$a
  implements Serializable, GenericArrayType
{
  private final Type a;
  
  public eh$a(Type paramType)
  {
    this.a = eh.a(paramType);
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof GenericArrayType)) && (eh.a(this, (GenericArrayType)paramObject));
  }
  
  public final Type getGenericComponentType()
  {
    return this.a;
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
  
  public final String toString()
  {
    return eh.c(this.a) + "[]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.eh.a
 * JD-Core Version:    0.7.0.1
 */