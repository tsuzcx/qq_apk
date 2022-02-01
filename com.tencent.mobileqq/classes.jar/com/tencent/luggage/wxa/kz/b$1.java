package com.tencent.luggage.wxa.kz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import java.io.InputStream;

final class b$1
  implements b
{
  public Bitmap a(InputStream paramInputStream)
  {
    return BitmapFactory.decodeStream(paramInputStream);
  }
  
  public Bitmap a(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    return BitmapFactory.decodeStream(paramInputStream, paramRect, paramOptions);
  }
  
  public Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    return BitmapFactory.decodeFile(paramString, paramOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kz.b.1
 * JD-Core Version:    0.7.0.1
 */