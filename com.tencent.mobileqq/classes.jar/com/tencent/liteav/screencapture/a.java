package com.tencent.liteav.screencapture;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.h;
import java.lang.ref.WeakReference;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLContext;

public class a
{
  protected final Handler a;
  protected volatile HandlerThread b = null;
  protected volatile a.b c = null;
  protected volatile WeakReference<b> d = null;
  protected volatile int e = 0;
  protected int f = 720;
  protected int g = 1280;
  protected int h = 20;
  protected boolean i = true;
  private final boolean j;
  private final Context k;
  private Object l = null;
  private int m = this.f;
  private int n = this.g;
  private WeakReference<com.tencent.liteav.basic.c.b> o = null;
  private WeakReference<a.a> p;
  private c.b q = new a.1(this);
  
  public a(Context paramContext, boolean paramBoolean, a.a parama)
  {
    this.p = new WeakReference(parama);
    this.k = paramContext.getApplicationContext();
    this.a = new Handler(Looper.getMainLooper());
    this.j = paramBoolean;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (this.j)
    {
      int i1 = h.g(this.k);
      if ((i1 != 0) && (i1 != 2))
      {
        if (paramInt1 < paramInt2)
        {
          this.f = paramInt2;
          this.g = paramInt1;
        }
        else
        {
          this.f = paramInt1;
          this.g = paramInt2;
        }
      }
      else if (paramInt1 > paramInt2)
      {
        this.f = paramInt2;
        this.g = paramInt1;
      }
      else
      {
        this.f = paramInt1;
        this.g = paramInt2;
      }
    }
    else
    {
      this.f = paramInt1;
      this.g = paramInt2;
    }
    this.m = this.f;
    this.n = this.g;
  }
  
  private a.a d()
  {
    WeakReference localWeakReference = this.p;
    if (localWeakReference != null) {
      return (a.a)localWeakReference.get();
    }
    return null;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.h = paramInt3;
    if (Build.VERSION.SDK_INT < 21)
    {
      c(20000004);
      return 20000004;
    }
    c(paramInt1, paramInt2);
    a();
    TXCLog.i("TXCScreenCapture", "start screen capture");
    return 0;
  }
  
  protected void a()
  {
    b();
    try
    {
      this.b = new HandlerThread("ScreenCaptureGLThread");
      this.b.start();
      this.c = new a.b(this, this.b.getLooper(), this);
      int i2 = this.e;
      int i1 = 1;
      this.e = (i2 + 1);
      this.c.a = this.e;
      this.c.e = this.m;
      this.c.f = this.n;
      a.b localb = this.c;
      if (this.h >= 1) {
        i1 = this.h;
      }
      localb.g = i1;
      b(100);
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
    b(103, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    b(105, paramInt1, paramInt2);
  }
  
  protected void a(int paramInt, long paramLong)
  {
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessageDelayed(paramInt, paramLong);
      }
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt, Runnable paramRunnable)
  {
    try
    {
      if (this.c != null)
      {
        Message localMessage = new Message();
        localMessage.what = paramInt;
        localMessage.obj = paramRunnable;
        this.c.sendMessage(localMessage);
      }
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt1, EGLContext paramEGLContext, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    b localb = c();
    if (localb != null) {
      localb.a(paramInt1, paramEGLContext, paramInt2, paramInt3, paramInt4, paramLong);
    }
  }
  
  public void a(com.tencent.liteav.basic.c.b paramb)
  {
    this.o = new WeakReference(paramb);
  }
  
  public void a(b paramb)
  {
    this.d = new WeakReference(paramb);
  }
  
  public void a(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop encode: ");
    localStringBuilder.append(paramObject);
    TXCLog.i("TXCScreenCapture", localStringBuilder.toString());
    this.l = paramObject;
    b();
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      if (this.c != null) {
        this.c.post(paramRunnable);
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      a.2 local2 = new a.2(this, paramBoolean);
      if (this.c != null) {
        this.c.post(local2);
      } else {
        local2.run();
      }
      return;
    }
    finally {}
  }
  
  protected void b()
  {
    try
    {
      this.e += 1;
      if (this.c != null)
      {
        HandlerThread localHandlerThread = this.b;
        a(101, new a.3(this, this.c, localHandlerThread));
      }
      this.c = null;
      this.b = null;
      return;
    }
    finally {}
  }
  
  protected void b(int paramInt)
  {
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally {}
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.c != null)
      {
        Message localMessage = new Message();
        localMessage.what = paramInt1;
        localMessage.arg1 = paramInt2;
        this.c.sendMessage(localMessage);
      }
      return;
    }
    finally {}
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (this.c != null)
      {
        Message localMessage = new Message();
        localMessage.what = paramInt1;
        localMessage.arg1 = paramInt2;
        localMessage.arg2 = paramInt3;
        this.c.sendMessage(localMessage);
      }
      return;
    }
    finally {}
  }
  
  protected void b(boolean paramBoolean)
  {
    int i1;
    int i2;
    int i3;
    if (paramBoolean)
    {
      i1 = this.f;
      i2 = this.g;
      if (i1 >= i2) {
        i1 = i2;
      }
      this.m = i1;
      i2 = this.f;
      i3 = this.g;
      i1 = i2;
      if (i2 < i3) {
        i1 = i3;
      }
      this.n = i1;
    }
    else
    {
      i2 = this.f;
      i3 = this.g;
      i1 = i2;
      if (i2 < i3) {
        i1 = i3;
      }
      this.m = i1;
      i1 = this.f;
      i2 = this.g;
      if (i1 >= i2) {
        i1 = i2;
      }
      this.n = i1;
    }
    TXCLog.i("TXCScreenCapture", String.format(Locale.ENGLISH, "reset screen capture isPortrait[%b] output size[%d/%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.m), Integer.valueOf(this.n) }));
  }
  
  protected b c()
  {
    if (this.d == null) {
      return null;
    }
    return (b)this.d.get();
  }
  
  protected void c(int paramInt)
  {
    a.a locala = d();
    if ((locala != null) && (paramInt == 0)) {
      locala.onScreenCaptureStarted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.screencapture.a
 * JD-Core Version:    0.7.0.1
 */