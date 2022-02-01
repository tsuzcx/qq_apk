package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap.Config;
import android.support.annotation.VisibleForTesting;

@VisibleForTesting
class SizeConfigStrategy$KeyPool
  extends BaseKeyPool<SizeConfigStrategy.Key>
{
  protected SizeConfigStrategy.Key a()
  {
    return new SizeConfigStrategy.Key(this);
  }
  
  public SizeConfigStrategy.Key a(int paramInt, Bitmap.Config paramConfig)
  {
    SizeConfigStrategy.Key localKey = (SizeConfigStrategy.Key)c();
    localKey.a(paramInt, paramConfig);
    return localKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.KeyPool
 * JD-Core Version:    0.7.0.1
 */