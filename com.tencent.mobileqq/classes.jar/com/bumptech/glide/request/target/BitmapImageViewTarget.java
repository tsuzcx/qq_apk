package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class BitmapImageViewTarget
  extends ImageViewTarget<Bitmap>
{
  public BitmapImageViewTarget(ImageView paramImageView)
  {
    super(paramImageView);
  }
  
  protected void a(Bitmap paramBitmap)
  {
    ((ImageView)this.a).setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.BitmapImageViewTarget
 * JD-Core Version:    0.7.0.1
 */