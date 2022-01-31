package com.huawei.hiar;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public class ARSession
{
  static final int AR_TRACKABLE_BASE_TRACKABLE = 1095893248;
  static final int AR_TRACKABLE_BODY = 1342177281;
  static final int AR_TRACKABLE_FACE = 1342177282;
  static final int AR_TRACKABLE_HAND = 1342177280;
  static final int AR_TRACKABLE_IMAGE = 1095893252;
  static final int AR_TRACKABLE_NOT_VALID = 0;
  static final int AR_TRACKABLE_PLANE = 1095893249;
  static final int AR_TRACKABLE_POINT = 1095893250;
  static final int AR_TRACKABLE_UNKNOWN_TO_JAVA = -1;
  static final int AR_TRACKING_STATE_PAUSED = 1;
  static final int AR_TRACKING_STATE_STOPPED = 2;
  static final int AR_TRACKING_STATE_TRACKING = 0;
  public static final int CURRENT_SDK_VERSIONCODE = 56;
  private static final String TAG = ARSession.class.getSimpleName();
  AtomicBoolean isDisplayRotationChanged = new AtomicBoolean(false);
  private Context mContext;
  long mNativeHandle;
  protected Object syncObject = new Object();
  
  public ARSession(Context paramContext)
  {
    this.mContext = paramContext;
    this.mNativeHandle = nativeCreateSession(paramContext.getApplicationContext());
  }
  
  static int getNativeTrackableFilterFromClass(Class<?> paramClass)
  {
    if (paramClass == ARTrackable.class) {
      return 1095893248;
    }
    if (paramClass == ARPlane.class) {
      return 1095893249;
    }
    if (paramClass == ARAugmentedImage.class) {
      return 1095893252;
    }
    if (paramClass == ARPoint.class) {
      return 1095893250;
    }
    if (paramClass == ARHand.class) {
      return 1342177280;
    }
    if (paramClass == ARBody.class) {
      return 1342177281;
    }
    if (paramClass == ARFace.class) {
      return 1342177282;
    }
    return -1;
  }
  
  private native long[] nativeAcquireAllAnchors(long paramLong);
  
  private native long[] nativeAcquireAllTrackables(long paramLong, int paramInt);
  
  private native void nativeConfigure(long paramLong1, long paramLong2);
  
  private native long nativeCreateAnchor(long paramLong, ARPose paramARPose);
  
  private static native long nativeCreateSession(Context paramContext);
  
  private native long[] nativeDeSerializeAnchors(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  private static native void nativeDestroySession(long paramLong);
  
  private native long nativeGetCameraConfig(long paramLong);
  
  private native long nativeGetSaveLimit(long paramLong);
  
  private native long nativeGetSerializeAnchorsLimit(long paramLong);
  
  private native boolean nativeIsSupported(long paramLong1, long paramLong2);
  
  private native void nativeLoad(long paramLong, ByteBuffer paramByteBuffer);
  
  private native void nativePause(long paramLong);
  
  private native void nativeResume(long paramLong);
  
  private native long nativeSave(long paramLong, ByteBuffer paramByteBuffer);
  
  private native long nativeSerializeAnchors(long paramLong, long[] paramArrayOfLong, ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  private native void nativeSetCameraTextureName(long paramLong, int paramInt);
  
  private native void nativeSetDisplayGeometry(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private native void nativeStop(long paramLong);
  
  private native void nativeUpdate(long paramLong1, long paramLong2);
  
  public Collection<ARAnchor> DeSerializeAnchors(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramByteBuffer == null) {
      throw new IllegalArgumentException();
    }
    if (!paramByteBuffer.isDirect()) {
      Log.w(TAG, "deSerializeAnchors: input bytebuffer is not direct");
    }
    return convertNativeAnchorsToCollection(nativeDeSerializeAnchors(this.mNativeHandle, paramByteBuffer, paramInt));
  }
  
  public ByteBuffer SerializeAnchors(ArrayList<ARAnchor> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null)
    {
      Log.e(TAG, "list is null");
      throw new IllegalArgumentException();
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect((int)nativeGetSerializeAnchorsLimit(this.mNativeHandle));
    long[] arrayOfLong = new long[paramArrayList.size()];
    int i = 0;
    while (i < paramArrayList.size())
    {
      arrayOfLong[i] = ((ARAnchor)paramArrayList.get(i)).mNativeHandle;
      i += 1;
    }
    return (ByteBuffer)localByteBuffer.limit((int)nativeSerializeAnchors(this.mNativeHandle, arrayOfLong, localByteBuffer, paramBoolean));
  }
  
  public void configure(ARConfigBase paramARConfigBase)
  {
    if (paramARConfigBase.mSession == null) {
      paramARConfigBase.setSession(this);
    }
    nativeConfigure(this.mNativeHandle, paramARConfigBase.mNativeHandle);
  }
  
  Collection<ARAnchor> convertNativeAnchorsToCollection(long[] paramArrayOfLong)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfLong.length);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new ARAnchor(paramArrayOfLong[i], this));
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  <T extends ARTrackable> Collection<T> convertNativeTrackablesToCollection(Class<T> paramClass, long[] paramArrayOfLong)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfLong.length);
    int j = paramArrayOfLong.length;
    int i = 0;
    if (i < j)
    {
      ARTrackable localARTrackable = createTrackable(paramArrayOfLong[i]);
      if (localARTrackable == null) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(paramClass.cast(localARTrackable));
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public ARAnchor createAnchor(ARPose paramARPose)
  {
    return new ARAnchor(nativeCreateAnchor(this.mNativeHandle, paramARPose), this);
  }
  
  ARTrackable createTrackable(long paramLong)
  {
    switch (ARTrackableBase.internalGetType(this.mNativeHandle, paramLong))
    {
    default: 
      ARTrackableBase.internalReleaseNativeHandle(paramLong);
      return null;
    case 1095893249: 
      Log.d(TAG, "createTrackable: plane");
      return new ARPlane(paramLong, this);
    case 1095893250: 
      Log.d(TAG, "createTrackable: point");
      return new ARPoint(paramLong, this);
    case 1095893252: 
      Log.d(TAG, "createTrackable: image");
      return new ARAugmentedImage(paramLong, this);
    case 1342177280: 
      Log.d(TAG, "createTrackable: hand");
      return new ARHand(paramLong, this);
    case 1342177281: 
      Log.d(TAG, "createTrackable: body");
      return new ARBody(paramLong, this);
    }
    Log.d(TAG, "createTrackable: face");
    return new ARFace(paramLong, this);
  }
  
  protected void finalize()
  {
    if (this.mNativeHandle != 0L) {
      nativeDestroySession(this.mNativeHandle);
    }
    super.finalize();
  }
  
  public Collection<ARAnchor> getAllAnchors()
  {
    return convertNativeAnchorsToCollection(nativeAcquireAllAnchors(this.mNativeHandle));
  }
  
  public <T extends ARTrackable> Collection<T> getAllTrackables(Class<T> paramClass)
  {
    int i = getNativeTrackableFilterFromClass(paramClass);
    if (i == -1) {
      return Collections.emptyList();
    }
    return convertNativeTrackablesToCollection(paramClass, nativeAcquireAllTrackables(this.mNativeHandle, i));
  }
  
  public ARCameraConfig getCameraConfig()
  {
    return new ARCameraConfig(this, nativeGetCameraConfig(this.mNativeHandle));
  }
  
  public void loadSharedData(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      throw new IllegalArgumentException();
    }
    if (!paramByteBuffer.isDirect()) {
      Log.w(TAG, "loadSharedData: input bytebuffer is not direct");
    }
    paramByteBuffer.order(ByteOrder.nativeOrder());
    nativeLoad(this.mNativeHandle, paramByteBuffer);
  }
  
  public void pause()
  {
    nativePause(this.mNativeHandle);
  }
  
  public void resume()
  {
    nativeResume(this.mNativeHandle);
  }
  
  public ByteBuffer saveSharedData()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect((int)nativeGetSaveLimit(this.mNativeHandle));
    return (ByteBuffer)localByteBuffer.limit((int)nativeSave(this.mNativeHandle, localByteBuffer));
  }
  
  public void setCameraTextureName(int paramInt)
  {
    nativeSetCameraTextureName(this.mNativeHandle, paramInt);
  }
  
  @Deprecated
  public void setDisplayGeometry(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 <= 0.0F) || (paramFloat2 <= 0.0F))
    {
      Log.e(TAG, "setDisplayGeometry: width or height is less than or equal to zero");
      throw new IllegalArgumentException("width or height must be greater than zero");
    }
    if (!(this.mContext instanceof Activity))
    {
      Log.e(TAG, "The Context set to this session should be a instance of Activity whilecalling setDisplayGeometry(float width, float height)");
      throw new IllegalStateException("context should be a instance of Activity");
    }
    setDisplayGeometry(((Activity)this.mContext).getWindowManager().getDefaultDisplay().getRotation(), (int)paramFloat1, (int)paramFloat2);
  }
  
  public void setDisplayGeometry(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3))
    {
      Log.e(TAG, String.format("setDisplayGeometry: displayRotation %d out of range(0~3)", new Object[] { Integer.valueOf(paramInt1) }));
      throw new IllegalArgumentException("displayRoation is out of range");
    }
    if ((paramInt2 <= 0) || (paramInt3 <= 0))
    {
      Log.e(TAG, "setDisplayGeometry: width or height is less than or equal to zero");
      throw new IllegalArgumentException("width or height must be greater than zero");
    }
    nativeSetDisplayGeometry(this.mNativeHandle, paramInt1, paramInt2, paramInt3);
    this.isDisplayRotationChanged.set(true);
  }
  
  public void stop()
  {
    nativeStop(this.mNativeHandle);
  }
  
  public ARFrame update()
  {
    synchronized (this.syncObject)
    {
      ARFrame localARFrame = new ARFrame(this);
      nativeUpdate(this.mNativeHandle, localARFrame.mNativeHandle);
      return localARFrame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.ARSession
 * JD-Core Version:    0.7.0.1
 */