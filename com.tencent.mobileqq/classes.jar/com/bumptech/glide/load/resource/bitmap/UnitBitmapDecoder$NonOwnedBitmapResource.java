package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

final class UnitBitmapDecoder$NonOwnedBitmapResource
  implements Resource<Bitmap>
{
  private final Bitmap a;
  
  UnitBitmapDecoder$NonOwnedBitmapResource(@NonNull Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }
  
  @NonNull
  public Bitmap a()
  {
    return this.a;
  }
  
  @NonNull
  public Class<Bitmap> c()
  {
    return Bitmap.class;
  }
  
  public int e()
  {
    return Util.a(this.a);
  }
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder.NonOwnedBitmapResource
 * JD-Core Version:    0.7.0.1
 */