package com.tencent.component.media.image;

import android.graphics.Bitmap;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class ReuseBitmapCache
{
  public static final String TAG = "AdvanceBitmapPool";
  private static ReuseBitmapCache instance;
  ReuseBitmapPool bigBitmapBucket;
  ReuseBitmapPool smallBitmapBucket;
  
  private ReuseBitmapCache(int paramInt)
  {
    String str = ImageManagerEnv.g().getProcessName(ImageManagerEnv.getAppContext());
    if ((str != null) && (str.contains(":picture"))) {
      i = 1;
    } else {
      i = 0;
    }
    int j = ImageDefaultConfig.getScreenWidth(ImageManagerEnv.getAppContext());
    int k = ImageDefaultConfig.getScreenHeight(ImageManagerEnv.getAppContext());
    if (i != 0)
    {
      i = paramInt >> 1;
      m = j * k * 4;
      this.smallBitmapBucket = new ReuseBitmapPool(paramInt - i, j * j, m);
      this.bigBitmapBucket = new ReuseBitmapPool(i, j * 4 * k, m * 2);
      return;
    }
    int i = paramInt >> 2;
    int m = j * j;
    if (i <= m) {
      i = 1;
    } else {
      paramInt -= i;
    }
    k = j * k * 4;
    this.smallBitmapBucket = new ReuseBitmapPool(paramInt, m, k);
    this.bigBitmapBucket = new ReuseBitmapPool(i, j * 4 * j, k);
  }
  
  public static ReuseBitmapCache getInstance(int paramInt)
  {
    if (instance == null) {
      try
      {
        if (instance == null)
        {
          ILog localILog = ImageManagerEnv.getLogger();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("maxSize:");
          localStringBuilder.append(paramInt);
          localILog.d("AdvanceBitmapPool", new Object[] { localStringBuilder.toString() });
          instance = new ReuseBitmapCache(paramInt);
        }
      }
      finally {}
    }
    return instance;
  }
  
  public boolean addBitMapIntoPool(Bitmap paramBitmap)
  {
    try
    {
      if (!this.smallBitmapBucket.addBitMapIntoPool(paramBitmap))
      {
        boolean bool = this.bigBitmapBucket.addBitMapIntoPool(paramBitmap);
        return bool;
      }
      return true;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  public Bitmap getBitmapFromPool(int paramInt)
  {
    try
    {
      Bitmap localBitmap2 = this.smallBitmapBucket.getBitmapFromPool(paramInt);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = this.bigBitmapBucket.getBitmapFromPool(paramInt);
      }
      return localBitmap1;
    }
    finally {}
  }
  
  public void resiezeCache(float paramFloat)
  {
    ReuseBitmapPool localReuseBitmapPool = this.smallBitmapBucket;
    if (localReuseBitmapPool != null) {
      localReuseBitmapPool.resizeCahce(paramFloat);
    }
    localReuseBitmapPool = this.bigBitmapBucket;
    if (localReuseBitmapPool != null) {
      localReuseBitmapPool.resizeCahce(paramFloat);
    }
  }
  
  public void trimToSize(float paramFloat)
  {
    ReuseBitmapPool localReuseBitmapPool = this.smallBitmapBucket;
    if (localReuseBitmapPool != null) {
      localReuseBitmapPool.trimToSize(paramFloat);
    }
    localReuseBitmapPool = this.bigBitmapBucket;
    if (localReuseBitmapPool != null) {
      localReuseBitmapPool.trimToSize(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.ReuseBitmapCache
 * JD-Core Version:    0.7.0.1
 */