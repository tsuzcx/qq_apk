package com.tencent.av.camera;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;
import lgf;
import lke;
import lkh;
import lki;
import lkj;
import lkk;
import lkl;
import lkp;
import mqq;

public class CameraUtils
{
  static volatile CameraUtils jdField_a_of_type_ComTencentAvCameraCameraUtils;
  int jdField_a_of_type_Int = 0;
  Context jdField_a_of_type_AndroidContentContext = null;
  SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(0);
  private Handler jdField_a_of_type_AndroidOsHandler;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread = null;
  public VideoController a;
  CameraUtils.CloseCameraRunnable jdField_a_of_type_ComTencentAvCameraCameraUtils$CloseCameraRunnable = new CameraUtils.CloseCameraRunnable(this);
  CameraUtils.NoPreviewRunnable jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable = new CameraUtils.NoPreviewRunnable(this);
  CameraUtils.OpenCameraRunnable jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable = new CameraUtils.OpenCameraRunnable(this);
  CameraUtils.SwitchCameraRunnable jdField_a_of_type_ComTencentAvCameraCameraUtils$SwitchCameraRunnable = new CameraUtils.SwitchCameraRunnable(this);
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap(2);
  lke jdField_a_of_type_Lke = new lkh(this);
  private lkj jdField_a_of_type_Lkj;
  private lkk jdField_a_of_type_Lkk;
  private lkl jdField_a_of_type_Lkl;
  lkp jdField_a_of_type_Lkp = null;
  public boolean a;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  boolean jdField_b_of_type_Boolean = true;
  boolean c = false;
  
