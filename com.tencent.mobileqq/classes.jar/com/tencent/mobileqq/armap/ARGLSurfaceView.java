package com.tencent.mobileqq.armap;

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
import com.tencent.mobileqq.armap.sensor.ARSensorManager;
import com.tencent.mobileqq.armap.sensor.ARSensorManager.OnSensorChangeListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class ARGLSurfaceView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer, ARSensorManager.OnSensorChangeListener
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
  private long mFrameCount = 0L;
  private long mFrameLastFPS = 0L;
  public long mFrameRate = 0L;
  private volatile boolean mIsContextDestroyed = false;
  volatile boolean mIsDestroyed = false;
  private boolean mIsSupportPreserveEGLContextOnPause = true;
  private ARSensorManager.OnSensorChangeListener mSensorListener;
  public ARSensorManager mSensorManager;
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
  
  public void initSensor(ARSensorManager.OnSensorChangeListener paramOnSensorChangeListener, int paramInt)
  {
    if (this.mSensorManager == null)
    {
      Activity localActivity = this.mCurActivity;
      if (localActivity != null)
      {
        this.mSensorManager = new ARSensorManager(localActivity, paramInt);
        this.mSensorListener = paramOnSensorChangeListener;
      }
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
    Object localObject = this.mSurfaceStateListener;
    if (localObject != null) {
      ((ARGLSurfaceView.SurfaceStateListener)localObject).onDestroy();
    }
    this.mIsDestroyed = true;
    super.queueEvent(new ARGLSurfaceView.6(this));
    localObject = this.mCallback;
    if (localObject != null) {
      ((ARGLSurfaceView.TraceCallback)localObject).endTrace();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.mIsDestroyed = true;
    super.onDetachedFromWindow();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.mEngineHandler;
    if (l2 != 0L) {
      native_onDrawFrame(l2);
    }
    updateFPSRate(l1);
  }
  
  public void onPause()
  {
    super.onPause();
    this.orientationListener.disable();
    queueEvent(new ARGLSurfaceView.4(this));
    ARGLSurfaceView.SurfaceStateListener localSurfaceStateListener = this.mSurfaceStateListener;
    if (localSurfaceStateListener != null) {
      localSurfaceStateListener.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.orientationListener.enable();
    queueEvent(new ARGLSurfaceView.5(this));
    ARGLSurfaceView.SurfaceStateListener localSurfaceStateListener = this.mSurfaceStateListener;
    if (localSurfaceStateListener != null) {
      localSurfaceStateListener.onResume();
    }
  }
  
  public void onRotationUpdateOriginal(float[] paramArrayOfFloat)
  {
    if (this.mEngineHandler != 0L)
    {
      ARSensorManager.OnSensorChangeListener localOnSensorChangeListener = this.mSensorListener;
      if (localOnSensorChangeListener != null) {
        localOnSensorChangeListener.onRotationUpdateOriginal(paramArrayOfFloat);
      }
    }
  }
  
  public void onRotationUpdateQuaternion(float[] paramArrayOfFloat)
  {
    if (this.mEngineHandler != 0L)
    {
      ARSensorManager.OnSensorChangeListener localOnSensorChangeListener = this.mSensorListener;
      if (localOnSensorChangeListener != null) {
        localOnSensorChangeListener.onRotationUpdateQuaternion(paramArrayOfFloat);
      }
    }
  }
  
  public void onSensorSupport(int paramInt, boolean paramBoolean)
  {
    queueEvent(new ARGLSurfaceView.19(this, paramInt, paramBoolean));
    ARSensorManager.OnSensorChangeListener localOnSensorChangeListener = this.mSensorListener;
    if (localOnSensorChangeListener != null) {
      localOnSensorChangeListener.onSensorSupport(paramInt, paramBoolean);
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    long l = this.mEngineHandler;
    if (l != 0L) {
      native_onSurfaceChanged(l, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    long l = this.mEngineHandler;
    if (l != 0L)
    {
      native_onSurfaceCreated(l, getMeasuredWidth(), getMeasuredHeight());
      ARGLSurfaceView.SurfaceStateListener localSurfaceStateListener = this.mSurfaceStateListener;
      if (localSurfaceStateListener != null) {
        localSurfaceStateListener.onSurfaceCreated(paramGL10, paramEGLConfig);
      }
    }
    if (QLog.isDevelopLevel()) {
      nativeSetLogLevel(4);
    } else if (QLog.isColorLevel()) {
      nativeSetLogLevel(2);
    } else {
      nativeSetLogLevel(1);
    }
    paramGL10 = this.mCallback;
    if (paramGL10 != null) {
      paramGL10.startTrace();
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
    i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 5)
            {
              if (i == 6)
              {
                i = paramMotionEvent.getAction() >> 8;
                queueEvent(new ARGLSurfaceView.10(this, paramMotionEvent.getPointerId(i), paramMotionEvent.getX(i), paramMotionEvent.getY(i), l));
              }
            }
            else
            {
              i = paramMotionEvent.getAction() >> 8;
              queueEvent(new ARGLSurfaceView.7(this, paramMotionEvent.getPointerId(i), paramMotionEvent.getX(i), paramMotionEvent.getY(i), l));
            }
          }
          else {
            queueEvent(new ARGLSurfaceView.12(this, arrayOfInt, arrayOfFloat1, arrayOfFloat2, l));
          }
        }
        else {
          queueEvent(new ARGLSurfaceView.9(this, arrayOfInt, arrayOfFloat1, arrayOfFloat2, l));
        }
      }
      else {
        queueEvent(new ARGLSurfaceView.11(this, paramMotionEvent.getPointerId(0), arrayOfFloat1[0], arrayOfFloat2[0], l));
      }
    }
    else {
      queueEvent(new ARGLSurfaceView.8(this, paramMotionEvent.getPointerId(0), arrayOfFloat1[0], arrayOfFloat2[0], l));
    }
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void queueEvent(Runnable paramRunnable)
  {
    if (!this.mIsContextDestroyed) {
      super.queueEvent(ARMapTracer.GLHackTask.a(paramRunnable, this));
    }
  }
  
  public void resumeSensor()
  {
    ARSensorManager localARSensorManager = this.mSensorManager;
    if (localARSensorManager != null) {
      localARSensorManager.a(this);
    }
  }
  
  public void resumeSensor(int paramInt)
  {
    ARSensorManager localARSensorManager = this.mSensorManager;
    if (localARSensorManager != null) {
      localARSensorManager.a(this, paramInt);
    }
  }
  
  public void runOnGlThread(Runnable paramRunnable)
  {
    queueEvent(paramRunnable);
  }
  
  public boolean sensorAvailable()
  {
    ARSensorManager localARSensorManager = this.mSensorManager;
    if (localARSensorManager != null) {
      return localARSensorManager.a();
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
    ARSensorManager localARSensorManager = this.mSensorManager;
    if (localARSensorManager != null) {
      localARSensorManager.b();
    }
  }
  
  public void updateAccelerometer(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    queueEvent(new ARGLSurfaceView.13(this, paramFloat1, paramFloat2, paramFloat3, paramLong));
    ARSensorManager.OnSensorChangeListener localOnSensorChangeListener = this.mSensorListener;
    if (localOnSensorChangeListener != null) {
      localOnSensorChangeListener.updateAccelerometer(paramFloat1, paramFloat2, paramFloat3, paramLong);
    }
  }
  
  public void updateAzimuth(float paramFloat)
  {
    if (this.mEngineHandler != 0L)
    {
      queueEvent(new ARGLSurfaceView.16(this, paramFloat));
      ARSensorManager.OnSensorChangeListener localOnSensorChangeListener = this.mSensorListener;
      if (localOnSensorChangeListener != null) {
        localOnSensorChangeListener.updateAzimuth(paramFloat);
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
      ARGLSurfaceView.TraceCallback localTraceCallback = this.mCallback;
      if (localTraceCallback != null) {
        localTraceCallback.trace(this.mFrameRate);
      }
    }
    paramLong = SystemClock.elapsedRealtime() - paramLong;
    if (FPS_LIMIT_SWITCH)
    {
      long l = FPS_LIMIT;
      if (paramLong < l) {
        try
        {
          Thread.sleep(l - paramLong);
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void updateGyroscope(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    queueEvent(new ARGLSurfaceView.14(this, paramFloat1, paramFloat2, paramFloat3, paramLong));
    ARSensorManager.OnSensorChangeListener localOnSensorChangeListener = this.mSensorListener;
    if (localOnSensorChangeListener != null) {
      localOnSensorChangeListener.updateGyroscope(paramFloat1, paramFloat2, paramFloat3, paramLong);
    }
  }
  
  public void updatePitch(float paramFloat)
  {
    if (this.mEngineHandler != 0L)
    {
      queueEvent(new ARGLSurfaceView.17(this, paramFloat));
      ARSensorManager.OnSensorChangeListener localOnSensorChangeListener = this.mSensorListener;
      if (localOnSensorChangeListener != null) {
        localOnSensorChangeListener.updatePitch(paramFloat);
      }
    }
  }
  
  public void updateRoll(float paramFloat)
  {
    if (this.mEngineHandler != 0L)
    {
      queueEvent(new ARGLSurfaceView.18(this, paramFloat));
      ARSensorManager.OnSensorChangeListener localOnSensorChangeListener = this.mSensorListener;
      if (localOnSensorChangeListener != null) {
        localOnSensorChangeListener.updateRoll(paramFloat);
      }
    }
  }
  
  public void updateRotation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.mEngineHandler != 0L)
    {
      ARSensorManager.OnSensorChangeListener localOnSensorChangeListener = this.mSensorListener;
      if (localOnSensorChangeListener != null) {
        localOnSensorChangeListener.updateRotation(paramFloat1, paramFloat2, paramFloat3);
      }
    }
  }
  
  public void updateSensor(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.mEngineHandler != 0L)
    {
      queueEvent(new ARGLSurfaceView.15(this, paramFloat1, paramFloat2, paramFloat3));
      ARSensorManager.OnSensorChangeListener localOnSensorChangeListener = this.mSensorListener;
      if (localOnSensorChangeListener != null) {
        localOnSensorChangeListener.updateSensor(paramFloat1, paramFloat2, paramFloat3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */