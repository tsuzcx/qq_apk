package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class SafeBitmapFactory
{
  private static final String TAG = "SafeBitmapFactory";
  public static Object lock = new Object();
  public static AtomicBoolean sInjectHotPatch = new AtomicBoolean(false);
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    injectBitmapHotPatch();
    return BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    injectBitmapHotPatch();
    return BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions);
  }
  
  public static Bitmap decodeFile(String paramString)
  {
    injectBitmapHotPatch();
    return BitmapFactory.decodeFile(paramString);
  }
  
  public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions)
  {
    injectBitmapHotPatch();
    return BitmapFactory.decodeFile(paramString, paramOptions);
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream)
  {
    injectBitmapHotPatch();
    return BitmapFactory.decodeStream(paramInputStream);
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    injectBitmapHotPatch();
    return BitmapFactory.decodeStream(paramInputStream, paramRect, paramOptions);
  }
  
  public static void injectBitmapHotPatch() {}
  
  @Deprecated
  public static void registProxyInstance() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.SafeBitmapFactory
 * JD-Core Version:    0.7.0.1
 */