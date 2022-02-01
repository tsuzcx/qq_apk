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
  private static final int b = ScreenUtil.SCREEN_WIDTH * 3 / 4;
  private static final int c = ScreenUtil.SCREEN_WIDTH * 3 / 4;
  private static final Object d = new Object();
  private static int e = -3;
  private static long f = -1L;
  SensorEventListener a = new ARCamera.2(this);
  private Camera g;
  private Handler h = null;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private boolean n = false;
  private Matrix o = new Matrix();
  private int p;
  private int q;
  private boolean r;
  private boolean s;
  private int t;
  private int u;
  private int v = 0;
  private int w = 0;
  private SensorManager x = (SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor");
  private ARCamera.AutoFocusListener y;
  private boolean z = false;
  
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
    this.o.mapRect(localRectF);
    return new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((this.g != null) && (n()))
    {
      if (this.n) {
        return;
      }
      try
      {
        Camera.Parameters localParameters1 = this.g.getParameters();
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
        this.g.cancelAutoFocus();
        this.g.setParameters(localParameters1);
        this.g.autoFocus(this);
        this.n = true;
        return;
      }
      catch (Exception localException1)
      {
        QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", localException1);
        try
        {
          this.g.cancelAutoFocus();
          Camera.Parameters localParameters2 = this.g.getParameters();
          CameraParameters.a(localParameters2);
          this.g.setParameters(localParameters2);
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
        if (this.g != null)
        {
          bool = true;
          this.r = true;
          if (paramInt2 > paramInt1)
          {
            this.s = bool;
            this.t = paramInt1;
            this.u = paramInt2;
            p();
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
  
  private boolean n()
  {
    return ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.a) ^ true;
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("revertZoom mZooming=%s", new Object[] { Boolean.valueOf(this.r) }));
    }
    try
    {
      if (this.g != null)
      {
        this.r = false;
        if (this.h != null)
        {
          this.h.removeMessages(102);
          this.h.removeMessages(101);
        }
        Camera.Parameters localParameters = this.g.getParameters();
        if (localParameters.isZoomSupported())
        {
          int i1 = localParameters.getZoom();
          if (i1 != this.p)
          {
            b(i1, this.p);
            ReportController.b(null, "dc00898", "", "", "0X80085B0", "0X80085B0", 0, 0, "", "", "", "");
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void p()
  {
    try
    {
      if (this.g != null)
      {
        int i1 = this.t;
        int i2 = this.u;
        if (i1 != i2)
        {
          try
          {
            if (this.s)
            {
              this.t += 5;
              this.t = Math.min(this.t, this.u);
            }
            else
            {
              this.t -= 5;
              this.t = Math.max(this.t, this.u);
            }
            this.t = Math.min(this.t, this.q);
            this.t = Math.max(this.t, this.p);
            Camera.Parameters localParameters = this.g.getParameters();
            localParameters.setZoom(this.t);
            this.g.setParameters(localParameters);
            if (this.h == null) {
              break label189;
            }
            this.h.removeMessages(102);
            this.h.sendEmptyMessageDelayed(102, 20L);
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
          this.r = false;
        }
      }
      label189:
      return;
    }
    catch (Exception localException2) {}
  }
  
  public int a()
  {
    return this.i;
  }
  
  public int a(int paramInt)
  {
    synchronized (d)
    {
      long l1 = f;
      int i2 = 0;
      int i1 = i2;
      if (l1 != -1L) {
        if (Thread.currentThread().getId() == f)
        {
          i1 = i2;
        }
        else
        {
          i1 = i2;
          if (e == 0) {
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
    ((StringBuilder)???).append(this.g);
    QLog.i("AREngine_ARCamera", 1, ((StringBuilder)???).toString());
    if (this.g != null) {
      synchronized (d)
      {
        e = 0;
        f = Thread.currentThread().getId();
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
              this.g = CameraUtil.a(i2, 1);
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
            if (this.g == null)
            {
              i1 = i2;
              if (i2 != 1)
              {
                this.g = CameraUtil.a(1, 1);
                i1 = 1;
              }
            }
            if (this.g != null)
            {
              ??? = new Camera.CameraInfo();
              Camera.getCameraInfo(i1, (Camera.CameraInfo)???);
              this.v = ((Camera.CameraInfo)???).orientation;
            }
          }
        }
        else {
          this.g = CameraUtil.a(-1, 1);
        }
        if (this.g == null)
        {
          QLog.i("AREngine_ARCamera", 1, "openCamera fail. mCamera is null.");
          synchronized (d)
          {
            e = -3;
            f = Thread.currentThread().getId();
            return -3;
          }
        }
        CameraParameters.a(this.g, 1280, 720, ScanEntranceDPC.a().b);
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
          this.g.setDisplayOrientation(i2);
          ??? = this.g.getParameters();
          this.k = ((Camera.Parameters)???).getPreviewFormat();
          PixelFormat localPixelFormat = new PixelFormat();
          PixelFormat.getPixelFormatInfo(this.k, localPixelFormat);
          Camera.Size localSize = ((Camera.Parameters)???).getPreviewSize();
          this.i = localSize.width;
          this.j = localSize.height;
          this.n = false;
          this.p = ((Camera.Parameters)???).getZoom();
          this.q = (((Camera.Parameters)???).getMaxZoom() / 3 * 2);
          QLog.d("AREngine_ARCamera", 1, String.format("openCamera mInitZoom=%s mMaxZoom=%s supportMaxZoom=%s", new Object[] { Integer.valueOf(this.p), Integer.valueOf(this.q), Integer.valueOf(((Camera.Parameters)???).getMaxZoom()) }));
          i1 = this.i * this.j * localPixelFormat.bitsPerPixel / 8;
          paramInt = 0;
          if (paramInt < 3)
          {
            this.g.addCallbackBuffer(new byte[i1]);
            paramInt += 1;
            continue;
          }
          synchronized (d)
          {
            e = 0;
            f = Thread.currentThread().getId();
            return 0;
          }
          continue;
        }
      }
      catch (Exception localException2)
      {
        QLog.i("AREngine_ARCamera", 1, "openCamera fail.", localException2);
        synchronized (d)
        {
          e = -3;
          f = Thread.currentThread().getId();
          return -3;
        }
        throw localObject7;
      }
      int i2 = 270;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i("AREngine_ARCamera", 1, String.format("autoFocus surfaceWidth=%s surfaceHeight=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (this.g != null)
    {
      if ((this.l != paramInt1) || (this.m != paramInt2))
      {
        localObject = new Matrix();
        ((Matrix)localObject).setScale(1.0F, 1.0F);
        ((Matrix)localObject).postRotate(90.0F);
        float f1 = paramInt1;
        float f2 = f1 / 2000.0F;
        float f3 = paramInt2;
        ((Matrix)localObject).postScale(f2, f3 / 2000.0F);
        ((Matrix)localObject).postTranslate(f1 / 2.0F, f3 / 2.0F);
        ((Matrix)localObject).invert(this.o);
        this.l = paramInt1;
        this.m = paramInt2;
      }
      Object localObject = this.h;
      if (localObject != null)
      {
        ((Handler)localObject).removeMessages(100);
        this.h.sendEmptyMessageDelayed(100, 500L);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.i("AREngine_ARCamera", 1, String.format("manualFocus touchX=%s touchY=%s surfaceWidth=%s surfaceHeight=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
    if (this.g != null) {
      CameraProxy.a().a(new ARCamera.1(this, paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  public boolean a(float paramFloat, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("directZoom scale=%.2f autoRevert=%s mZooming=%s", new Object[] { Float.valueOf(paramFloat), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.r) }));
    }
    if (this.r)
    {
      this.r = false;
      localObject = this.h;
      if (localObject != null)
      {
        ((Handler)localObject).removeMessages(102);
        this.h.removeMessages(101);
      }
    }
    Object localObject = this.g;
    if ((localObject != null) && (!this.r)) {}
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
            i1 = Math.max(Math.min(i9, this.q), this.p);
            if (i1 != i11)
            {
              ((Camera.Parameters)localObject).setZoom(i1);
              this.g.setParameters((Camera.Parameters)localObject);
              return true;
            }
            if (this.h != null)
            {
              this.h.removeMessages(101);
              if (paramBoolean) {
                this.h.sendEmptyMessageDelayed(101, 5000L);
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
    QLog.i("AREngine_ARCamera", 1, String.format("startPreview callback=%s surfaceTexture=%s mCamera=%s", new Object[] { paramPreviewCallback, paramSurfaceTexture, this.g }));
    Camera localCamera = this.g;
    if (localCamera != null) {
      try
      {
        localCamera.setPreviewCallbackWithBuffer(paramPreviewCallback);
        this.g.setPreviewTexture(paramSurfaceTexture);
        this.g.startPreview();
        this.y = paramAutoFocusListener;
        try
        {
          if (this.x != null) {
            this.x.registerListener(this.a, this.x.getDefaultSensor(1), 3);
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
    Object localObject = this.g;
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
        this.g.setParameters((Camera.Parameters)localObject);
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
    return this.j;
  }
  
  public int c()
  {
    return this.k;
  }
  
  public int d()
  {
    return (this.v - this.w + 360) % 360;
  }
  
  public int e()
  {
    return a(0, 0L);
  }
  
  public void f()
  {
    QLog.i("AREngine_ARCamera", 1, String.format("stopPreview mCamera=%s", new Object[] { this.g }));
    i();
    Object localObject = this.h;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.g;
    if (localObject != null) {
      try
      {
        ((Camera)localObject).setPreviewCallbackWithBuffer(null);
        this.g.stopPreview();
        this.y = null;
        if (this.x != null)
        {
          this.x.unregisterListener(this.a);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.i("AREngine_ARCamera", 1, "stopCamera fail.", localException);
      }
    }
  }
  
  /* Error */
  public boolean g()
  {
    // Byte code:
    //   0: ldc 189
    //   2: iconst_1
    //   3: ldc_w 642
    //   6: iconst_1
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_0
    //   13: getfield 162	com/tencent/mobileqq/ar/arengine/ARCamera:g	Landroid/hardware/Camera;
    //   16: aastore
    //   17: invokestatic 197	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokestatic 288	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: getfield 162	com/tencent/mobileqq/ar/arengine/ARCamera:g	Landroid/hardware/Camera;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +124 -> 153
    //   32: aload_1
    //   33: invokevirtual 645	android/hardware/Camera:release	()V
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 162	com/tencent/mobileqq/ar/arengine/ARCamera:g	Landroid/hardware/Camera;
    //   41: getstatic 58	com/tencent/mobileqq/ar/arengine/ARCamera:d	Ljava/lang/Object;
    //   44: astore_1
    //   45: aload_1
    //   46: monitorenter
    //   47: bipush 253
    //   49: putstatic 60	com/tencent/mobileqq/ar/arengine/ARCamera:e	I
    //   52: invokestatic 389	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   55: invokevirtual 393	java/lang/Thread:getId	()J
    //   58: putstatic 64	com/tencent/mobileqq/ar/arengine/ARCamera:f	J
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
    //   75: ldc 189
    //   77: iconst_1
    //   78: ldc_w 647
    //   81: aload_1
    //   82: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   85: aload_0
    //   86: aconst_null
    //   87: putfield 162	com/tencent/mobileqq/ar/arengine/ARCamera:g	Landroid/hardware/Camera;
    //   90: getstatic 58	com/tencent/mobileqq/ar/arengine/ARCamera:d	Ljava/lang/Object;
    //   93: astore_1
    //   94: aload_1
    //   95: monitorenter
    //   96: bipush 253
    //   98: putstatic 60	com/tencent/mobileqq/ar/arengine/ARCamera:e	I
    //   101: invokestatic 389	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   104: invokevirtual 393	java/lang/Thread:getId	()J
    //   107: putstatic 64	com/tencent/mobileqq/ar/arengine/ARCamera:f	J
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
    //   121: putfield 162	com/tencent/mobileqq/ar/arengine/ARCamera:g	Landroid/hardware/Camera;
    //   124: getstatic 58	com/tencent/mobileqq/ar/arengine/ARCamera:d	Ljava/lang/Object;
    //   127: astore_1
    //   128: aload_1
    //   129: monitorenter
    //   130: bipush 253
    //   132: putstatic 60	com/tencent/mobileqq/ar/arengine/ARCamera:e	I
    //   135: invokestatic 389	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   138: invokevirtual 393	java/lang/Thread:getId	()J
    //   141: putstatic 64	com/tencent/mobileqq/ar/arengine/ARCamera:f	J
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
  
  public void h()
  {
    Handler localHandler = this.h;
    if (localHandler != null)
    {
      localHandler.removeMessages(100);
      this.h.sendEmptyMessageDelayed(100, 100L);
    }
  }
  
  public void i()
  {
    Handler localHandler = this.h;
    if (localHandler != null) {
      localHandler.removeMessages(100);
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("autoZoom mZooming=%s", new Object[] { Boolean.valueOf(this.r) }));
    }
    if (this.g != null) {
      try
      {
        this.r = false;
        if (this.h != null)
        {
          this.h.removeMessages(102);
          this.h.removeMessages(101);
        }
        Camera.Parameters localParameters = this.g.getParameters();
        if (localParameters.isZoomSupported())
        {
          int i1 = localParameters.getZoom();
          if (i1 == this.p) {
            b(i1, this.q);
          } else {
            b(i1, this.p);
          }
          ScanEntranceReport.a().c();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("AREngine_ARCamera", 1, "autoZoom fail!", localException);
      }
    }
  }
  
  public void k()
  {
    Handler localHandler = this.h;
    if (localHandler != null)
    {
      localHandler.removeMessages(101);
      this.h.sendEmptyMessageDelayed(101, 20L);
    }
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    QLog.d("AREngine_ARCamera", 1, String.format("onAutoFocus success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.n)
    {
      try
      {
        this.g.cancelAutoFocus();
        paramCamera = this.g.getParameters();
        CameraParameters.a(paramCamera);
        this.g.setParameters(paramCamera);
      }
      catch (Exception paramCamera)
      {
        QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", paramCamera);
      }
      paramCamera = this.y;
      if (paramCamera != null) {
        paramCamera.a(paramBoolean);
      }
    }
    this.n = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera
 * JD-Core Version:    0.7.0.1
 */