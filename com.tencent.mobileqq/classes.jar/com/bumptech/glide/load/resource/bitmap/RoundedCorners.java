package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class RoundedCorners
  extends BitmapTransformation
{
  private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(a);
  private final int c;
  
  protected Bitmap a(@NonNull BitmapPool paramBitmapPool, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return TransformationUtils.b(paramBitmapPool, paramBitmap, this.c);
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(b);
    paramMessageDigest.update(ByteBuffer.allocate(4).putInt(this.c).array());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof RoundedCorners;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (RoundedCorners)paramObject;
      bool1 = bool2;
      if (this.c == paramObject.c) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return Util.b("com.bumptech.glide.load.resource.bitmap.RoundedCorners".hashCode(), Util.b(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.RoundedCorners
 * JD-Core Version:    0.7.0.1
 */