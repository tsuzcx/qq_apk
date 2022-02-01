package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class BitmapThumbnailImageViewTarget
  extends ThumbnailImageViewTarget<Bitmap>
{
  protected Drawable a(Bitmap paramBitmap)
  {
    return new BitmapDrawable(((ImageView)this.a).getResources(), paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.BitmapThumbnailImageViewTarget
 * JD-Core Version:    0.7.0.1
 */