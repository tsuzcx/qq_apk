package com.tencent.falco.base.imageloader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.tencent.falco.base.libapi.imageloader.DisplayImageOptions;

class ImageLoaderComponent$2
  implements com.nostra13.universalimageloader.core.display.BitmapDisplayer
{
  ImageLoaderComponent$2(ImageLoaderComponent paramImageLoaderComponent, DisplayImageOptions paramDisplayImageOptions) {}
  
  public void display(Bitmap paramBitmap, ImageAware paramImageAware, LoadedFrom paramLoadedFrom)
  {
    if ((paramImageAware != null) && ((paramImageAware.getWrappedView() instanceof ImageView))) {
      this.val$options.getBitmapDisplayer().display((ImageView)paramImageAware.getWrappedView(), paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.imageloader.ImageLoaderComponent.2
 * JD-Core Version:    0.7.0.1
 */