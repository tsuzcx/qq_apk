package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

final class $Gson$Types$WildcardTypeImpl
  implements Serializable, WildcardType
{
  private static final long serialVersionUID = 0L;
  private final Type lowerBound;
  private final Type upperBound;
  
  public $Gson$Types$WildcardTypeImpl(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
  {
    int i = paramArrayOfType2.length;
    boolean bool2 = true;
    boolean bool1;
    if (i <= 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    .Gson.Preconditions.checkArgument(bool1);
    if (paramArrayOfType1.length == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    .Gson.Preconditions.checkArgument(bool1);
    if (paramArrayOfType2.length == 1)
    {
      .Gson.Preconditions.checkNotNull(paramArrayOfType2[0]);
      .Gson.Types.checkNotPrimitive(paramArrayOfType2[0]);
      if (paramArrayOfType1[0] == Object.class) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      .Gson.Preconditions.checkArgument(bool1);
      this.lowerBound = .Gson.Types.canonicalize(paramArrayOfType2[0]);
      this.upperBound = Object.class;
      return;
    }
    .Gson.Preconditions.checkNotNull(paramArrayOfType1[0]);
    .Gson.Types.checkNotPrimitive(paramArrayOfType1[0]);
    this.lowerBound = null;
    this.upperBound = .Gson.Types.canonicalize(paramArrayOfType1[0]);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof WildcardType)) && (.Gson.Types.equals(this, (WildcardType)paramObject));
  }
  
  public Type[] getLowerBounds()
  {
    Type localType = this.lowerBound;
    if (localType != null) {
      return new Type[] { localType };
    }
    return .Gson.Types.EMPTY_TYPE_ARRAY;
  }
  
  public Type[] getUpperBounds()
  {
    return new Type[] { this.upperBound };
  }
  
  public int hashCode()
  {
    Type localType = this.lowerBound;
    int i;
    if (localType != null) {
      i = localType.hashCode() + 31;
    } else {
      i = 1;
    }
    return i ^ this.upperBound.hashCode() + 31;
  }
  
  public String toString()
  {
    if (this.lowerBound != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("? super ");
      localStringBuilder.append(.Gson.Types.typeToString(this.lowerBound));
      return localStringBuilder.toString();
    }
    if (this.upperBound == Object.class) {
      return "?";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("? extends ");
    localStringBuilder.append(.Gson.Types.typeToString(this.upperBound));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.internal..Gson.Types.WildcardTypeImpl
 * JD-Core Version:    0.7.0.1
 */