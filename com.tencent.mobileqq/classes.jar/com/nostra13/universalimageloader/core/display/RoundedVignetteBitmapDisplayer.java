package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

public class RoundedVignetteBitmapDisplayer
  extends RoundedBitmapDisplayer
{
  public RoundedVignetteBitmapDisplayer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public void display(Bitmap paramBitmap, ImageAware paramImageAware, LoadedFrom paramLoadedFrom)
  {
    if ((paramImageAware instanceof ImageViewAware))
    {
      paramImageAware.setImageDrawable(new RoundedVignetteBitmapDisplayer.RoundedVignetteDrawable(paramBitmap, this.cornerRadius, this.margin));
      return;
    }
    throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.display.RoundedVignetteBitmapDisplayer
 * JD-Core Version:    0.7.0.1
 */