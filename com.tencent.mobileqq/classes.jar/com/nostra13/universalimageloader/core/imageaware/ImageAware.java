package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

public abstract interface ImageAware
{
  public abstract int getHeight();
  
  public abstract int getId();
  
  public abstract ViewScaleType getScaleType();
  
  public abstract int getWidth();
  
  public abstract View getWrappedView();
  
  public abstract boolean isCollected();
  
  public abstract boolean setImageBitmap(Bitmap paramBitmap);
  
  public abstract boolean setImageDrawable(Drawable paramDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.imageaware.ImageAware
 * JD-Core Version:    0.7.0.1
 */