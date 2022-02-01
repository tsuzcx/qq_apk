package com.huawei.hiar;

import java.util.Locale;

public class ARLightEstimate
{
  static final String TAG = ARLightEstimate.class.getSimpleName();
  long mNativeHandle;
  private final ARSession mSession;
  
  protected ARLightEstimate()
  {
    this.mSession = null;
    this.mNativeHandle = 0L;
  }
  
  ARLightEstimate(ARSession paramARSession)
  {
    this.mSession = paramARSession;
    this.mNativeHandle = nativeCreateLightEstimate(this.mSession.mNativeHandle);
  }
  
  private static native long nativeCreateLightEstimate(long paramLong);
  
  private static native void nativeDestroyLightEstimate(long paramLong);
  
  private native float nativeGetPixelIntensity(long paramLong1, long paramLong2);
  
  private native int nativeGetState(long paramLong1, long paramLong2);
  
  protected void finalize()
  {
    if (this.mNativeHandle != 0L) {
      nativeDestroyLightEstimate(this.mNativeHandle);
    }
    super.finalize();
  }
  
  public float getPixelIntensity()
  {
    return nativeGetPixelIntensity(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public ARLightEstimate.State getState()
  {
    return ARLightEstimate.State.forNumber(nativeGetState(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  @Deprecated
  public boolean isValid()
  {
    return getState() == ARLightEstimate.State.VALID;
  }
  
  public String toString()
  {
    return String.format(Locale.ENGLISH, "ARLightEstimate: { handle= 0x%x, light estimate with state %s, intensity %s }", new Object[] { Long.valueOf(this.mNativeHandle), getState().name(), Float.valueOf(getPixelIntensity()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.ARLightEstimate
 * JD-Core Version:    0.7.0.1
 */