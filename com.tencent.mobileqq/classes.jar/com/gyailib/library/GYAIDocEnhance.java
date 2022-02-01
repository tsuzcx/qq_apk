package com.gyailib.library;

import android.graphics.Bitmap;

public class GYAIDocEnhance
{
  private long nativePtr;
  
  public native int documentCornerValid(float[] paramArrayOfFloat);
  
  public native Bitmap documentDeshadow(Bitmap paramBitmap);
  
  public native float[] documentDetect(Bitmap paramBitmap);
  
  public native Bitmap documentEnhance(Bitmap paramBitmap);
  
  public native Bitmap documentWarp(Bitmap paramBitmap, float[] paramArrayOfFloat);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.GYAIDocEnhance
 * JD-Core Version:    0.7.0.1
 */