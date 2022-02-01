package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class IBitmapFactory$DefaultBitmapFactory
  extends IBitmapFactory
{
  IDecoder mDecoder;
  
  public IBitmapFactory$DefaultBitmapFactory(IDecoder paramIDecoder)
  {
    this.mDecoder = paramIDecoder;
  }
  
  public BitmapReference createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return BitmapReference.getBitmapReference(Bitmap.createBitmap(paramInt1, paramInt2, paramConfig));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.IBitmapFactory.DefaultBitmapFactory
 * JD-Core Version:    0.7.0.1
 */