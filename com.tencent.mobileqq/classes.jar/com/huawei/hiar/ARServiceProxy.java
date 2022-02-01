package com.huawei.hiar;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.view.Surface;
import com.huawei.arengine.service.IAREngine;
import com.huawei.hiar.annotations.UsedByNative;
import com.huawei.hiar.exceptions.ARCameraNotAvailableException;
import com.huawei.hiar.exceptions.ARCameraPermissionDeniedException;
import com.huawei.hiar.exceptions.ARDeadlineExceededException;
import com.huawei.hiar.exceptions.ARFatalException;
import com.huawei.hiar.exceptions.ARMissingGlContextException;
import com.huawei.hiar.exceptions.ARNotTrackingException;
import com.huawei.hiar.exceptions.ARNotYetAvailableException;
import com.huawei.hiar.exceptions.ARResourceExhaustedException;
import com.huawei.hiar.exceptions.ARSessionNotPausedException;
import com.huawei.hiar.exceptions.ARSessionPausedException;
import com.huawei.hiar.exceptions.ARTextureNotSetException;
import com.huawei.hiar.exceptions.ARUnSupportedConfigurationException;
import com.huawei.hiar.exceptions.ARUnavailableClientSdkTooOldException;
import com.huawei.hiar.exceptions.ARUnavailableConnectServerTimeOutException;
import com.huawei.hiar.exceptions.ARUnavailableDeviceNotCompatibleException;
import com.huawei.hiar.exceptions.ARUnavailableEmuiNotCompatibleException;
import com.huawei.hiar.exceptions.ARUnavailableServiceApkTooOldException;
import com.huawei.hiar.exceptions.ARUnavailableServiceNotInstalledException;
import com.huawei.hiar.exceptions.ARUnavailableUserDeclinedInstallationException;
import java.io.FileDescriptor;
import java.util.concurrent.atomic.AtomicBoolean;

