package com.tencent.luggage.wxa.kz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import java.io.InputStream;

public abstract interface b
  extends com.tencent.luggage.wxa.ba.b
{
  public static final b a = new b.1();
  
  public abstract Bitmap a(InputStream paramInputStream);
  
  public abstract Bitmap a(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions);
  
  public abstract Bitmap a(String paramString, BitmapFactory.Options paramOptions);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kz.b
 * JD-Core Version:    0.7.0.1
 */