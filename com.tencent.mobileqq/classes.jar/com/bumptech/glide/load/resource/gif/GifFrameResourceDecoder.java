package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

public final class GifFrameResourceDecoder
  implements ResourceDecoder<GifDecoder, Bitmap>
{
  private final BitmapPool a;
  
  public GifFrameResourceDecoder(BitmapPool paramBitmapPool)
  {
    this.a = paramBitmapPool;
  }
  
  public Resource<Bitmap> a(@NonNull GifDecoder paramGifDecoder, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    return BitmapResource.a(paramGifDecoder.h(), this.a);
  }
  
  public boolean a(@NonNull GifDecoder paramGifDecoder, @NonNull Options paramOptions)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder
 * JD-Core Version:    0.7.0.1
 */