package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

public class CircleBitmapDisplayer
  implements BitmapDisplayer
{
  protected final Integer strokeColor;
  protected final float strokeWidth;
  
  public CircleBitmapDisplayer()
  {
    this(null);
  }
  
  public CircleBitmapDisplayer(Integer paramInteger)
  {
    this(paramInteger, 0.0F);
  }
  
  public CircleBitmapDisplayer(Integer paramInteger, float paramFloat)
  {
    this.strokeColor = paramInteger;
    this.strokeWidth = paramFloat;
  }
  
  public void display(Bitmap paramBitmap, ImageAware paramImageAware, LoadedFrom paramLoadedFrom)
  {
    if (!(paramImageAware instanceof ImageViewAware)) {
      throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }
    paramImageAware.setImageDrawable(new CircleBitmapDisplayer.CircleDrawable(paramBitmap, this.strokeColor, this.strokeWidth));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer
 * JD-Core Version:    0.7.0.1
 */