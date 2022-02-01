package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.NonNull;

public class BitmapPoolAdapter
  implements BitmapPool
{
  @NonNull
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(Bitmap paramBitmap)
  {
    paramBitmap.recycle();
  }
  
  @NonNull
  public Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return a(paramInt1, paramInt2, paramConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter
 * JD-Core Version:    0.7.0.1
 */