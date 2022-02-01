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
    int i = paramArrayOfType2.length;
    boolean bool2 = true;
    boolean bool1;
    if (i <= 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    eg.a(bool1);
    if (paramArrayOfType1.length == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    eg.a(bool1);
    if (paramArrayOfType2.length == 1)
    {
      eg.a(paramArrayOfType2[0]);
      eh.e(paramArrayOfType2[0]);
      if (paramArrayOfType1[0] == Object.class) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      eg.a(bool1);
      this.b = eh.a(paramArrayOfType2[0]);
      this.a = Object.class;
      return;
    }
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
    Type localType = this.b;
    if (localType != null) {
      return new Type[] { localType };
    }
    return eh.a;
  }
  
  public final Type[] getUpperBounds()
  {
    return new Type[] { this.a };
  }
  
  public final int hashCode()
  {
    Type localType = this.b;
    int i;
    if (localType != null) {
      i = localType.hashCode() + 31;
    } else {
      i = 1;
    }
    return i ^ this.a.hashCode() + 31;
  }
  
  public final String toString()
  {
    if (this.b != null)
    {
      localStringBuilder = new StringBuilder("? super ");
      localStringBuilder.append(eh.c(this.b));
      return localStringBuilder.toString();
    }
    if (this.a == Object.class) {
      return "?";
    }
    StringBuilder localStringBuilder = new StringBuilder("? extends ");
    localStringBuilder.append(eh.c(this.a));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.eh.c
 * JD-Core Version:    0.7.0.1
 */