package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.NonNull;

public abstract interface GifDecoder$BitmapProvider
{
  @NonNull
  public abstract Bitmap a(int paramInt1, int paramInt2, @NonNull Bitmap.Config paramConfig);
  
  public abstract void a(@NonNull Bitmap paramBitmap);
  
  public abstract void a(@NonNull byte[] paramArrayOfByte);
  
  public abstract void a(@NonNull int[] paramArrayOfInt);
  
  @NonNull
  public abstract byte[] a(int paramInt);
  
  @NonNull
  public abstract int[] b(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
 * JD-Core Version:    0.7.0.1
 */