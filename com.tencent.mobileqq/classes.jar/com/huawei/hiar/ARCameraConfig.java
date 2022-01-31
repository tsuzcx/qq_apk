package com.huawei.hiar;

import android.annotation.TargetApi;
import android.util.Log;
import android.util.Size;

@TargetApi(21)
public class ARCameraConfig
{
  private static final String TAG = ARCameraConfig.class.getSimpleName();
  long mNativeHandle;
  final ARSession mSession;
  
  protected ARCameraConfig()
  {
    this.mSession = null;
    this.mNativeHandle = 0L;
  }
  
  ARCameraConfig(ARSession paramARSession, long paramLong)
  {
    this.mSession = paramARSession;
    this.mNativeHandle = paramLong;
  }
  
  private static native long nativeCreate(long paramLong);
  
  private static native void nativeDestroy(long paramLong);
  
  private native int[] nativeGetImageDimensions(long paramLong1, long paramLong2);
  
  private native int[] nativeGetTextureDimensions(long paramLong1, long paramLong2);
  
  public Size GetImageDimensions()
  {
    int[] arrayOfInt = nativeGetImageDimensions(this.mSession.mNativeHandle, this.mNativeHandle);
    return new Size(arrayOfInt[0], arrayOfInt[1]);
  }
  
  public Size GetTextureDimensions()
  {
    int[] arrayOfInt = nativeGetTextureDimensions(this.mSession.mNativeHandle, this.mNativeHandle);
    return new Size(arrayOfInt[0], arrayOfInt[1]);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {}
    while (((ARCameraConfig)paramObject).mNativeHandle != this.mNativeHandle) {
      return false;
    }
    return true;
  }
  
  protected void finalize()
  {
    if (this.mNativeHandle != 0L)
    {
      Log.d(TAG, String.format("finalize: native release begin with cameraHandle= 0x%x", new Object[] { Long.valueOf(this.mNativeHandle) }));
      nativeDestroy(this.mNativeHandle);
      Log.d(TAG, "finalize: native release end ");
    }
    super.finalize();
  }
  
  public int hashCode()
  {
    return Long.valueOf(this.mNativeHandle).hashCode();
  }
  
  public String toString()
  {
    return String.format("ARCameraConfig: {handle=0x%x, ImageDimensions=(%d,%d), TextureDimensions=(%d,%d)}", new Object[] { Long.valueOf(this.mNativeHandle), Integer.valueOf(GetImageDimensions().getWidth()), Integer.valueOf(GetImageDimensions().getHeight()), Integer.valueOf(GetTextureDimensions().getWidth()), Integer.valueOf(GetTextureDimensions().getHeight()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.ARCameraConfig
 * JD-Core Version:    0.7.0.1
 */