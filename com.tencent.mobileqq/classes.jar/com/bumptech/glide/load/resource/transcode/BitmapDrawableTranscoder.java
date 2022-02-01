package com.bumptech.glide.load.resource.transcode;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

public class BitmapDrawableTranscoder
  implements ResourceTranscoder<Bitmap, BitmapDrawable>
{
  private final Resources a;
  
  public BitmapDrawableTranscoder(@NonNull Resources paramResources)
  {
    this.a = ((Resources)Preconditions.a(paramResources));
  }
  
  @Nullable
  public Resource<BitmapDrawable> a(@NonNull Resource<Bitmap> paramResource, @NonNull Options paramOptions)
  {
    return LazyBitmapDrawableResource.a(this.a, paramResource);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder
 * JD-Core Version:    0.7.0.1
 */