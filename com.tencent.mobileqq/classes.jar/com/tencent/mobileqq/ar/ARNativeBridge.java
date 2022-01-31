package com.tencent.mobileqq.ar;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ARNativeBridge
{
  public static final int ANIMATION_TYPE_MAIN = 3;
  public static final int ANIMATION_TYPE_SWIPE_LEFT = 1;
  public static final int ANIMATION_TYPE_SWIPE_RIGHT = 2;
  private static boolean globalInitialized;
  private static boolean loadSoSuccess;
  private static boolean needCheckMd5 = true;
  public static int sIdCount;
  public String basePath;
  public int id;
  public ARGLSurfaceView mAttached;
  public int mCurrentActiveId;
  public ARNativeBridge.ActionCallback sActionCallback;
  
  public ARNativeBridge()
  {
    initSoEnvirontMent();
    int i = sIdCount;
    sIdCount = i + 1;
    this.id = i;
  }
  
  public ARNativeBridge(ARGLSurfaceView paramARGLSurfaceView)
  {
    this.mAttached = paramARGLSurfaceView;
  }
  
  private static boolean initSoEnvirontMent()
  {
    boolean bool2 = true;
    long l = System.currentTimeMillis();
    boolean bool3 = ArNativeSoLoader.a("ArMapEngine738", needCheckMd5);
    if (!bool3) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      needCheckMd5 = bool1;
      if (bool3) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARNativeBridge", 2, "native so is not exist!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARNativeBridge", 2, "initSoEnvirontMent, globalInitialzed=" + globalInitialized);
    }
    if (!globalInitialized) {
      globalInitialized = true;
    }
    for (;;)
    {
      try
      {
        int i = ArNativeSoLoader.a("ArMapEngine738");
        if (i != 0) {
          continue;
        }
        bool1 = bool2;
        loadSoSuccess = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("ARNativeBridge", 2, "initSoEnvirontMent, result=" + i);
        }
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ARNativeBridge", 2, "initSoEnvirontMent", localThrowable);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AREngine", 2, "initSoEnvirontMent loadSoSuccess = " + loadSoSuccess);
      }
      ARReport.a().f(System.currentTimeMillis() - l, loadSoSuccess);
      return loadSoSuccess;
      bool1 = false;
    }
  }
  
  public static boolean loadNativeLibrary()
  {
    return initSoEnvirontMent();
  }
  
  private native void nativeConfig(String paramString1, String paramString2);
  
  private native void nativeCreateEngine();
  
  private native String nativeGetConfig(String paramString);
  
  private native void nativeOnDestroy();
  
  private native void nativeOnDrawFrame(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  private native void nativeOnPause();
  
  private native void nativeOnResume();
  
  private native void nativeSetupScene(int paramInt1, int paramInt2, ArrayList paramArrayList);
  
  public static void qqColorLog(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d(paramString1, 2, paramString2);
        return;
      } while (!QLog.isColorLevel());
      QLog.w(paramString1, 2, paramString2);
      return;
    } while (!QLog.isColorLevel());
    QLog.e(paramString1, 2, paramString2);
  }
  
  private static native void setAssetManager(AssetManager paramAssetManager, String paramString);
  
  public void config(String paramString1, String paramString2) {}
  
  public void createEngine() {}
  
  public void fNativeDoActionCallback(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, "fNativeDoActionCallback action=" + paramInt1 + ", params=" + paramString1 + ", callbackId=" + paramInt2 + ", result=" + paramString2);
    }
    ARNativeBridge.ActionCallback localActionCallback = this.sActionCallback;
    if (localActionCallback != null) {
      localActionCallback.callback(paramInt1, paramString1, paramInt2, paramString2);
    }
  }
  
  public String getConfig(String paramString)
  {
    return "";
  }
  
  public int getIndentification()
  {
    int i = this.mCurrentActiveId + 1;
    this.mCurrentActiveId = i;
    return i;
  }
  
  public void handleDrawFrame(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (!loadSoSuccess) {
      return;
    }
    try
    {
      nativeOnDrawFrame(paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    catch (UnsatisfiedLinkError paramArrayOfFloat1)
    {
      paramArrayOfFloat1.printStackTrace();
    }
  }
  
  public void handleOnSurfaceCreate(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    if (!loadSoSuccess) {
      return;
    }
    try
    {
      nativeSetupScene(paramInt1, paramInt2, paramArrayList);
      return;
    }
    catch (UnsatisfiedLinkError paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public boolean isLoadSoSuccess()
  {
    return loadSoSuccess;
  }
  
  public void nativeCreateEngine(long paramLong, String paramString1, Context paramContext, AssetManager paramAssetManager, String paramString2, int paramInt1, int paramInt2)
  {
    nativeCreateEngineBusiness(paramLong, paramString1, paramContext, paramAssetManager, paramString2, paramInt1, paramInt2, -1);
  }
  
  public void nativeCreateEngineBusiness(long paramLong, String paramString1, Context paramContext, AssetManager paramAssetManager, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      native_CreateEngineBusiness(paramLong, paramString1, paramContext, paramAssetManager, paramString2, paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void nativeDestroyCertainEngine(long paramLong)
  {
    try
    {
      native_destroyCertainEngine(paramLong);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public void nativeOnDrawFrame(long paramLong, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    try
    {
      native_onDrawFrame(paramLong, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    catch (UnsatisfiedLinkError paramArrayOfFloat1)
    {
      paramArrayOfFloat1.printStackTrace();
    }
  }
  
  public void nativePause(long paramLong)
  {
    try
    {
      native_pause(paramLong);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public void nativeResume(long paramLong)
  {
    try
    {
      native_resume(paramLong);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public native void native_CreateEngine(long paramLong, String paramString1, Context paramContext, AssetManager paramAssetManager, String paramString2, int paramInt1, int paramInt2);
  
  public native void native_CreateEngineBusiness(long paramLong, String paramString1, Context paramContext, AssetManager paramAssetManager, String paramString2, int paramInt1, int paramInt2, int paramInt3);
  
  public native void native_destroyCertainEngine(long paramLong);
  
  public native void native_exit();
  
  public native void native_onDrawFrame(long paramLong, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  public native long native_onOrientationChanged(int paramInt);
  
  public native void native_onSensorChanged(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, int paramInt);
  
  public native void native_onSurfaceChanged(long paramLong, int paramInt1, int paramInt2);
  
  public native void native_onTouchBegin(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong1, long paramLong2);
  
  public native void native_onTouchCancel(int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong1, long paramLong2);
  
  public native void native_onTouchEnd(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong1, long paramLong2);
  
  public native void native_onTouchMove(int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong1, long paramLong2);
  
  public native void native_pause(long paramLong);
  
  public native void native_playARCardAnimation(int paramInt);
  
  public native void native_resume(long paramLong);
  
  public native void native_setARCardAnimationCallback(ARNativeBridge.ARCardAnimationCallback paramARCardAnimationCallback);
  
  public native void native_setARCardQuaternion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public native void native_setARCardVideoCover(String paramString);
  
  public native void native_setARCardVideoMatrix(float[] paramArrayOfFloat);
  
  public native void native_setARCardVideoTexture(int paramInt1, int paramInt2, int paramInt3);
  
  public native void native_setARCardVideoYUVTexture(int paramInt);
  
  public native void native_setBinHaiState(Activity paramActivity, ARNativeBridge paramARNativeBridge, int paramInt1, int paramInt2, String paramString);
  
  public void nativeonSurfaceChanged(long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      native_onSurfaceChanged(paramLong, paramInt1, paramInt2);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void setupActionCallback(ARNativeBridge.ActionCallback paramActionCallback)
  {
    this.sActionCallback = paramActionCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARNativeBridge
 * JD-Core Version:    0.7.0.1
 */