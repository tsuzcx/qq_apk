package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Rect;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

final class SafeBitmapFactory$1
  implements Runnable
{
  SafeBitmapFactory$1(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject, Canvas paramCanvas, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    int i = 1;
    for (;;)
    {
      try
      {
        if (this.val$fopts.inSampleSize > 0) {
          i = this.val$fopts.inSampleSize;
        }
        ??? = new Rect(this.val$fj * this.val$perWidth * i, this.val$fi * this.val$perHeight * i, (this.val$fj + 1) * this.val$perWidth * i, i * ((this.val$fi + 1) * this.val$perHeight));
        localObject1 = SafeBitmapFactory.access$000(this.val$dataSource, true);
        localBitmap = ((BitmapRegionDecoder)localObject1).decodeRegion((Rect)???, this.val$fopts);
      }
      catch (IOException localIOException)
      {
        Object localObject1;
        Bitmap localBitmap;
        localIOException.printStackTrace();
        CountDownLatch localCountDownLatch = this.val$countDownLatch;
        continue;
      }
      finally
      {
        this.val$countDownLatch.countDown();
      }
      synchronized (this.val$canvas)
      {
        this.val$canvas.drawBitmap(localBitmap, this.val$fj * this.val$perWidth, this.val$fi * this.val$perHeight, null);
        localBitmap.recycle();
        ((BitmapRegionDecoder)localObject1).recycle();
        localObject1 = this.val$countDownLatch;
        ((CountDownLatch)localObject1).countDown();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.SafeBitmapFactory.1
 * JD-Core Version:    0.7.0.1
 */