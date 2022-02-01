package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;

public class ResourceBitmapDecoder
  implements ResourceDecoder<Uri, Bitmap>
{
  private final ResourceDrawableDecoder a;
  private final BitmapPool b;
  
  public ResourceBitmapDecoder(ResourceDrawableDecoder paramResourceDrawableDecoder, BitmapPool paramBitmapPool)
  {
    this.a = paramResourceDrawableDecoder;
    this.b = paramBitmapPool;
  }
  
  @Nullable
  public Resource<Bitmap> a(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    paramUri = this.a.a(paramUri, paramInt1, paramInt2, paramOptions);
    if (paramUri == null) {
      return null;
    }
    paramUri = (Drawable)paramUri.d();
    return DrawableToBitmapConverter.a(this.b, paramUri, paramInt1, paramInt2);
  }
  
  public boolean a(@NonNull Uri paramUri, @NonNull Options paramOptions)
  {
    return "android.resource".equals(paramUri.getScheme());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder
 * JD-Core Version:    0.7.0.1
 */