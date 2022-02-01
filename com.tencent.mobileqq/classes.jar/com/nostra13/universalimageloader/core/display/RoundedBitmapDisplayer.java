package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

public class RoundedBitmapDisplayer
  implements BitmapDisplayer
{
  protected final int cornerRadius;
  protected final int margin;
  
  public RoundedBitmapDisplayer(int paramInt)
  {
    this(paramInt, 0);
  }
  
  public RoundedBitmapDisplayer(int paramInt1, int paramInt2)
  {
    this.cornerRadius = paramInt1;
    this.margin = paramInt2;
  }
  
  public void display(Bitmap paramBitmap, ImageAware paramImageAware, LoadedFrom paramLoadedFrom)
  {
    if (!(paramImageAware instanceof ImageViewAware)) {
      throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }
    paramImageAware.setImageDrawable(new RoundedBitmapDisplayer.RoundedDrawable(paramBitmap, this.cornerRadius, this.margin));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer
 * JD-Core Version:    0.7.0.1
 */