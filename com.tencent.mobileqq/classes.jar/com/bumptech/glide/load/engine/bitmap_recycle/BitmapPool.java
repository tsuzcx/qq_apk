package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.NonNull;

public abstract interface BitmapPool
{
  @NonNull
  public abstract Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(Bitmap paramBitmap);
  
  @NonNull
  public abstract Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 * JD-Core Version:    0.7.0.1
 */