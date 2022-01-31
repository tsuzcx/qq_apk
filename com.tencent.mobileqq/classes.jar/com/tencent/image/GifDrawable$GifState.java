package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class GifDrawable$GifState
  extends Drawable.ConstantState
{
  int mChangingConfigurations;
  AbstractGifImage mGif;
  int mGravity = 119;
  Paint mPaint = new Paint(6);
  int mTargetDensity = 160;
  boolean stickerPause = false;
  
  public GifDrawable$GifState(AbstractGifImage paramAbstractGifImage)
  {
    this.mGif = paramAbstractGifImage;
  }
  
  public GifDrawable$GifState(GifState paramGifState)
  {
    this.mGif = paramGifState.mGif;
    this.mChangingConfigurations = paramGifState.mChangingConfigurations;
    this.mGravity = paramGifState.mGravity;
    this.mTargetDensity = paramGifState.mTargetDensity;
    this.mPaint = new Paint(6);
  }
  
  public int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }
  
  public Drawable newDrawable()
  {
    return new GifDrawable(this, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new GifDrawable(this, paramResources);
  }
  
  public void setStickerPause(boolean paramBoolean)
  {
    this.stickerPause = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.GifDrawable.GifState
 * JD-Core Version:    0.7.0.1
 */