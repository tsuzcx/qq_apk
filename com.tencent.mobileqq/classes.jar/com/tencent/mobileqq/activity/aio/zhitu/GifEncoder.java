package com.tencent.mobileqq.activity.aio.zhitu;

import android.graphics.Bitmap;
import java.io.FileNotFoundException;
import java.util.Locale;

public class GifEncoder
{
  private long a = 0L;
  private int b = 1;
  private int c;
  private int d;
  
  private native void nativeClose(long paramLong);
  
  private native boolean nativeEncodeFrame(long paramLong, Bitmap paramBitmap, int paramInt);
  
  private native long nativeInit(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4);
  
  private native void nativeSetDither(long paramLong, boolean paramBoolean);
  
  private native void nativeSetThreadCount(long paramLong, int paramInt);
  
  public void a()
  {
    nativeClose(this.a);
    this.a = 0L;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (0L != this.a) {
      a();
    }
    this.c = paramInt1;
    this.d = paramInt2;
    this.a = nativeInit(paramInt1, paramInt2, paramString, paramInt3, this.b);
    if (0L != this.a) {
      return;
    }
    throw new FileNotFoundException();
  }
  
  public boolean a(Bitmap paramBitmap, int paramInt)
  {
    if (0L == this.a) {
      return false;
    }
    if ((paramBitmap.getWidth() == this.c) && (paramBitmap.getHeight() == this.d))
    {
      nativeEncodeFrame(this.a, paramBitmap, paramInt);
      return true;
    }
    throw new RuntimeException(String.format(Locale.ENGLISH, "The size specified at initialization differs from the size of the image.\n expected:(%d, %d) actual:(%d,%d)", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.GifEncoder
 * JD-Core Version:    0.7.0.1
 */