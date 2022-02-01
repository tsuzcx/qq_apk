package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap.Config;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;

@VisibleForTesting
final class SizeConfigStrategy$Key
  implements Poolable
{
  int a;
  private final SizeConfigStrategy.KeyPool b;
  private Bitmap.Config c;
  
  public SizeConfigStrategy$Key(SizeConfigStrategy.KeyPool paramKeyPool)
  {
    this.b = paramKeyPool;
  }
  
  public void a()
  {
    this.b.a(this);
  }
  
  public void a(int paramInt, Bitmap.Config paramConfig)
  {
    this.a = paramInt;
    this.c = paramConfig;
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
      if (this.a == paramObject.a)
      {
        bool1 = bool2;
        if (Util.a(this.c, paramObject.c)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    int j = this.a;
    Bitmap.Config localConfig = this.c;
    int i;
    if (localConfig != null) {
      i = localConfig.hashCode();
    } else {
      i = 0;
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    return SizeConfigStrategy.a(this.a, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key
 * JD-Core Version:    0.7.0.1
 */