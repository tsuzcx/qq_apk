package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

public class DrawableImageViewTarget
  extends ImageViewTarget<Drawable>
{
  public DrawableImageViewTarget(ImageView paramImageView)
  {
    super(paramImageView);
  }
  
  protected void d(@Nullable Drawable paramDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.DrawableImageViewTarget
 * JD-Core Version:    0.7.0.1
 */