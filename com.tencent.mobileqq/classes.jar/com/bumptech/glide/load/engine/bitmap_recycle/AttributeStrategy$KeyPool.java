package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap.Config;
import android.support.annotation.VisibleForTesting;

@VisibleForTesting
class AttributeStrategy$KeyPool
  extends BaseKeyPool<AttributeStrategy.Key>
{
  protected AttributeStrategy.Key a()
  {
    return new AttributeStrategy.Key(this);
  }
  
  AttributeStrategy.Key a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AttributeStrategy.Key localKey = (AttributeStrategy.Key)c();
    localKey.a(paramInt1, paramInt2, paramConfig);
    return localKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy.KeyPool
 * JD-Core Version:    0.7.0.1
 */