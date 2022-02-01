package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

public class BitmapDrawableResource
  extends DrawableResource<BitmapDrawable>
  implements Initializable
{
  private final BitmapPool b;
  
  public void a()
  {
    ((BitmapDrawable)this.a).getBitmap().prepareToDraw();
  }
  
  @NonNull
  public Class<BitmapDrawable> c()
  {
    return BitmapDrawable.class;
  }
  
  public int e()
  {
    return Util.a(((BitmapDrawable)this.a).getBitmap());
  }
  
  public void f()
  {
    this.b.a(((BitmapDrawable)this.a).getBitmap());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.BitmapDrawableResource
 * JD-Core Version:    0.7.0.1
 */