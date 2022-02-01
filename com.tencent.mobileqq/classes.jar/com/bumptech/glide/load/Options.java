package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

public final class Options
  implements Key
{
  private final ArrayMap<Option<?>, Object> b = new CachedHashCodeArrayMap();
  
  private static <T> void a(@NonNull Option<T> paramOption, @NonNull Object paramObject, @NonNull MessageDigest paramMessageDigest)
  {
    paramOption.a(paramObject, paramMessageDigest);
  }
  
  @NonNull
  public <T> Options a(@NonNull Option<T> paramOption, @NonNull T paramT)
  {
    this.b.put(paramOption, paramT);
    return this;
  }
  
  @Nullable
  public <T> T a(@NonNull Option<T> paramOption)
  {
    if (this.b.containsKey(paramOption)) {
      return this.b.get(paramOption);
    }
    return paramOption.a();
  }
  
  public void a(@NonNull Options paramOptions)
  {
    this.b.putAll(paramOptions.b);
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest)
  {
    int i = 0;
    while (i < this.b.size())
    {
      a((Option)this.b.keyAt(i), this.b.valueAt(i), paramMessageDigest);
      i += 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Options))
    {
      paramObject = (Options)paramObject;
      return this.b.equals(paramObject.b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Options{values=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.Options
 * JD-Core Version:    0.7.0.1
 */