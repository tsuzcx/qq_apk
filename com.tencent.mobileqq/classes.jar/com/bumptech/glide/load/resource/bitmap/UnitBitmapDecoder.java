package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

public final class UnitBitmapDecoder
  implements ResourceDecoder<Bitmap, Bitmap>
{
  public Resource<Bitmap> a(@NonNull Bitmap paramBitmap, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    return new UnitBitmapDecoder.NonOwnedBitmapResource(paramBitmap);
  }
  
  public boolean a(@NonNull Bitmap paramBitmap, @NonNull Options paramOptions)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder
 * JD-Core Version:    0.7.0.1
 */