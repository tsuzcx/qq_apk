package com.tencent.liteav.capturer;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a
  implements Camera.AutoFocusCallback, Camera.ErrorCallback, Camera.PreviewCallback
{
  private Matrix a = new Matrix();
  private int b = 0;
  private Camera c;
  private boolean d = true;
  private b e;
  private int f = 15;
  private int g = 1;
  private int h;
  private int i;
  private int j;
  private int k;
  private SurfaceTexture l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p = false;
  private int q;
  private int r;
  private boolean s = false;
  private boolean t = false;
  
  private Rect a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramFloat1;
    if (this.d == true) {
      f1 = 1.0F - paramFloat1;
    }
    int i2 = this.j / 90;
    int i1 = 0;
    while (i1 < i2)
    {
      paramFloat1 = --(paramFloat2 - 0.5F);
      paramFloat2 = -(f1 - 0.5F);
      i1 += 1;
      paramFloat2 += 0.5F;
      f1 = paramFloat1 + 0.5F;
    }
    i2 = (int)(f1 * 2000.0F - 1000.0F);
    int i3 = (int)(paramFloat2 * 2000.0F - 1000.0F);
    i1 = i2;
    if (i2 < -1000) {
      i1 = -1000;
    }
    i2 = i3;
    if (i3 < -1000) {
      i2 = -1000;
    }
    i3 = (int)(paramFloat3 * 200.0F);
    int i4 = i1 + i3;
    int i5 = i3 + i2;
    i3 = i4;
    if (i4 > 1000) {
      i3 = 1000;
    }
    i4 = i5;
    if (i5 > 1000) {
      i4 = 1000;
    }
    return new Rect(i1, i2, i3, i4);
  }
  
  private static d a(Camera.Parameters paramParameters, int paramInt1, int paramInt2)
  {
    TXCLog.d("TXCCameraCapturer", "camera preview wanted: %d x %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramParameters = paramParameters.getSupportedPreviewSizes();
    float f1 = paramInt1 * 1.0F / paramInt2;
    Object localObject1 = new ArrayList();
    paramParameters = paramParameters.iterator();
    int i2 = 2147483647;
    while (paramParameters.hasNext())
    {
      localObject2 = (Camera.Size)paramParameters.next();
      TXCLog.d("TXCCameraCapturer", "camera support preview size: %dx%d", new Object[] { Integer.valueOf(((Camera.Size)localObject2).width), Integer.valueOf(((Camera.Size)localObject2).height) });
      int i1;
      if ((((Camera.Size)localObject2).width >= 640) && (((Camera.Size)localObject2).height >= 480)) {
        i1 = Math.round(Math.abs(((Camera.Size)localObject2).width * 1.0F / ((Camera.Size)localObject2).height - f1) * 10.0F);
      } else {
        i1 = 2147483647;
      }
      if (i1 < i2)
      {
        ((List)localObject1).clear();
        ((List)localObject1).add(localObject2);
        i2 = i1;
      }
      else if (i1 == i2)
      {
        ((List)localObject1).add(localObject2);
      }
    }
    Collections.sort((List)localObject1, new a.1());
    paramParameters = (Camera.Size)((List)localObject1).get(0);
    float f2 = paramInt1 * paramInt2;
    f1 = 2.147484E+009F;
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Camera.Size)((Iterator)localObject2).next();
      TXCLog.i("TXCCameraCapturer", "size in same buck: %dx%d", new Object[] { Integer.valueOf(((Camera.Size)localObject1).width), Integer.valueOf(((Camera.Size)localObject1).height) });
      float f3 = ((Camera.Size)localObject1).width * ((Camera.Size)localObject1).height;
      if (f3 / f2 >= 0.9D)
      {
        f3 -= f2;
        if (Math.abs(f3) < f1)
        {
          f1 = Math.abs(f3);
          paramParameters = (Camera.Parameters)localObject1;
        }
      }
    }
    TXCLog.i("TXCCameraCapturer", "best match preview size: %d x %d", new Object[] { Integer.valueOf(paramParameters.width), Integer.valueOf(paramParameters.height) });
    return new d(paramParameters.width, paramParameters.height);
  }
  
  private static d b(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      return new d(paramInt1, paramInt2);
    }
    d[] arrayOfd = new d[1];
    d locald = new d(1080, 1920);
    int i2 = 0;
    arrayOfd[0] = locald;
    float f1 = Math.min(paramInt1, paramInt2);
    float f2 = Math.max(paramInt1, paramInt2);
    int i4 = arrayOfd.length;
    int i1;
    int i3;
    for (;;)
    {
      i1 = paramInt1;
      i3 = paramInt2;
      if (i2 >= i4) {
        break;
      }
      locald = arrayOfd[i2];
      if ((f1 <= locald.a) && (f2 <= locald.b))
      {
        f1 = Math.min(locald.a / f1, locald.b / f2);
        i1 = (int)(paramInt1 * f1);
        i3 = (int)(paramInt2 * f1);
        break;
      }
      i2 += 1;
    }
    return new d(i1, i3);
  }
  
  private int d(int paramInt)
  {
    Object localObject = a();
    if (localObject == null) {
      return 1;
    }
    localObject = ((Camera.Parameters)localObject).getSupportedPreviewFrameRates();
    if (localObject == null)
    {
      TXCLog.e("TXCCameraCapturer", "getSupportedFPS error");
      return 1;
    }
    int i1 = 0;
    int i3;
    for (int i2 = ((Integer)((List)localObject).get(0)).intValue(); i1 < ((List)localObject).size(); i2 = i3)
    {
      int i4 = ((Integer)((List)localObject).get(i1)).intValue();
      i3 = i2;
      if (Math.abs(i4 - paramInt) - Math.abs(i2 - paramInt) < 0) {
        i3 = i4;
      }
      i1 += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("choose fps=");
    ((StringBuilder)localObject).append(i2);
    TXCLog.i("TXCCameraCapturer", ((StringBuilder)localObject).toString());
    return i2;
  }
  
  private int[] e(int paramInt)
  {
    paramInt *= 1000;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("camera supported preview fps range: wantFPS = ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = a();
    if (localObject2 == null) {
      return null;
    }
    Object localObject3 = ((Camera.Parameters)localObject2).getSupportedPreviewFpsRange();
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject2 = (int[])((List)localObject3).get(0);
      Collections.sort((List)localObject3, new a.2(this));
      Iterator localIterator = ((List)localObject3).iterator();
      while (localIterator.hasNext())
      {
        int[] arrayOfInt = (int[])localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("camera supported preview fps range: ");
        localStringBuilder.append(arrayOfInt[0]);
        localStringBuilder.append(" - ");
        localStringBuilder.append(arrayOfInt[1]);
        localStringBuilder.append("\n");
        localObject1 = localStringBuilder.toString();
      }
      localIterator = ((List)localObject3).iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (int[])localIterator.next();
        if ((localObject3[0] <= paramInt) && (paramInt <= localObject3[1])) {
          localObject2 = localObject3;
        }
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("choose preview fps range: ");
      ((StringBuilder)localObject3).append(localObject2[0]);
      ((StringBuilder)localObject3).append(" - ");
      ((StringBuilder)localObject3).append(localObject2[1]);
      TXCLog.i("TXCCameraCapturer", ((StringBuilder)localObject3).toString());
      return localObject2;
    }
    return null;
  }
  
  private int f(int paramInt)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vsize camera orientation ");
    localStringBuilder.append(localCameraInfo.orientation);
    localStringBuilder.append(", front ");
    boolean bool;
    if (localCameraInfo.facing == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    TXCLog.i("TXCCameraCapturer", localStringBuilder.toString());
    int i1 = localCameraInfo.orientation;
    if (i1 != 0)
    {
      paramInt = i1;
      if (i1 != 180) {}
    }
    else
    {
      paramInt = i1 + 90;
    }
    if (localCameraInfo.facing == 1) {
      return (360 - paramInt) % 360;
    }
    return (paramInt + 360) % 360;
  }
  
  public Camera.Parameters a()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((Camera)localObject).getParameters();
      return localObject;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCameraCapturer", "getCameraParameters error ", localException);
    }
    return null;
  }
  
  public void a(float paramFloat)
  {
    if (this.c != null)
    {
      float f1 = paramFloat;
      if (paramFloat > 1.0F) {
        f1 = 1.0F;
      }
      paramFloat = f1;
      if (f1 < -1.0F) {
        paramFloat = -1.0F;
      }
      Camera.Parameters localParameters = a();
      if (localParameters == null)
      {
        TXCLog.e("TXCCameraCapturer", "camera setExposureCompensation camera parameter is null");
        return;
      }
      int i1 = localParameters.getMinExposureCompensation();
      int i2 = localParameters.getMaxExposureCompensation();
      if ((i1 != 0) && (i2 != 0))
      {
        int i3 = c.a().e();
        f1 = i2;
        paramFloat *= f1;
        StringBuilder localStringBuilder;
        if ((i3 != 0) && (i3 <= i2) && (i3 >= i1))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("camera setExposureCompensation: ");
          localStringBuilder.append(i3);
          TXCLog.i("TXCCameraCapturer", localStringBuilder.toString());
          localParameters.setExposureCompensation(i3);
        }
        else if ((paramFloat <= f1) && (paramFloat >= i1))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("camera setExposureCompensation: ");
          localStringBuilder.append(paramFloat);
          TXCLog.i("TXCCameraCapturer", localStringBuilder.toString());
          localParameters.setExposureCompensation((int)paramFloat);
        }
      }
      else
      {
        TXCLog.e("TXCCameraCapturer", "camera not support setExposureCompensation!");
      }
      try
      {
        this.c.setParameters(localParameters);
        return;
      }
      catch (Exception localException)
      {
        TXCLog.e("TXCCameraCapturer", "setExposureCompensation failed.", localException);
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (!this.s) {
      return;
    }
    try
    {
      this.c.cancelAutoFocus();
      Camera.Parameters localParameters = this.c.getParameters();
      ArrayList localArrayList;
      if (this.m)
      {
        localArrayList = new ArrayList();
        localArrayList.add(new Camera.Area(a(paramFloat1, paramFloat2, 2.0F), 1000));
        localParameters.setFocusAreas(localArrayList);
      }
      if (this.n)
      {
        localArrayList = new ArrayList();
        localArrayList.add(new Camera.Area(a(paramFloat1, paramFloat2, 3.0F), 1000));
        localParameters.setMeteringAreas(localArrayList);
      }
      this.c.setParameters(localParameters);
      this.c.autoFocus(this);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.l = paramSurfaceTexture;
  }
  
  public void a(a.a parama)
  {
    if (parama != a.a.a)
    {
      this.q = a.a.a(parama);
      this.r = a.a.b(parama);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set resolution ");
    localStringBuilder.append(parama);
    TXCLog.i("TXCCameraCapturer", localStringBuilder.toString());
  }
  
  public void a(b paramb)
  {
    this.e = paramb;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.p = paramBoolean;
    this.q = paramInt1;
    this.r = paramInt2;
    TXCLog.i("TXCCameraCapturer", "setCaptureBuffer %b, width: %d, height: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.o = paramBoolean;
    if (this.c != null)
    {
      boolean bool = true;
      Camera.Parameters localParameters = a();
      if (localParameters == null) {
        return false;
      }
      List localList = localParameters.getSupportedFlashModes();
      if (paramBoolean)
      {
        if ((localList != null) && (localList.contains("torch")))
        {
          TXCLog.i("TXCCameraCapturer", "set FLASH_MODE_TORCH");
          localParameters.setFlashMode("torch");
          paramBoolean = bool;
          break label113;
        }
      }
      else if ((localList != null) && (localList.contains("off")))
      {
        TXCLog.i("TXCCameraCapturer", "set FLASH_MODE_OFF");
        localParameters.setFlashMode("off");
        paramBoolean = bool;
        break label113;
      }
      paramBoolean = false;
      try
      {
        label113:
        this.c.setParameters(localParameters);
        return paramBoolean;
      }
      catch (Exception localException)
      {
        TXCLog.e("TXCCameraCapturer", "setParameters failed.", localException);
        return false;
      }
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.t = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set performance mode to ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i("TXCCameraCapturer", localStringBuilder.toString());
  }
  
  public boolean b()
  {
    if (this.c != null)
    {
      Camera.Parameters localParameters = a();
      if ((localParameters != null) && (localParameters.getMaxZoom() > 0) && (localParameters.isZoomSupported())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b(int paramInt)
  {
    if (this.c != null)
    {
      Camera.Parameters localParameters = a();
      if ((localParameters != null) && (localParameters.getMaxZoom() > 0) && (localParameters.isZoomSupported()))
      {
        if ((paramInt >= 0) && (paramInt <= localParameters.getMaxZoom())) {
          try
          {
            localParameters.setZoom(paramInt);
            this.c.setParameters(localParameters);
            return true;
          }
          catch (Exception localException)
          {
            TXCLog.e("TXCCameraCapturer", "set zoom failed.", localException);
            return false;
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("invalid zoom value : ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", while max zoom is ");
        localStringBuilder.append(localException.getMaxZoom());
        TXCLog.e("TXCCameraCapturer", localStringBuilder.toString());
        return false;
      }
      TXCLog.e("TXCCameraCapturer", "camera not support zoom!");
    }
    return false;
  }
  
  public void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vsize setHomeOrientation ");
    localStringBuilder.append(paramInt);
    TXCLog.w("TXCCameraCapturer", localStringBuilder.toString());
    this.g = paramInt;
    this.j = ((this.k - 90 + this.g * 90 + 360) % 360);
  }
  
  public void c(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public boolean c()
  {
    Object localObject = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = a();
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = ((Camera.Parameters)localObject).getSupportedFlashModes();
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((List)localObject).contains("torch")) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int d(boolean paramBoolean)
  {
    int i2;
    int i3;
    int i1;
    int i4;
    int i5;
    try
    {
      TXCLog.i("TXCCameraCapturer", "trtc_capture: start capture");
      if (this.l == null) {
        return -2;
      }
      if (this.c != null) {
        g();
      }
      localObject1 = new Camera.CameraInfo();
      i2 = 0;
      i3 = -1;
      i1 = -1;
      if (i2 < Camera.getNumberOfCameras())
      {
        Camera.getCameraInfo(i2, (Camera.CameraInfo)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("camera index ");
        ((StringBuilder)localObject2).append(i2);
        ((StringBuilder)localObject2).append(", facing = ");
        ((StringBuilder)localObject2).append(((Camera.CameraInfo)localObject1).facing);
        TXCLog.i("TXCCameraCapturer", ((StringBuilder)localObject2).toString());
        i4 = i3;
        if (((Camera.CameraInfo)localObject1).facing == 1)
        {
          i4 = i3;
          if (i3 == -1) {
            i4 = i2;
          }
        }
        i5 = i1;
        if (((Camera.CameraInfo)localObject1).facing != 0) {
          break label822;
        }
        i5 = i1;
        if (i1 != -1) {
          break label822;
        }
        i5 = i2;
        break label822;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("camera front, id = ");
      ((StringBuilder)localObject1).append(i3);
      TXCLog.i("TXCCameraCapturer", ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("camera back , id = ");
      ((StringBuilder)localObject1).append(i1);
      TXCLog.i("TXCCameraCapturer", ((StringBuilder)localObject1).toString());
      i2 = i3;
      if (i3 != -1) {
        break label836;
      }
      i2 = i3;
      if (i1 == -1) {
        break label836;
      }
      i2 = i1;
    }
    catch (Exception localException)
    {
      Object localObject1;
      break label740;
    }
    catch (IOException localIOException)
    {
      label257:
      break label781;
    }
    this.d = paramBoolean;
    if (this.d) {
      this.c = Camera.open(i2);
    } else {
      this.c = Camera.open(i3);
    }
    localObject1 = this.c.getParameters();
    Object localObject2 = ((Camera.Parameters)localObject1).getSupportedFocusModes();
    if ((this.s) && (localObject2 != null) && (((List)localObject2).contains("auto")))
    {
      TXCLog.i("TXCCameraCapturer", "support FOCUS_MODE_AUTO");
      ((Camera.Parameters)localObject1).setFocusMode("auto");
    }
    else if ((localObject2 != null) && (((List)localObject2).contains("continuous-video")))
    {
      TXCLog.i("TXCCameraCapturer", "support FOCUS_MODE_CONTINUOUS_VIDEO");
      ((Camera.Parameters)localObject1).setFocusMode("continuous-video");
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (((Camera.Parameters)localObject1).getMaxNumFocusAreas() > 0) {
        this.m = true;
      }
      if (((Camera.Parameters)localObject1).getMaxNumMeteringAreas() > 0) {
        this.n = true;
      }
    }
    if (this.p)
    {
      ((Camera.Parameters)localObject1).setPreviewFormat(17);
      this.c.setPreviewCallback(this);
    }
    localObject2 = b(this.t, this.q, this.r);
    localObject2 = a((Camera.Parameters)localObject1, Math.max(((d)localObject2).a, ((d)localObject2).b), Math.min(((d)localObject2).a, ((d)localObject2).b));
    this.h = ((d)localObject2).a;
    this.i = ((d)localObject2).b;
    ((Camera.Parameters)localObject1).setPreviewSize(this.h, this.i);
    localObject2 = e(this.f);
    if (localObject2 != null) {
      ((Camera.Parameters)localObject1).setPreviewFpsRange(localObject2[0], localObject2[1]);
    } else {
      ((Camera.Parameters)localObject1).setPreviewFrameRate(d(this.f));
    }
    if (this.d) {
      break label574;
    }
    for (;;)
    {
      label574:
      this.k = f(i2);
      this.j = ((this.k - 90 + this.g * 90 + 360) % 360);
      this.c.setDisplayOrientation(0);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("vsize camera orientation ");
      ((StringBuilder)localObject2).append(this.k);
      ((StringBuilder)localObject2).append(", preview ");
      ((StringBuilder)localObject2).append(this.j);
      ((StringBuilder)localObject2).append(", home orientation ");
      ((StringBuilder)localObject2).append(this.g);
      TXCLog.i("TXCCameraCapturer", ((StringBuilder)localObject2).toString());
      this.c.setPreviewTexture(this.l);
      this.c.setParameters((Camera.Parameters)localObject1);
      this.c.setErrorCallback(this);
      this.c.startPreview();
      return 0;
      label740:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("open camera failed.");
      ((StringBuilder)localObject2).append(localIOException.getMessage());
      TXCLog.e("TXCCameraCapturer", ((StringBuilder)localObject2).toString());
      return -1;
      label781:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("open camera failed.");
      ((StringBuilder)localObject2).append(localIOException.getMessage());
      TXCLog.e("TXCCameraCapturer", ((StringBuilder)localObject2).toString());
      return -1;
      label822:
      i2 += 1;
      i3 = i4;
      i1 = i5;
      break;
      label836:
      i3 = i1;
      if (i1 != -1) {
        break label257;
      }
      i3 = i1;
      if (i2 == -1) {
        break label257;
      }
      i3 = i2;
      break label257;
      i2 = i3;
    }
  }
  
  public boolean d()
  {
    return this.m;
  }
  
  public boolean e()
  {
    Object localObject = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = a();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((Camera.Parameters)localObject).getMaxNumDetectedFaces() > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int f()
  {
    Camera.Parameters localParameters = a();
    if ((localParameters != null) && (localParameters.getMaxZoom() > 0) && (localParameters.isZoomSupported())) {
      return localParameters.getMaxZoom();
    }
    return 0;
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 269	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +70 -> 76
    //   9: aload_1
    //   10: aconst_null
    //   11: invokevirtual 514	android/hardware/Camera:setErrorCallback	(Landroid/hardware/Camera$ErrorCallback;)V
    //   14: aload_0
    //   15: getfield 269	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   18: aconst_null
    //   19: invokevirtual 477	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   22: aload_0
    //   23: getfield 269	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   26: invokevirtual 529	android/hardware/Camera:stopPreview	()V
    //   29: aload_0
    //   30: getfield 269	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   33: invokevirtual 532	android/hardware/Camera:release	()V
    //   36: goto +17 -> 53
    //   39: astore_1
    //   40: goto +24 -> 64
    //   43: astore_1
    //   44: ldc 75
    //   46: ldc_w 534
    //   49: aload_1
    //   50: invokestatic 277	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 269	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 341	com/tencent/liteav/capturer/a:l	Landroid/graphics/SurfaceTexture;
    //   63: return
    //   64: aload_0
    //   65: aconst_null
    //   66: putfield 269	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   69: aload_0
    //   70: aconst_null
    //   71: putfield 341	com/tencent/liteav/capturer/a:l	Landroid/graphics/SurfaceTexture;
    //   74: aload_1
    //   75: athrow
    //   76: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	a
    //   4	6	1	localCamera	Camera
    //   39	1	1	localObject	Object
    //   43	32	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	36	39	finally
    //   44	53	39	finally
    //   9	36	43	java/lang/Exception
  }
  
  public int h()
  {
    return this.j;
  }
  
  public boolean i()
  {
    return this.d;
  }
  
  public int j()
  {
    return this.h;
  }
  
  public int k()
  {
    return this.i;
  }
  
  public Camera l()
  {
    return this.c;
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (paramBoolean)
    {
      TXCLog.i("TXCCameraCapturer", "AUTO focus success");
      return;
    }
    TXCLog.i("TXCCameraCapturer", "AUTO focus failed");
  }
  
  public void onError(int paramInt, Camera paramCamera)
  {
    paramCamera = new StringBuilder();
    paramCamera.append("camera catch error ");
    paramCamera.append(paramInt);
    TXCLog.w("TXCCameraCapturer", paramCamera.toString());
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 100))
    {
      paramCamera = this.e;
      if (paramCamera != null) {
        paramCamera.m();
      }
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    paramCamera = this.e;
    if (paramCamera != null) {
      paramCamera.a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.capturer.a
 * JD-Core Version:    0.7.0.1
 */