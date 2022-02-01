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
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;
import liz;
import ljb;
import ljc;
import lje;
import ljf;
import ljg;
import ljk;
import mqn;

public class CameraUtils
  implements liz
{
  static volatile CameraUtils jdField_a_of_type_ComTencentAvCameraCameraUtils;
  int jdField_a_of_type_Int = 0;
  Context jdField_a_of_type_AndroidContentContext = null;
  SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(0);
  Handler jdField_a_of_type_AndroidOsHandler = null;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread = null;
  CameraUtils.CloseCameraRunnable jdField_a_of_type_ComTencentAvCameraCameraUtils$CloseCameraRunnable = new CameraUtils.CloseCameraRunnable(this);
  CameraUtils.NoPreviewRunnable jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable = new CameraUtils.NoPreviewRunnable(this);
  CameraUtils.OpenCameraRunnable jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable = new CameraUtils.OpenCameraRunnable(this);
  CameraUtils.SwitchCameraRunnable jdField_a_of_type_ComTencentAvCameraCameraUtils$SwitchCameraRunnable = new CameraUtils.SwitchCameraRunnable(this);
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap(2);
  ljb jdField_a_of_type_Ljb = null;
  private ljc jdField_a_of_type_Ljc;
  private ljf jdField_a_of_type_Ljf;
  private ljg jdField_a_of_type_Ljg;
  ljk jdField_a_of_type_Ljk = null;
  boolean jdField_a_of_type_Boolean = true;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  
  private CameraUtils(Context paramContext)
  {
    if (Build.MODEL.equals("HUAWEI GRA-TL00")) {
      this.c = true;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Ljk = new ljk(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Ljk.a(this);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Ljk.f();
    if (this.jdField_a_of_type_Int > 0)
    {
      paramContext = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("cameracfg", 0);
      int i = paramContext.getInt("frontCameraRotation", 0);
      int j = paramContext.getInt("backCameraRotation", 0);
      this.jdField_a_of_type_Ljk.a(true, i);
      this.jdField_a_of_type_Ljk.a(false, j);
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("AppStoreWorkThread");
    this.jdField_b_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Ljg = new ljg(this, this.jdField_b_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_JavaUtilMap.put("0", Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilMap.put("1", Integer.valueOf(1));
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandlerThread == null))
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("QAV_Camera_Handler_Thread", 0);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_b_of_type_AndroidOsHandler = new lje(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
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
  
  private ljc a()
  {
    if (this.jdField_a_of_type_Ljc == null) {
      this.jdField_a_of_type_Ljc = new ljc();
    }
    return this.jdField_a_of_type_Ljc;
  }
  
  private void b(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ljk != null) {}
    for (boolean bool = this.jdField_a_of_type_Ljk.a(paramLong, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, paramInt1, paramInt2);; bool = false)
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
    QLog.w("CameraUtils", 1, "closeCamera begin, mCamera[" + this.jdField_a_of_type_Ljk + "], seq[" + paramLong + "]");
    a().a(new Object[] { Integer.valueOf(3), Long.valueOf(paramLong) });
    if (this.jdField_a_of_type_Ljb != null) {
      this.jdField_a_of_type_Ljb.c();
    }
    if (this.jdField_a_of_type_Ljk != null) {
      this.jdField_a_of_type_Ljk.c(paramLong);
    }
    a("CloseCameraRunnable.run");
    if (this.jdField_a_of_type_Ljb != null) {
      this.jdField_a_of_type_Ljb.a(paramLong, paramBoolean);
    }
    a().a(new Object[] { Integer.valueOf(4), Boolean.valueOf(true), Long.valueOf(paramLong) });
    e();
    QLog.w("CameraUtils", 1, "closeCamera end, mCamera[" + this.jdField_a_of_type_Ljk + "], seq[" + paramLong + "]");
  }
  
  private void c(long paramLong, int paramInt)
  {
    if ((AudioHelper.f()) || (this.jdField_a_of_type_Ljk == null)) {
      QLog.w("CameraUtils", 1, "setCameraParaInSubThread begin, mCamera[" + this.jdField_a_of_type_Ljk + "], seq[" + paramLong + "]");
    }
    if (this.jdField_a_of_type_Ljk == null) {
      return;
    }
    this.jdField_a_of_type_Ljk.a(paramLong, paramInt);
  }
  
  private void e(long paramLong)
  {
    if (AudioHelper.f()) {
      QLog.w("CameraUtils", 1, "switchCamera begin, mCamera[" + this.jdField_a_of_type_Ljk + "], seq[" + paramLong + "]");
    }
    mqn.a("switch_camera", "SwitchCameraRunnable", 3, new Object[] { Long.valueOf(paramLong) });
    a().a(new Object[] { Integer.valueOf(5) });
    if (this.jdField_a_of_type_Ljk != null) {}
    for (boolean bool = this.jdField_a_of_type_Ljk.b(paramLong, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);; bool = false)
    {
      a().a(new Object[] { Integer.valueOf(6), Boolean.valueOf(bool) });
      if (AudioHelper.f()) {
        QLog.w("CameraUtils", 1, "switchCamera end, result[" + bool + "], mCamera[" + this.jdField_a_of_type_Ljk + "], seq[" + paramLong + "]");
      }
      return;
    }
  }
  
  private void f(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    QLog.w("CameraUtils", 1, "openCamera begin, mCamera[" + this.jdField_a_of_type_Ljk + "], seq[" + paramLong + "]");
    a().a(new Object[] { Integer.valueOf(1), Boolean.valueOf(this.jdField_a_of_type_Ljk.d()), Long.valueOf(paramLong) });
    if (this.jdField_a_of_type_Ljb != null) {
      this.jdField_a_of_type_Ljb.d();
    }
    boolean bool2 = this.jdField_a_of_type_Ljk.a(paramLong, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    if (bool2) {
      a(paramLong, "OpenCameraRunnable.run");
    }
    boolean bool1;
    if (this.jdField_a_of_type_Ljb != null) {
      if (this.jdField_a_of_type_Ljk.g() != 0) {
        bool1 = true;
      }
    }
    for (int i = this.jdField_a_of_type_Ljb.a(paramLong, bool2, bool1);; i = 0)
    {
      a().a(new Object[] { Integer.valueOf(2), Boolean.valueOf(bool2), Integer.valueOf(i), Long.valueOf(paramLong) });
      if (bool2) {
        d();
      }
      long l2 = System.currentTimeMillis();
      QLog.w("CameraUtils", 1, "openCamera end. result[" + bool2 + "], cost[" + (l2 - l1) + "], seq[" + paramLong + "]");
      return;
      bool1 = false;
      break;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Camera.Parameters a()
  {
    if (this.jdField_a_of_type_Ljk != null) {
      return this.jdField_a_of_type_Ljk.a();
    }
    return null;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Ljk != null) && (this.jdField_a_of_type_Int > 0))
    {
      if ((this.jdField_a_of_type_Int == 1) || (!this.jdField_a_of_type_Ljk.b()))
      {
        i = this.jdField_a_of_type_Ljk.c(false) + 90;
        j = i % 360 / 90;
        this.jdField_a_of_type_Ljk.a(false, i);
      }
    }
    else {
      return;
    }
    int i = this.jdField_a_of_type_Ljk.c(true) + 90;
    int j = i % 360 / 90;
    this.jdField_a_of_type_Ljk.a(true, i);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Ljk != null) {
      this.jdField_a_of_type_Ljk.a(paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    QLog.w("CameraUtils", 1, "openCamera, seq[" + paramLong + "], openCamera[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable + "], closeCamera[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$CloseCameraRunnable + "], mCamera[" + this.jdField_a_of_type_Ljk + "]");
    if (this.jdField_a_of_type_Boolean)
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
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new CameraUtils.2(this, paramLong), 1000L);
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
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(5);
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    c();
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.sendToTarget();
  }
  
  public void a(long paramLong, String paramString)
  {
    if (AudioHelper.f()) {
      QLog.w("CameraUtils", 2, "startNoPreviewRunnable[" + paramString + "], seq[" + paramLong + "], noPreview[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable.a + "]");
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable.a = paramLong;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable, 10000L);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    c();
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = Long.valueOf(paramLong);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      localMessage.sendToTarget();
      return;
    }
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, boolean paramBoolean)
  {
    ljb localljb = this.jdField_a_of_type_Ljb;
    if (localljb != null)
    {
      a("onPreviewData_" + paramLong1);
      if (this.c) {
        a(-1019L, "onPreviewData_" + paramLong1);
      }
      localljb.a(paramLong1, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramLong2, paramBoolean);
    }
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (AudioHelper.f()) {
        QLog.w("CameraUtils", 2, "stopNoPreviewRunnable[" + paramString + "], noPreview[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable.a + "]");
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvCameraCameraUtils$NoPreviewRunnable);
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      a(paramLong, paramInt1, paramInt2);
    }
    while (this.jdField_a_of_type_Ljg == null) {
      return;
    }
    this.jdField_a_of_type_Ljg.a(paramString, paramLong, paramInt1, paramInt2);
  }
  
  public void a(Observer paramObserver)
  {
    if (paramObserver != null) {
      a().addObserver(paramObserver);
    }
  }
  
  public void a(ljb paramljb)
  {
    this.jdField_a_of_type_Ljb = paramljb;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ljk != null)
    {
      if (this.jdField_a_of_type_Ljk.e != paramBoolean) {
        QLog.w("CameraUtils", 1, "setSupportLandscape, value[" + this.jdField_a_of_type_Ljk.e + "->" + paramBoolean + "]");
      }
      this.jdField_a_of_type_Ljk.e = paramBoolean;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Ljk != null) {
      bool = this.jdField_a_of_type_Ljk.b();
    }
    if (QLog.isColorLevel()) {
      QLog.w("CameraUtils", 1, "isFrontCamera[" + bool + "], mCamera[" + this.jdField_a_of_type_Ljk + "]");
    }
    return bool;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_Ljk != null) {}
    for (boolean bool1 = this.jdField_a_of_type_Ljk.c();; bool1 = false)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("isCameraOpening[").append(bool1).append("], mCamera[");
        if (this.jdField_a_of_type_Ljk != null) {
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
    if (this.jdField_a_of_type_Ljk != null) {
      str = this.jdField_a_of_type_Ljk.d() + "";
    }
    if (QLog.isColorLevel()) {}
    for (Throwable localThrowable = new Throwable();; localThrowable = null)
    {
      QLog.w("CameraUtils", 1, "closeCamera, changeStatus[" + paramBoolean + "], isCameraOpened[" + str + "], openCamera[" + this.jdField_a_of_type_ComTencentAvCameraCameraUtils$OpenCameraRunnable + "], seq[" + paramLong + "]", localThrowable);
      if ((this.jdField_a_of_type_Ljk != null) && (this.jdField_a_of_type_Ljk.d()))
      {
        if (this.jdField_a_of_type_Boolean) {
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
    int i = this.jdField_a_of_type_Ljk.c(true);
    int j = this.jdField_a_of_type_Ljk.c(false);
    localEditor.putInt("frontCameraRotation", i);
    localEditor.putInt("backCameraRotation", j);
    localEditor.commit();
  }
  
  public void b(long paramLong)
  {
    c();
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.sendToTarget();
  }
  
  public void b(long paramLong, int paramInt)
  {
    if ((this.jdField_a_of_type_Ljk != null) && (this.jdField_a_of_type_Ljk.d()))
    {
      if (this.jdField_a_of_type_Boolean) {
        a(paramLong, paramInt);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ljk.a(paramLong, paramInt);
  }
  
  public void b(Observer paramObserver)
  {
    a().deleteObserver(paramObserver);
  }
  
  public boolean b(long paramLong)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Ljk != null) {
      bool = this.jdField_a_of_type_Ljk.d();
    }
    QLog.w("CameraUtils", 1, "isCameraOpened, isCameraOpened[" + bool + "], seq[" + paramLong + "]");
    return bool;
  }
  
  void c()
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(5);
  }
  
  public void c(long paramLong)
  {
    c();
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.sendToTarget();
  }
  
  void d()
  {
    if (this.jdField_a_of_type_Ljf == null)
    {
      this.jdField_a_of_type_Ljf = new ljf(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Ljf, localIntentFilter);
    }
  }
  
  public void d(long paramLong)
  {
    if (this.jdField_a_of_type_Ljk.d())
    {
      if (this.jdField_a_of_type_Boolean) {
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
    if (this.jdField_a_of_type_Ljf != null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Ljf);
      this.jdField_a_of_type_Ljf = null;
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
      a("finalize");
      this.jdField_a_of_type_Ljb = null;
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.camera.CameraUtils
 * JD-Core Version:    0.7.0.1
 */