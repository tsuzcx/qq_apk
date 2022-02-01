package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class Option<T>
{
  private static final Option.CacheKeyUpdater<Object> a = new Option.1();
  private final T b;
  private final Option.CacheKeyUpdater<T> c;
  private final String d;
  private volatile byte[] e;
  
  private Option(@NonNull String paramString, @Nullable T paramT, @NonNull Option.CacheKeyUpdater<T> paramCacheKeyUpdater)
  {
    this.d = Preconditions.a(paramString);
    this.b = paramT;
    this.c = ((Option.CacheKeyUpdater)Preconditions.a(paramCacheKeyUpdater));
  }
  
  @NonNull
  public static <T> Option<T> a(@NonNull String paramString)
  {
    return new Option(paramString, null, c());
  }
  
  @NonNull
  public static <T> Option<T> a(@NonNull String paramString, @NonNull T paramT)
  {
    return new Option(paramString, paramT, c());
  }
  
  @NonNull
  public static <T> Option<T> a(@NonNull String paramString, @Nullable T paramT, @NonNull Option.CacheKeyUpdater<T> paramCacheKeyUpdater)
  {
    return new Option(paramString, paramT, paramCacheKeyUpdater);
  }
  
  @NonNull
  private byte[] b()
  {
    if (this.e == null) {
      this.e = this.d.getBytes(Key.a);
    }
    return this.e;
  }
  
  @NonNull
  private static <T> Option.CacheKeyUpdater<T> c()
  {
    return a;
  }
  
  @Nullable
  public T a()
  {
    return this.b;
  }
  
  public void a(@NonNull T paramT, @NonNull MessageDigest paramMessageDigest)
  {
    this.c.a(b(), paramT, paramMessageDigest);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Option))
    {
      paramObject = (Option)paramObject;
      return this.d.equals(paramObject.d);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.d.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Option{key='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.Option
 * JD-Core Version:    0.7.0.1
 */