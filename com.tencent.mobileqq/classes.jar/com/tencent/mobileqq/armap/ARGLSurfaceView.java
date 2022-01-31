package com.tencent.mobileqq.armap;

import aljf;
import aljg;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class ARGLSurfaceView
  extends GLSurfaceView
  implements aljg, GLSurfaceView.Renderer
{
  public static final int ACCELER_TYPE = 1;
  public static long FPS_LIMIT = 33L;
  public static boolean FPS_LIMIT_SWITCH = false;
  public static final int GYROSCOPE_TYPE = 2;
  public static final long MAX_FPS_LIMIT = 33L;
  private static final String TAG = "ARGLSurfaceView";
  private ARGLSurfaceView.TraceCallback mCallback;
  private Activity mCurActivity;
  protected long mEngineHandler;
  private long mFrameCount;
  private long mFrameLastFPS;
  public long mFrameRate;
  private volatile boolean mIsContextDestroyed;
  volatile boolean mIsDestroyed = false;
  private boolean mIsSupportPreserveEGLContextOnPause = true;
  private aljg mSensorListener;
  public aljf mSensorManager;
  private ARGLSurfaceView.SurfaceStateListener mSurfaceStateListener;
  private OrientationEventListener orientationListener;
  
  public ARGLSurfaceView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ARGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static native void nataiveSetCameraTexture(long paramLong, int paramInt);
  
  public static native void nativeSetLogLevel(int paramInt);
  
  private native void native_destroy(long paramLong);
  
  private native long native_init(Activity paramActivity, AssetManager paramAssetManager, String paramString, int paramInt);
  
  private native void native_onContextDestroy(long paramLong);
  
  private native long native_onOrientationChanged(int paramInt);
  
  private native void native_onTouchBegin(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong1, long paramLong2);
  
  private native void native_onTouchCancel(int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong1, long paramLong2);
  
  private native void native_onTouchEnd(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong1, long paramLong2);
  
  private native void native_onTouchMove(int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong1, long paramLong2);
  
  private native void native_pause(long paramLong);
  
  private native void native_resume(long paramLong);
  
  public static native void setDrawTexture(long paramLong, int paramInt);
  
  public static native void setVideoSize(long paramLong, int paramInt1, int paramInt2);
  
  public long getEngineHandler()
  {
    return this.mEngineHandler;
  }
  
  @TargetApi(11)
  public void init(Activity paramActivity, String paramString, int paramInt)
  {
    this.mCurActivity = paramActivity;
    setEGLContextClientVersion(2);
    setPreserveEGLContextOnPause(this.mIsSupportPreserveEGLContextOnPause);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    setEGLContextFactory(new ARGLSurfaceView.1(this));
    setRenderer(this);
    setRenderMode(1);
    queueEvent(new ARGLSurfaceView.2(this, paramActivity, paramString, paramInt));
    this.orientationListener = new ARGLSurfaceView.3(this, paramActivity, paramActivity);
  }
  
  public void initSensor(aljg paramaljg, int paramInt)
  {
    if ((this.mSensorManager == null) && (this.mCurActivity != null))
    {
      this.mSensorManager = new aljf(this.mCurActivity, paramInt);
      this.mSensorListener = paramaljg;
    }
  }
  
  public native void nativeCameraTextureM(long paramLong, float[] paramArrayOfFloat);
  
  public native void nativeSetCameraBgTexture(long paramLong, int paramInt);
  
  public native void nativeSetCameraYUVTexture(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public native void nativeTextureM(long paramLong, float[] paramArrayOfFloat);
  
  public native void nativeUpdatePerfLevel(int paramInt);
  
  public native void nativeUpdateRotation(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public native void nativeUpdateRotationM(long paramLong, float[] paramArrayOfFloat);
  
  public native void native_onDrawFrame(long paramLong);
  
  public native void native_onSensorChanged(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, int paramInt);
  
  public native void native_onSurfaceChanged(long paramLong, int paramInt1, int paramInt2);
  
  public native void native_onSurfaceCreated(long paramLong, int paramInt1, int paramInt2);
  
  public native void native_setSensorSupport(int paramInt, boolean paramBoolean);
  
  public native void native_updateAccel(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public native void native_updateAzimuth(long paramLong, float paramFloat);
  
  public native void native_updateHongbaoNumber(long paramLong, int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  public native void native_updatePitch(long paramLong, float paramFloat);
  
  public native void native_updateQuaternion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public native void native_updateRoll(long paramLong, float paramFloat);
  
  public native void native_updateSensor(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public native void nativestopRenderScene(long paramLong);
  
  public void onDestroy()
  {
    if (this.mSurfaceStateListener != null) {
      this.mSurfaceStateListener.onDestroy();
    }
    this.mIsDestroyed = true;
    super.queueEvent(new ARGLSurfaceView.6(this));
    if (this.mCallback != null) {
      this.mCallback.endTrace();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.mIsDestroyed = true;
    super.onDetachedFromWindow();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    long l = SystemClock.elapsedRealtime();
    if (this.mEngineHandler != 0L) {
      native_onDrawFrame(this.mEngineHandler);
    }
    updateFPSRate(l);
  }
  
  public void onPause()
  {
    super.onPause();
    this.orientationListener.disable();
    queueEvent(new ARGLSurfaceView.4(this));
    if (this.mSurfaceStateListener != null) {
      this.mSurfaceStateListener.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.orientationListener.enable();
    queueEvent(new ARGLSurfaceView.5(this));
    if (this.mSurfaceStateListener != null) {
      this.mSurfaceStateListener.onResume();
    }
  }
  
  public void onRotationUpdateOriginal(float[] paramArrayOfFloat)
  {
    if ((this.mEngineHandler != 0L) && (this.mSensorListener != null)) {
      this.mSensorListener.onRotationUpdateOriginal(paramArrayOfFloat);
    }
  }
  
  public void onRotationUpdateQuaternion(float[] paramArrayOfFloat)
  {
    if (this.mEngineHandler != 0L)
    {
      queueEvent(new ARGLSurfaceView.19(this, paramArrayOfFloat));
      if (this.mSensorListener != null) {
        this.mSensorListener.onRotationUpdateQuaternion(paramArrayOfFloat);
      }
    }
  }
  
  public void onSensorSupport(int paramInt, boolean paramBoolean)
  {
    queueEvent(new ARGLSurfaceView.20(this, paramInt, paramBoolean));
    if (this.mSensorListener != null) {
      this.mSensorListener.onSensorSupport(paramInt, paramBoolean);
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (this.mEngineHandler != 0L) {
      native_onSurfaceChanged(this.mEngineHandler, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (this.mEngineHandler != 0L)
    {
      native_onSurfaceCreated(this.mEngineHandler, getMeasuredWidth(), getMeasuredHeight());
      if (this.mSurfaceStateListener != null) {
        this.mSurfaceStateListener.onSurfaceCreated(paramGL10, paramEGLConfig);
      }
    }
    if (QLog.isDevelopLevel()) {
      nativeSetLogLevel(4);
    }
    for (;;)
    {
      if (this.mCallback != null) {
        this.mCallback.startTrace();
      }
      return;
      if (QLog.isColorLevel()) {
        nativeSetLogLevel(2);
      } else {
        nativeSetLogLevel(1);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    int[] arrayOfInt = new int[j];
    float[] arrayOfFloat1 = new float[j];
    float[] arrayOfFloat2 = new float[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = paramMotionEvent.getPointerId(i);
      arrayOfFloat1[i] = paramMotionEvent.getX(i);
      arrayOfFloat2[i] = paramMotionEvent.getY(i);
      i += 1;
    }
    long l = System.currentTimeMillis();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      super.onTouchEvent(paramMotionEvent);
      return true;
      i = paramMotionEvent.getAction() >> 8;
      queueEvent(new ARGLSurfaceView.7(this, paramMotionEvent.getPointerId(i), paramMotionEvent.getX(i), paramMotionEvent.getY(i), l));
      continue;
      queueEvent(new ARGLSurfaceView.8(this, paramMotionEvent.getPointerId(0), arrayOfFloat1[0], arrayOfFloat2[0], l));
      continue;
      queueEvent(new ARGLSurfaceView.9(this, arrayOfInt, arrayOfFloat1, arrayOfFloat2, l));
      continue;
      i = paramMotionEvent.getAction() >> 8;
      queueEvent(new ARGLSurfaceView.10(this, paramMotionEvent.getPointerId(i), paramMotionEvent.getX(i), paramMotionEvent.getY(i), l));
      continue;
      queueEvent(new ARGLSurfaceView.11(this, paramMotionEvent.getPointerId(0), arrayOfFloat1[0], arrayOfFloat2[0], l));
      continue;
      queueEvent(new ARGLSurfaceView.12(this, arrayOfInt, arrayOfFloat1, arrayOfFloat2, l));
    }
  }
  
  public void queueEvent(Runnable paramRunnable)
  {
    if (!this.mIsContextDestroyed) {
      super.queueEvent(ARMapTracer.GLHackTask.a(paramRunnable, this));
    }
  }
  
  public void resumeSensor()
  {
    if (this.mSensorManager != null) {
      this.mSensorManager.a(this);
    }
  }
  
  public void resumeSensor(int paramInt)
  {
    if (this.mSensorManager != null) {
      this.mSensorManager.a(this, paramInt);
    }
  }
  
  public void runOnGlThread(Runnable paramRunnable)
  {
    queueEvent(paramRunnable);
  }
  
  public boolean sensorAvailable()
  {
    if (this.mSensorManager != null) {
      return this.mSensorManager.a();
    }
    return false;
  }
  
  public void setLowFPSRate(boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARGLSurfaceView", 2, String.format(Locale.getDefault(), "setLowFPSRate fromDPC=%s enable=%s fpsLimit=%d", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong) }));
    }
    FPS_LIMIT_SWITCH = paramBoolean1;
    long l = paramLong;
    if (paramBoolean2) {
      if (paramLong >= 0L)
      {
        l = paramLong;
        if (paramLong <= 33L) {}
      }
      else
      {
        l = 33L;
      }
    }
    FPS_LIMIT = l;
  }
  
  public native void setShouldShowGameTipsNative(boolean paramBoolean);
  
  public void setSurfaceStateListener(ARGLSurfaceView.SurfaceStateListener paramSurfaceStateListener)
  {
    this.mSurfaceStateListener = paramSurfaceStateListener;
  }
  
  public void setTraceCallback(ARGLSurfaceView.TraceCallback paramTraceCallback)
  {
    this.mCallback = paramTraceCallback;
  }
  
  public void stopSensor()
  {
    if (this.mSensorManager != null) {
      this.mSensorManager.a();
    }
  }
  
  public void updateAccelerometer(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    queueEvent(new ARGLSurfaceView.13(this, paramFloat1, paramFloat2, paramFloat3, paramLong));
    if (this.mSensorListener != null) {
      this.mSensorListener.updateAccelerometer(paramFloat1, paramFloat2, paramFloat3, paramLong);
    }
  }
  
  public void updateAzimuth(float paramFloat)
  {
    if (this.mEngineHandler != 0L)
    {
      queueEvent(new ARGLSurfaceView.16(this, paramFloat));
      if (this.mSensorListener != null) {
        this.mSensorListener.updateAzimuth(paramFloat);
      }
    }
  }
  
  public void updateFPSRate(long paramLong)
  {
    this.mFrameCount += 1L;
    if (this.mFrameLastFPS == 0L) {
      this.mFrameLastFPS = SystemClock.elapsedRealtime();
    }
    if (SystemClock.elapsedRealtime() - this.mFrameLastFPS >= 1000L)
    {
      this.mFrameRate = this.mFrameCount;
      this.mFrameCount = 0L;
      this.mFrameLastFPS = SystemClock.elapsedRealtime();
      if (this.mCallback != null) {
        this.mCallback.trace(this.mFrameRate);
      }
    }
    paramLong = SystemClock.elapsedRealtime() - paramLong;
    if ((FPS_LIMIT_SWITCH) && (paramLong < FPS_LIMIT)) {}
    try
    {
      Thread.sleep(FPS_LIMIT - paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void updateGyroscope(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    queueEvent(new ARGLSurfaceView.14(this, paramFloat1, paramFloat2, paramFloat3, paramLong));
    if (this.mSensorListener != null) {
      this.mSensorListener.updateGyroscope(paramFloat1, paramFloat2, paramFloat3, paramLong);
    }
  }
  
  public void updatePitch(float paramFloat)
  {
    if (this.mEngineHandler != 0L)
    {
      queueEvent(new ARGLSurfaceView.17(this, paramFloat));
      if (this.mSensorListener != null) {
        this.mSensorListener.updatePitch(paramFloat);
      }
    }
  }
  
  public void updateRoll(float paramFloat)
  {
    if (this.mEngineHandler != 0L)
    {
      queueEvent(new ARGLSurfaceView.18(this, paramFloat));
      if (this.mSensorListener != null) {
        this.mSensorListener.updateRoll(paramFloat);
      }
    }
  }
  
  public void updateRotation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((this.mEngineHandler != 0L) && (this.mSensorListener != null)) {
      this.mSensorListener.updateRotation(paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  public void updateSensor(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.mEngineHandler != 0L)
    {
      queueEvent(new ARGLSurfaceView.15(this, paramFloat1, paramFloat2, paramFloat3));
      if (this.mSensorListener != null) {
        this.mSensorListener.updateSensor(paramFloat1, paramFloat2, paramFloat3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */