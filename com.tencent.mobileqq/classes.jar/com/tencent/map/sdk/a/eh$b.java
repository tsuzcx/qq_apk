package com.tencent.map.sdk.a;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class eh$b
  implements Serializable, ParameterizedType
{
  private final Type a;
  private final Type b;
  private final Type[] c;
  
  public eh$b(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    boolean bool1;
    if ((paramType2 instanceof Class))
    {
      Class localClass = (Class)paramType2;
      if ((paramType1 != null) || (localClass.getEnclosingClass() == null))
      {
        bool1 = true;
        eg.a(bool1);
        bool1 = bool2;
        if (paramType1 != null)
        {
          if (localClass.getEnclosingClass() == null) {
            break label160;
          }
          bool1 = bool2;
        }
        label63:
        eg.a(bool1);
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
    for (paramType1 = null;; paramType1 = eh.a(paramType1))
    {
      this.a = paramType1;
      this.b = eh.a(paramType2);
      this.c = ((Type[])paramVarArgs.clone());
      while (i < this.c.length)
      {
        eg.a(this.c[i]);
        eh.e(this.c[i]);
        paramType1 = this.c;
        paramType1[i] = eh.a(paramType1[i]);
        i += 1;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label63;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ParameterizedType)) && (eh.a(this, (ParameterizedType)paramObject));
  }
  
  public final Type[] getActualTypeArguments()
  {
    return (Type[])this.c.clone();
  }
  
  public final Type getOwnerType()
  {
    return this.a;
  }
  
  public final Type getRawType()
  {
    return this.b;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(this.c) ^ this.b.hashCode() ^ eh.a(this.a);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder((this.c.length + 1) * 30);
    localStringBuilder.append(eh.c(this.b));
    if (this.c.length == 0) {
      return localStringBuilder.toString();
    }
    localStringBuilder.append("<").append(eh.c(this.c[0]));
    int i = 1;
    while (i < this.c.length)
    {
      localStringBuilder.append(", ").append(eh.c(this.c[i]));
      i += 1;
    }
    return ">";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.eh.b
 * JD-Core Version:    0.7.0.1
 */