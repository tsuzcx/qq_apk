package com.tencent.falco.base.libapi.imageloader;

import android.graphics.Bitmap;
import android.widget.ImageView;

public final class SimpleBitmapDisplayer
  implements BitmapDisplayer
{
  public void display(ImageView paramImageView, Bitmap paramBitmap)
  {
    paramImageView.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.imageloader.SimpleBitmapDisplayer
 * JD-Core Version:    0.7.0.1
 */