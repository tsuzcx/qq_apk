package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.util.concurrent.locks.Lock;

final class DrawableToBitmapConverter
{
  private static final BitmapPool a = new DrawableToBitmapConverter.1();
  
  @Nullable
  static Resource<Bitmap> a(BitmapPool paramBitmapPool, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    paramDrawable = paramDrawable.getCurrent();
    boolean bool = paramDrawable instanceof BitmapDrawable;
    int i = 0;
    if (bool)
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      paramInt1 = i;
    }
    else if (!(paramDrawable instanceof Animatable))
    {
      paramDrawable = b(paramBitmapPool, paramDrawable, paramInt1, paramInt2);
      paramInt1 = 1;
    }
    else
    {
      paramDrawable = null;
      paramInt1 = i;
    }
    if (paramInt1 == 0) {
      paramBitmapPool = a;
    }
    return BitmapResource.a(paramDrawable, paramBitmapPool);
  }
  
  @Nullable
  private static Bitmap b(BitmapPool paramBitmapPool, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -2147483648) && (paramDrawable.getIntrinsicWidth() <= 0))
    {
      if (Log.isLoggable("DrawableToBitmap", 5))
      {
        paramBitmapPool = new StringBuilder();
        paramBitmapPool.append("Unable to draw ");
        paramBitmapPool.append(paramDrawable);
        paramBitmapPool.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
        Log.w("DrawableToBitmap", paramBitmapPool.toString());
      }
      return null;
    }
    if ((paramInt2 == -2147483648) && (paramDrawable.getIntrinsicHeight() <= 0))
    {
      if (Log.isLoggable("DrawableToBitmap", 5))
      {
        paramBitmapPool = new StringBuilder();
        paramBitmapPool.append("Unable to draw ");
        paramBitmapPool.append(paramDrawable);
        paramBitmapPool.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
        Log.w("DrawableToBitmap", paramBitmapPool.toString());
      }
      return null;
    }
    if (paramDrawable.getIntrinsicWidth() > 0) {
      paramInt1 = paramDrawable.getIntrinsicWidth();
    }
    if (paramDrawable.getIntrinsicHeight() > 0) {
      paramInt2 = paramDrawable.getIntrinsicHeight();
    }
    Lock localLock = TransformationUtils.a();
    localLock.lock();
    paramBitmapPool = paramBitmapPool.a(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    try
    {
      Canvas localCanvas = new Canvas(paramBitmapPool);
      paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
      paramDrawable.draw(localCanvas);
      localCanvas.setBitmap(null);
      return paramBitmapPool;
    }
    finally
    {
      localLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter
 * JD-Core Version:    0.7.0.1
 */