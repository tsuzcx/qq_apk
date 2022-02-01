package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

public class NonViewAware
  implements ImageAware
{
  protected final ImageSize imageSize;
  protected final String imageUri;
  protected final ViewScaleType scaleType;
  
  public NonViewAware(ImageSize paramImageSize, ViewScaleType paramViewScaleType)
  {
    this(null, paramImageSize, paramViewScaleType);
  }
  
  public NonViewAware(String paramString, ImageSize paramImageSize, ViewScaleType paramViewScaleType)
  {
    if (paramImageSize != null)
    {
      if (paramViewScaleType != null)
      {
        this.imageUri = paramString;
        this.imageSize = paramImageSize;
        this.scaleType = paramViewScaleType;
        return;
      }
      throw new IllegalArgumentException("scaleType must not be null");
    }
    throw new IllegalArgumentException("imageSize must not be null");
  }
  
  public int getHeight()
  {
    return this.imageSize.getHeight();
  }
  
  public int getId()
  {
    return hashCode();
  }
  
  public ViewScaleType getScaleType()
  {
    return this.scaleType;
  }
  
  public int getWidth()
  {
    return this.imageSize.getWidth();
  }
  
  public View getWrappedView()
  {
    return null;
  }
  
  public boolean isCollected()
  {
    return false;
  }
  
  public boolean setImageBitmap(Bitmap paramBitmap)
  {
    return true;
  }
  
  public boolean setImageDrawable(Drawable paramDrawable)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.imageaware.NonViewAware
 * JD-Core Version:    0.7.0.1
 */