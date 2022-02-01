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
  private static boolean globalInitialized = false;
  private static boolean loadSoSuccess = false;
  private static boolean needCheckMd5 = true;
  public static int sIdCount;
  public String basePath = null;
  public int id;
  public ARGLSurfaceView mAttached;
  public int mCurrentActiveId = 0;
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
    long l = System.currentTimeMillis();
    bool = ArNativeSoLoader.a("ArMapEngine836", needCheckMd5);
    needCheckMd5 = bool ^ true;
    if (!bool) {
      return false;
    }
    if (!globalInitialized)
    {
      bool = true;
      globalInitialized = true;
    }
    try
    {
      if (ArNativeSoLoader.c("ArMapEngine836") != 0) {
        break label116;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        continue;
        bool = false;
      }
    }
    loadSoSuccess = bool;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initSoEnvirontMent loadSoSuccess = ");
      localStringBuilder.append(loadSoSuccess);
      QLog.d("AREngine", 2, localStringBuilder.toString());
    }
    ARReport.a().f(System.currentTimeMillis() - l, loadSoSuccess);
    return loadSoSuccess;
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
  
  private native void nativeSetupScene(int paramInt1, int paramInt2, ArrayList<String> paramArrayList);
  
  public static void qqColorLog(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e(paramString1, 2, paramString2);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w(paramString1, 2, paramString2);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  private static native void setAssetManager(AssetManager paramAssetManager, String paramString);
  
  public void config(String paramString1, String paramString2) {}
  
  public void createEngine() {}
  
  public void fNativeDoActionCallback(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fNativeDoActionCallback action=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", params=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", callbackId=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", result=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("AREngine", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.sActionCallback;
    if (localObject != null) {
      ((ARNativeBridge.ActionCallback)localObject).callback(paramInt1, paramString1, paramInt2, paramString2);
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
  
  public native float getRotateDegree();
  
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
  
  public void handleOnSurfaceCreate(ArrayList<String> paramArrayList, int paramInt1, int paramInt2)
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
  
  public native void nativePreLoadTransferDoorAnd360Ball();
  
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
  
  public native void native_changeBigScreenTextureID(int paramInt);
  
  public native void native_cleanWorldCupSparks();
  
  public native void native_destroyCertainEngine(long paramLong);
  
  public native void native_enterTransferDoor(int paramInt);
  
  public native void native_exit();
  
  public native int native_getNativeGameStatus();
  
  public native void native_hiddenBigScreen();
  
  public native void native_insertWorldCupSpark(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
  
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
  
  public native void native_setARWorldCupCallBack(ARNativeBridge.ARWorldCupCallback paramARWorldCupCallback);
  
  public native void native_setARWorldCupQuaternion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public native void native_setBigScreenImageTexture(int paramInt);
  
  public native void native_setBigScreenInfo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5);
  
  public native void native_setBinHaiState(Activity paramActivity, ARNativeBridge paramARNativeBridge, int paramInt1, int paramInt2, String paramString);
  
  public native void native_setFullScreenMatrix(int paramInt, float[] paramArrayOfFloat);
  
  public native void native_setGuideFullScreenVideo(int paramInt1, int paramInt2, int paramInt3);
  
  public native void native_setRecogRes(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void native_startTranversalAnimation();
  
  public native void native_switchGameStatusWithNoParams(int paramInt);
  
  public native void native_switchGameStatusWithVideoId(int paramInt1, int paramInt2);
  
  public native void native_updateBallTanslateFromVideoTime(int paramInt);
  
  public native void native_updateBallTanslateFromXYZ(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public native void native_zoomOutWorldCupSparks();
  
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
  
  public native void setARCoreSupport(int paramInt);
  
  public native void setPreLoadTransferDoorFlags();
  
  public void setupActionCallback(ARNativeBridge.ActionCallback paramActionCallback)
  {
    this.sActionCallback = paramActionCallback;
  }
  
  public native void updateCameraTranslate(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARNativeBridge
 * JD-Core Version:    0.7.0.1
 */