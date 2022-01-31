package com.tencent.mobileqq.activity.aio.zhitu;

import android.graphics.Bitmap;
import java.io.FileNotFoundException;
import java.util.Locale;

public class GifEncoder
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private int b;
  private int c;
  
  private native void nativeClose(long paramLong);
  
  private native boolean nativeEncodeFrame(long paramLong, Bitmap paramBitmap, int paramInt);
  
  private native long nativeInit(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4);
  
  private native void nativeSetDither(long paramLong, boolean paramBoolean);
  
  private native void nativeSetThreadCount(long paramLong, int paramInt);
  
  public void a()
  {
    nativeClose(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, GifEncoder.EncodingType paramEncodingType)
  {
    if (0L != this.jdField_a_of_type_Long) {
      a();
    }
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_Long = nativeInit(paramInt1, paramInt2, paramString, paramEncodingType.ordinal(), this.jdField_a_of_type_Int);
    if (0L == this.jdField_a_of_type_Long) {
      throw new FileNotFoundException();
    }
  }
  
  public boolean a(Bitmap paramBitmap, int paramInt)
  {
    if (0L == this.jdField_a_of_type_Long) {
      return false;
    }
    if ((paramBitmap.getWidth() != this.b) || (paramBitmap.getHeight() != this.c)) {
      throw new RuntimeException(String.format(Locale.ENGLISH, "The size specified at initialization differs from the size of the image.\n expected:(%d, %d) actual:(%d,%d)", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) }));
    }
    nativeEncodeFrame(this.jdField_a_of_type_Long, paramBitmap, paramInt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.GifEncoder
 * JD-Core Version:    0.7.0.1
 */