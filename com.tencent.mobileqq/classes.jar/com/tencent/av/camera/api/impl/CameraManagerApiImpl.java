package com.tencent.av.camera.api.impl;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.camera.CameraListener;
import com.tencent.av.camera.CameraNotifyCenter;
import com.tencent.av.camera.CameraPreviewCallback;
import com.tencent.av.camera.VcCamera;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.opengl.effects.CameraFrame;
import com.tencent.av.opengl.effects.EffectCtrlBase;
import com.tencent.av.utils.AVTraceUtil;
import com.tencent.av.utils.QavDpcUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

public class CameraManagerApiImpl
  implements ICameraManagerApi
{
  private static final int FROM_CAMERA = 1;
  private static final int FROM_RENDER = 2;
  private static final String PREF_BACK_CAMERA_ROTATE = "backCameraRotation";
  private static final String PREF_CAMERA_NUMBER = "cameraNumber";
  private static final String PREF_FRONT_CAMERA_ROTATE = "frontCameraRotation";
  public static final String TAG = "CameraUtils";
  private final CameraManagerApiImpl.CloseCameraRunnable closeCamera = new CameraManagerApiImpl.CloseCameraRunnable(this);
  private final Map<String, Integer> device = new HashMap(2);
  private final boolean doCameraNewMode = true;
  private VcCamera mCamera = null;
  private CameraManagerApiImpl.CameraAvailabilityReceiver mCameraAvailabilityReceiver = null;
  private Handler mCameraHandler = null;
  private HandlerThread mCameraHandlerThread = null;
  private CameraNotifyCenter mCameraNotifyCenter = null;
  private int mCameraNum = 0;
  private Context mContext = null;
  private CameraManagerApiImpl.UpdateHandler mDBWorkHandler;
  private boolean mIsHuaWeiGraTL00 = false;
  private CameraListener mListener = null;
  boolean mPreview = false;
  private final SurfaceTexture mSurfaceTexture = new SurfaceTexture(0);
  private Handler mUIHandler = null;
  private HandlerThread mWorkThread;
  CameraManagerApiImpl.NoPreviewRunnable noPreview = new CameraManagerApiImpl.NoPreviewRunnable(this);
  private final CameraManagerApiImpl.OpenCameraRunnable openCamera = new CameraManagerApiImpl.OpenCameraRunnable(this);
  private final CameraManagerApiImpl.SwitchCameraRunnable switchCamera = new CameraManagerApiImpl.SwitchCameraRunnable(this);
  
  private void checkCameraNumbers()
  {
    Object localObject = this.mContext.getSharedPreferences("cameracfg", 0);
    int i;
    if (((SharedPreferences)localObject).contains("cameraNumber"))
    {
      int j = ((SharedPreferences)localObject).getInt("cameraNumber", 0);
      i = j;
      if (j < 1)
      {
        i = Camera.getNumberOfCameras();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CameraHandlerThread, checkCameraNumbers numberOfCameras ");
        ((StringBuilder)localObject).append(i);
        QLog.d("CameraUtils", 1, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      ThreadManager.excute(new CameraManagerApiImpl.2(this, (SharedPreferences)localObject), 64, null, false);
      i = 2;
    }
    this.mCameraNum = i;
  }
  
  private void closeCameraInSubThread(long paramLong, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("closeCamera begin, mCamera[");
    ((StringBuilder)localObject).append(this.mCamera);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w("CameraUtils", 1, ((StringBuilder)localObject).toString());
    getCameraNotifyCenter().a(new Object[] { Integer.valueOf(3), Long.valueOf(paramLong) });
    localObject = this.mListener;
    if (localObject != null) {
      ((CameraListener)localObject).d();
    }
    localObject = this.mCamera;
    if (localObject != null) {
      ((VcCamera)localObject).c(paramLong);
    }
    stopNoPreviewRunnable("CloseCameraRunnable.run");
    localObject = this.mListener;
    if (localObject != null) {
      ((CameraListener)localObject).a(paramLong, paramBoolean);
    }
    getCameraNotifyCenter().a(new Object[] { Integer.valueOf(4), Boolean.valueOf(true), Long.valueOf(paramLong) });
    unRegistCameraAvailability();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("closeCamera end, mCamera[");
    ((StringBuilder)localObject).append(this.mCamera);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w("CameraUtils", 1, ((StringBuilder)localObject).toString());
  }
  
  private CameraNotifyCenter getCameraNotifyCenter()
  {
    if (this.mCameraNotifyCenter == null) {
      this.mCameraNotifyCenter = new CameraNotifyCenter();
    }
    return this.mCameraNotifyCenter;
  }
  
  private SurfaceTexture getSurfaceTexture()
  {
    return getSurfaceTexture(1);
  }
  
  private SurfaceTexture getSurfaceTexture(int paramInt)
  {
    boolean bool2 = EffectCtrlBase.b();
    int i = 0;
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = QavDpcUtil.a(0);
    }
    if (bool1) {
      i = 1;
    }
    if ((i == 1) && (paramInt == 1))
    {
      if (!CameraFrame.a(this.mSurfaceTexture)) {
        QLog.i("CameraUtils", 1, "getSurfaceTexture, frame is not deal right.");
      }
      CameraFrame.c(this.mSurfaceTexture);
    }
    this.mCamera.a(i, this);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSurfaceTexture, isUseSurface[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], cameraMode[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.i("SurfaceTag", 2, localStringBuilder.toString());
    }
    return this.mSurfaceTexture;
  }
  
  private void openCameraInSubThread(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openCamera begin, mCamera[");
    ((StringBuilder)localObject).append(this.mCamera);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w("CameraUtils", 1, ((StringBuilder)localObject).toString());
    getCameraNotifyCenter().a(new Object[] { Integer.valueOf(1), Boolean.valueOf(this.mCamera.d()), Long.valueOf(paramLong) });
    localObject = this.mListener;
    if (localObject != null) {
      ((CameraListener)localObject).e();
    }
    boolean bool2 = this.mCamera.a(paramLong, getSurfaceTexture());
    if (bool2) {
      startNoPreviewRunnable(paramLong, "OpenCameraRunnable.run");
    }
    int i;
    if (this.mListener != null)
    {
      boolean bool1;
      if (this.mCamera.h() != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      i = this.mListener.a(paramLong, bool2, bool1);
    }
    else
    {
      i = 0;
    }
    getCameraNotifyCenter().a(new Object[] { Integer.valueOf(2), Boolean.valueOf(bool2), Integer.valueOf(i), Long.valueOf(paramLong) });
    if (bool2) {
      registCameraAvailability();
    }
    long l2 = System.currentTimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openCamera end. result[");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append("], cost[");
    ((StringBuilder)localObject).append(l2 - l1);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w("CameraUtils", 1, ((StringBuilder)localObject).toString());
  }
  
  private void reopenCameraInSubThread(long paramLong, int paramInt1, int paramInt2)
  {
    VcCamera localVcCamera = this.mCamera;
    boolean bool;
    if (localVcCamera != null) {
      bool = localVcCamera.a(paramLong, getSurfaceTexture(), paramInt1, paramInt2);
    } else {
      bool = false;
    }
    if (bool) {
      startNoPreviewRunnable(paramLong, "reopenCameraInSubThread");
    } else {
      stopNoPreviewRunnable("reopenCameraInSubThread");
    }
    getCameraNotifyCenter().a(new Object[] { Integer.valueOf(8), Boolean.valueOf(bool) });
  }
  
  private void setCameraParaInSubThread(long paramLong, int paramInt)
  {
    if ((QQAudioHelper.c()) || (this.mCamera == null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCameraParaInSubThread begin, mCamera[");
      ((StringBuilder)localObject).append(this.mCamera);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("CameraUtils", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mCamera;
    if (localObject == null) {
      return;
    }
    ((VcCamera)localObject).a(paramLong, paramInt);
  }
  
  private void switchCameraInSubThread(long paramLong)
  {
    if (QQAudioHelper.c())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("switchCamera begin, mCamera[");
      ((StringBuilder)localObject).append(this.mCamera);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("CameraUtils", 1, ((StringBuilder)localObject).toString());
    }
    AVTraceUtil.a("switch_camera", "SwitchCameraRunnable", 3, new Object[] { Long.valueOf(paramLong) });
    getCameraNotifyCenter().a(new Object[] { Integer.valueOf(5) });
    Object localObject = this.mCamera;
    boolean bool;
    if (localObject != null) {
      bool = ((VcCamera)localObject).b(paramLong, getSurfaceTexture());
    } else {
      bool = false;
    }
    getCameraNotifyCenter().a(new Object[] { Integer.valueOf(6), Boolean.valueOf(bool) });
    if (QQAudioHelper.c())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("switchCamera end, result[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("], mCamera[");
      ((StringBuilder)localObject).append(this.mCamera);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("CameraUtils", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void addObserver(Observer paramObserver)
  {
    if (paramObserver != null) {
      getCameraNotifyCenter().addObserver(paramObserver);
    }
  }
  
  public boolean closeCamera(long paramLong, boolean paramBoolean)
  {
    if (this.mCamera != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mCamera.d());
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "null";
    }
    Throwable localThrowable;
    if (QLog.isColorLevel()) {
      localThrowable = new Throwable();
    } else {
      localThrowable = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeCamera, changeStatus[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], isCameraOpened[");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("], openCamera[");
    localStringBuilder.append(this.openCamera);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("CameraUtils", 1, localStringBuilder.toString(), localThrowable);
    Object localObject = this.mCamera;
    if ((localObject != null) && (((VcCamera)localObject).d()))
    {
      closeCamera2(paramLong, paramBoolean);
      return true;
    }
    return false;
  }
  
  public void closeCamera2(long paramLong, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void deleteObserver(Observer paramObserver)
  {
    getCameraNotifyCenter().deleteObserver(paramObserver);
  }
  
  protected void finalize()
  {
    try
    {
      stopNoPreviewRunnable("finalize");
      this.mListener = null;
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getCameraNum()
  {
    return this.mCameraNum;
  }
  
  public Camera.Parameters getCameraParams()
  {
    VcCamera localVcCamera = this.mCamera;
    if (localVcCamera != null) {
      return localVcCamera.a();
    }
    return null;
  }
  
  public SurfaceTexture getSurfaceTextureForRender()
  {
    SurfaceTexture localSurfaceTexture = getSurfaceTexture(2);
    int i = this.mCamera.a();
    if (i != 1) {
      localSurfaceTexture = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSurfaceTextureForRender, cameraMode[");
      localStringBuilder.append(i);
      localStringBuilder.append("], surfaceTexture[");
      localStringBuilder.append(localSurfaceTexture);
      localStringBuilder.append("]");
      QLog.i("SurfaceTag", 2, localStringBuilder.toString());
    }
    return localSurfaceTexture;
  }
  
  public boolean isCameraOpened(long paramLong)
  {
    Object localObject = this.mCamera;
    boolean bool;
    if (localObject != null) {
      bool = ((VcCamera)localObject).d();
    } else {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isCameraOpened, isCameraOpened[");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w("CameraUtils", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public boolean isCameraOpening(long paramLong)
  {
    Object localObject = this.mCamera;
    boolean bool2 = false;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((VcCamera)localObject).c();
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isCameraOpening[");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("], mCamera[");
      if (this.mCamera != null) {
        bool2 = true;
      }
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("CameraUtils", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public boolean isFrontCamera()
  {
    Object localObject = this.mCamera;
    boolean bool;
    if (localObject != null) {
      bool = ((VcCamera)localObject).b();
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isFrontCamera[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("], mCamera[");
      ((StringBuilder)localObject).append(this.mCamera);
      ((StringBuilder)localObject).append("]");
      QLog.w("CameraUtils", 1, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public void onPreviewData(CameraFrame paramCameraFrame)
  {
    CameraListener localCameraListener = this.mListener;
    if (localCameraListener != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPreviewData_");
      localStringBuilder.append(paramCameraFrame.c);
      stopNoPreviewRunnable(localStringBuilder.toString());
      if (this.mIsHuaWeiGraTL00)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPreviewData_");
        localStringBuilder.append(paramCameraFrame.c);
        startNoPreviewRunnable(-1019L, localStringBuilder.toString());
      }
      localCameraListener.onPreviewData(paramCameraFrame);
      return;
    }
    paramCameraFrame.b();
  }
  
  public void openCamera(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openCamera, seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("], openCamera[");
    ((StringBuilder)localObject).append(this.openCamera);
    ((StringBuilder)localObject).append("], closeCamera[");
    ((StringBuilder)localObject).append(this.closeCamera);
    ((StringBuilder)localObject).append("], mCamera[");
    ((StringBuilder)localObject).append(this.mCamera);
    ((StringBuilder)localObject).append("]");
    QLog.w("CameraUtils", 1, ((StringBuilder)localObject).toString());
    if (Build.MODEL.equalsIgnoreCase("HWI-AL00"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Build.MODEL);
      ((StringBuilder)localObject).append("_SP_QAV_CAMERA_OPENED");
      localObject = ((StringBuilder)localObject).toString();
      localObject = this.mContext.getSharedPreferences((String)localObject, 4);
      boolean bool = ((SharedPreferences)localObject).getBoolean("KEY_OPENED", false);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AVTest. openCamera. hasOpened = ");
      localStringBuilder.append(bool);
      QLog.w("CameraUtils", 1, localStringBuilder.toString());
      if (!bool)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("KEY_OPENED", true);
        ((SharedPreferences.Editor)localObject).commit();
        this.mUIHandler.postDelayed(new CameraManagerApiImpl.3(this, paramLong), 1000L);
        return;
      }
      openCamera2(paramLong);
      return;
    }
    openCamera2(paramLong);
  }
  
  public void openCamera2(long paramLong)
  {
    removeAllCameraEvent();
    Message localMessage = this.mCameraHandler.obtainMessage(1);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.sendToTarget();
  }
  
  void registCameraAvailability()
  {
    if (this.mCameraAvailabilityReceiver == null)
    {
      this.mCameraAvailabilityReceiver = new CameraManagerApiImpl.CameraAvailabilityReceiver(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
      this.mContext.registerReceiver(this.mCameraAvailabilityReceiver, localIntentFilter);
    }
  }
  
  void removeAllCameraEvent()
  {
    this.mCameraHandler.removeMessages(1);
    this.mCameraHandler.removeMessages(2);
    this.mCameraHandler.removeMessages(3);
    this.mCameraHandler.removeMessages(4);
    this.mCameraHandler.removeMessages(5);
  }
  
  public void reopenCamera(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    reopenCamera2(paramLong, paramInt1, paramInt2);
  }
  
  public void reopenCamera2(long paramLong, int paramInt1, int paramInt2)
  {
    removeAllCameraEvent();
    Message localMessage = this.mCameraHandler.obtainMessage(3);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.sendToTarget();
  }
  
  public void resetCamera()
  {
    VcCamera localVcCamera = this.mCamera;
    if (localVcCamera != null) {
      localVcCamera.a();
    }
  }
  
  public void rotateCamera()
  {
    VcCamera localVcCamera = this.mCamera;
    if (localVcCamera != null)
    {
      int i = this.mCameraNum;
      if (i > 0)
      {
        if ((i != 1) && (localVcCamera.b()))
        {
          i = this.mCamera.c(true);
          this.mCamera.a(true, i + 90);
          return;
        }
        i = this.mCamera.c(false);
        this.mCamera.a(false, i + 90);
      }
    }
  }
  
  public void saveCameraAngle()
  {
    SharedPreferences.Editor localEditor = this.mContext.getSharedPreferences("cameracfg", 0).edit();
    int i = this.mCamera.c(true);
    int j = this.mCamera.c(false);
    localEditor.putInt("frontCameraRotation", i);
    localEditor.putInt("backCameraRotation", j);
    localEditor.commit();
  }
  
  public void setCameraListener(CameraListener paramCameraListener)
  {
    this.mListener = paramCameraListener;
  }
  
  public void setCameraPara2(long paramLong, int paramInt)
  {
    this.mCameraHandler.removeMessages(5);
    Message localMessage = this.mCameraHandler.obtainMessage(5);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public void setCameraSensorMode(boolean paramBoolean)
  {
    com.tencent.av.camera.AndroidCamera.a = paramBoolean;
  }
  
  public void setCameraWithNewFps(long paramLong, int paramInt)
  {
    VcCamera localVcCamera = this.mCamera;
    if ((localVcCamera != null) && (localVcCamera.d())) {
      setCameraPara2(paramLong, paramInt);
    }
  }
  
  public void setRotation(int paramInt)
  {
    VcCamera localVcCamera = this.mCamera;
    if (localVcCamera != null) {
      localVcCamera.a(paramInt);
    }
  }
  
  public void setSupportLandscape(boolean paramBoolean)
  {
    Object localObject = this.mCamera;
    if (localObject != null)
    {
      if (((VcCamera)localObject).f != paramBoolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setSupportLandscape, value[");
        ((StringBuilder)localObject).append(this.mCamera.f);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append("]");
        QLog.w("CameraUtils", 1, ((StringBuilder)localObject).toString());
      }
      this.mCamera.f = paramBoolean;
    }
  }
  
  public void setUp(Context paramContext)
  {
    boolean bool = Build.MODEL.equals("HUAWEI GRA-TL00");
    Integer localInteger = Integer.valueOf(1);
    if (bool) {
      this.mIsHuaWeiGraTL00 = true;
    }
    this.mContext = paramContext.getApplicationContext();
    this.mCamera = new VcCamera(this.mContext);
    checkCameraNumbers();
    if (this.mCameraNum > 0)
    {
      paramContext = this.mContext.getSharedPreferences("cameracfg", 0);
      int i = paramContext.getInt("frontCameraRotation", 0);
      int j = paramContext.getInt("backCameraRotation", 0);
      this.mCamera.a(true, i);
      this.mCamera.a(false, j);
    }
    this.mUIHandler = new Handler(Looper.getMainLooper());
    this.mWorkThread = new HandlerThread("AppStoreWorkThread");
    this.mWorkThread.start();
    this.mDBWorkHandler = new CameraManagerApiImpl.UpdateHandler(this, this.mWorkThread.getLooper());
    this.device.put("0", localInteger);
    this.device.put("1", localInteger);
    if (this.mCameraHandlerThread == null)
    {
      this.mCameraHandlerThread = ThreadManager.newFreeHandlerThread("QAV_Camera_Handler_Thread", 0);
      this.mCameraHandlerThread.start();
      this.mCameraHandler = new CameraManagerApiImpl.1(this, this.mCameraHandlerThread.getLooper());
    }
  }
  
  public void startNoPreviewRunnable(long paramLong, String paramString)
  {
    if (QQAudioHelper.c())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startNoPreviewRunnable[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], noPreview[");
      localStringBuilder.append(this.noPreview.a);
      localStringBuilder.append("]");
      QLog.w("CameraUtils", 2, localStringBuilder.toString());
    }
    paramString = this.noPreview;
    paramString.a = paramLong;
    this.mUIHandler.removeCallbacks(paramString);
    this.mUIHandler.postDelayed(this.noPreview, 10000L);
    this.mPreview = false;
  }
  
  public void stopNoPreviewRunnable(String paramString)
  {
    if (!this.mPreview)
    {
      if (QQAudioHelper.c())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopNoPreviewRunnable[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], noPreview[");
        localStringBuilder.append(this.noPreview.a);
        localStringBuilder.append("]");
        QLog.w("CameraUtils", 2, localStringBuilder.toString());
      }
      this.mPreview = true;
      this.mUIHandler.removeCallbacks(this.noPreview);
    }
  }
  
  public void switchCamera(long paramLong)
  {
    if (this.mCamera.d()) {
      switchCamera2(paramLong);
    }
  }
  
  public void switchCamera2(long paramLong)
  {
    removeAllCameraEvent();
    Message localMessage = this.mCameraHandler.obtainMessage(4);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.sendToTarget();
  }
  
  void unRegistCameraAvailability()
  {
    CameraManagerApiImpl.CameraAvailabilityReceiver localCameraAvailabilityReceiver = this.mCameraAvailabilityReceiver;
    if (localCameraAvailabilityReceiver != null)
    {
      try
      {
        this.mContext.unregisterReceiver(localCameraAvailabilityReceiver);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.mCameraAvailabilityReceiver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.camera.api.impl.CameraManagerApiImpl
 * JD-Core Version:    0.7.0.1
 */