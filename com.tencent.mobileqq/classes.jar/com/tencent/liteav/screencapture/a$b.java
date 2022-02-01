package com.tencent.liteav.screencapture;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.c.i;
import com.tencent.liteav.basic.c.j;
import com.tencent.liteav.basic.c.k;
import com.tencent.liteav.basic.c.l;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.e;
import com.tencent.liteav.basic.util.f;

public class a$b
  extends Handler
{
  public int a = 0;
  public int[] b = null;
  public Surface c = null;
  public SurfaceTexture d = null;
  public int e = 720;
  public int f = 1280;
  public int g = 25;
  protected boolean h = false;
  protected long i = 0L;
  protected long j = 0L;
  protected com.tencent.liteav.basic.c.b k = null;
  protected i l = null;
  float[] m = new float[16];
  private boolean o = true;
  
  public a$b(a parama1, Looper paramLooper, a parama2)
  {
    super(paramLooper);
    TXCLog.i("TXCScreenCapture", "TXCScreenCaptureGLThreadHandler inited. hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
  }
  
  protected void a()
  {
    if ((this.o) && (this.k != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", "Screen recording started successfully");
      f.a(a.a(this.n), 1004, localBundle);
      this.n.c(0);
    }
    this.o = false;
  }
  
  protected void a(Message paramMessage)
  {
    this.i = 0L;
    this.j = 0L;
    if (!b())
    {
      c();
      this.n.b();
      this.n.c(20000003);
    }
  }
  
  protected void b(Message paramMessage)
  {
    paramMessage = this.n;
    paramMessage.i = false;
    paramMessage = a.b(paramMessage);
    if (paramMessage != null) {
      paramMessage.onScreenCaptureStopped(0);
    }
    paramMessage = this.n.c();
    if (paramMessage != null) {
      paramMessage.a(a.f(this.n));
    }
    c();
  }
  
  protected boolean b()
  {
    TXCLog.i("TXCScreenCapture", String.format("init egl size[%d/%d]", new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.f) }));
    this.k = com.tencent.liteav.basic.c.b.a(null, null, null, this.e, this.f);
    if (this.k == null) {
      return false;
    }
    this.l = new i();
    if (!this.l.a()) {
      return false;
    }
    this.l.a(true);
    this.l.a(this.e, this.f);
    this.l.a(l.e, l.a(k.a, false, false));
    e();
    return true;
  }
  
  protected void c()
  {
    d();
    Object localObject = this.l;
    if (localObject != null)
    {
      ((i)localObject).d();
      this.l = null;
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((com.tencent.liteav.basic.c.b)localObject).c();
      this.k = null;
    }
  }
  
  protected void c(Message paramMessage)
  {
    this.n.a(102, 5L);
    if (!this.n.i) {
      return;
    }
    if (this.k == null)
    {
      TXCLog.e("TXCScreenCapture", "eglhelper is null");
      return;
    }
    if (!this.h)
    {
      this.i = 0L;
      this.j = System.nanoTime();
      return;
    }
    long l1 = System.nanoTime();
    long l2 = this.j;
    if (l1 < this.i * 1000L * 1000L * 1000L / this.g + l2) {
      return;
    }
    if (l2 == 0L)
    {
      this.j = l1;
    }
    else if (l1 > l2 + 1000000000L)
    {
      this.i = 0L;
      this.j = l1;
    }
    this.i += 1L;
    paramMessage = this.d;
    if (paramMessage != null)
    {
      if (this.b == null) {
        return;
      }
      paramMessage.getTransformMatrix(this.m);
      try
      {
        this.d.updateTexImage();
      }
      catch (Exception paramMessage)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onMsgRend Exception ");
        localStringBuilder.append(paramMessage.getMessage());
        TXCLog.e("TXCScreenCapture", localStringBuilder.toString());
      }
      this.l.a(this.m);
      GLES20.glViewport(0, 0, this.e, this.f);
      int i1 = this.l.b(this.b[0]);
      this.n.a(0, this.k.d(), i1, this.e, this.f, TXCTimeUtil.getTimeTick());
    }
  }
  
  protected void d()
  {
    new e(Looper.getMainLooper()).a(new a.b.1(this));
    Object localObject = this.c;
    if (localObject != null)
    {
      ((Surface)localObject).release();
      this.c = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((SurfaceTexture)localObject).setOnFrameAvailableListener(null);
      this.d.release();
      this.h = false;
      this.d = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      GLES20.glDeleteTextures(1, (int[])localObject, 0);
      this.b = null;
    }
  }
  
  protected void d(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    int i2 = paramMessage.arg1;
    int i1 = 1;
    if (i2 >= 1) {
      i1 = paramMessage.arg1;
    }
    this.g = i1;
    this.i = 0L;
    this.j = 0L;
  }
  
  protected void e()
  {
    this.b = new int[1];
    this.b[0] = j.b();
    int[] arrayOfInt = this.b;
    if (arrayOfInt[0] <= 0)
    {
      this.b = null;
      return;
    }
    this.d = new SurfaceTexture(arrayOfInt[0]);
    this.c = new Surface(this.d);
    this.d.setDefaultBufferSize(this.e, this.f);
    this.d.setOnFrameAvailableListener(new a.b.2(this));
    new Handler(Looper.getMainLooper()).post(new a.b.3(this));
  }
  
  protected void e(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    this.e = paramMessage.arg1;
    this.f = paramMessage.arg2;
    d();
    this.l.a(this.e, this.f);
    e();
    TXCLog.i("TXCScreenCapture", String.format("set screen capture size[%d/%d]", new Object[] { Integer.valueOf(a.d(this.n)), Integer.valueOf(a.e(this.n)) }));
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if ((this.a != this.n.e) && (101 != paramMessage.what)) {
      return;
    }
    switch (paramMessage.what)
    {
    case 104: 
    default: 
      break;
    case 106: 
      a();
      break;
    case 105: 
      e(paramMessage);
      break;
    case 103: 
      d(paramMessage);
      break;
    case 102: 
      try
      {
        c(paramMessage);
      }
      catch (Exception localException)
      {
        TXCLog.e("TXCScreenCapture", "render failed.", localException);
      }
    case 101: 
      b(paramMessage);
      break;
    case 100: 
      a(paramMessage);
    }
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      ((Runnable)paramMessage.obj).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.screencapture.a.b
 * JD-Core Version:    0.7.0.1
 */