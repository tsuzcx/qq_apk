package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

public class UnitDrawableDecoder
  implements ResourceDecoder<Drawable, Drawable>
{
  @Nullable
  public Resource<Drawable> a(@NonNull Drawable paramDrawable, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    return NonOwnedDrawableResource.a(paramDrawable);
  }
  
  public boolean a(@NonNull Drawable paramDrawable, @NonNull Options paramOptions)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder
 * JD-Core Version:    0.7.0.1
 */