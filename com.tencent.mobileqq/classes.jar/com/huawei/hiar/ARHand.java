package com.huawei.hiar;

import java.util.Arrays;

public class ARHand
  extends ARTrackableBase
{
  static final String TAG = ARHand.class.getSimpleName();
  
  ARHand(long paramLong, ARSession paramARSession)
  {
    super(paramLong, paramARSession);
  }
  
  private native int[] nativeGetGestureAction(long paramLong1, long paramLong2);
  
  private native float[] nativeGetGestureCenter(long paramLong1, long paramLong2);
  
  private native int nativeGetGestureCoordinateSystem(long paramLong1, long paramLong2);
  
  private native float[] nativeGetGestureHandBox(long paramLong1, long paramLong2);
  
  private native float[] nativeGetGestureOrientation(long paramLong1, long paramLong2);
  
  private native int nativeGetGestureType(long paramLong1, long paramLong2);
  
  private native int nativeGetHandType(long paramLong1, long paramLong2);
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  protected void finalize()
  {
    super.finalize();
  }
  
  public int[] getGestureAction()
  {
    return nativeGetGestureAction(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public float[] getGestureCenter()
  {
    return nativeGetGestureCenter(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public ARCoordinateSystemType getGestureCoordinateSystem()
  {
    return ARCoordinateSystemType.forNumber(nativeGetGestureCoordinateSystem(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public float[] getGestureHandBox()
  {
    return nativeGetGestureHandBox(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public float[] getGestureOrientation()
  {
    return nativeGetGestureOrientation(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public int getGestureType()
  {
    return nativeGetGestureType(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public ARHand.ARHandType getHandtype()
  {
    return ARHand.ARHandType.forNumber(nativeGetHandType(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return String.format("ARHand{ coordinate: %d, handType: %d,gestureType:%d, handBox:%s , center:%s, action:%s, eulerAngle:%s}\n", new Object[] { getGestureCoordinateSystem(), getHandtype(), Integer.valueOf(getGestureType()), Arrays.toString(getGestureHandBox()), Arrays.toString(getGestureCenter()), Arrays.toString(getGestureAction()), Arrays.toString(getGestureOrientation()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.ARHand
 * JD-Core Version:    0.7.0.1
 */