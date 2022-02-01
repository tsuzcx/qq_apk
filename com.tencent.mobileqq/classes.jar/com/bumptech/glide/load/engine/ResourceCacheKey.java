package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class ResourceCacheKey
  implements Key
{
  private static final LruCache<Class<?>, byte[]> b = new LruCache(50L);
  private final ArrayPool c;
  private final Key d;
  private final Key e;
  private final int f;
  private final int g;
  private final Class<?> h;
  private final Options i;
  private final Transformation<?> j;
  
  ResourceCacheKey(ArrayPool paramArrayPool, Key paramKey1, Key paramKey2, int paramInt1, int paramInt2, Transformation<?> paramTransformation, Class<?> paramClass, Options paramOptions)
  {
    this.c = paramArrayPool;
    this.d = paramKey1;
    this.e = paramKey2;
    this.f = paramInt1;
    this.g = paramInt2;
    this.j = paramTransformation;
    this.h = paramClass;
    this.i = paramOptions;
  }
  
  private byte[] a()
  {
    byte[] arrayOfByte2 = (byte[])b.b(this.h);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = this.h.getName().getBytes(a);
      b.b(this.h, arrayOfByte1);
    }
    return arrayOfByte1;
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest)
  {
    byte[] arrayOfByte = (byte[])this.c.b(8, [B.class);
    ByteBuffer.wrap(arrayOfByte).putInt(this.f).putInt(this.g).array();
    this.e.a(paramMessageDigest);
    this.d.a(paramMessageDigest);
    paramMessageDigest.update(arrayOfByte);
    Transformation localTransformation = this.j;
    if (localTransformation != null) {
      localTransformation.a(paramMessageDigest);
    }
    this.i.a(paramMessageDigest);
    paramMessageDigest.update(a());
    this.c.a(arrayOfByte);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof ResourceCacheKey;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (ResourceCacheKey)paramObject;
      bool1 = bool2;
      if (this.g == paramObject.g)
      {
        bool1 = bool2;
        if (this.f == paramObject.f)
        {
          bool1 = bool2;
          if (Util.a(this.j, paramObject.j))
          {
            bool1 = bool2;
            if (this.h.equals(paramObject.h))
            {
              bool1 = bool2;
              if (this.d.equals(paramObject.d))
              {
                bool1 = bool2;
                if (this.e.equals(paramObject.e))
                {
                  bool1 = bool2;
                  if (this.i.equals(paramObject.i)) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    int m = ((this.d.hashCode() * 31 + this.e.hashCode()) * 31 + this.f) * 31 + this.g;
    Transformation localTransformation = this.j;
    int k = m;
    if (localTransformation != null) {
      k = m * 31 + localTransformation.hashCode();
    }
    return (k * 31 + this.h.hashCode()) * 31 + this.i.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResourceCacheKey{sourceKey=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", signature=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", decodedResourceClass=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", transformation='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", options=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.ResourceCacheKey
 * JD-Core Version:    0.7.0.1
 */