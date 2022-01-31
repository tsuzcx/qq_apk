package com.tencent.component.media.image;

import android.graphics.Bitmap;
import phl;

public final class ReuseBitmapCacheProxy
  extends BitmapPool
{
  ReuseBitmapCache a;
  
  public ReuseBitmapCacheProxy(PoolParams paramPoolParams, int paramInt)
  {
    super(new phl());
    this.a = ReuseBitmapCache.getInstance(paramInt);
  }
  
  /* Error */
  public Bitmap get(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/tencent/component/media/image/ReuseBitmapCacheProxy:a	Lcom/tencent/component/media/image/ReuseBitmapCache;
    //   6: iload_1
    //   7: invokevirtual 30	com/tencent/component/media/image/ReuseBitmapCache:getBitmapFromPool	(I)Landroid/graphics/Bitmap;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +24 -> 36
    //   15: aload_0
    //   16: iload_1
    //   17: invokevirtual 34	com/tencent/component/media/image/ReuseBitmapCacheProxy:miss	(I)V
    //   20: aload_3
    //   21: astore_2
    //   22: aload_3
    //   23: ifnonnull +9 -> 32
    //   26: aload_0
    //   27: iload_1
    //   28: invokevirtual 37	com/tencent/component/media/image/ReuseBitmapCacheProxy:allocData	(I)Landroid/graphics/Bitmap;
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: aload_0
    //   37: iload_1
    //   38: aload_3
    //   39: invokevirtual 41	com/tencent/component/media/image/ReuseBitmapCacheProxy:hit	(ILandroid/graphics/Bitmap;)V
    //   42: goto -22 -> 20
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	ReuseBitmapCacheProxy
    //   0	50	1	paramInt	int
    //   21	14	2	localBitmap1	Bitmap
    //   45	4	2	localObject	java.lang.Object
    //   10	29	3	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   2	11	45	finally
    //   15	20	45	finally
    //   26	32	45	finally
    //   36	42	45	finally
  }
  
  public void release(Bitmap paramBitmap)
  {
    try
    {
      if (!this.a.addBitMapIntoPool(paramBitmap)) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ReuseBitmapCacheProxy
 * JD-Core Version:    0.7.0.1
 */