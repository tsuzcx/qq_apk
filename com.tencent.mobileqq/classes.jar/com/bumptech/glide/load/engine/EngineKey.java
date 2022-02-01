package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

class EngineKey
  implements Key
{
  private final Object b;
  private final int c;
  private final int d;
  private final Class<?> e;
  private final Class<?> f;
  private final Key g;
  private final Map<Class<?>, Transformation<?>> h;
  private final Options i;
  private int j;
  
  EngineKey(Object paramObject, Key paramKey, int paramInt1, int paramInt2, Map<Class<?>, Transformation<?>> paramMap, Class<?> paramClass1, Class<?> paramClass2, Options paramOptions)
  {
    this.b = Preconditions.a(paramObject);
    this.g = ((Key)Preconditions.a(paramKey, "Signature must not be null"));
    this.c = paramInt1;
    this.d = paramInt2;
    this.h = ((Map)Preconditions.a(paramMap));
    this.e = ((Class)Preconditions.a(paramClass1, "Resource class must not be null"));
    this.f = ((Class)Preconditions.a(paramClass2, "Transcode class must not be null"));
    this.i = ((Options)Preconditions.a(paramOptions));
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof EngineKey;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (EngineKey)paramObject;
      bool1 = bool2;
      if (this.b.equals(paramObject.b))
      {
        bool1 = bool2;
        if (this.g.equals(paramObject.g))
        {
          bool1 = bool2;
          if (this.d == paramObject.d)
          {
            bool1 = bool2;
            if (this.c == paramObject.c)
            {
              bool1 = bool2;
              if (this.h.equals(paramObject.h))
              {
                bool1 = bool2;
                if (this.e.equals(paramObject.e))
                {
                  bool1 = bool2;
                  if (this.f.equals(paramObject.f))
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
    }
    return bool1;
  }
  
  public int hashCode()
  {
    if (this.j == 0)
    {
      this.j = this.b.hashCode();
      this.j = (this.j * 31 + this.g.hashCode());
      this.j = (this.j * 31 + this.c);
      this.j = (this.j * 31 + this.d);
      this.j = (this.j * 31 + this.h.hashCode());
      this.j = (this.j * 31 + this.e.hashCode());
      this.j = (this.j * 31 + this.f.hashCode());
      this.j = (this.j * 31 + this.i.hashCode());
    }
    return this.j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EngineKey{model=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", resourceClass=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", transcodeClass=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", signature=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", hashCode=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", transformations=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", options=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.EngineKey
 * JD-Core Version:    0.7.0.1
 */