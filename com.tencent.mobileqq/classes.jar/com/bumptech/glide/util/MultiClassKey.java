package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class MultiClassKey
{
  private Class<?> a;
  private Class<?> b;
  private Class<?> c;
  
  public MultiClassKey() {}
  
  public MultiClassKey(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2)
  {
    a(paramClass1, paramClass2);
  }
  
  public MultiClassKey(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2, @Nullable Class<?> paramClass3)
  {
    a(paramClass1, paramClass2, paramClass3);
  }
  
  public void a(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2)
  {
    a(paramClass1, paramClass2, null);
  }
  
  public void a(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2, @Nullable Class<?> paramClass3)
  {
    this.a = paramClass1;
    this.b = paramClass2;
    this.c = paramClass3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (MultiClassKey)paramObject;
      if (!this.a.equals(paramObject.a)) {
        return false;
      }
      if (!this.b.equals(paramObject.b)) {
        return false;
      }
      return Util.a(this.c, paramObject.c);
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.a.hashCode();
    int k = this.b.hashCode();
    Class localClass = this.c;
    int i;
    if (localClass != null) {
      i = localClass.hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiClassKey{first=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", second=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.MultiClassKey
 * JD-Core Version:    0.7.0.1
 */