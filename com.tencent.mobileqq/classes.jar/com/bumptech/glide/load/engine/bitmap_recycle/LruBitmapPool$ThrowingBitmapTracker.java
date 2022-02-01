package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class LruBitmapPool$ThrowingBitmapTracker
  implements LruBitmapPool.BitmapTracker
{
  private final Set<Bitmap> a = Collections.synchronizedSet(new HashSet());
  
  public void a(Bitmap paramBitmap)
  {
    if (!this.a.contains(paramBitmap))
    {
      this.a.add(paramBitmap);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Can't add already added bitmap: ");
    localStringBuilder.append(paramBitmap);
    localStringBuilder.append(" [");
    localStringBuilder.append(paramBitmap.getWidth());
    localStringBuilder.append("x");
    localStringBuilder.append(paramBitmap.getHeight());
    localStringBuilder.append("]");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void b(Bitmap paramBitmap)
  {
    if (this.a.contains(paramBitmap))
    {
      this.a.remove(paramBitmap);
      return;
    }
    throw new IllegalStateException("Cannot remove bitmap not in tracker");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.ThrowingBitmapTracker
 * JD-Core Version:    0.7.0.1
 */