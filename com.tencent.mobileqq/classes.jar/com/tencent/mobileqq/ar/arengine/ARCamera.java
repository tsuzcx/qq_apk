package com.tencent.mobileqq.ar.arengine;

import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.hiar.sdk.camera.CameraParameters;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.ar.model.CameraProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.CameraUtil;
import java.util.ArrayList;
import java.util.List;

public class ARCamera
  implements Camera.AutoFocusCallback
{
  private static final int jdField_a_of_type_Int = ScreenUtil.SCREEN_WIDTH * 3 / 4;
  private static long jdField_a_of_type_Long = -1L;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static final int jdField_b_of_type_Int = ScreenUtil.SCREEN_WIDTH * 3 / 4;
  private static int jdField_c_of_type_Int;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  SensorEventListener jdField_a_of_type_AndroidHardwareSensorEventListener = new ARCamera.2(this);
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager = (SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor");
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private ARCamera.AutoFocusListener jdField_a_of_type_ComTencentMobileqqArArengineARCamera$AutoFocusListener;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m = 0;
  private int n = 0;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_c_of_type_Int = -3;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    paramInt5 = (int)(paramInt5 * paramFloat);
    int i1 = paramInt5 / 2;
    paramInt1 = a(paramInt1 - i1, 0, paramInt3 - paramInt5);
    paramInt2 = a(paramInt2 - i1, 0, paramInt4 - paramInt5);
    RectF localRectF = new RectF(paramInt1, paramInt2, paramInt1 + paramInt5, paramInt2 + paramInt5);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF);
    return new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera != null) && (b()))
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      try
      {
        Camera.Parameters localParameters1 = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (!localParameters1.getSupportedFocusModes().contains("auto")) {
          return;
        }
        Object localObject = a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 1.0F);
        Rect localRect = a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 1.0F);
        QLog.d("AREngine_ARCamera", 1, String.format("focusOnArea focusRect=%s meteringRect=%s", new Object[] { localObject, localRect }));
        localParameters1.setFocusMode("auto");
        if (localParameters1.getMaxNumFocusAreas() > 0)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(new Camera.Area((Rect)localObject, 1000));
          localParameters1.setFocusAreas(localArrayList);
        }
        if (localParameters1.getMaxNumMeteringAreas() > 0)
        {
          localObject = new ArrayList();
          ((List)localObject).add(new Camera.Area(localRect, 1000));
          localParameters1.setMeteringAreas((List)localObject);
        }
        this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
        this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters1);
        this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this);
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException1)
      {
        QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", localException1);
        try
        {
          this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
          Camera.Parameters localParameters2 = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
          CameraParameters.a(localParameters2);
          this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters2);
          return;
        }
        catch (Exception localException2)
        {
          QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", localException2);
        }
      }
    }
  }
  
  public static int b(int paramInt)
  {
    int i2 = Camera.getNumberOfCameras();
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2) {
        try
        {
          Camera.getCameraInfo(i1, localCameraInfo);
          int i3 = localCameraInfo.facing;
          if (paramInt == i3) {
            return i1;
          }
          i1 += 1;
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkCameraFacing error:");
          localStringBuilder.append(localThrowable.getMessage());
          QLog.i("AREngine_ARCamera", 1, localStringBuilder.toString());
        }
      }
    }
    return 0;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidHardwareCamera != null)
        {
          bool = true;
          this.jdField_b_of_type_Boolean = true;
          if (paramInt2 > paramInt1)
          {
            this.jdField_c_of_type_Boolean = bool;
            this.k = paramInt1;
            this.l = paramInt2;
            g();
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      boolean bool = false;
    }
  }
  
  private boolean b()
  {
    return ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.a) ^ true;
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("revertZoom mZooming=%s", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    }
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.jdField_b_of_type_Boolean = false;
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        }
        Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (localParameters.isZoomSupported())
        {
          int i1 = localParameters.getZoom();
          if (i1 != this.i)
          {
            b(i1, this.i);
            ReportController.b(null, "dc00898", "", "", "0X80085B0", "0X80085B0", 0, 0, "", "", "", "");
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void g()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        int i1 = this.k;
        int i2 = this.l;
        if (i1 != i2)
        {
          try
          {
            if (this.jdField_c_of_type_Boolean)
            {
              this.k += 5;
              this.k = Math.min(this.k, this.l);
            }
            else
            {
              this.k -= 5;
              this.k = Math.max(this.k, this.l);
            }
            this.k = Math.min(this.k, this.j);
            this.k = Math.max(this.k, this.i);
            Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
            localParameters.setZoom(this.k);
            this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
            if (this.jdField_a_of_type_AndroidOsHandler == null) {
              break label189;
            }
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(102, 20L);
            return;
          }
          catch (Exception localException1)
          {
            if (!QLog.isColorLevel()) {
              break label189;
            }
          }
          QLog.d("AREngine_ARCamera", 2, "updateZoom fail!", localException1);
        }
        else
        {
          this.jdField_b_of_type_Boolean = false;
        }
      }
      label189:
      return;
    }
    catch (Exception localException2) {}
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      long l1 = jdField_a_of_type_Long;
      int i2 = 0;
      int i1 = i2;
      if (l1 != -1L) {
        if (Thread.currentThread().getId() == jdField_a_of_type_Long)
        {
          i1 = i2;
        }
        else
        {
          i1 = i2;
          if (jdField_c_of_type_Int == 0) {
            i1 = 1;
          }
        }
      }
      if (i1 != 0) {
        return a(paramInt, 150L);
      }
      return a(paramInt, 0L);
    }
  }
  
  public int a(int paramInt, long paramLong)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("openCamera mCamera=");
    ((StringBuilder)???).append(this.jdField_a_of_type_AndroidHardwareCamera);
    QLog.i("AREngine_ARCamera", 1, ((StringBuilder)???).toString());
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        jdField_c_of_type_Int = 0;
        jdField_a_of_type_Long = Thread.currentThread().getId();
        return 0;
      }
    }
    for (;;)
    {
      try
      {
        if ((Build.MODEL.equalsIgnoreCase("MI 5s Plus")) || (Build.MODEL.equalsIgnoreCase("vivo X7")) || (paramLong != 0L)) {
          if (paramLong != 0L)
          {
            Thread.currentThread();
            Thread.sleep(paramLong);
          }
          else
          {
            Thread.currentThread();
            Thread.sleep(800L);
          }
        }
        if (Build.VERSION.SDK_INT >= 9)
        {
          if (Camera.getNumberOfCameras() > 0)
          {
            i2 = b(paramInt);
            try
            {
              this.jdField_a_of_type_AndroidHardwareCamera = CameraUtil.a(i2, 1);
            }
            catch (Exception localException1)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("openCamera index:");
              localStringBuilder.append(i2);
              localStringBuilder.append(" fail.");
              QLog.i("AREngine_ARCamera", 1, localStringBuilder.toString(), localException1);
            }
            i1 = i2;
            if (this.jdField_a_of_type_AndroidHardwareCamera == null)
            {
              i1 = i2;
              if (i2 != 1)
              {
                this.jdField_a_of_type_AndroidHardwareCamera = CameraUtil.a(1, 1);
                i1 = 1;
              }
            }
            if (this.jdField_a_of_type_AndroidHardwareCamera != null)
            {
              ??? = new Camera.CameraInfo();
              Camera.getCameraInfo(i1, (Camera.CameraInfo)???);
              this.m = ((Camera.CameraInfo)???).orientation;
            }
          }
        }
        else {
          this.jdField_a_of_type_AndroidHardwareCamera = CameraUtil.a(-1, 1);
        }
        if (this.jdField_a_of_type_AndroidHardwareCamera == null)
        {
          QLog.i("AREngine_ARCamera", 1, "openCamera fail. mCamera is null.");
          synchronized (jdField_a_of_type_JavaLangObject)
          {
            jdField_c_of_type_Int = -3;
            jdField_a_of_type_Long = Thread.currentThread().getId();
            return -3;
          }
        }
        CameraParameters.a(this.jdField_a_of_type_AndroidHardwareCamera, 1280, 720, ScanEntranceDPC.a().jdField_a_of_type_Int);
        i2 = 90;
        int i1 = i2;
        if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.g))
        {
          i1 = i2;
          if (paramInt == 0) {
            i1 = 270;
          }
        }
        i2 = i1;
        if (paramInt == 1)
        {
          if (!((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.e))
          {
            i2 = i1;
            if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(CameraCompatibleConstants.f)) {}
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(i2);
          ??? = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
          this.f = ((Camera.Parameters)???).getPreviewFormat();
          PixelFormat localPixelFormat = new PixelFormat();
          PixelFormat.getPixelFormatInfo(this.f, localPixelFormat);
          Camera.Size localSize = ((Camera.Parameters)???).getPreviewSize();
          this.jdField_d_of_type_Int = localSize.width;
          this.e = localSize.height;
          this.jdField_a_of_type_Boolean = false;
          this.i = ((Camera.Parameters)???).getZoom();
          this.j = (((Camera.Parameters)???).getMaxZoom() / 3 * 2);
          QLog.d("AREngine_ARCamera", 1, String.format("openCamera mInitZoom=%s mMaxZoom=%s supportMaxZoom=%s", new Object[] { Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(((Camera.Parameters)???).getMaxZoom()) }));
          i1 = this.jdField_d_of_type_Int * this.e * localPixelFormat.bitsPerPixel / 8;
          paramInt = 0;
          if (paramInt < 3)
          {
            this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(new byte[i1]);
            paramInt += 1;
            continue;
          }
          synchronized (jdField_a_of_type_JavaLangObject)
          {
            jdField_c_of_type_Int = 0;
            jdField_a_of_type_Long = Thread.currentThread().getId();
            return 0;
          }
          continue;
        }
      }
      catch (Exception localException2)
      {
        QLog.i("AREngine_ARCamera", 1, "openCamera fail.", localException2);
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          jdField_c_of_type_Int = -3;
          jdField_a_of_type_Long = Thread.currentThread().getId();
          return -3;
        }
        throw localObject7;
      }
      int i2 = 270;
    }
  }
  
  public void a()
  {
    QLog.i("AREngine_ARCamera", 1, String.format("stopPreview mCamera=%s", new Object[] { this.jdField_a_of_type_AndroidHardwareCamera }));
    c();
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localObject != null) {
      try
      {
        ((Camera)localObject).setPreviewCallbackWithBuffer(null);
        this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera$AutoFocusListener = null;
        if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
        {
          this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.i("AREngine_ARCamera", 1, "stopCamera fail.", localException);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i("AREngine_ARCamera", 1, String.format("autoFocus surfaceWidth=%s surfaceHeight=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (this.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      if ((this.g != paramInt1) || (this.h != paramInt2))
      {
        localObject = new Matrix();
        ((Matrix)localObject).setScale(1.0F, 1.0F);
        ((Matrix)localObject).postRotate(90.0F);
        float f1 = paramInt1;
        float f2 = f1 / 2000.0F;
        float f3 = paramInt2;
        ((Matrix)localObject).postScale(f2, f3 / 2000.0F);
        ((Matrix)localObject).postTranslate(f1 / 2.0F, f3 / 2.0F);
        ((Matrix)localObject).invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
        this.g = paramInt1;
        this.h = paramInt2;
      }
      Object localObject = this.jdField_a_of_type_AndroidOsHandler;
      if (localObject != null)
      {
        ((Handler)localObject).removeMessages(100);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 500L);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.i("AREngine_ARCamera", 1, String.format("manualFocus touchX=%s touchY=%s surfaceWidth=%s surfaceHeight=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      CameraProxy.a().a(new ARCamera.1(this, paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: ldc 177
    //   2: iconst_1
    //   3: ldc_w 564
    //   6: iconst_1
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_0
    //   13: getfield 150	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   16: aastore
    //   17: invokestatic 185	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokestatic 279	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: getfield 150	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +124 -> 153
    //   32: aload_1
    //   33: invokevirtual 567	android/hardware/Camera:release	()V
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 150	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   41: getstatic 46	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   44: astore_1
    //   45: aload_1
    //   46: monitorenter
    //   47: bipush 253
    //   49: putstatic 48	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_c_of_type_Int	I
    //   52: invokestatic 377	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   55: invokevirtual 381	java/lang/Thread:getId	()J
    //   58: putstatic 52	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_Long	J
    //   61: aload_1
    //   62: monitorexit
    //   63: iconst_1
    //   64: ireturn
    //   65: astore_2
    //   66: aload_1
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    //   70: astore_2
    //   71: goto +48 -> 119
    //   74: astore_1
    //   75: ldc 177
    //   77: iconst_1
    //   78: ldc_w 569
    //   81: aload_1
    //   82: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   85: aload_0
    //   86: aconst_null
    //   87: putfield 150	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   90: getstatic 46	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   93: astore_1
    //   94: aload_1
    //   95: monitorenter
    //   96: bipush 253
    //   98: putstatic 48	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_c_of_type_Int	I
    //   101: invokestatic 377	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   104: invokevirtual 381	java/lang/Thread:getId	()J
    //   107: putstatic 52	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_Long	J
    //   110: aload_1
    //   111: monitorexit
    //   112: iconst_1
    //   113: ireturn
    //   114: astore_2
    //   115: aload_1
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    //   119: aload_0
    //   120: aconst_null
    //   121: putfield 150	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   124: getstatic 46	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   127: astore_1
    //   128: aload_1
    //   129: monitorenter
    //   130: bipush 253
    //   132: putstatic 48	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_c_of_type_Int	I
    //   135: invokestatic 377	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   138: invokevirtual 381	java/lang/Thread:getId	()J
    //   141: putstatic 52	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_Long	J
    //   144: aload_1
    //   145: monitorexit
    //   146: aload_2
    //   147: athrow
    //   148: astore_2
    //   149: aload_1
    //   150: monitorexit
    //   151: aload_2
    //   152: athrow
    //   153: iconst_1
    //   154: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	ARCamera
    //   27	40	1	localObject1	Object
    //   74	8	1	localException	Exception
    //   93	57	1	localObject2	Object
    //   65	4	2	localObject3	Object
    //   70	1	2	localObject4	Object
    //   114	33	2	localObject5	Object
    //   148	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   47	63	65	finally
    //   66	68	65	finally
    //   32	36	70	finally
    //   75	85	70	finally
    //   32	36	74	java/lang/Exception
    //   96	112	114	finally
    //   115	117	114	finally
    //   130	146	148	finally
    //   149	151	148	finally
  }
  
  public boolean a(float paramFloat, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("directZoom scale=%.2f autoRevert=%s mZooming=%s", new Object[] { Float.valueOf(paramFloat), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      if (localObject != null)
      {
        ((Handler)localObject).removeMessages(102);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidHardwareCamera;
    if ((localObject != null) && (!this.jdField_b_of_type_Boolean)) {}
    for (;;)
    {
      int i11;
      int i2;
      int i4;
      try
      {
        localObject = ((Camera)localObject).getParameters();
        List localList = ((Camera.Parameters)localObject).getZoomRatios();
        if (localList != null)
        {
          if (localList.size() == 0) {
            return false;
          }
          i11 = ((Camera.Parameters)localObject).getZoom();
          if (i11 < 0) {
            return false;
          }
          if (localList.size() <= i11) {
            break label515;
          }
          i5 = ((Integer)localList.get(i11)).intValue();
          break label518;
          if (i1 < localList.size())
          {
            i2 = i8;
            i3 = i9;
            i4 = i10;
            i7 = i6;
            if (Math.abs(((Integer)localList.get(i1)).intValue() - i12) >= i8) {
              break label562;
            }
            i2 = i8;
            i3 = i9;
            i4 = i10;
            i7 = i6;
            if (((Integer)localList.get(i1)).intValue() >= i12) {
              break label562;
            }
            i2 = Math.abs(((Integer)localList.get(i1)).intValue() - i12);
            i4 = ((Integer)localList.get(i1)).intValue();
            i3 = i1 + 1;
            if (i3 >= localList.size()) {
              break label555;
            }
            i7 = ((Integer)localList.get(i3)).intValue();
            i3 = i1;
            break label562;
          }
          if (QLog.isColorLevel()) {
            QLog.i("AREngine_ARCamera", 2, String.format("directZoom [curZoomRatio,dstZoomRatio,index,cur,finalRatio,nextRatio]=[%d,%d,%d,%d,%d,%d]", new Object[] { Integer.valueOf(i5), Integer.valueOf(i12), Integer.valueOf(i9), Integer.valueOf(i11), Integer.valueOf(i10), Integer.valueOf(i6) }));
          }
          if ((((Camera.Parameters)localObject).isZoomSupported()) && (i9 >= 0) && (i9 != i11))
          {
            i1 = Math.max(Math.min(i9, this.j), this.i);
            if (i1 != i11)
            {
              ((Camera.Parameters)localObject).setZoom(i1);
              this.jdField_a_of_type_AndroidHardwareCamera.setParameters((Camera.Parameters)localObject);
              return true;
            }
            if (this.jdField_a_of_type_AndroidOsHandler != null)
            {
              this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
              if (paramBoolean) {
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 5000L);
              }
            }
          }
        }
        return false;
      }
      catch (Exception localException)
      {
        return false;
      }
      label515:
      int i5 = -1;
      label518:
      int i12 = (int)(i5 * paramFloat);
      if (i12 <= i5) {
        return false;
      }
      int i8 = 2147483647;
      int i1 = i11;
      int i9 = -1;
      int i10 = -1;
      int i6 = 0;
      continue;
      label555:
      int i3 = i1;
      int i7 = i6;
      label562:
      i1 += 1;
      i8 = i2;
      i9 = i3;
      i10 = i4;
      i6 = i7;
    }
  }
  
  public boolean a(Camera.PreviewCallback paramPreviewCallback, SurfaceTexture paramSurfaceTexture, ARCamera.AutoFocusListener paramAutoFocusListener)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    QLog.i("AREngine_ARCamera", 1, String.format("startPreview callback=%s surfaceTexture=%s mCamera=%s", new Object[] { paramPreviewCallback, paramSurfaceTexture, this.jdField_a_of_type_AndroidHardwareCamera }));
    Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localCamera != null) {
      try
      {
        localCamera.setPreviewCallbackWithBuffer(paramPreviewCallback);
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
        this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera$AutoFocusListener = paramAutoFocusListener;
        try
        {
          if (this.jdField_a_of_type_AndroidHardwareSensorManager != null) {
            this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1), 3);
          }
          return true;
        }
        catch (Exception paramPreviewCallback)
        {
          bool1 = true;
        }
        QLog.i("AREngine_ARCamera", 1, "startPreview fail.", paramPreviewCallback);
      }
      catch (Exception paramPreviewCallback)
      {
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public boolean a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localObject != null) {
      try
      {
        localObject = ((Camera)localObject).getParameters();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCamera", 2, String.format("switchFlashLight on=%s current=%s", new Object[] { Boolean.valueOf(paramBoolean), ((Camera.Parameters)localObject).getFlashMode() }));
        }
        if (paramBoolean) {
          ((Camera.Parameters)localObject).setFlashMode("torch");
        } else {
          ((Camera.Parameters)localObject).setFlashMode("off");
        }
        this.jdField_a_of_type_AndroidHardwareCamera.setParameters((Camera.Parameters)localObject);
        return true;
      }
      catch (Exception localException)
      {
        QLog.e("AREngine_ARCamera", 1, "switchFlashLight fail.", localException);
      }
    }
    return false;
  }
  
  public int b()
  {
    return this.e;
  }
  
  public void b()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(100);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 100L);
    }
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void c()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeMessages(100);
    }
  }
  
  public int d()
  {
    return (this.m - this.n + 360) % 360;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("autoZoom mZooming=%s", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    }
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      try
      {
        this.jdField_b_of_type_Boolean = false;
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        }
        Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (localParameters.isZoomSupported())
        {
          int i1 = localParameters.getZoom();
          if (i1 == this.i) {
            b(i1, this.j);
          } else {
            b(i1, this.i);
          }
          ScanEntranceReport.a().b();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("AREngine_ARCamera", 1, "autoZoom fail!", localException);
      }
    }
  }
  
  public int e()
  {
    return a(0, 0L);
  }
  
  public void e()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(101);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 20L);
    }
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    QLog.d("AREngine_ARCamera", 1, String.format("onAutoFocus success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_Boolean)
    {
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
        paramCamera = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        CameraParameters.a(paramCamera);
        this.jdField_a_of_type_AndroidHardwareCamera.setParameters(paramCamera);
      }
      catch (Exception paramCamera)
      {
        QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", paramCamera);
      }
      paramCamera = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera$AutoFocusListener;
      if (paramCamera != null) {
        paramCamera.a(paramBoolean);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera
 * JD-Core Version:    0.7.0.1
 */