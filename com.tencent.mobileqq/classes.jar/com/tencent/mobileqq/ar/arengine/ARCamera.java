package com.tencent.mobileqq.ar.arengine;

import aaey;
import aaez;
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
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.hiar.sdk.camera.CameraParameters;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.CameraUtil;
import java.util.ArrayList;
import java.util.List;

public class ARCamera
  implements Camera.AutoFocusCallback
{
  private static final int jdField_a_of_type_Int = ScreenUtil.jdField_a_of_type_Int * 3 / 4;
  private static long jdField_a_of_type_Long = -1L;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static final int jdField_b_of_type_Int = ScreenUtil.jdField_a_of_type_Int * 3 / 4;
  private static int jdField_c_of_type_Int;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  private Handler jdField_a_of_type_AndroidOsHandler = new aaez(this, Looper.myLooper());
  private ARCamera.AutoFocusListener jdField_a_of_type_ComTencentMobileqqArArengineARCamera$AutoFocusListener;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
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
    paramInt1 = a(paramInt1 - paramInt5 / 2, 0, paramInt3 - paramInt5);
    paramInt2 = a(paramInt2 - paramInt5 / 2, 0, paramInt4 - paramInt5);
    RectF localRectF = new RectF(paramInt1, paramInt2, paramInt1 + paramInt5, paramInt5 + paramInt2);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF);
    return new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (!b()) || (this.jdField_a_of_type_Boolean)) {}
    for (;;)
    {
      return;
      try
      {
        Camera.Parameters localParameters1 = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (localParameters1.getSupportedFocusModes().contains("auto"))
        {
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
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    int n = Camera.getNumberOfCameras();
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (m < n)
      {
        Camera.getCameraInfo(m, localCameraInfo);
        if (paramInt == localCameraInfo.facing) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      m += 1;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.jdField_b_of_type_Boolean = true;
        if (paramInt2 <= paramInt1) {
          break label39;
        }
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = bool;
        this.k = paramInt1;
        this.l = paramInt2;
        e();
        return;
        label39:
        bool = false;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean b()
  {
    return !CameraCompatibleList.d(CameraCompatibleList.a);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("revertZoom mZooming=%s", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    }
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (localParameters.isZoomSupported())
        {
          int m = localParameters.getZoom();
          if (m != this.i)
          {
            b(m, this.i);
            ReportController.b(null, "dc00898", "", "", "0X80085B0", "0X80085B0", 0, 0, "", "", "", "");
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        int m = this.k;
        int n = this.l;
        if (m != n) {
          try
          {
            if (this.jdField_c_of_type_Boolean) {}
            for (this.k += 5;; this.k -= 5)
            {
              this.k = Math.min(this.k, this.j);
              this.k = Math.max(this.k, this.i);
              Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
              localParameters.setZoom(this.k);
              this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
              if (this.jdField_a_of_type_AndroidOsHandler == null) {
                break;
              }
              this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(102, 20L);
              return;
            }
            QLog.d("AREngine_ARCamera", 2, "updateZoom fail!", localException1);
          }
          catch (Exception localException1)
          {
            if (!QLog.isColorLevel()) {
              break label159;
            }
          }
        } else {
          this.jdField_b_of_type_Boolean = false;
        }
      }
      label159:
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
    int n = 0;
    Object localObject1 = jdField_a_of_type_JavaLangObject;
    int m = n;
    try
    {
      if (jdField_a_of_type_Long != -1L)
      {
        if (Thread.currentThread().getId() != jdField_a_of_type_Long) {
          break label53;
        }
        m = n;
      }
      for (;;)
      {
        if (m == 0) {
          break;
        }
        return a(paramInt, 150L);
        label53:
        m = n;
        if (jdField_c_of_type_Int == 0) {
          m = 1;
        }
      }
      return a(paramInt, 0L);
    }
    finally {}
  }
  
  public int a(int paramInt, long paramLong)
  {
    QLog.i("AREngine_ARCamera", 1, "openCamera mCamera=" + this.jdField_a_of_type_AndroidHardwareCamera);
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        jdField_c_of_type_Int = 0;
        jdField_a_of_type_Long = Thread.currentThread().getId();
        return 0;
      }
    }
    try
    {
      if ((Build.MODEL.equalsIgnoreCase("MI 5s Plus")) || (Build.MODEL.equalsIgnoreCase("vivo X7")) || (paramLong != 0L))
      {
        if (paramLong == 0L) {
          break label189;
        }
        Thread.currentThread();
        Thread.sleep(paramLong);
      }
    }
    catch (Exception localException)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        for (;;)
        {
          jdField_c_of_type_Int = -3;
          jdField_a_of_type_Long = Thread.currentThread().getId();
          return -3;
          label189:
          Thread.currentThread();
          Thread.sleep(800L);
        }
        localException = localException;
        QLog.i("AREngine_ARCamera", 1, "openCamera fail.", localException);
      }
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      if ((Camera.getNumberOfCameras() > 0) && (a(paramInt))) {
        this.jdField_a_of_type_AndroidHardwareCamera = CameraUtil.a(paramInt, 1);
      }
      if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
        break label263;
      }
      QLog.i("AREngine_ARCamera", 1, "openCamera fail. mCamera is null.");
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        jdField_c_of_type_Int = -3;
        jdField_a_of_type_Long = Thread.currentThread().getId();
        return -3;
        this.jdField_a_of_type_AndroidHardwareCamera = CameraUtil.a(-1, 1);
        break;
        localObject4 = finally;
        throw localObject4;
        label263:
        CameraParameters.a(this.jdField_a_of_type_AndroidHardwareCamera, 1280, 720, ScanEntranceDPC.a().jdField_a_of_type_Int);
        n = 90;
        int m = n;
        if (CameraCompatibleList.d(CameraCompatibleList.g))
        {
          m = n;
          if (paramInt == 0) {
            m = 270;
          }
        }
        n = m;
        if (paramInt == 1)
        {
          if (CameraCompatibleList.d(CameraCompatibleList.e)) {
            break label577;
          }
          n = m;
          if (CameraCompatibleList.b(CameraCompatibleList.f)) {
            break label577;
          }
        }
        this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(n);
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
        m = this.jdField_d_of_type_Int * this.e * localPixelFormat.bitsPerPixel / 8;
        paramInt = 0;
        if (paramInt < 3)
        {
          this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(new byte[m]);
          paramInt += 1;
        }
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        jdField_c_of_type_Int = 0;
        jdField_a_of_type_Long = Thread.currentThread().getId();
        return 0;
      }
      label577:
      int n = 270;
    }
  }
  
  public void a()
  {
    QLog.i("AREngine_ARCamera", 1, String.format("stopPreview mCamera=%s", new Object[] { this.jdField_a_of_type_AndroidHardwareCamera }));
    b();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {}
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(null);
      this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera$AutoFocusListener = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.i("AREngine_ARCamera", 1, "stopCamera fail.", localException);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i("AREngine_ARCamera", 1, String.format("autoFocus surfaceWidth=%s surfaceHeight=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (this.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      if ((this.g != paramInt1) || (this.h != paramInt2))
      {
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(1.0F, 1.0F);
        localMatrix.postRotate(90.0F);
        localMatrix.postScale(paramInt1 / 2000.0F, paramInt2 / 2000.0F);
        localMatrix.postTranslate(paramInt1 / 2.0F, paramInt2 / 2.0F);
        localMatrix.invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
        this.g = paramInt1;
        this.h = paramInt2;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 500L);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.i("AREngine_ARCamera", 1, String.format("manualFocus touchX=%s touchY=%s surfaceWidth=%s surfaceHeight=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      AREngine.c(new aaey(this, paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("stepZoom delta=%s autoRevert=%s mZooming=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    }
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {}
    try
    {
      Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      if (localParameters.isZoomSupported())
      {
        int m = localParameters.getZoom();
        paramInt = Math.max(Math.min(m + paramInt, this.j), this.i);
        if (paramInt != m)
        {
          b(m, paramInt);
          ReportController.b(null, "dc00898", "", "", "0X80085AF", "0X80085AF", 0, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
          if (paramBoolean) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 5000L);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: ldc 139
    //   2: iconst_1
    //   3: ldc_w 504
    //   6: iconst_1
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_0
    //   13: getfield 110	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   16: aastore
    //   17: invokestatic 147	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokestatic 341	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: getfield 110	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   27: ifnull +124 -> 151
    //   30: aload_0
    //   31: getfield 110	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   34: invokevirtual 507	android/hardware/Camera:release	()V
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 110	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   42: getstatic 40	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   45: astore_1
    //   46: aload_1
    //   47: monitorenter
    //   48: bipush 253
    //   50: putstatic 42	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_c_of_type_Int	I
    //   53: invokestatic 314	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   56: invokevirtual 318	java/lang/Thread:getId	()J
    //   59: putstatic 46	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_Long	J
    //   62: aload_1
    //   63: monitorexit
    //   64: iconst_1
    //   65: ireturn
    //   66: astore_2
    //   67: aload_1
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    //   71: astore_1
    //   72: ldc 139
    //   74: iconst_1
    //   75: ldc_w 509
    //   78: aload_1
    //   79: invokestatic 197	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 110	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   87: getstatic 40	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   90: astore_1
    //   91: aload_1
    //   92: monitorenter
    //   93: bipush 253
    //   95: putstatic 42	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_c_of_type_Int	I
    //   98: invokestatic 314	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   101: invokevirtual 318	java/lang/Thread:getId	()J
    //   104: putstatic 46	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_Long	J
    //   107: aload_1
    //   108: monitorexit
    //   109: iconst_1
    //   110: ireturn
    //   111: astore_2
    //   112: aload_1
    //   113: monitorexit
    //   114: aload_2
    //   115: athrow
    //   116: astore_2
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 110	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   122: getstatic 40	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   125: astore_1
    //   126: aload_1
    //   127: monitorenter
    //   128: bipush 253
    //   130: putstatic 42	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_c_of_type_Int	I
    //   133: invokestatic 314	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   136: invokevirtual 318	java/lang/Thread:getId	()J
    //   139: putstatic 46	com/tencent/mobileqq/ar/arengine/ARCamera:jdField_a_of_type_Long	J
    //   142: aload_1
    //   143: monitorexit
    //   144: aload_2
    //   145: athrow
    //   146: astore_2
    //   147: aload_1
    //   148: monitorexit
    //   149: aload_2
    //   150: athrow
    //   151: iconst_1
    //   152: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	ARCamera
    //   45	23	1	localObject1	Object
    //   71	8	1	localException	Exception
    //   90	58	1	localObject2	Object
    //   66	4	2	localObject3	Object
    //   111	4	2	localObject4	Object
    //   116	29	2	localObject5	Object
    //   146	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   48	64	66	finally
    //   67	69	66	finally
    //   30	37	71	java/lang/Exception
    //   93	109	111	finally
    //   112	114	111	finally
    //   30	37	116	finally
    //   72	82	116	finally
    //   128	144	146	finally
    //   147	149	146	finally
  }
  
  public boolean a(Camera.PreviewCallback paramPreviewCallback, SurfaceTexture paramSurfaceTexture, ARCamera.AutoFocusListener paramAutoFocusListener)
  {
    QLog.i("AREngine_ARCamera", 1, String.format("startPreview callback=%s surfaceTexture=%s mCamera=%s", new Object[] { paramPreviewCallback, paramSurfaceTexture, this.jdField_a_of_type_AndroidHardwareCamera }));
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(paramPreviewCallback);
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
        this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera$AutoFocusListener = paramAutoFocusListener;
        return true;
      }
      catch (Exception paramPreviewCallback)
      {
        QLog.i("AREngine_ARCamera", 1, "startPreview fail.", paramPreviewCallback);
      }
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      try
      {
        Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCamera", 2, String.format("switchFlashLight on=%s current=%s", new Object[] { Boolean.valueOf(paramBoolean), localParameters.getFlashMode() }));
        }
        if (paramBoolean) {
          localParameters.setFlashMode("torch");
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
          return true;
          localParameters.setFlashMode("off");
        }
        return false;
      }
      catch (Exception localException)
      {
        QLog.e("AREngine_ARCamera", 1, "switchFlashLight fail.", localException);
      }
    }
  }
  
  public int b()
  {
    return this.e;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    }
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("autoZoom mZooming=%s", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    }
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      try
      {
        Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (localParameters.isZoomSupported())
        {
          int m = localParameters.getZoom();
          if (m == this.j) {
            b(m, this.i);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_AndroidOsHandler != null) {
              this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
            }
            ScanEntranceReport.a().b();
            return;
            b(m, this.j);
          }
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AREngine_ARCamera", 1, "autoZoom fail!", localException);
      }
    }
  }
  
  public int d()
  {
    return a(0, 0L);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    QLog.d("AREngine_ARCamera", 1, String.format("onAutoFocus success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
      paramCamera = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      CameraParameters.a(paramCamera);
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(paramCamera);
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera$AutoFocusListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera$AutoFocusListener.a(paramBoolean);
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception paramCamera)
    {
      for (;;)
      {
        QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", paramCamera);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera
 * JD-Core Version:    0.7.0.1
 */