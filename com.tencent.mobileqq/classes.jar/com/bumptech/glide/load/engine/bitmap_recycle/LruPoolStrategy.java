package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.Nullable;

abstract interface LruPoolStrategy
{
  @Nullable
  public abstract Bitmap a();
  
  @Nullable
  public abstract Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public abstract void a(Bitmap paramBitmap);
  
  public abstract String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public abstract String b(Bitmap paramBitmap);
  
  public abstract int c(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
 * JD-Core Version:    0.7.0.1
 */