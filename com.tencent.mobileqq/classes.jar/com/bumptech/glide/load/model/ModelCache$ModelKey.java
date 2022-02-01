package com.bumptech.glide.load.model;

import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import java.util.Queue;

@VisibleForTesting
final class ModelCache$ModelKey<A>
{
  private static final Queue<ModelKey<?>> a = Util.a(0);
  private int b;
  private int c;
  private A d;
  
  static <A> ModelKey<A> a(A paramA, int paramInt1, int paramInt2)
  {
    synchronized (a)
    {
      ModelKey localModelKey = (ModelKey)a.poll();
      ??? = localModelKey;
      if (localModelKey == null) {
        ??? = new ModelKey();
      }
      ((ModelKey)???).b(paramA, paramInt1, paramInt2);
      return ???;
    }
  }
  
  private void b(A paramA, int paramInt1, int paramInt2)
  {
    this.d = paramA;
    this.c = paramInt1;
    this.b = paramInt2;
  }
  
  public void a()
  {
    synchronized (a)
    {
      a.offer(this);
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof ModelKey;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (ModelKey)paramObject;
      bool1 = bool2;
      if (this.c == paramObject.c)
      {
        bool1 = bool2;
        if (this.b == paramObject.b)
        {
          bool1 = bool2;
          if (this.d.equals(paramObject.d)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (this.b * 31 + this.c) * 31 + this.d.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ModelCache.ModelKey
 * JD-Core Version:    0.7.0.1
 */