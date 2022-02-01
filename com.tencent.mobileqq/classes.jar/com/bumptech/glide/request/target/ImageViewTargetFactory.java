package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.ImageView;

public class ImageViewTargetFactory
{
  @NonNull
  public <Z> ViewTarget<ImageView, Z> a(@NonNull ImageView paramImageView, @NonNull Class<Z> paramClass)
  {
    if (Bitmap.class.equals(paramClass)) {
      return new BitmapImageViewTarget(paramImageView);
    }
    if (Drawable.class.isAssignableFrom(paramClass)) {
      return new DrawableImageViewTarget(paramImageView);
    }
    paramImageView = new StringBuilder();
    paramImageView.append("Unhandled class: ");
    paramImageView.append(paramClass);
    paramImageView.append(", try .as*(Class).transcode(ResourceTranscoder)");
    throw new IllegalArgumentException(paramImageView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.ImageViewTargetFactory
 * JD-Core Version:    0.7.0.1
 */