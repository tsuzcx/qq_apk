package com.tencent.luggage.scanner.camera;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.tencent.luggage.wxa.ry.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a
  implements g
{
  protected Camera a;
  protected volatile boolean b = false;
  protected volatile boolean c = false;
  protected Point d = null;
  protected Point e = null;
  protected Point f = null;
  protected float g = 1.0F;
  protected boolean h;
  protected int i;
  protected boolean j = false;
  protected boolean k = false;
  protected int l = -1;
  protected int m;
  protected int n;
  protected int o;
  
  private Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Point localPoint = null;
    Collections.sort((List)localObject, new a.a(null));
    ((List)localObject).remove(0);
    float f4 = paramPoint.x / paramPoint.y;
    b.d("BaseScanCamera", String.format("visible.x: %d, visible.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f4) }));
    b.c("BaseScanCamera", String.format("SCREEN_PIXELS: %s", new Object[] { Integer.valueOf(paramPoint.x * paramPoint.y) }));
    localObject = ((List)localObject).iterator();
    float f1 = (1.0F / 1.0F);
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
      int i3 = localSize.width;
      int i4 = localSize.height;
      b.c("BaseScanCamera", String.format("realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4) }));
      int i1;
      if (!e()) {
        i1 = i3;
      } else {
        i1 = Math.min(i3, i4);
      }
      int i2;
      if (!e()) {
        i2 = i4;
      } else {
        i2 = Math.max(i3, i4);
      }
      b.d("BaseScanCamera", String.format("maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }));
      if ((i1 == paramPoint.x) && (i2 == paramPoint.y))
      {
        paramParameters = new Point(i3, i4);
        paramPoint = new StringBuilder();
        paramPoint.append("Found preview size exactly matching screen size: ");
        paramPoint.append(paramParameters);
        b.c("BaseScanCamera", paramPoint.toString());
        return paramParameters;
      }
      if (i3 * i4 >= 307200)
      {
        float f3 = Math.abs(i1 / i2 - f4);
        float f2 = f1;
        if (f3 < f1)
        {
          localPoint = new Point(i3, i4);
          f2 = f3;
        }
        b.c("BaseScanCamera", String.format("diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i3), Integer.valueOf(i4) }));
        f1 = f2;
      }
    }
    paramPoint = localPoint;
    if (localPoint == null)
    {
      paramParameters = paramParameters.getPreviewSize();
      paramPoint = new Point(paramParameters.width, paramParameters.height);
      paramParameters = new StringBuilder();
      paramParameters.append("No suitable preview sizes, using default: ");
      paramParameters.append(paramPoint);
      b.c("BaseScanCamera", paramParameters.toString());
    }
    paramParameters = new StringBuilder();
    paramParameters.append("Found best approximate preview size: ");
    paramParameters.append(paramPoint);
    b.c("BaseScanCamera", paramParameters.toString());
    return paramPoint;
  }
  
  private void a(Camera.Parameters paramParameters)
  {
    try
    {
      if (this.a != null)
      {
        localObject = paramParameters.get("zoom-supported");
        if ((!ScanUtil.isNullOrNil((String)localObject)) && (Boolean.parseBoolean((String)localObject)))
        {
          paramParameters = paramParameters.getZoomRatios();
          if (paramParameters == null) {
            return;
          }
          if (paramParameters.size() <= 0) {
            return;
          }
          this.n = 0;
          int i1 = paramParameters.size();
          double d1 = i1;
          Double.isNaN(d1);
          i1 = (int)(d1 / 1.5D);
          this.o = i1;
          b.d("BaseScanCamera", String.format("divideRatio: %f,max zoom: %d", new Object[] { Double.valueOf(1.5D), Integer.valueOf(this.o) }));
          if (this.o < this.n) {
            this.o = this.n;
          } else if (((Integer)paramParameters.get(this.o)).intValue() > 400) {
            this.o = a(paramParameters, 400);
          }
          b.c("BaseScanCamera", String.format("default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", new Object[] { Integer.valueOf(this.n), paramParameters.get(this.n), Integer.valueOf(this.o), paramParameters.get(this.o) }));
          return;
        }
        b.c("BaseScanCamera", "not support zoom");
        return;
      }
    }
    catch (Exception paramParameters)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init zoom exception! ");
      ((StringBuilder)localObject).append(paramParameters.getMessage());
      b.a("BaseScanCamera", ((StringBuilder)localObject).toString());
    }
    return;
  }
  
  private Point c(Point paramPoint)
  {
    Camera.Parameters localParameters = this.a.getParameters();
    Object localObject1 = localParameters.get("preview-size-values");
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = localParameters.get("preview-size-value");
    }
    localObject1 = null;
    if (localObject2 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("preview-size-values parameter: ");
      ((StringBuilder)localObject1).append((String)localObject2);
      b.d("BaseScanCamera", ((StringBuilder)localObject1).toString());
      localObject1 = a(localParameters, paramPoint);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new Point(paramPoint.x >> 3 << 3, paramPoint.y >> 3 << 3);
    }
    return localObject2;
  }
  
  private Point d(Point paramPoint)
  {
    float f1;
    float f2;
    int i1;
    if (e())
    {
      f1 = this.e.x * 1.0F / paramPoint.y;
      f2 = this.e.y * 1.0F;
      i1 = paramPoint.x;
    }
    else
    {
      f1 = this.e.x * 1.0F / paramPoint.x;
      f2 = this.e.y * 1.0F;
      i1 = paramPoint.y;
    }
    this.g = Math.max(f1, f2 / i1);
    return new Point((int)(paramPoint.x * this.g), (int)(paramPoint.y * this.g));
  }
  
  public int a(List<Integer> paramList, int paramInt)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      b.c("BaseScanCamera", String.format("zoomRatios: %s,size: %d", new Object[] { paramList, Integer.valueOf(paramList.size()) }));
      i1 = Collections.binarySearch(paramList, Integer.valueOf(paramInt));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("insert index: ");
      localStringBuilder.append(i1);
      b.c("BaseScanCamera", localStringBuilder.toString());
      if (i1 >= 0) {
        return i1;
      }
      int i2 = -(i1 + 1);
      int i3 = i2 - 1;
      if ((i2 >= 0) && (i2 <= paramList.size() - 1) && (i3 >= 0) && (i3 <= paramList.size() - 1))
      {
        i1 = i2;
        if (((Integer)paramList.get(i2)).intValue() - paramInt <= paramInt - ((Integer)paramList.get(i3)).intValue()) {
          return i1;
        }
      }
      else
      {
        if ((i2 >= 0) && (i2 <= paramList.size() - 1)) {
          return i2;
        }
        if ((i3 < 0) || (i3 > paramList.size() - 1)) {
          break label225;
        }
      }
      return i3;
    }
    label225:
    int i1 = 0;
    return i1;
  }
  
  public Point a(Point paramPoint)
  {
    int i1 = (this.f.x - this.e.x) / 2;
    int i2 = (this.f.y - this.e.y) / 2;
    Point localPoint1 = new Point(paramPoint.x + i1, paramPoint.y + i2);
    if (e())
    {
      i1 = (this.f.y - this.e.x) / 2;
      i2 = (this.f.x - this.e.y) / 2;
      localPoint1 = new Point(paramPoint.y + i2, this.e.x - paramPoint.x + i1);
    }
    b.d("BaseScanCamera", String.format("dx %d, dy %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }));
    Point localPoint2 = new Point((int)(localPoint1.x / this.g), (int)(localPoint1.y / this.g));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("viewPoint ");
    localStringBuilder.append(paramPoint);
    localStringBuilder.append(", previewPoint ");
    localStringBuilder.append(localPoint1);
    localStringBuilder.append(", scanPoint ");
    localStringBuilder.append(localPoint2);
    b.c("BaseScanCamera", localStringBuilder.toString());
    return localPoint2;
  }
  
  public Rect a(Rect paramRect)
  {
    Rect localRect = new Rect();
    b.c("BaseScanCamera", String.format("visibleResolution:%s, previewResolution:%s", new Object[] { this.e, this.f }));
    if (e()) {
      localPoint1 = new Point(paramRect.right, paramRect.top);
    } else {
      localPoint1 = new Point(paramRect.left, paramRect.top);
    }
    Point localPoint2 = a(localPoint1);
    if (e()) {
      localPoint1 = new Point(paramRect.left, paramRect.bottom);
    } else {
      localPoint1 = new Point(paramRect.right, paramRect.bottom);
    }
    Point localPoint1 = a(localPoint1);
    localRect.set(localPoint2.x, localPoint2.y, localPoint1.x, localPoint1.y);
    b.c("BaseScanCamera", String.format("uiRect %s, scanRect %s", new Object[] { paramRect, localRect }));
    return localRect;
  }
  
  public void a(int paramInt)
  {
    if (this.b)
    {
      b.b("BaseScanCamera", "in open(), is open already");
      return;
    }
    int i2 = h.a();
    long l1 = System.currentTimeMillis();
    Object localObject1 = h.a(i2, paramInt);
    if (localObject1 == null)
    {
      b.a("BaseScanCamera", "in open(), openCameraRes == null");
      return;
    }
    this.k = false;
    this.l = -1;
    this.i = ((h.a.a)localObject1).b;
    paramInt = ((h.a.a)localObject1).b;
    int i1 = 1;
    boolean bool;
    if (paramInt % 180 != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.h = bool;
    b.d("BaseScanCamera", String.format("openCamera done, cameraId=[%s] costTime=[%s] rotation[%d]", new Object[] { Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(this.i) }));
    this.a = ((h.a.a)localObject1).a;
    localObject1 = this.a;
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("in open(), camera == null, bNeedRotate ");
      ((StringBuilder)localObject1).append(this.h);
      b.a("BaseScanCamera", ((StringBuilder)localObject1).toString());
      return;
    }
    this.b = true;
    localObject1 = ((Camera)localObject1).getParameters();
    a((Camera.Parameters)localObject1);
    Object localObject2 = ((Camera.Parameters)localObject1).getSupportedPreviewFormats();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("supportedPreviewFormat:");
    localStringBuilder.append(localObject2);
    b.c("BaseScanCamera", localStringBuilder.toString());
    if (((List)localObject2).contains(Integer.valueOf(17)))
    {
      paramInt = 0;
    }
    else
    {
      if (((List)localObject2).contains(Integer.valueOf(842094169))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      i1 = 0;
    }
    if (i1 != 0)
    {
      b.c("BaseScanCamera", "Preview support NV21");
      ((Camera.Parameters)localObject1).setPreviewFormat(17);
    }
    else if (paramInt != 0)
    {
      b.c("BaseScanCamera", "Preview not support NV21, but support YV12");
      ((Camera.Parameters)localObject1).setPreviewFormat(842094169);
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Preview not support NV21 and YV12. Use format: ");
      localStringBuilder.append(((List)localObject2).get(0));
      b.c("BaseScanCamera", localStringBuilder.toString());
      ((Camera.Parameters)localObject1).setPreviewFormat(((Integer)((List)localObject2).get(0)).intValue());
    }
    this.a.setParameters((Camera.Parameters)localObject1);
    try
    {
      l();
      return;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("set focus mode error: ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      b.a("BaseScanCamera", ((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    long l1 = System.currentTimeMillis();
    if ((this.a != null) && (!this.c))
    {
      if (paramSurfaceTexture != null) {
        this.a.setPreviewTexture(paramSurfaceTexture);
      }
      if (this.d == null)
      {
        this.d = c(this.e);
        this.f = d(this.d);
      }
      paramSurfaceTexture = this.a.getParameters();
      paramSurfaceTexture.setPreviewSize(this.d.x, this.d.y);
      this.a.setParameters(paramSurfaceTexture);
      this.a.startPreview();
      this.c = true;
      b.d("BaseScanCamera", String.format("startPreview done costTime=[%s]", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l1)) }));
    }
  }
  
  public void a(Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if ((this.a != null) && (this.c)) {
      try
      {
        this.a.autoFocus(paramAutoFocusCallback);
        return;
      }
      catch (Exception paramAutoFocusCallback)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("autoFocus() ");
        localStringBuilder.append(paramAutoFocusCallback.getMessage());
        b.b("BaseScanCamera", localStringBuilder.toString());
      }
    }
  }
  
  public void a(Camera.PreviewCallback paramPreviewCallback)
  {
    Object localObject = this.a;
    if (localObject != null) {
      try
      {
        ((Camera)localObject).setOneShotPreviewCallback(paramPreviewCallback);
        return;
      }
      catch (RuntimeException paramPreviewCallback)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("takeOneShot() ");
        ((StringBuilder)localObject).append(paramPreviewCallback.getMessage());
        b.b("BaseScanCamera", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.a != null)
      {
        localObject = this.a.getParameters();
        List localList = ((Camera.Parameters)localObject).getSupportedFocusModes();
        if ((localList != null) && (localList.contains(paramString)))
        {
          ((Camera.Parameters)localObject).setFocusMode(paramString);
          this.a.setParameters((Camera.Parameters)localObject);
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setFocusMode ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      b.b("BaseScanCamera", ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b()
  {
    Camera localCamera = this.a;
    if (localCamera != null)
    {
      localCamera.stopPreview();
      this.c = false;
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.a != null) && (this.c) && (paramInt > 0)) {
      try
      {
        Camera.Parameters localParameters = this.a.getParameters();
        localObject = localParameters.getZoomRatios();
        if (localObject != null)
        {
          if (((List)localObject).size() <= 0) {
            return;
          }
          b.d("BaseScanCamera", String.format("zoom to ratio:%d", new Object[] { Integer.valueOf(paramInt) }));
          if ((paramInt >= ((Integer)((List)localObject).get(this.n)).intValue()) && (paramInt <= ((Integer)((List)localObject).get(this.o)).intValue()))
          {
            paramInt = a((List)localObject, paramInt);
          }
          else if (paramInt < ((Integer)((List)localObject).get(this.n)).intValue())
          {
            paramInt = this.n;
          }
          else
          {
            b.c("BaseScanCamera", "exceed max zoom");
            int i1 = this.m + (this.o - this.m) / 5;
            paramInt = i1;
            if (i1 > this.o) {
              paramInt = this.o;
            }
          }
          b.c("BaseScanCamera", String.format("zoom:%d,ratio:%d", new Object[] { Integer.valueOf(paramInt), ((List)localObject).get(paramInt) }));
          this.m = paramInt;
          localParameters.setZoom(paramInt);
          this.a.setParameters(localParameters);
          return;
        }
        return;
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("zoom scale exception:");
        ((StringBuilder)localObject).append(localException.getMessage());
        b.a("BaseScanCamera", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void b(Point paramPoint)
  {
    this.e = new Point(paramPoint);
    paramPoint = new StringBuilder();
    paramPoint.append("set visible resolution: ");
    paramPoint.append(this.e);
    b.d("BaseScanCamera", paramPoint.toString());
    try
    {
      this.d = c(this.e);
      this.f = d(this.d);
      return;
    }
    catch (Exception paramPoint)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set preview size");
      localStringBuilder.append(paramPoint.getMessage());
      b.a("BaseScanCamera", localStringBuilder.toString());
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.a != null) && (this.c)) {}
    for (;;)
    {
      try
      {
        Camera.Parameters localParameters = this.a.getParameters();
        localObject = localParameters.getZoomRatios();
        if (localObject != null)
        {
          if (((List)localObject).size() <= 0) {
            return;
          }
          b.c("BaseScanCamera", String.format("zoom action:%d,beforeZoom:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localParameters.getZoom()) }));
        }
        int i1;
        switch (paramInt)
        {
        case 5: 
          if (this.m != this.n) {
            this.m = this.n;
          } else {
            this.m = this.o;
          }
          break;
        case 4: 
          this.m = this.o;
          break;
        case 3: 
          if (this.m > this.n)
          {
            this.m -= 1;
            if (this.m < this.n) {
              i1 = this.n;
            } else {
              i1 = this.m;
            }
            this.m = i1;
          }
          break;
        case 2: 
          if (this.m < this.o)
          {
            this.m += 1;
            if (this.m > this.o) {
              i1 = this.o;
            } else {
              i1 = this.m;
            }
            this.m = i1;
          }
          break;
        case 1: 
          this.m = this.n;
          break;
        case 0: 
          this.m = 0;
        case 6: 
          localParameters.setZoom(this.m);
          this.a.setParameters(localParameters);
          b.c("BaseScanCamera", String.format("zoom action:%d,afterZoom:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localParameters.getZoom()) }));
          return;
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("zoom action exception:");
        ((StringBuilder)localObject).append(localException.getMessage());
        b.a("BaseScanCamera", ((StringBuilder)localObject).toString());
      }
      return;
    }
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("close(), previewing ");
    localStringBuilder.append(this.c);
    b.c("BaseScanCamera", localStringBuilder.toString());
    if (this.a != null)
    {
      this.b = false;
      long l1 = System.currentTimeMillis();
      this.a.setPreviewCallback(null);
      this.a.stopPreview();
      this.c = false;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopPreview costTime ");
      localStringBuilder.append(System.currentTimeMillis() - l1);
      b.c("BaseScanCamera", localStringBuilder.toString());
      l1 = System.currentTimeMillis();
      this.a.release();
      this.a = null;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("camera.close() costTime ");
      localStringBuilder.append(System.currentTimeMillis() - l1);
      b.c("BaseScanCamera", localStringBuilder.toString());
    }
    this.k = false;
    this.j = false;
    this.l = -1;
    this.h = false;
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  public int f()
  {
    return this.i;
  }
  
  public Point g()
  {
    return this.d;
  }
  
  public Point h()
  {
    return this.f;
  }
  
  public int i()
  {
    Camera localCamera = this.a;
    if ((localCamera != null) && (localCamera.getParameters() != null) && (this.a.getParameters().getZoomRatios() != null) && (this.a.getParameters().getZoomRatios().size() > 0)) {
      return ((Integer)this.a.getParameters().getZoomRatios().get(this.m)).intValue();
    }
    return 100;
  }
  
  public boolean j()
  {
    return "auto".equals(k());
  }
  
  public String k()
  {
    try
    {
      if (this.a != null)
      {
        String str = this.a.getParameters().getFocusMode();
        return str;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFocusMode() ");
      localStringBuilder.append(localException.getMessage());
      b.b("BaseScanCamera", localStringBuilder.toString());
    }
    return "";
  }
  
  public void l()
  {
    try
    {
      b.c("BaseScanCamera", "set scan focus");
      List localList = this.a.getParameters().getSupportedFocusModes();
      if (localList != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("supported focus modes size = ");
        ((StringBuilder)localObject).append(localList.size());
        b.c("BaseScanCamera", ((StringBuilder)localObject).toString());
        localObject = localList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("supported focus modes : ");
          localStringBuilder.append(str);
          b.c("BaseScanCamera", localStringBuilder.toString());
        }
        if (localList.contains("continuous-video"))
        {
          b.d("BaseScanCamera", "camera support continuous video focus");
          a("continuous-video");
          return;
        }
        if (localList.contains("auto"))
        {
          b.d("BaseScanCamera", "camera support auto focus");
          a("auto");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setScanFocus error: ");
      ((StringBuilder)localObject).append(localException.getMessage());
      b.a("BaseScanCamera", ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.a
 * JD-Core Version:    0.7.0.1
 */