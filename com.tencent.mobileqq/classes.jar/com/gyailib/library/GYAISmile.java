package com.gyailib.library;

import android.graphics.Bitmap;

public class GYAISmile
{
  private long nativePtr;
  
  public native int deinit();
  
  public native int detect(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int init();
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.gyailib.library.GYAISmile
 * JD-Core Version:    0.7.0.1
 */