package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

public class BitmapDrawableEncoder
  implements ResourceEncoder<BitmapDrawable>
{
  private final BitmapPool a;
  private final ResourceEncoder<Bitmap> b;
  
  public BitmapDrawableEncoder(BitmapPool paramBitmapPool, ResourceEncoder<Bitmap> paramResourceEncoder)
  {
    this.a = paramBitmapPool;
    this.b = paramResourceEncoder;
  }
  
  @NonNull
  public EncodeStrategy a(@NonNull Options paramOptions)
  {
    return this.b.a(paramOptions);
  }
  
  public boolean a(@NonNull Resource<BitmapDrawable> paramResource, @NonNull File paramFile, @NonNull Options paramOptions)
  {
    return this.b.a(new BitmapResource(((BitmapDrawable)paramResource.d()).getBitmap(), this.a), paramFile, paramOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder
 * JD-Core Version:    0.7.0.1
 */