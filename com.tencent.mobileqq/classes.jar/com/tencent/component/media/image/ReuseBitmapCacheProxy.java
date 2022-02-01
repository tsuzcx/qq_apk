package com.tencent.component.media.image;

import android.graphics.Bitmap;

public final class ReuseBitmapCacheProxy
  extends BitmapPool
{
  private static final String TAG = "NewBitmapPool";
  ReuseBitmapCache advanceBitmapPool;
  
  public ReuseBitmapCacheProxy(PoolParams paramPoolParams, int paramInt)
  {
    super(new ReuseBitmapCacheProxy.1());
    this.advanceBitmapPool = ReuseBitmapCache.getInstance(paramInt);
  }
  
  public Bitmap get(int paramInt)
  {
    try
    {
      Bitmap localBitmap2 = this.advanceBitmapPool.getBitmapFromPool(paramInt);
      if (localBitmap2 == null) {
        miss(paramInt);
      } else {
        hit(paramInt, localBitmap2);
      }
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = allocData(paramInt);
      }
      return localBitmap1;
    }
    finally {}
  }
  
  public void release(Bitmap paramBitmap)
  {
    try
    {
      if (!this.advanceBitmapPool.addBitMapIntoPool(paramBitmap)) {
        releaseData(paramBitmap);
      }
      return;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  public void resizeCache(float paramFloat)
  {
    ReuseBitmapCache localReuseBitmapCache = this.advanceBitmapPool;
    if (localReuseBitmapCache != null) {
      localReuseBitmapCache.resiezeCache(paramFloat);
    }
  }
  
  public void trimToSize(float paramFloat)
  {
    ReuseBitmapCache localReuseBitmapCache = this.advanceBitmapPool;
    if (localReuseBitmapCache != null) {
      localReuseBitmapCache.trimToSize(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.ReuseBitmapCacheProxy
 * JD-Core Version:    0.7.0.1
 */