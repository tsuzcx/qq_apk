package com.tencent.map.sdk.a;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

final class eh$c
  implements Serializable, WildcardType
{
  private final Type a;
  private final Type b;
  
  public eh$c(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
  {
    if (paramArrayOfType2.length <= 1)
    {
      bool1 = true;
      eg.a(bool1);
      if (paramArrayOfType1.length != 1) {
        break label87;
      }
      bool1 = true;
      label27:
      eg.a(bool1);
      if (paramArrayOfType2.length != 1) {
        break label97;
      }
      eg.a(paramArrayOfType2[0]);
      eh.e(paramArrayOfType2[0]);
      if (paramArrayOfType1[0] != Object.class) {
        break label92;
      }
    }
    label87:
    label92:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      eg.a(bool1);
      this.b = eh.a(paramArrayOfType2[0]);
      this.a = Object.class;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label27;
    }
    label97:
    eg.a(paramArrayOfType1[0]);
    eh.e(paramArrayOfType1[0]);
    this.b = null;
    this.a = eh.a(paramArrayOfType1[0]);
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof WildcardType)) && (eh.a(this, (WildcardType)paramObject));
  }
  
  public final Type[] getLowerBounds()
  {
    if (this.b != null) {
      return new Type[] { this.b };
    }
    return eh.a;
  }
  
  public final Type[] getUpperBounds()
  {
    return new Type[] { this.a };
  }
  
  public final int hashCode()
  {
    if (this.b != null) {}
    for (int i = this.b.hashCode() + 31;; i = 1) {
      return i ^ this.a.hashCode() + 31;
    }
  }
  
  public final String toString()
  {
    if (this.b != null) {
      return "? super " + eh.c(this.b);
    }
    if (this.a == Object.class) {
      return "?";
    }
    return "? extends " + eh.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.eh.c
 * JD-Core Version:    0.7.0.1
 */