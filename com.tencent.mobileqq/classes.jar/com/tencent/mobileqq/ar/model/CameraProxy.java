package com.tencent.mobileqq.ar.model;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.ar.arengine.ARCamera.AutoFocusListener;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class CameraProxy
  implements Camera.PreviewCallback, ARCamera.AutoFocusListener
{
  public static HandlerThread a;
  private volatile int b = 0;
  private int c = 1;
  private Handler d = null;
  private ARCamera e = null;
  private int f = 0;
  private int g = 0;
  private int h = 17;
  private int i = 10;
  private long j = 0L;
  private boolean k = false;
  private ArrayList<WeakReference<ARCamera.AutoFocusListener>> l = new ArrayList();
  private ArrayList<WeakReference<CameraProxy.CameraOperationStatusCallBack>> m = new ArrayList();
  private WeakReference<CameraProxy.OnCameraPreviewCallback> n;
  private ArrayList<WeakReference<CameraProxy.OnCameraPreviewCallback>> o = new ArrayList();
  private volatile byte[] p;
  private int q;
  
  private CameraProxy()
  {
    if (a == null)
    {
      a = ThreadManager.newFreeHandlerThread("Camera2 Handler Thread", 0);
      a.start();
      this.d = new Handler(a.getLooper());
    }
    this.e = new ARCamera();
    if (Build.MODEL.equalsIgnoreCase("Redmi Note 3")) {
      this.j = 500L;
    } else {
      this.j = 300L;
    }
    this.i = 0;
  }
  
  public static CameraProxy a()
  {
    return CameraProxy.CameraProxyHolder.a();
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i1;
    synchronized (this.m)
    {
      i1 = this.m.size() - 1;
      if (i1 >= 0)
      {
        WeakReference localWeakReference = (WeakReference)this.m.get(i1);
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          if (paramBoolean) {
            ((CameraProxy.CameraOperationStatusCallBack)localWeakReference.get()).b();
          } else {
            ((CameraProxy.CameraOperationStatusCallBack)localWeakReference.get()).b(paramInt1, paramInt2);
          }
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.b == 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openCamera mCurCameraState = ");
      localStringBuilder.append(this.b);
      QLog.i("CameraProxy", 2, localStringBuilder.toString());
      return;
    }
    this.b = 1;
    this.i = 0;
    a(new CameraProxy.1(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ARCamera localARCamera = this.e;
    if (localARCamera != null) {
      localARCamera.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ARCamera localARCamera = this.e;
    if (localARCamera != null) {
      localARCamera.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.b == 2) && (this.k))
    {
      QLog.i("CameraProxy", 2, "startCameraPreview return now");
      return;
    }
    a(new CameraProxy.2(this, paramSurfaceTexture));
  }
  
  public void a(ARCamera.AutoFocusListener paramAutoFocusListener)
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramAutoFocusListener) {
        return;
      }
    }
    this.l.add(new WeakReference(paramAutoFocusListener));
  }
  
  public void a(CameraProxy.CameraOperationStatusCallBack paramCameraOperationStatusCallBack)
  {
    synchronized (this.m)
    {
      Iterator localIterator = this.m.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramCameraOperationStatusCallBack) {
          return;
        }
      }
      this.m.add(new WeakReference(paramCameraOperationStatusCallBack));
      return;
    }
    for (;;)
    {
      throw paramCameraOperationStatusCallBack;
    }
  }
  
  public void a(CameraProxy.OnCameraPreviewCallback paramOnCameraPreviewCallback)
  {
    if (paramOnCameraPreviewCallback == null)
    {
      this.n = null;
      return;
    }
    this.n = new WeakReference(paramOnCameraPreviewCallback);
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (a)
    {
      if (this.d != null) {
        this.d.post(paramRunnable);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((ARCamera.AutoFocusListener)localWeakReference.get()).a(paramBoolean);
      }
    }
  }
  
  public boolean a(float paramFloat, boolean paramBoolean)
  {
    ARCamera localARCamera = this.e;
    if (localARCamera != null) {
      return localARCamera.a(paramFloat, paramBoolean);
    }
    return false;
  }
  
  public void b()
  {
    ARCamera localARCamera = this.e;
    if (localARCamera != null) {
      localARCamera.i();
    }
  }
  
  public void b(ARCamera.AutoFocusListener paramAutoFocusListener)
  {
    int i2 = this.l.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((WeakReference)this.l.get(i1)).get() == paramAutoFocusListener) {
        break label45;
      }
      i1 += 1;
    }
    i1 = -1;
    label45:
    if (i1 != -1) {
      this.l.remove(i1);
    }
  }
  
  public void b(CameraProxy.CameraOperationStatusCallBack paramCameraOperationStatusCallBack)
  {
    int i1;
    synchronized (this.m)
    {
      int i2 = this.m.size();
      i1 = 0;
      if (i1 < i2) {
        if (((WeakReference)this.m.get(i1)).get() == paramCameraOperationStatusCallBack)
        {
          if (i1 != -1) {
            this.m.remove(i1);
          }
          return;
        }
      }
    }
  }
  
  public void b(CameraProxy.OnCameraPreviewCallback paramOnCameraPreviewCallback)
  {
    synchronized (this.o)
    {
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramOnCameraPreviewCallback) {
          return;
        }
      }
      this.o.add(new WeakReference(paramOnCameraPreviewCallback));
      return;
    }
    for (;;)
    {
      throw paramOnCameraPreviewCallback;
    }
  }
  
  public boolean b(boolean paramBoolean)
  {
    return this.e.a(paramBoolean);
  }
  
  public void c()
  {
    ARCamera localARCamera = this.e;
    if (localARCamera != null) {
      localARCamera.j();
    }
  }
  
  public void c(CameraProxy.OnCameraPreviewCallback paramOnCameraPreviewCallback)
  {
    int i1;
    synchronized (this.o)
    {
      int i2 = this.o.size();
      i1 = 0;
      if (i1 < i2) {
        if (((WeakReference)this.o.get(i1)).get() == paramOnCameraPreviewCallback)
        {
          if (i1 != -1) {
            this.o.remove(i1);
          }
          return;
        }
      }
    }
  }
  
  public void d()
  {
    ARCamera localARCamera = this.e;
    if (localARCamera != null) {
      localARCamera.h();
    }
  }
  
  public void e()
  {
    ARCamera localARCamera = this.e;
    if (localARCamera != null) {
      localARCamera.k();
    }
  }
  
  public boolean f()
  {
    return this.b == 2;
  }
  
  public boolean g()
  {
    return (this.b == 2) && (this.k);
  }
  
  public int h()
  {
    return this.f;
  }
  
  public int i()
  {
    return this.g;
  }
  
  public int j()
  {
    return this.h;
  }
  
  public void k()
  {
    if (this.b == 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeCamera mCurCameraState = ");
      localStringBuilder.append(this.b);
      QLog.i("CameraProxy", 2, localStringBuilder.toString());
      return;
    }
    this.b = 3;
    a(new CameraProxy.3(this));
  }
  
  public void l()
  {
    synchronized (this.o)
    {
      this.o.clear();
      synchronized (this.m)
      {
        this.m.clear();
        this.l.clear();
        return;
      }
    }
  }
  
  public String m()
  {
    int i1 = this.q;
    if (Build.MODEL.equalsIgnoreCase("M1 E")) {
      i1 = 90;
    }
    String str;
    if (this.p != null) {
      str = ((IOCR)QRoute.api(IOCR.class)).savePreviewImage(this.p, this.f, this.g, this.h, i1);
    } else {
      str = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraProxy", 2, String.format("getLastPreviewFrame, path: %s, rotation: %s", new Object[] { str, Integer.valueOf(i1) }));
    }
    return str;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    Object localObject = this.o;
    boolean bool1 = false;
    try
    {
      i1 = this.o.size() - 1;
      bool2 = bool1;
      if (i1 >= 0)
      {
        WeakReference localWeakReference = (WeakReference)this.o.get(i1);
        bool2 = bool1;
        if (localWeakReference.get() == null) {
          break label188;
        }
        bool1 = ((CameraProxy.OnCameraPreviewCallback)localWeakReference.get()).a(paramArrayOfByte);
        bool2 = bool1;
        if (!bool1) {
          break label188;
        }
        bool2 = bool1;
      }
      if ((!bool2) && (this.n != null) && (this.n.get() != null)) {
        ((CameraProxy.OnCameraPreviewCallback)this.n.get()).a(paramArrayOfByte);
      }
      if (this.b == 2) {
        this.p = paramArrayOfByte;
      } else {
        this.p = null;
      }
      localObject = this.e;
      if (localObject != null) {
        this.q = ((ARCamera)localObject).d();
      }
      paramCamera.addCallbackBuffer(paramArrayOfByte);
      return;
    }
    finally
    {
      for (;;)
      {
        int i1;
        boolean bool2;
        for (;;)
        {
          throw paramArrayOfByte;
        }
        label188:
        i1 -= 1;
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy
 * JD-Core Version:    0.7.0.1
 */