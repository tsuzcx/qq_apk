package com.tencent.falco.base.imageloader;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.tencent.falco.base.libapi.imageloader.DisplayImageOptions;
import com.tencent.falco.base.libapi.imageloader.DisplayImageOptions.OptionBitmapProcessor;

class ImageLoaderComponent$1
  implements BitmapProcessor
{
  ImageLoaderComponent$1(ImageLoaderComponent paramImageLoaderComponent, DisplayImageOptions paramDisplayImageOptions) {}
  
  public Bitmap process(Bitmap paramBitmap)
  {
    DisplayImageOptions.OptionBitmapProcessor localOptionBitmapProcessor = this.val$options.getProcessor();
    Bitmap localBitmap = paramBitmap;
    if (localOptionBitmapProcessor != null) {
      localBitmap = localOptionBitmapProcessor.process(paramBitmap);
    }
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.imageloader.ImageLoaderComponent.1
 * JD-Core Version:    0.7.0.1
 */