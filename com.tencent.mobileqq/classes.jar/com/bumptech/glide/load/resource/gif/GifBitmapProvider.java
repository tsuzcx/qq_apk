package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public final class GifBitmapProvider
  implements GifDecoder.BitmapProvider
{
  private final BitmapPool a;
  @Nullable
  private final ArrayPool b;
  
  public GifBitmapProvider(BitmapPool paramBitmapPool, @Nullable ArrayPool paramArrayPool)
  {
    this.a = paramBitmapPool;
    this.b = paramArrayPool;
  }
  
  @NonNull
  public Bitmap a(int paramInt1, int paramInt2, @NonNull Bitmap.Config paramConfig)
  {
    return this.a.b(paramInt1, paramInt2, paramConfig);
  }
  
  public void a(@NonNull Bitmap paramBitmap)
  {
    this.a.a(paramBitmap);
  }
  
  public void a(@NonNull byte[] paramArrayOfByte)
  {
    ArrayPool localArrayPool = this.b;
    if (localArrayPool == null) {
      return;
    }
    localArrayPool.a(paramArrayOfByte);
  }
  
  public void a(@NonNull int[] paramArrayOfInt)
  {
    ArrayPool localArrayPool = this.b;
    if (localArrayPool == null) {
      return;
    }
    localArrayPool.a(paramArrayOfInt);
  }
  
  @NonNull
  public byte[] a(int paramInt)
  {
    ArrayPool localArrayPool = this.b;
    if (localArrayPool == null) {
      return new byte[paramInt];
    }
    return (byte[])localArrayPool.a(paramInt, [B.class);
  }
  
  @NonNull
  public int[] b(int paramInt)
  {
    ArrayPool localArrayPool = this.b;
    if (localArrayPool == null) {
      return new int[paramInt];
    }
    return (int[])localArrayPool.a(paramInt, [I.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.gif.GifBitmapProvider
 * JD-Core Version:    0.7.0.1
 */