  private CameraUtils(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    if (Build.MODEL.equals("HUAWEI GRA-TL00")) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Lkp = new lkp(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Lkp.a(this.jdField_a_of_type_Lke);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Lkp.f();
    if (this.jdField_a_of_type_Int > 0)
    {
      paramContext = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("cameracfg", 0);
      int i = paramContext.getInt("frontCameraRotation", 0);
      int j = paramContext.getInt("backCameraRotation", 0);
      this.jdField_a_of_type_Lkp.a(true, i);
      this.jdField_a_of_type_Lkp.a(false, j);
    }
    this.jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("AppStoreWorkThread");
    this.jdField_b_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Lkl = new lkl(this, this.jdField_b_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_JavaUtilMap.put("0", Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilMap.put("1", Integer.valueOf(1));
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandlerThread == null))
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("QAV_Camera_Handler_Thread", 0);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new lki(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
  }
  
  public static CameraUtils a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentAvCameraCameraUtils == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvCameraCameraUtils == null) {
        jdField_a_of_type_ComTencentAvCameraCameraUtils = new CameraUtils(paramContext);
      }
      return jdField_a_of_type_ComTencentAvCameraCameraUtils;
    }
    finally {}
  }
  
  private lkk a()
  {
    if (this.jdField_a_of_type_Lkk == null) {
      this.jdField_a_of_type_Lkk = new lkk(this);
    }
    return this.jdField_a_of_type_Lkk;
  }
  
  private void b(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Lkp != null) {}
    for (boolean bool = this.jdField_a_of_type_Lkp.a(paramLong, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, paramInt1, paramInt2);; bool = false)
    {
      if (bool) {
        a(paramLong, "reopenCameraInSubThread");
      }
      for (;;)
      {
        a().a(new Object[] { Integer.valueOf(8), Boolean.valueOf(bool) });
        return;
        a("reopenCameraInSubThread");
      }
    }
  }
  
  private void b(long paramLong, boolean paramBoolean)
  {
    QLog.w("CameraUtils", 1, "closeCamera begin, mCamera[" + this.jdField_a_of_type_Lkp + "], seq[" + paramLong + "]");
    a().a(new Object[] { Integer.valueOf(3), Long.valueOf(paramLong) });
    if (this.jdField_a_of_type_Lkp != null) {
      this.jdField_a_of_type_Lkp.c(paramLong);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      a("CloseCameraRunnable.run");
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 2) {
        break label265;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, false);
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().k)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "CloseCameraRunnable.1", 1);
          this.jdField_a_of_type_ComTencentAvVideoController.a().Q = true;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvVideoController.a().d);
      a().a(new Object[] { Integer.valueOf(4), Boolean.valueOf(true), Long.valueOf(paramLong) });
      e();
      QLog.w("CameraUtils", 1, "closeCamera end, mCamera[" + this.jdField_a_of_type_Lkp + "], seq[" + paramLong + "]");
      return;
      label265:
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().k)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "CloseCameraRunnable.2", 3);
      }
    }
  }
  
  private void c(long paramLong, int paramInt)
  {
    if ((AudioHelper.e()) || (this.jdField_a_of_type_Lkp == null)) {
      QLog.w("CameraUtils", 1, "setCameraParaInSubThread begin, mCamera[" + this.jdField_a_of_type_Lkp + "], seq[" + paramLong + "]");
    }
    if (this.jdField_a_of_type_Lkp == null) {
      return;
    }
    this.jdField_a_of_type_Lkp.a(paramLong, paramInt);
  }
  
  private void e(long paramLong)
  {
    if (AudioHelper.e()) {
      QLog.w("CameraUtils", 1, "switchCamera begin, mCamera[" + this.jdField_a_of_type_Lkp + "], seq[" + paramLong + "]");
    }
    mqq.a("switch_camera", "SwitchCameraRunnable", 3, new Object[] { Long.valueOf(paramLong) });
    a().a(new Object[] { Integer.valueOf(5) });
    if (this.jdField_a_of_type_Lkp != null) {}
    for (boolean bool = this.jdField_a_of_type_Lkp.b(paramLong, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);; bool = false)
    {
      a().a(new Object[] { Integer.valueOf(6), Boolean.valueOf(bool) });
      if (AudioHelper.e()) {
        QLog.w("CameraUtils", 1, "switchCamera end, result[" + bool + "], mCamera[" + this.jdField_a_of_type_Lkp + "], seq[" + paramLong + "]");
      }
      return;
    }
  }
  
  private void f(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    QLog.w("CameraUtils", 1, "openCamera begin, mCamera[" + this.jdField_a_of_type_Lkp + "], seq[" + paramLong + "]");
    a().a(new Object[] { Integer.valueOf(1), Boolean.valueOf(this.jdField_a_of_type_Lkp.c()), Long.valueOf(paramLong) });
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.e = 0;
      this.jdField_a_of_type_ComTencentAvVideoController.g = false;
    }
    boolean bool = this.jdField_a_of_type_Lkp.a(paramLong, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    int j;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      j = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
      if (this.jdField_a_of_type_Lkp.g() != 0) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().p = true;
      }
      i = j;
      if (bool)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().m = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a().Q = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, true);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 1) {
          break label374;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "OpenCameraRunnable.1", 2);
        this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvVideoController.a().d);
        a(paramLong, "OpenCameraRunnable.run");
      }
    }
    for (int i = j;; i = 0)
    {
      a().a(new Object[] { Integer.valueOf(2), Boolean.valueOf(bool), Integer.valueOf(i), Long.valueOf(paramLong) });
      if (bool) {
        d();
      }
      long l2 = System.currentTimeMillis();
      QLog.w("CameraUtils", 1, "openCamera end. result[" + bool + "], cost[" + (l2 - l1) + "], seq[" + paramLong + "]");
      return;
      label374:
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d != 3) && (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 4)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "OpenCameraRunnable.2", 4);
      break;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Camera.Parameters a()
  {
    if (this.jdField_a_of_type_Lkp != null) {
      return this.jdField_a_of_type_Lkp.a();
    }
    return null;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Lkp != null) && (this.jdField_a_of_type_Int > 0))
    {
      if ((this.jdField_a_of_type_Int == 1) || (!this.jdField_a_of_type_Lkp.a()))
      {
        i = this.jdField_a_of_type_Lkp.c(false) + 90;
        j = i % 360 / 90;
        this.jdField_a_of_type_Lkp.a(false, i);
      }
    }
    else {
      return;
    }
    int i = this.jdField_a_of_type_Lkp.c(true) + 90;
    int j = i % 360 / 90;
    this.jdField_a_of_type_Lkp.a(true, i);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Lkp != null) {
      this.jdField_a_of_type_Lkp.a(paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    QLog.w("CameraUtils", 1, "openCamera, seq[" + paramLong + "], openCamera[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable + "], closeCamera[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$CloseCameraRunnable + "], mCamera[" + this.jdField_a_of_type_Lkp + "]");
    if (this.jdField_b_of_type_Boolean)
    {
      if (Build.MODEL.equalsIgnoreCase("HWI-AL00"))
      {
        Object localObject = Build.MODEL + "_SP_QAV_CAMERA_OPENED";
        localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences((String)localObject, 4);
        boolean bool = ((SharedPreferences)localObject).getBoolean("KEY_OPENED", false);
        QLog.w("CameraUtils", 1, "AVTest. openCamera. hasOpened = " + bool);
        if (!bool)
        {
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putBoolean("KEY_OPENED", true);
          ((SharedPreferences.Editor)localObject).commit();
          this.jdField_a_of_type_ComTencentAvVideoController.a().a().postDelayed(new CameraUtils.3(this, paramLong), 1000L);
          return;
        }
        b(paramLong);
        return;
      }
      b(paramLong);
      return;
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable.a = paramLong;
    ThreadManager.remove(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$CloseCameraRunnable);
    ThreadManager.post(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable, 8, null, false);
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    c();
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.sendToTarget();
  }
  
  public void a(long paramLong, String paramString)
  {
    if (AudioHelper.e()) {
      QLog.w("CameraUtils", 2, "startNoPreviewRunnable[" + paramString + "], seq[" + paramLong + "], noPreview[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable.a + "]");
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable.a = paramLong;
    this.jdField_a_of_type_ComTencentAvVideoController.a().a().removeCallbacks(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable);
    this.jdField_a_of_type_ComTencentAvVideoController.a().a().postDelayed(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable, 10000L);
    this.c = false;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    c();
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = Long.valueOf(paramLong);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      localMessage.sendToTarget();
      return;
    }
  }
  
  public void a(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  public void a(String paramString)
  {
    if (!this.c)
    {
      if (AudioHelper.e()) {
        QLog.w("CameraUtils", 2, "stopNoPreviewRunnable[" + paramString + "], noPreview[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable.a + "]");
      }
      this.c = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().a().removeCallbacks(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable);
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Boolean) {
      a(paramLong, paramInt1, paramInt2);
    }
    while (this.jdField_a_of_type_Lkl == null) {
      return;
    }
    this.jdField_a_of_type_Lkl.a(paramString, paramLong, paramInt1, paramInt2);
  }
  
  public void a(Observer paramObserver)
  {
    if (paramObserver != null) {
      a().addObserver(paramObserver);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lkp != null)
    {
      if (this.jdField_a_of_type_Lkp.e != paramBoolean) {
        QLog.w("CameraUtils", 1, "setSupportLandscape, value[" + this.jdField_a_of_type_Lkp.e + "->" + paramBoolean + "]");
      }
      this.jdField_a_of_type_Lkp.e = paramBoolean;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Lkp != null) {
      bool = this.jdField_a_of_type_Lkp.a();
    }
    if (QLog.isColorLevel()) {
      QLog.w("CameraUtils", 1, "isFrontCamera[" + bool + "], mCamera[" + this.jdField_a_of_type_Lkp + "]");
    }
    return bool;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_Lkp != null) {}
    for (boolean bool1 = this.jdField_a_of_type_Lkp.b();; bool1 = false)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("isCameraOpening[").append(bool1).append("], mCamera[");
        if (this.jdField_a_of_type_Lkp != null) {
          bool2 = true;
        }
        QLog.w("CameraUtils", 2, bool2 + "], seq[" + paramLong + "]");
      }
      return bool1;
    }
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    String str = "null";
    if (this.jdField_a_of_type_Lkp != null) {
      str = this.jdField_a_of_type_Lkp.c() + "";
    }
    if (QLog.isColorLevel()) {}
    for (Throwable localThrowable = new Throwable();; localThrowable = null)
    {
      QLog.w("CameraUtils", 1, "closeCamera, changeStatus[" + paramBoolean + "], isCameraOpened[" + str + "], openCamera[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable + "], seq[" + paramLong + "]", localThrowable);
      if ((this.jdField_a_of_type_Lkp != null) && (this.jdField_a_of_type_Lkp.c()))
      {
        if (this.jdField_b_of_type_Boolean) {
          a(paramLong, paramBoolean);
        }
        for (;;)
        {
          return true;
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils$CloseCameraRunnable.a = paramLong;
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils$CloseCameraRunnable.a(paramBoolean);
          ThreadManager.remove(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable);
          ThreadManager.post(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$CloseCameraRunnable, 8, null, false);
        }
      }
      return false;
    }
  }
  
  public void b()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("cameracfg", 0).edit();
    int i = this.jdField_a_of_type_Lkp.c(true);
    int j = this.jdField_a_of_type_Lkp.c(false);
    localEditor.putInt("frontCameraRotation", i);
    localEditor.putInt("backCameraRotation", j);
    localEditor.commit();
  }
  
  public void b(long paramLong)
  {
    c();
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.sendToTarget();
  }
  
  public void b(long paramLong, int paramInt)
  {
    if ((this.jdField_a_of_type_Lkp != null) && (this.jdField_a_of_type_Lkp.c()))
    {
      if (this.jdField_b_of_type_Boolean) {
        a(paramLong, paramInt);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Lkp.a(paramLong, paramInt);
  }
  
  public void b(Observer paramObserver)
  {
    a().deleteObserver(paramObserver);
  }
  
  public boolean b(long paramLong)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Lkp != null) {
      bool = this.jdField_a_of_type_Lkp.c();
    }
    QLog.w("CameraUtils", 1, "isCameraOpened, isCameraOpened[" + bool + "], seq[" + paramLong + "]");
    return bool;
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
  }
  
  public void c(long paramLong)
  {
    c();
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.sendToTarget();
  }
  
  void d()
  {
    if (this.jdField_a_of_type_Lkj == null)
    {
      this.jdField_a_of_type_Lkj = new lkj(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Lkj, localIntentFilter);
    }
  }
  
  public void d(long paramLong)
  {
    if (this.jdField_a_of_type_Lkp.c())
    {
      if (this.jdField_b_of_type_Boolean) {
        c(paramLong);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils$SwitchCameraRunnable.a = paramLong;
    ThreadManager.post(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$SwitchCameraRunnable, 8, null, false);
  }
  
  void e()
  {
    if (this.jdField_a_of_type_Lkj != null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Lkj);
      this.jdField_a_of_type_Lkj = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void finalize()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        a("finalize");
      }
      this.jdField_a_of_type_ComTencentAvVideoController = null;
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.camera.CameraUtils
 * JD-Core Version:    0.7.0.1
 */