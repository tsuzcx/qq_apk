package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;

final class NonOwnedDrawableResource
  extends DrawableResource<Drawable>
{
  private NonOwnedDrawableResource(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  @Nullable
  static Resource<Drawable> a(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      return new NonOwnedDrawableResource(paramDrawable);
    }
    return null;
  }
  
  @NonNull
  public Class<Drawable> c()
  {
    return this.a.getClass();
  }
  
  public int e()
  {
    return Math.max(1, this.a.getIntrinsicWidth() * this.a.getIntrinsicHeight() * 4);
  }
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.drawable.NonOwnedDrawableResource
 * JD-Core Version:    0.7.0.1
 */