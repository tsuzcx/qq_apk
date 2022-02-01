package com.tencent.mobileqq.activity.aio.zhitu;

import android.graphics.Bitmap;

public class GifDecoder
{
  private int a = 0;
  private int b = 0;
  private Bitmap[] c = new Bitmap[0];
  private int[] d = new int[0];
  private boolean e = false;
  
  private native boolean nativeBitmapIteratorHasNext(long paramLong);
  
  private native GifImage nativeBitmapIteratornext(long paramLong1, long paramLong2);
  
  private native void nativeClose(long paramLong);
  
  private native int nativeGetDelay(long paramLong, int paramInt);
  
  private native Bitmap nativeGetFrame(long paramLong, int paramInt);
  
  private native int nativeGetFrameCount(long paramLong);
  
  private native int nativeGetHeight(long paramLong);
  
  private native int nativeGetWidth(long paramLong);
  
  private native long nativeInit();
  
  private native boolean nativeLoad(long paramLong, String paramString);
  
  private native long nativeLoadUsingIterator(long paramLong, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.GifDecoder
 * JD-Core Version:    0.7.0.1
 */