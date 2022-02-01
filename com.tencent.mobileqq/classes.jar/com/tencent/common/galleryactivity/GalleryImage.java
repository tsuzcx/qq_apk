package com.tencent.common.galleryactivity;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public abstract class GalleryImage
{
  public static final int PHOTO_LAST_SELECTED = 3;
  public static final int PHOTO_SELECTED = 1;
  public static final int PHOTO_UNSELECTED = 2;
  public boolean isImgCenterCropMode;
  public int selectStatus = 2;
  public Rect thubmRect;
  
  public static int getCutValue(Rect paramRect, Drawable paramDrawable)
  {
    float f1 = paramRect.width();
    float f2 = paramRect.height();
    float f3 = paramDrawable.getIntrinsicWidth();
    float f4 = paramDrawable.getIntrinsicHeight();
    if ((f1 <= 0.0F) || (f2 <= 0.0F) || (f3 <= 0.0F) || (f4 <= 0.0F)) {}
    do
    {
      return 0;
      f1 = f1 * f4 / (f2 * f3);
      if (f1 < 1.0F) {
        return 1;
      }
    } while (f1 <= 1.0F);
    return 2;
  }
  
  public abstract Drawable getAnimationDrawable();
  
  public abstract int getCutValue();
  
  public int getSelected()
  {
    return this.selectStatus;
  }
  
  public Rect getStartSrcRect()
  {
    return null;
  }
  
  public int getStartX()
  {
    return 0;
  }
  
  public int getStartY()
  {
    return 0;
  }
  
  public Rect getThumbRect()
  {
    return this.thubmRect;
  }
  
  public boolean needAnimation(boolean paramBoolean)
  {
    return true;
  }
  
  public void setSelected(int paramInt)
  {
    this.selectStatus = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.GalleryImage
 * JD-Core Version:    0.7.0.1
 */