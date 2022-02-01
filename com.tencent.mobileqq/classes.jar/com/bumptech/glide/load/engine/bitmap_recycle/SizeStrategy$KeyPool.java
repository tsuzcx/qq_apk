package com.bumptech.glide.load.engine.bitmap_recycle;

import android.support.annotation.VisibleForTesting;

@VisibleForTesting
class SizeStrategy$KeyPool
  extends BaseKeyPool<SizeStrategy.Key>
{
  protected SizeStrategy.Key a()
  {
    return new SizeStrategy.Key(this);
  }
  
  public SizeStrategy.Key a(int paramInt)
  {
    SizeStrategy.Key localKey = (SizeStrategy.Key)super.c();
    localKey.a(paramInt);
    return localKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy.KeyPool
 * JD-Core Version:    0.7.0.1
 */