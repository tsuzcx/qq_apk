package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.annotation.Public;

@Public
public abstract class ImageProcessor
{
  public static final int TYPE_BUBBLE = 6;
  public static final int TYPE_CIRCLE = 8;
  public static final int TYPE_DEFAULT = 1;
  public static final int TYPE_FEED_LIST_IMAGE = 5;
  public static final int TYPE_MARK = 7;
  public static final int TYPE_OVAL = 3;
  public static final int TYPE_ROUND_CORNER = 2;
  public static final int TYPE_SpecifiedSizeCropByPivot = 4;
  protected ImageKey mImageKey;
  protected ImageProcessor mPreProcessor;
  
  final Drawable doProcess(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    Drawable localDrawable = process(paramDrawable);
    if ((getType() == 5) && (localDrawable == null)) {
      return null;
    }
    if (localDrawable != null) {
      paramDrawable = localDrawable;
    }
    return paramDrawable;
  }
  
  public int getType()
  {
    return 1;
  }
  
  @Public
  public abstract Drawable process(Drawable paramDrawable);
  
  public void setImageKey(ImageKey paramImageKey)
  {
    this.mImageKey = paramImageKey;
  }
  
  public void setPreProcessor(ImageProcessor paramImageProcessor)
  {
    this.mPreProcessor = paramImageProcessor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageProcessor
 * JD-Core Version:    0.7.0.1
 */