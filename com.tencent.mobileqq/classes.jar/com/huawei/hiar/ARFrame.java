package com.huawei.hiar;

import android.media.Image;
import android.util.Log;
import android.view.MotionEvent;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ARFrame
{
  private static final String TAG = ARFrame.class.getSimpleName();
  ARCamera mCamera;
  ARLightEstimate mLightEstimate;
  long mNativeHandle;
  ARSession mSession;
  
  protected ARFrame()
  {
    this.mSession = null;
    this.mNativeHandle = 0L;
    this.mLightEstimate = null;
    this.mCamera = null;
  }
  
  ARFrame(ARSession paramARSession)
  {
    this.mSession = paramARSession;
    this.mNativeHandle = nativeCreateFrame(this.mSession.mNativeHandle);
    this.mLightEstimate = new ARLightEstimate(this.mSession);
    this.mCamera = new ARCamera(this.mSession, this);
  }
  
  private native long nativeAcquireCameraImage(long paramLong1, long paramLong2);
  
  private native long nativeAcquireDepthImage(long paramLong1, long paramLong2);
  
  private native long nativeAcquireImageMetadata(long paramLong1, long paramLong2);
  
  private native long[] nativeAcquireUpdatedAnchors(long paramLong1, long paramLong2);
  
  private native long[] nativeAcquireUpdatedTrackables(long paramLong1, long paramLong2, int paramInt);
  
  private static native long nativeCreateFrame(long paramLong);
  
  private static native void nativeDestroyFrame(long paramLong);
  
  private native int nativeGetAlignState(long paramLong1, long paramLong2);
  
  private native void nativeGetLightEstimate(long paramLong1, long paramLong2, long paramLong3);
  
  private native int nativeGetMappingState(long paramLong1, long paramLong2);
  
  private native long nativeGetTimestamp(long paramLong1, long paramLong2);
  
  private native boolean nativeHasDisplayGeometryChanged(long paramLong1, long paramLong2);
  
  private native long[] nativeHitTest(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2);
  
  private native void nativeTransformDisplayUvCoords(long paramLong1, long paramLong2, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2);
  
  public Image acquireCameraImage()
  {
    return new ARImage(nativeAcquireCameraImage(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public Image acquireDepthImage()
  {
    return new ARImage(nativeAcquireDepthImage(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public ARPointCloud acquirePointCloud()
  {
    return new ARPointCloud(nativeAcquirePointCloud(this.mSession.mNativeHandle, this.mNativeHandle), this.mSession);
  }
  
  protected void finalize()
  {
    if (this.mNativeHandle != 0L) {
      nativeDestroyFrame(this.mNativeHandle);
    }
  }
  
  public ARFrame.AlignState getAlignState()
  {
    int i = nativeGetAlignState(this.mSession.mNativeHandle, this.mNativeHandle);
    ARFrame.AlignState localAlignState = ARFrame.AlignState.NONE;
    switch (i)
    {
    default: 
      return localAlignState;
    case 0: 
      return ARFrame.AlignState.NONE;
    case 1: 
      return ARFrame.AlignState.FAILED;
    case 2: 
      return ARFrame.AlignState.PROCESSING;
    }
    return ARFrame.AlignState.SUCCESS;
  }
  
  public ARCamera getCamera()
  {
    return this.mCamera;
  }
  
  public ARImageMetadata getImageMetadata()
  {
    return new ARImageMetadata(nativeAcquireImageMetadata(this.mSession.mNativeHandle, this.mNativeHandle), this.mSession);
  }
  
  public ARLightEstimate getLightEstimate()
  {
    nativeGetLightEstimate(this.mSession.mNativeHandle, this.mNativeHandle, this.mLightEstimate.mNativeHandle);
    return this.mLightEstimate;
  }
  
  public ARFrame.WorldMappingState getMappingState()
  {
    int i = nativeGetMappingState(this.mSession.mNativeHandle, this.mNativeHandle);
    ARFrame.WorldMappingState localWorldMappingState = ARFrame.WorldMappingState.NOT_AVAILABLE;
    switch (i)
    {
    default: 
      return localWorldMappingState;
    case -1: 
      return ARFrame.WorldMappingState.NOT_AVAILABLE;
    case 0: 
      return ARFrame.WorldMappingState.LIMITED;
    case 1: 
      return ARFrame.WorldMappingState.EXTENDING;
    }
    return ARFrame.WorldMappingState.MAPPED;
  }
  
  @Deprecated
  public ARPointCloud getPointCloud()
  {
    return acquirePointCloud();
  }
  
  @Deprecated
  public ARPose getPointCloudPose()
  {
    return ARPose.IDENTITY;
  }
  
  @Deprecated
  public ARPose getPose()
  {
    return this.mCamera.getDisplayOrientedPose();
  }
  
  public long getTimestampNs()
  {
    return nativeGetTimestamp(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  @Deprecated
  public ARTrackable.TrackingState getTrackingState()
  {
    return this.mCamera.getTrackingState();
  }
  
  public Collection<ARAnchor> getUpdatedAnchors()
  {
    return this.mSession.convertNativeAnchorsToCollection(nativeAcquireUpdatedAnchors(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  @Deprecated
  public Collection<ARPlane> getUpdatedPlanes()
  {
    return getUpdatedTrackables(ARPlane.class);
  }
  
  public <T extends ARTrackable> Collection<T> getUpdatedTrackables(Class<T> paramClass)
  {
    int i = ARSession.getNativeTrackableFilterFromClass(paramClass);
    if (i == -1) {
      return Collections.emptyList();
    }
    long[] arrayOfLong = nativeAcquireUpdatedTrackables(this.mSession.mNativeHandle, this.mNativeHandle, i);
    return this.mSession.convertNativeTrackablesToCollection(paramClass, arrayOfLong);
  }
  
  @Deprecated
  public void getViewMatrix(float[] paramArrayOfFloat, int paramInt)
  {
    if ((paramArrayOfFloat == null) || (paramInt < 0) || (paramArrayOfFloat.length < paramInt + 16))
    {
      Log.e(TAG, "getViewMatrix: illegal argument ");
      throw new IllegalArgumentException("length of mViewMatrix is illegal.");
    }
    this.mCamera.getViewMatrix(paramArrayOfFloat, paramInt);
  }
  
  public boolean hasDisplayGeometryChanged()
  {
    if (nativeHasDisplayGeometryChanged(this.mSession.mNativeHandle, this.mNativeHandle)) {
      this.mSession.isDisplayRotationChanged.set(true);
    }
    return this.mSession.isDisplayRotationChanged.getAndSet(false);
  }
  
  public List<ARHitResult> hitTest(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F))
    {
      Log.e(TAG, "hitTest: illegal argument");
      throw new IllegalArgumentException();
    }
    long[] arrayOfLong = nativeHitTest(this.mSession.mNativeHandle, this.mNativeHandle, paramFloat1, paramFloat2);
    ArrayList localArrayList = new ArrayList(arrayOfLong.length);
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = arrayOfLong[i];
      ARHitResult localARHitResult = new ARHitResult(l, this.mSession);
      Object localObject = null;
      if (localARHitResult.getTrackable() == null)
      {
        i += 1;
      }
      else
      {
        if ((localARHitResult.getTrackable() instanceof ARPlane))
        {
          localARHitResult.mNativeHandle = 0L;
          localObject = new ARPlaneHitResult(l, this.mSession);
        }
        for (;;)
        {
          localArrayList.add(localObject);
          break;
          if ((localARHitResult.getTrackable() instanceof ARPoint))
          {
            localARHitResult.mNativeHandle = 0L;
            localObject = new ARPointCloudHitResult(l, this.mSession, getPointCloud());
          }
        }
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public List<ARHitResult> hitTest(MotionEvent paramMotionEvent)
  {
    return hitTest(paramMotionEvent.getX(), paramMotionEvent.getY());
  }
  
  @Deprecated
  public boolean isDisplayRotationChanged()
  {
    return hasDisplayGeometryChanged();
  }
  
  native long nativeAcquirePointCloud(long paramLong1, long paramLong2);
  
  public void transformDisplayUvCoords(FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    if ((paramFloatBuffer1 == null) || (paramFloatBuffer2 == null)) {
      throw new IllegalArgumentException("input parameter is null pointer.");
    }
    if ((!paramFloatBuffer1.isDirect()) || (!paramFloatBuffer2.isDirect())) {
      throw new IllegalArgumentException("transformDisplayUvCoords currently requires direct buffers.");
    }
    nativeTransformDisplayUvCoords(this.mSession.mNativeHandle, this.mNativeHandle, paramFloatBuffer1, paramFloatBuffer2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.ARFrame
 * JD-Core Version:    0.7.0.1
 */