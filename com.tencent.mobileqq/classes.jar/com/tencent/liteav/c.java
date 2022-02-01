package com.tencent.liteav;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.liteav.basic.c.m;
import com.tencent.liteav.basic.c.n;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.capturer.a;
import com.tencent.liteav.capturer.a.a;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.microedition.khronos.egl.EGLContext;

public class c
  implements com.tencent.liteav.basic.b.b, n, com.tencent.liteav.capturer.b, k
{
  WeakReference<com.tencent.liteav.basic.b.b> a;
  private Context b;
  private final a c = new a();
  private l d;
  private boolean e;
  private g f;
  private int g = 0;
  private m h = null;
  private boolean i = false;
  private long j = 0L;
  private long k;
  private long l = 0L;
  private int m = 0;
  private Object n = new Object();
  private HandlerThread o = null;
  private Handler p = null;
  private String q = "";
  private boolean r = true;
  
  public c(Context paramContext, g paramg, m paramm, boolean paramBoolean)
  {
    try
    {
      this.f = ((g)paramg.clone());
    }
    catch (CloneNotSupportedException paramg)
    {
      this.f = new g();
      paramg.printStackTrace();
    }
    this.b = paramContext;
    this.h = paramm;
    this.h.setSurfaceTextureListener(this);
    paramContext = this.f;
    paramContext.W = paramBoolean;
    this.c.b(paramContext.U);
  }
  
  private void a(int paramInt, String paramString)
  {
    f.a(this.a, paramInt, paramString);
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, float[] paramArrayOfFloat, int paramInt2)
  {
    if (!this.e) {
      return;
    }
    if (!this.i)
    {
      Monitor.a(2, String.format("VideoCapture[%d]: capture first frame", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
      f.a(this.a, 1007, "First frame capture completed");
      this.i = true;
      this.r = true;
      TXCLog.i("CameraCapture", "trtc_render: render first frame");
    }
    com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
    localb.e = this.c.j();
    localb.f = this.c.k();
    localb.g = this.f.a;
    localb.h = this.f.b;
    localb.j = this.c.h();
    boolean bool;
    if (this.c.i())
    {
      if (!this.f.S) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else {
      bool = this.f.S;
    }
    localb.i = bool;
    localb.a = paramInt1;
    localb.c = paramArrayOfFloat;
    localb.d = this.f.W;
    localb.m = paramArrayOfByte;
    localb.b = paramInt2;
    if ((localb.j != 0) && (localb.j != 180))
    {
      localb.g = this.f.a;
      localb.h = this.f.b;
    }
    else
    {
      localb.g = this.f.b;
      localb.h = this.f.a;
    }
    localb.l = f.a(localb.e, localb.f, this.f.b, this.f.a);
    paramArrayOfByte = this.d;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.b(localb);
    }
    if (this.r)
    {
      this.r = false;
      TXCLog.i("CameraCapture", String.format("vsize onCaptureFrame w*h:%d*%d angle:%d", new Object[] { Integer.valueOf(localb.g), Integer.valueOf(localb.h), Integer.valueOf(localb.j) }));
    }
    this.j += 1L;
    long l1 = System.currentTimeMillis() - this.k;
    if (l1 >= 1000L)
    {
      double d1 = this.j - this.l;
      Double.isNaN(d1);
      double d2 = l1;
      Double.isNaN(d2);
      d1 = d1 * 1000.0D / d2;
      TXCStatus.a(this.q, 1001, this.m, Double.valueOf(d1));
      this.l = this.j;
      this.k += l1;
    }
  }
  
  private void c(SurfaceTexture paramSurfaceTexture)
  {
    if ((paramSurfaceTexture != null) && (!this.e))
    {
      a locala = this.c;
      if (locala != null)
      {
        locala.a(this);
        this.c.a(paramSurfaceTexture);
        this.c.a(this.f.h);
        this.c.c(this.f.l);
        this.c.c(this.f.K);
        this.c.a(n());
        this.c.a(this.f.W, this.f.a, this.f.b);
        TXCLog.i("CameraCapture", String.format("vsize startCapture w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.f.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }));
        if (this.c.d(this.f.m) == 0)
        {
          this.e = true;
          this.k = System.currentTimeMillis();
          int i1 = hashCode();
          if (this.f.m) {
            paramSurfaceTexture = "front";
          } else {
            paramSurfaceTexture = "back";
          }
          Monitor.a(2, String.format("VideoCapture[%d]: start %s camera successfully", new Object[] { Integer.valueOf(i1), paramSurfaceTexture }), "", 0);
          a(1003, "Enabled camera successfully");
          this.i = false;
          return;
        }
        this.e = false;
        a(-1301, "Failed to open camera, please confirm whether the camera permission is turned on");
      }
    }
  }
  
  private a.a n()
  {
    if (this.f.T) {
      return a.a.i;
    }
    int i1 = c.3.a[this.f.k.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              return a.a.g;
            }
            return a.a.d;
          }
          return a.a.h;
        }
        return a.a.f;
      }
      return a.a.e;
    }
    return a.a.a;
  }
  
  private boolean o()
  {
    for (;;)
    {
      try
      {
        if (this.b != null)
        {
          List localList = ((ActivityManager)this.b.getSystemService("activity")).getRunningAppProcesses();
          if (localList != null) {
            break label120;
          }
          TXCLog.w("CameraCapture", "List of RunningAppProcessInfo is null");
          return false;
          if (i1 < localList.size())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localList.get(i1);
            if (localRunningAppProcessInfo == null)
            {
              TXCLog.w("CameraCapture", "ActivityManager.RunningAppProcessInfo is null");
            }
            else if (localRunningAppProcessInfo.processName.equals(this.b.getPackageName()))
            {
              int i2 = localRunningAppProcessInfo.importance;
              if (i2 == 100) {
                return true;
              }
            }
            i1 += 1;
            continue;
          }
        }
        return false;
      }
      catch (Exception localException)
      {
        return false;
      }
      label120:
      int i1 = 0;
    }
  }
  
  public int a(int paramInt, float[] paramArrayOfFloat)
  {
    a(paramInt, null, paramArrayOfFloat, 4);
    return 0;
  }
  
  public void a()
  {
    Monitor.a(2, String.format("VideoCapture[%d]: start camera", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start->enter with getSurfaceTexture:");
    localStringBuilder.append(this.h.getSurfaceTexture());
    TXCLog.i("CameraCapture", localStringBuilder.toString());
    this.h.a(this.f.h, true ^ this.f.W);
    c(this.h.getSurfaceTexture());
  }
  
  public void a(float paramFloat)
  {
    this.c.a(paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if ((this.c != null) && (this.f.K)) {
      this.c.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c.a(paramInt1, paramInt2);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSurfaceTextureAvailable->enter with mListener:");
    ((StringBuilder)localObject).append(this.d);
    TXCLog.i("CameraCapture", ((StringBuilder)localObject).toString());
    c(paramSurfaceTexture);
    localObject = this.d;
    if (localObject != null) {
      ((l)localObject).a(paramSurfaceTexture);
    }
  }
  
  public void a(com.tencent.liteav.basic.a.c paramc)
  {
    this.f.k = paramc;
    this.r = true;
  }
  
  public void a(com.tencent.liteav.basic.b.b paramb)
  {
    this.a = new WeakReference(paramb);
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb)
  {
    m localm = this.h;
    if (localm != null) {
      localm.a(paramb.a, paramb.i, this.g, paramb.e, paramb.f, this.c.i());
    }
  }
  
  public void a(l paraml)
  {
    this.d = paraml;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.h.a(paramRunnable);
  }
  
  public void a(String paramString)
  {
    this.q = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    Monitor.a(2, String.format("VideoCapture[%d]: stop camera", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    c();
    this.h.a();
    synchronized (this.n)
    {
      if (this.p != null) {
        this.p.removeCallbacksAndMessages(null);
      }
      if (this.o != null)
      {
        TXCLog.w("CameraCapture", "stop camera monitor ");
        this.o.quit();
        this.o = null;
        this.p = null;
      }
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    m localm = this.h;
    if (localm != null) {
      localm.a(paramArrayOfByte);
    }
  }
  
  public void a(byte[] paramArrayOfByte, float[] paramArrayOfFloat)
  {
    a(-1, paramArrayOfByte, paramArrayOfFloat, 3);
  }
  
  public boolean a(int paramInt)
  {
    return this.c.b(paramInt);
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startCapture->enter with getSurfaceTexture:");
    localStringBuilder.append(this.h.getSurfaceTexture());
    TXCLog.i("CameraCapture", localStringBuilder.toString());
    c(this.h.getSurfaceTexture());
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    g localg = this.f;
    localg.a = paramInt1;
    localg.b = paramInt2;
    this.r = true;
    TXCLog.i("CameraCapture", String.format("vsize setVideoEncSize w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(localg.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }));
  }
  
  public void b(SurfaceTexture paramSurfaceTexture)
  {
    c();
    paramSurfaceTexture = new StringBuilder();
    paramSurfaceTexture.append("onSurfaceTextureDestroy->enter with mListener:");
    paramSurfaceTexture.append(this.d);
    TXCLog.i("CameraCapture", paramSurfaceTexture.toString());
    paramSurfaceTexture = this.d;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.s();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.e) && (this.c != null))
    {
      Object localObject = this.f;
      if (paramBoolean)
      {
        if (!((g)localObject).m) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
      }
      else {
        paramBoolean = ((g)localObject).m;
      }
      ((g)localObject).m = paramBoolean;
      this.c.g();
      this.h.a(false);
      this.c.a(this.f.h);
      this.c.c(this.f.l);
      this.c.a(n());
      this.c.a(this.f.W, this.f.a, this.f.b);
      this.c.a(this);
      this.c.a(this.h.getSurfaceTexture());
      TXCLog.i("CameraCapture", String.format("vsize refreshCapture w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.f.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }));
      if (this.c.d(this.f.m) == 0)
      {
        this.e = true;
        int i1 = hashCode();
        if (this.f.m) {
          localObject = "front";
        } else {
          localObject = "back";
        }
        Monitor.a(2, String.format("VideoCapture[%d]: start %s camera successfully", new Object[] { Integer.valueOf(i1), localObject }), "", 0);
        a(1003, "Enabled camera successfully");
      }
      else
      {
        this.e = false;
        a(-1301, "Failed to open the camera, please confirm whether the camera permission is turned on");
      }
      this.i = false;
    }
  }
  
  public void c()
  {
    TXCLog.i("CameraCapture", "stopCapture->enter with null");
    this.c.a(null);
    this.c.g();
    this.e = false;
  }
  
  public void c(int paramInt)
  {
    m localm = this.h;
    if (localm != null) {
      localm.setRendMode(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    a(new c.1(this, paramBoolean));
  }
  
  public void d(int paramInt)
  {
    m localm = this.h;
    if (localm != null) {
      localm.setRendMirror(paramInt);
    }
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public boolean d(boolean paramBoolean)
  {
    return this.c.a(paramBoolean);
  }
  
  public int e()
  {
    return this.c.f();
  }
  
  public void e(int paramInt)
  {
    g localg = this.f;
    localg.l = paramInt;
    this.c.c(localg.l);
    this.r = true;
    TXCLog.i("CameraCapture", String.format("vsize setCaptureOrientation w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.f.a), Integer.valueOf(this.f.b), Integer.valueOf(this.f.l) }));
  }
  
  public void e(boolean paramBoolean)
  {
    this.f.U = paramBoolean;
    this.c.b(paramBoolean);
    this.r = true;
  }
  
  public EGLContext f()
  {
    return this.h.getGLContext();
  }
  
  public void f(int paramInt)
  {
    this.f.h = paramInt;
    Object localObject = this.c;
    if (localObject != null) {
      ((a)localObject).a(paramInt);
    }
    localObject = this.h;
    if ((localObject != null) && ((localObject instanceof TXCGLSurfaceView))) {
      ((TXCGLSurfaceView)localObject).setFPS(paramInt);
    }
  }
  
  public int g()
  {
    return this.f.h;
  }
  
  public void g(int paramInt)
  {
    this.m = paramInt;
  }
  
  public boolean h()
  {
    a locala = this.c;
    if (locala != null) {
      return locala.b();
    }
    return false;
  }
  
  public boolean i()
  {
    a locala = this.c;
    if (locala != null) {
      return locala.c();
    }
    return false;
  }
  
  public boolean j()
  {
    a locala = this.c;
    if (locala != null) {
      return locala.d();
    }
    return false;
  }
  
  public boolean k()
  {
    a locala = this.c;
    if (locala != null) {
      return locala.e();
    }
    return false;
  }
  
  public boolean l()
  {
    a locala = this.c;
    if (locala != null) {
      return locala.i();
    }
    return false;
  }
  
  public void m()
  {
    if (this.c.l() != null) {
      this.c.g();
    }
    synchronized (this.n)
    {
      if (this.o == null)
      {
        this.o = new HandlerThread("cameraMonitorThread");
        this.o.start();
        this.p = new Handler(this.o.getLooper());
        TXCLog.w("CameraCapture", "start camera monitor ");
      }
      if (this.p != null) {
        this.p.postDelayed(new c.2(this), 2000L);
      }
      return;
    }
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    f.a(this.a, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.c
 * JD-Core Version:    0.7.0.1
 */