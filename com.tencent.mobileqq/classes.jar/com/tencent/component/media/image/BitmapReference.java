package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.component.media.utils.BitmapUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BitmapReference
{
  private static final String TAG = "BitmapReference";
  static int releaseCount = 0;
  private static Set<Bitmap> sBitmapMemSet = Collections.synchronizedSet(new HashSet());
  private static Releaser<Bitmap> sReleaser;
  private volatile boolean isReleased = false;
  private Bitmap mBitmap;
  
  @TargetApi(19)
  public static BitmapReference getBitmapReference(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      BitmapReference localBitmapReference = new BitmapReference();
      localBitmapReference.mBitmap = paramBitmap;
      if ((!ImageManager.sCloseNativeAndCache) && (paramBitmap.isMutable())) {
        sBitmapMemSet.add(paramBitmap);
      }
      return localBitmapReference;
    }
    return null;
  }
  
  public static void setGlobalReleaser(Releaser<Bitmap> paramReleaser)
  {
    sReleaser = paramReleaser;
  }
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 82	com/tencent/component/media/image/BitmapReference:release	()V
    //   4: aload_0
    //   5: invokespecial 84	java/lang/Object:finalize	()V
    //   8: return
    //   9: astore_1
    //   10: goto +40 -> 50
    //   13: astore_1
    //   14: new 86	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   21: astore_2
    //   22: aload_2
    //   23: ldc 89
    //   25: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: aload_1
    //   31: invokestatic 99	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   34: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: ldc 8
    //   40: aload_2
    //   41: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 109	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: goto -43 -> 4
    //   50: aload_0
    //   51: invokespecial 84	java/lang/Object:finalize	()V
    //   54: goto +5 -> 59
    //   57: aload_1
    //   58: athrow
    //   59: goto -2 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	BitmapReference
    //   9	1	1	localObject	Object
    //   13	45	1	localThrowable	java.lang.Throwable
    //   21	20	2	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	4	9	finally
    //   14	47	9	finally
    //   0	4	13	java/lang/Throwable
  }
  
  public final int getAllocSize()
  {
    return BitmapUtils.getBitmapAllocSize(this.mBitmap);
  }
  
  public Bitmap getBitmap()
  {
    if (this.mBitmap.isRecycled()) {
      return null;
    }
    return this.mBitmap;
  }
  
  public final Bitmap.Config getConfig()
  {
    return this.mBitmap.getConfig();
  }
  
  public final int getHeight()
  {
    return this.mBitmap.getHeight();
  }
  
  public final int getRowBytes()
  {
    return this.mBitmap.getRowBytes();
  }
  
  public final int getWidth()
  {
    return this.mBitmap.getWidth();
  }
  
  public final boolean hasAlpha()
  {
    return this.mBitmap.hasAlpha();
  }
  
  public final boolean isMutable()
  {
    return this.mBitmap.isMutable();
  }
  
  public final boolean isRecycled()
  {
    return this.mBitmap.isRecycled();
  }
  
  @TargetApi(19)
  public void release()
  {
    if (!this.isReleased)
    {
      if (ImageManager.sCloseNativeAndCache) {
        return;
      }
      this.isReleased = true;
      if (!sBitmapMemSet.remove(this.mBitmap)) {
        return;
      }
      if (!this.mBitmap.isRecycled())
      {
        if (!this.mBitmap.isMutable()) {
          return;
        }
        Releaser localReleaser = sReleaser;
        if (localReleaser != null)
        {
          localReleaser.release(this.mBitmap);
          return;
        }
        this.mBitmap.recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.BitmapReference
 * JD-Core Version:    0.7.0.1
 */