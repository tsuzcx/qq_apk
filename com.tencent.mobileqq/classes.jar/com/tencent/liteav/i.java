package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.b.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.e;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.screencapture.a.a;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGLContext;

public class i
  implements k, com.tencent.liteav.screencapture.b
{
  private final a a;
  private l b;
  private EGLContext c = null;
  private WeakReference<com.tencent.liteav.basic.c.b> d = null;
  private int e;
  private e f;
  private int g;
  private int h;
  private String i = "";
  private int j = 0;
  private long k;
  private long l;
  private long m;
  private boolean n;
  private final Queue<Runnable> o = new LinkedList();
  
  public i(Context paramContext, g paramg, a.a parama)
  {
    this.a = new a(paramContext, paramg.W, parama);
    this.a.a(this);
    paramg.a();
    this.f = c(paramg.a, paramg.b);
    this.e = paramg.i;
    this.g = paramg.a;
    this.h = paramg.b;
    TXCLog.i("TXCScreenCaptureSource", "capture size: %s, encode size: %dx%d", new Object[] { this.f, Integer.valueOf(this.g), Integer.valueOf(this.h) });
  }
  
  private boolean a(Queue<Runnable> paramQueue)
  {
    try
    {
      if (paramQueue.isEmpty()) {
        return false;
      }
      Runnable localRunnable = (Runnable)paramQueue.poll();
      if (localRunnable == null) {
        return false;
      }
      localRunnable.run();
      return true;
    }
    finally {}
  }
  
  private e c(int paramInt1, int paramInt2)
  {
    int i1;
    if (paramInt1 > paramInt2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    e locale = new e();
    if ((paramInt1 <= 1280) && (paramInt2 <= 1280))
    {
      paramInt2 = 720;
      if (i1 != 0) {
        paramInt1 = 1280;
      } else {
        paramInt1 = 720;
      }
      locale.a = paramInt1;
      if (i1 != 0) {
        paramInt1 = paramInt2;
      } else {
        paramInt1 = 1280;
      }
      locale.b = paramInt1;
      return locale;
    }
    int i2;
    if (i1 != 0) {
      i2 = Math.max(paramInt1, paramInt2);
    } else {
      i2 = Math.min(paramInt1, paramInt2);
    }
    locale.a = i2;
    if (i1 != 0) {
      paramInt1 = Math.min(paramInt1, paramInt2);
    } else {
      paramInt1 = Math.max(paramInt1, paramInt2);
    }
    locale.b = paramInt1;
    return locale;
  }
  
  private void f(boolean paramBoolean)
  {
    int i1;
    int i2;
    if (paramBoolean)
    {
      i1 = this.g;
      i2 = this.h;
      if (i1 > i2) {
        b(i2, i1);
      }
    }
    else
    {
      i1 = this.g;
      i2 = this.h;
      if (i1 < i2) {
        b(i2, i1);
      }
    }
  }
  
  public void a()
  {
    Monitor.a(2, String.format("VideoCapture[%d]: start screen", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.n = true;
    this.a.a(this.f.a, this.f.b, this.e);
  }
  
  public void a(float paramFloat) {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, EGLContext paramEGLContext, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.c = paramEGLContext;
    while (a(this.o)) {}
    if (paramInt1 != 0)
    {
      TXCLog.e("TXCScreenCaptureSource", "onScreenCaptureFrame failed");
      return;
    }
    boolean bool2 = this.n;
    boolean bool1 = true;
    if (bool2)
    {
      this.n = false;
      Monitor.a(2, String.format("VideoCapture[%d]: capture first frame", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
      h.a(this.d, 1007, "First frame capture completed");
      TXCLog.i("TXCScreenCaptureSource", "on Got first frame");
    }
    this.k += 1L;
    paramLong = System.currentTimeMillis() - this.l;
    if (paramLong >= TimeUnit.SECONDS.toMillis(1L))
    {
      long l1 = this.k;
      double d1 = l1 - this.m;
      Double.isNaN(d1);
      double d2 = paramLong;
      Double.isNaN(d2);
      d1 = d1 * 1000.0D / d2;
      this.m = l1;
      this.l = System.currentTimeMillis();
      TXCStatus.a(this.i, 1001, this.j, Double.valueOf(d1));
    }
    if (this.b != null)
    {
      if (paramInt3 >= paramInt4) {
        bool1 = false;
      }
      f(bool1);
      paramEGLContext = new com.tencent.liteav.basic.structs.b();
      paramEGLContext.e = paramInt3;
      paramEGLContext.f = paramInt4;
      paramEGLContext.g = this.g;
      paramEGLContext.h = this.h;
      paramEGLContext.a = paramInt2;
      paramEGLContext.b = 0;
      paramEGLContext.j = 0;
      paramEGLContext.l = h.a(paramEGLContext.e, paramEGLContext.f, this.g, this.h);
      this.b.b(paramEGLContext);
    }
  }
  
  public void a(c paramc) {}
  
  public void a(com.tencent.liteav.basic.c.b paramb)
  {
    this.d = new WeakReference(paramb);
    a locala = this.a;
    if (locala != null) {
      locala.a(paramb);
    }
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb) {}
  
  public void a(l paraml)
  {
    this.b = paraml;
  }
  
  public void a(Object paramObject)
  {
    while (a(this.o)) {}
    paramObject = this.b;
    if (paramObject != null) {
      paramObject.t();
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    a locala = this.a;
    if (locala != null) {
      locala.a(paramRunnable);
    }
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    Monitor.a(2, String.format("VideoCapture[%d]: stop screen", new Object[] { Integer.valueOf(hashCode()) }), "", 0);
    this.a.a(null);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void b()
  {
    this.a.a(true);
  }
  
  public void b(int paramInt) {}
  
  public void b(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public void b(boolean paramBoolean)
  {
    e locale = c(this.g, this.h);
    if (!locale.equals(this.f))
    {
      this.f = locale;
      this.a.a(locale.a, locale.b);
      TXCLog.i("TXCScreenCaptureSource", "capture size: %s, encode size: %dx%d", new Object[] { this.f, Integer.valueOf(this.g), Integer.valueOf(this.h) });
    }
  }
  
  public void c()
  {
    this.a.a(false);
  }
  
  public void c(int paramInt) {}
  
  public void c(boolean paramBoolean) {}
  
  public void d(int paramInt) {}
  
  public boolean d()
  {
    return true;
  }
  
  public boolean d(boolean paramBoolean)
  {
    return false;
  }
  
  public int e()
  {
    return 0;
  }
  
  public void e(int paramInt) {}
  
  public void e(boolean paramBoolean) {}
  
  public EGLContext f()
  {
    return this.c;
  }
  
  public void f(int paramInt)
  {
    this.e = paramInt;
    this.a.a(paramInt);
  }
  
  public int g()
  {
    return this.e;
  }
  
  public void g(int paramInt)
  {
    this.j = paramInt;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public boolean i()
  {
    return false;
  }
  
  public boolean j()
  {
    return false;
  }
  
  public boolean k()
  {
    return false;
  }
  
  public boolean l()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.i
 * JD-Core Version:    0.7.0.1
 */