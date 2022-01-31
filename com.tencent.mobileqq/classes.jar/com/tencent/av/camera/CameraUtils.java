package com.tencent.av.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;
import jgt;
import jgu;
import jgv;
import jgw;
import jgx;
import jgy;
import jgz;
import jha;

public class CameraUtils
{
  static volatile CameraUtils jdField_a_of_type_ComTencentAvCameraCameraUtils;
  int jdField_a_of_type_Int = 0;
  Context jdField_a_of_type_AndroidContentContext = null;
  public SurfaceTexture a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public VideoController a;
  AndroidCamera.CameraPreviewCallback jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback = new jgt(this);
  public VcCamera a;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap(2);
  private jgu jdField_a_of_type_Jgu;
  private jgv jdField_a_of_type_Jgv;
  jgw jdField_a_of_type_Jgw = new jgw(this);
  jgx jdField_a_of_type_Jgx = new jgx(this);
  jgy jdField_a_of_type_Jgy = new jgy(this);
  jgz jdField_a_of_type_Jgz = new jgz(this);
  private jha jdField_a_of_type_Jha;
  public boolean a;
  boolean b = false;
  
  private CameraUtils(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAvCameraVcCamera = null;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(0);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    if (Build.MODEL.equals("HUAWEI GRA-TL00")) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_ComTencentAvCameraVcCamera = new VcCamera(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(this.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAvCameraVcCamera.f();
    if (this.jdField_a_of_type_Int > 0)
    {
      paramContext = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("cameracfg", 0);
      int i = paramContext.getInt("frontCameraRotation", 0);
      int j = paramContext.getInt("backCameraRotation", 0);
      this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(true, i);
      this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(false, j);
    }
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("AppStoreWorkThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Jha = new jha(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_JavaUtilMap.put("0", Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilMap.put("1", Integer.valueOf(1));
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
  
  private jgv a()
  {
    if (this.jdField_a_of_type_Jgv == null) {
      this.jdField_a_of_type_Jgv = new jgv(this);
    }
    return this.jdField_a_of_type_Jgv;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, paramInt1, paramInt2);; bool = false)
    {
      a().a(new Object[] { Integer.valueOf(8), Boolean.valueOf(bool) });
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Camera.Parameters a()
  {
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
      return this.jdField_a_of_type_ComTencentAvCameraVcCamera.a();
    }
    return null;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) && (this.jdField_a_of_type_Int > 0))
    {
      if ((this.jdField_a_of_type_Int == 1) || (!this.jdField_a_of_type_ComTencentAvCameraVcCamera.d()))
      {
        i = this.jdField_a_of_type_ComTencentAvCameraVcCamera.c(false) + 90;
        j = i % 360 / 90;
        this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(false, i);
      }
    }
    else {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentAvCameraVcCamera.c(true) + 90;
    int j = i % 360 / 90;
    this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(true, i);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
      this.jdField_a_of_type_ComTencentAvCameraVcCamera.b(paramInt);
    }
  }
  
  public void a(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("CameraUtils", 2, "startNoPreviewRunnable[" + paramString + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a().removeCallbacks(this.jdField_a_of_type_Jgx);
    this.jdField_a_of_type_ComTencentAvVideoController.a().a().postDelayed(this.jdField_a_of_type_Jgx, 10000L);
    this.b = false;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Jha != null) {
      this.jdField_a_of_type_Jha.a("reopenCamera_" + paramString, paramInt1, paramInt2);
    }
  }
  
  public void a(Observer paramObserver)
  {
    if (paramObserver != null) {
      a().addObserver(paramObserver);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e("CameraUtils", 2, "closeCamera isCameraOpened : " + this.jdField_a_of_type_ComTencentAvCameraVcCamera.f());
    }
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera.f())
    {
      this.jdField_a_of_type_Jgw.a(paramBoolean);
      ThreadManager.post(this.jdField_a_of_type_Jgw, 8, null, false);
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "isFrontCamera");
    }
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
      return this.jdField_a_of_type_ComTencentAvCameraVcCamera.d();
    }
    return false;
  }
  
  @TargetApi(14)
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvCameraVcCamera.f())
      {
        this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(paramInt);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("cameracfg", 0).edit();
    int i = this.jdField_a_of_type_ComTencentAvCameraVcCamera.c(true);
    int j = this.jdField_a_of_type_ComTencentAvCameraVcCamera.c(false);
    localEditor.putInt("frontCameraRotation", i);
    localEditor.putInt("backCameraRotation", j);
    localEditor.commit();
  }
  
  public void b(String paramString)
  {
    if (!this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CameraUtils", 2, "stopNoPreviewRunnable[" + paramString + "]");
      }
      this.b = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().a().removeCallbacks(this.jdField_a_of_type_Jgx);
    }
  }
  
  public void b(Observer paramObserver)
  {
    a().deleteObserver(paramObserver);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
      this.jdField_a_of_type_ComTencentAvCameraVcCamera.e = paramBoolean;
    }
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {}
    for (boolean bool1 = this.jdField_a_of_type_ComTencentAvCameraVcCamera.e();; bool1 = false)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("isCameraOpening[").append(bool1).append("], mCamera[");
        if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
          bool2 = true;
        }
        QLog.w("CameraUtils", 1, bool2 + "]");
      }
      return bool1;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("CameraUtils", 2, "openCamera");
    }
    ThreadManager.post(this.jdField_a_of_type_Jgy, 8, null, false);
  }
  
  public boolean c()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
      bool = this.jdField_a_of_type_ComTencentAvCameraVcCamera.f();
    }
    if (QLog.isColorLevel()) {
      QLog.w("CameraUtils", 2, "isCameraOpened[" + bool + "]");
    }
    return bool;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera.f()) {
      ThreadManager.post(this.jdField_a_of_type_Jgz, 8, null, false);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Jgu == null)
    {
      this.jdField_a_of_type_Jgu = new jgu(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_Jgu, localIntentFilter);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Jgu != null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Jgu);
      this.jdField_a_of_type_Jgu = null;
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
        b("finalize");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.camera.CameraUtils
 * JD-Core Version:    0.7.0.1
 */