package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

public class BitmapResource
  implements Initializable, Resource<Bitmap>
{
  private final Bitmap a;
  private final BitmapPool b;
  
  public BitmapResource(@NonNull Bitmap paramBitmap, @NonNull BitmapPool paramBitmapPool)
  {
    this.a = ((Bitmap)Preconditions.a(paramBitmap, "Bitmap must not be null"));
    this.b = ((BitmapPool)Preconditions.a(paramBitmapPool, "BitmapPool must not be null"));
  }
  
  @Nullable
  public static BitmapResource a(@Nullable Bitmap paramBitmap, @NonNull BitmapPool paramBitmapPool)
  {
    if (paramBitmap == null) {
      return null;
    }
    return new BitmapResource(paramBitmap, paramBitmapPool);
  }
  
  public void a()
  {
    this.a.prepareToDraw();
  }
  
  @NonNull
  public Bitmap b()
  {
    return this.a;
  }
  
  @NonNull
  public Class<Bitmap> c()
  {
    return Bitmap.class;
  }
  
  public int e()
  {
    return Util.a(this.a);
  }
  
  public void f()
  {
    this.b.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.BitmapResource
 * JD-Core Version:    0.7.0.1
 */