package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CenterInside
  extends BitmapTransformation
{
  private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(a);
  
  protected Bitmap a(@NonNull BitmapPool paramBitmapPool, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return TransformationUtils.c(paramBitmapPool, paramBitmap, paramInt1, paramInt2);
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(b);
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof CenterInside;
  }
  
  public int hashCode()
  {
    return "com.bumptech.glide.load.resource.bitmap.CenterInside".hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.CenterInside
 * JD-Core Version:    0.7.0.1
 */