@UsedByNative("HiARSession.cpp")
class ARServiceProxy
  implements SurfaceTexture.OnFrameAvailableListener
{
  static final int HWAR_ERROR_CAMERA_NOT_AVAILABLE = -13;
  static final int HWAR_ERROR_CAMERA_PERMISSION_NOT_GRANTED = -9;
  static final int HWAR_ERROR_DEADLINE_EXCEEDED = -10;
  static final int HWAR_ERROR_FATAL = -2;
  static final int HWAR_ERROR_INVALID_ARGUMENT = -1;
  static final int HWAR_ERROR_MISSING_GL_CONTEXT = -7;
  static final int HWAR_ERROR_NOT_TRACKING = -5;
  static final int HWAR_ERROR_NOT_YET_AVAILABLE = -12;
  static final int HWAR_ERROR_RESOURCE_EXHAUSTED = -11;
  static final int HWAR_ERROR_SESSION_NOT_PAUSED = -4;
  static final int HWAR_ERROR_SESSION_PAUSED = -3;
  static final int HWAR_ERROR_TEXTURE_NOT_SET = -6;
  static final int HWAR_ERROR_UNSUPPORTED_CONFIGURATION = -8;
  static final int HWAR_SUCCESS = 0;
  static final int HWAR_UNAVAILABLE_APK_TOO_OLD = -103;
  static final int HWAR_UNAVAILABLE_ARSERVICE_NOT_INSTALLED = -100;
  static final int HWAR_UNAVAILABLE_CONNECT_SERVER_TIME_OUT = -1001;
  static final int HWAR_UNAVAILABLE_DEVICE_NOT_COMPATIBLE = -101;
  static final int HWAR_UNAVAILABLE_EMUI_NOT_COMPATIBLE = -1000;
  static final int HWAR_UNAVAILABLE_SDK_TOO_OLD = -104;
  static final int HWAR_UNAVAILABLE_USER_DECLINED_INSTALLATION = -105;
  private static final String NAME_ARENGINE_REMOTE_SERVICE = "com.huawei.arengine.service.AREngineServer";
  private static final String PACKAGE_ARENGINE_REMOTE_SERVICE = "com.huawei.arengine.service";
  private static final String TAG = ARServiceProxy.class.getSimpleName();
  private static final boolean USE_64_BIT_LIB = false;
  public static int mPreviewSizeHeight = 960;
  public static int mPreviewSizeWidth = 1280;
  private final long NANOSECONDS_IN_MILLISECOND = 1000000L;
  private ServiceConnection connection = new ARServiceProxy.1(this);
  private Context context;
  private IAREngine hiARService;
  private boolean isSetMetaData = false;
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  private Surface mPreviewSurface = null;
  private SurfaceTexture mSTexture = null;
  private int[] metaData;
  private long sessionHandle;
  private final Object syncObject = new Object();
  private AtomicBoolean textureAvailable = new AtomicBoolean(false);
  
  @UsedByNative("HiARSession.cpp")
  public ARServiceProxy(Object paramObject, long paramLong)
  {
    this.context = ((Context)paramObject);
    this.sessionHandle = paramLong;
    this.mHandlerThread = new HandlerThread("OnFrameAvailableThread");
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
    arBindService(this.context);
  }
  
  @UsedByNative("HiARSession.cpp")
  private Surface GetPreviewSurfaceWithTexture(int paramInt)
  {
    if (paramInt < 0)
    {
      Log.e(TAG, "invalid textureId  yet");
      return null;
    }
    if (this.mSTexture == null)
    {
      this.mSTexture = new SurfaceTexture(paramInt);
      if (Build.VERSION.SDK_INT < 21) {
        break label111;
      }
      this.mSTexture.setOnFrameAvailableListener(this, this.mHandler);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.mSTexture.setDefaultBufferSize(mPreviewSizeWidth, mPreviewSizeHeight);
      }
      this.mPreviewSurface = new Surface(this.mSTexture);
      if (this.mPreviewSurface == null) {
        Log.e(TAG, "GetSurfaceWithTexture  failed,  lost surface ");
      }
      return this.mPreviewSurface;
      label111:
      this.mSTexture.setOnFrameAvailableListener(this);
    }
  }
  
  private void arBindService(Context paramContext)
  {
    Log.d(TAG, "arBindService");
    Intent localIntent = new Intent();
    localIntent.setAction("com.huawei.arengine.service.ARENGINE_SERVICE");
    paramContext.bindService(new Intent(creatExplicitStartIntent(localIntent)), this.connection, 1);
  }
  
  private void arUnbindService(Context paramContext)
  {
    Log.d(TAG, "arUnbindService");
    if (paramContext == null)
    {
      Log.e(TAG, "context is null");
      return;
    }
    paramContext.unbindService(this.connection);
  }
  
  private Intent creatExplicitStartIntent(Intent paramIntent)
  {
    ComponentName localComponentName = new ComponentName("com.huawei.arengine.service", "com.huawei.arengine.service.AREngineServer");
    paramIntent = new Intent(paramIntent);
    paramIntent.setComponent(localComponentName);
    return paramIntent;
  }
  
  private static String getAbsolutePath(Context paramContext)
  {
    boolean bool = false;
    paramContext = paramContext.getPackageResourcePath();
    int i = paramContext.length() - 1;
    for (;;)
    {
      if ((i < 0) || (paramContext.charAt(i) == '/'))
      {
        if (i >= 0) {
          break;
        }
        return null;
      }
      i -= 1;
    }
    paramContext = paramContext.substring(0, i);
    if (Build.VERSION.SDK_INT >= 23) {
      bool = Process.is64Bit();
    }
    if (bool)
    {
      Log.d(TAG, "current process is 64bit, use arm64");
      return paramContext + "/lib/arm64/";
    }
    Log.d(TAG, "current process is 32bit, use arm");
    return paramContext + "/lib/arm/";
  }
  
  @UsedByNative("session_impl.cpp")
  private static String getAbsoluteRemoteLibName(Object paramObject, String paramString)
  {
    Log.d(TAG, "into getAbsoluteRemoteLibName");
    try
    {
      paramObject = getAbsolutePath(((Context)paramObject).createPackageContext(paramString, 3));
      return paramObject;
    }
    catch (Exception paramObject)
    {
      Log.e(TAG, "create context failed");
      paramObject.printStackTrace();
    }
    return null;
  }
  
  @UsedByNative("HiARHelper.cpp")
  private FileDescriptor getSharedFile(String paramString)
  {
    if (this.hiARService == null)
    {
      Log.w(TAG, "AR service is not ready.");
      return null;
    }
    try
    {
      paramString = this.hiARService.getSharedFile(paramString);
      if (paramString == null)
      {
        Log.i(TAG, "Failed to get file descriptor.");
        return null;
      }
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
    return paramString.getFileDescriptor();
  }
  
  private native void nativeSetMetaData(long paramLong, int[] paramArrayOfInt, int paramInt);
  
  private native void nativeStart(long paramLong);
  
  @UsedByNative("HiARSession.cpp")
  private boolean newFrameAvaliableByWait(long paramLong)
  {
    for (;;)
    {
      synchronized (this.textureAvailable)
      {
        if (!this.textureAvailable.getAndSet(false)) {
          break label149;
        }
        return true;
        Object localObject1;
        Object localObject2;
        localObject1 -= System.nanoTime() - localObject2;
        if (l1 <= 0L) {
          break label111;
        }
        long l2 = System.nanoTime();
      }
      try
      {
        long l3 = l1 / 1000000L;
        this.textureAvailable.wait(l3, (int)(l1 % 1000000L));
        if (!this.textureAvailable.getAndSet(false)) {
          continue;
        }
        Log.d(TAG, "newFrameAvaliableByWait: notifyed by onFrameAvailable");
        return true;
        localObject3 = finally;
        throw localObject3;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
      label111:
      Log.d(TAG, "texture unavailable for " + paramLong + " ms");
      return false;
      label149:
      long l1 = 1000000L * paramLong;
    }
  }
  
  @UsedByNative("HiARSession.cpp")
  public static float[] projectionMatrixFromCameraIntrinsics(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10)
  {
    float[] arrayOfFloat1 = new float[32];
    Matrix.setIdentityM(arrayOfFloat1, 0);
    arrayOfFloat1[0] = (1.0F / paramFloat3);
    arrayOfFloat1[5] = (1.0F / paramFloat4);
    Matrix.frustumM(arrayOfFloat1, 16, -paramFloat7 * paramFloat5 / 2.0F - paramFloat9, paramFloat5 * paramFloat7 / 2.0F - paramFloat9, -paramFloat8 * paramFloat6 / 2.0F - paramFloat10, paramFloat6 * paramFloat8 / 2.0F - paramFloat10, paramFloat1, paramFloat2);
    float[] arrayOfFloat2 = new float[16];
    Matrix.multiplyMM(arrayOfFloat2, paramInt, arrayOfFloat1, 0, arrayOfFloat1, 16);
    return arrayOfFloat2;
  }
  
  @UsedByNative("HiARSession.cpp")
  private void stop()
  {
    arUnbindService(this.context);
  }
  
  @UsedByNative("hiarsession_jni.cpp")
  static void throwExceptionFromArStatus(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new RuntimeException("Unexpected error code: " + paramInt);
    case -1: 
      throw new IllegalArgumentException();
    case -2: 
      throw new ARFatalException();
    case -3: 
      throw new ARSessionPausedException();
    case -4: 
      throw new ARSessionNotPausedException();
    case -5: 
      throw new ARNotTrackingException();
    case -6: 
      throw new ARTextureNotSetException();
    case -7: 
      throw new ARMissingGlContextException();
    case -8: 
      throw new ARUnSupportedConfigurationException();
    case -9: 
      throw new ARCameraPermissionDeniedException();
    case -10: 
      throw new ARDeadlineExceededException();
    case -11: 
      throw new ARResourceExhaustedException();
    case -12: 
      throw new ARNotYetAvailableException();
    case -13: 
      throw new ARCameraNotAvailableException();
    case -100: 
      throw new ARUnavailableServiceNotInstalledException();
    case -101: 
      throw new ARUnavailableDeviceNotCompatibleException();
    case -1000: 
      throw new ARUnavailableEmuiNotCompatibleException();
    case -1001: 
      throw new ARUnavailableConnectServerTimeOutException();
    case -103: 
      throw new ARUnavailableServiceApkTooOldException();
    case -104: 
      throw new ARUnavailableClientSdkTooOldException();
    case -105: 
      throw new ARUnavailableUserDeclinedInstallationException();
    }
  }
  
  @UsedByNative("HiARSession.cpp")
  private long updatePreview()
  {
    this.mSTexture.updateTexImage();
    return this.mSTexture.getTimestamp();
  }
  
  protected void finalize()
  {
    this.mHandlerThread.quit();
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.textureAvailable)
    {
      this.textureAvailable.set(true);
      this.textureAvailable.notify();
      return;
    }
  }
  
  @UsedByNative("HiARSession.cpp")
  void update(long paramLong1, long paramLong2)
  {
    if (this.hiARService != null)
    {
      if (!this.isSetMetaData)
      {
        nativeSetMetaData(paramLong1, this.metaData, this.metaData.length);
        this.isSetMetaData = true;
      }
      return;
    }
    Log.w(TAG, "AR service is not ready.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.ARServiceProxy
 * JD-Core Version:    0.7.0.1
 */