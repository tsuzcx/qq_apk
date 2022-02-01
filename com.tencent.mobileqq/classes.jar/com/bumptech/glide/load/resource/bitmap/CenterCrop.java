package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CenterCrop
  extends BitmapTransformation
{
  private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(a);
  
  protected Bitmap a(@NonNull BitmapPool paramBitmapPool, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return TransformationUtils.a(paramBitmapPool, paramBitmap, paramInt1, paramInt2);
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(b);
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof CenterCrop;
  }
  
  public int hashCode()
  {
    return "com.bumptech.glide.load.resource.bitmap.CenterCrop".hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.CenterCrop
 * JD-Core Version:    0.7.0.1
 */