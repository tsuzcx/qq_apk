package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

final class DataCacheKey
  implements Key
{
  private final Key b;
  private final Key c;
  
  DataCacheKey(Key paramKey1, Key paramKey2)
  {
    this.b = paramKey1;
    this.c = paramKey2;
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest)
  {
    this.b.a(paramMessageDigest);
    this.c.a(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof DataCacheKey;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (DataCacheKey)paramObject;
      bool1 = bool2;
      if (this.b.equals(paramObject.b))
      {
        bool1 = bool2;
        if (this.c.equals(paramObject.c)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.b.hashCode() * 31 + this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataCacheKey{sourceKey=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", signature=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.DataCacheKey
 * JD-Core Version:    0.7.0.1
 */