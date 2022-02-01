package com.tencent.filter;

import android.graphics.Bitmap;
import com.tencent.ttpic.util.SoInfo;

public class QImage
{
  private int height;
  private long nativeImage;
  private int pixelBytes;
  private int pixelFormat;
  private int width;
  
  public QImage()
  {
    this.width = 0;
    this.height = 0;
    this.nativeImage = 0L;
    this.pixelBytes = 0;
  }
  
  public QImage(int paramInt1, int paramInt2)
  {
    CreateImage(paramInt1, paramInt2, 4);
  }
  
  @SoInfo(libName="image_filter_common")
  public static native QImage BindBitmap(Bitmap paramBitmap);
  
  @SoInfo(libName="image_filter_common")
  public static native QImage Bitmap2QImage(Bitmap paramBitmap);
  
  @SoInfo(libName="")
  public static native byte[] CompressJPEGFromRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  @SoInfo(libName="image_filter_common")
  public native int AverageChannels();
  
  @SoInfo(libName="")
  public native void CopyExif(QImage paramQImage);
  
  @SoInfo(libName="image_filter_common")
  public native void CopyPixels(int[] paramArrayOfInt, int paramInt);
  
  @SoInfo(libName="image_filter_common")
  public native void CopyPixelsRGB(int[] paramArrayOfInt, int paramInt);
  
  @SoInfo(libName="image_filter_common")
  public native void CreateImage(int paramInt1, int paramInt2, int paramInt3);
  
  @SoInfo(libName="image_filter_common")
  public native QImage CreateImageFromQImage();
  
  @SoInfo(libName="image_filter_common")
  public native void Dispose();
  
  @SoInfo(libName="image_filter_common")
  public native boolean FromBitmap(Bitmap paramBitmap);
  
  @SoInfo(libName="image_filter_common")
  public native QImage InplaceBlur8bitQImage(int paramInt1, int paramInt2);
  
  @SoInfo(libName="image_filter_common")
  public native void RGB565toRGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  @SoInfo(libName="image_filter_common")
  public native boolean ToBitmap(Bitmap paramBitmap);
  
  @SoInfo(libName="image_filter_common")
  public native boolean UnBindBitmap(Bitmap paramBitmap);
  
  @SoInfo(libName="image_filter_common")
  public native void WrapExif(QImage paramQImage);
  
  @SoInfo(libName="image_filter_common")
  public native void YUV420sp2RGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  @SoInfo(libName="image_filter_common")
  public native void YUV420sp2YUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  @SoInfo(libName="image_filter_common")
  public native void YUV420sp2YUV2(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  @SoInfo(libName="image_filter_common")
  public native void YUV422toRGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  @SoInfo(libName="image_filter_common")
  public native boolean alphaMix(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  @SoInfo(libName="image_filter_common")
  public native QImage createSubImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @SoInfo(libName="image_filter_common")
  public native long getByteSize();
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getPixelBytes()
  {
    return this.pixelBytes;
  }
  
  public int getPixelFormat()
  {
    return this.pixelFormat;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  @SoInfo(libName="image_filter_common")
  public native boolean nativeFlip(int paramInt1, int paramInt2);
  
  @SoInfo(libName="image_filter_common")
  public native int[] nativeGetArrayHistogram();
  
  @SoInfo(libName="image_filter_common")
  public native int[] nativeGetArrayHistogramChannels();
  
  @SoInfo(libName="image_filter_common")
  public native boolean nativeRotate(int paramInt);
  
  @SoInfo(libName="image_filter_common")
  public native void nativeUpdateROI();
  
  @SoInfo(libName="image_filter_common")
  public native void toGPUTexture(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.filter.QImage
 * JD-Core Version:    0.7.0.1
 */