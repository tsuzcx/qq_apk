package com.bumptech.glide.load.resource.gif;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

final class GifDrawable$GifState
  extends Drawable.ConstantState
{
  @VisibleForTesting
  final GifFrameLoader a;
  
  GifDrawable$GifState(GifFrameLoader paramGifFrameLoader)
  {
    this.a = paramGifFrameLoader;
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    return new GifDrawable(this);
  }
  
  @NonNull
  public Drawable newDrawable(Resources paramResources)
  {
    return newDrawable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.gif.GifDrawable.GifState
 * JD-Core Version:    0.7.0.1
 */