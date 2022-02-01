package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap.Config;
import android.support.annotation.VisibleForTesting;

@VisibleForTesting
class AttributeStrategy$Key
  implements Poolable
{
  private final AttributeStrategy.KeyPool a;
  private int b;
  private int c;
  private Bitmap.Config d;
  
  public AttributeStrategy$Key(AttributeStrategy.KeyPool paramKeyPool)
  {
    this.a = paramKeyPool;
  }
  
  public void a()
  {
    this.a.a(this);
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramConfig;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof Key;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (Key)paramObject;
      bool1 = bool2;
      if (this.b == paramObject.b)
      {
        bool1 = bool2;
        if (this.c == paramObject.c)
        {
          bool1 = bool2;
          if (this.d == paramObject.d) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    int j = this.b;
    int k = this.c;
    Bitmap.Config localConfig = this.d;
    int i;
    if (localConfig != null) {
      i = localConfig.hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    return AttributeStrategy.c(this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy.Key
 * JD-Core Version:    0.7.0.1
 */