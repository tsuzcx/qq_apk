package com.huawei.hiar;

import android.graphics.Rect;
import android.media.Image.Plane;
import android.media.ImageAdapter;
import com.huawei.hiar.exceptions.ARFatalException;
import java.nio.ByteBuffer;

public class ARImage
  extends ImageAdapter
{
  private long nativeHandle;
  
  public ARImage(long paramLong)
  {
    this.nativeHandle = paramLong;
  }
  
  private native void nativeClose(long paramLong);
  
  private native ByteBuffer nativeGetBuffer(long paramLong, int paramInt);
  
  private native int nativeGetFormat(long paramLong);
  
  private native int nativeGetHeight(long paramLong);
  
  private native int nativeGetNumberOfPlanes(long paramLong);
  
  private native int nativeGetPixelStride(long paramLong, int paramInt);
  
  private native int nativeGetRowStride(long paramLong, int paramInt);
  
  private native long nativeGetTimestamp(long paramLong);
  
  private native int nativeGetWidth(long paramLong);
  
  public void close()
  {
    nativeClose(this.nativeHandle);
    this.nativeHandle = 0L;
  }
  
  public Rect getCropRect()
  {
    throw new UnsupportedOperationException("Crop rect is unknown in this image.");
  }
  
  public int getFormat()
  {
    int i = nativeGetFormat(this.nativeHandle);
    if (i == -1) {
      throw new ARFatalException("Unknown error in ArImage.getFormat().");
    }
    return i;
  }
  
  public int getHeight()
  {
    int i = nativeGetHeight(this.nativeHandle);
    if (i == -1) {
      throw new ARFatalException("Unknown error in ArImage.getHeight().");
    }
    return i;
  }
  
  public Image.Plane[] getPlanes()
  {
    int j = nativeGetNumberOfPlanes(this.nativeHandle);
    if (j == -1) {
      throw new ARFatalException("Unknown error in ArImage.getPlanes().");
    }
    ARImage.a[] arrayOfa = new ARImage.a[j];
    int i = 0;
    while (i < j)
    {
      arrayOfa[i] = new ARImage.a(this, this.nativeHandle, i);
      i += 1;
    }
    return arrayOfa;
  }
  
  public long getTimestamp()
  {
    long l = nativeGetTimestamp(this.nativeHandle);
    if (l == -1L) {
      throw new ARFatalException("Unknown error in ArImage.getTimestamp().");
    }
    return l;
  }
  
  public int getWidth()
  {
    int i = nativeGetWidth(this.nativeHandle);
    if (i == -1) {
      throw new ARFatalException("Unknown error in ArImage.getWidth().");
    }
    return i;
  }
  
  public void setCropRect(Rect paramRect)
  {
    throw new UnsupportedOperationException("This is a read-only image.");
  }
  
  public void setTimestamp(long paramLong)
  {
    throw new UnsupportedOperationException("This is a read-only image.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.ARImage
 * JD-Core Version:    0.7.0.1
 */