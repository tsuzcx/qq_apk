package com.tencent.liteav.basic.c;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import javax.microedition.khronos.egl.EGLContext;

public class f
  implements g.a, m
{
  public int a = 25;
  private volatile HandlerThread b = null;
  private volatile g c = null;
  private n d;
  private int[] e = null;
  private SurfaceTexture f = null;
  private boolean g = false;
  private long h = 0L;
  private long i = 0L;
  private float[] j = new float[16];
  
  private void a(int paramInt)
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
  
  private void a(int paramInt, long paramLong)
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
  
  private void a(int paramInt, Runnable paramRunnable)
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
  
  private void b()
  {
    f();
    try
    {
      this.b = new HandlerThread("TXGLSurfaceTextureThread");
      this.b.start();
      this.c = new g(this.b.getLooper());
      this.c.a(this);
      this.c.a = 1280;
      this.c.b = 720;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create gl thread ");
      localStringBuilder.append(this.b.getName());
      TXCLog.w("TXGLSurfaceTextureThread", localStringBuilder.toString());
      a(100);
      return;
    }
    finally {}
  }
  
  private void f()
  {
    try
    {
      if (this.c != null)
      {
        g.a(this.c, this.b);
        TXCLog.w("TXGLSurfaceTextureThread", "destroy gl thread");
      }
      this.c = null;
      this.b = null;
      return;
    }
    finally {}
  }
  
  private void g()
  {
    TXCLog.w("TXGLSurfaceTextureThread", "destroy surface texture ");
    Object localObject = this.d;
    if (localObject != null) {
      ((n)localObject).b(this.f);
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((SurfaceTexture)localObject).setOnFrameAvailableListener(null);
      this.f.release();
      this.g = false;
      this.f = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      GLES20.glDeleteTextures(1, (int[])localObject, 0);
      this.e = null;
    }
  }
  
  private void h()
  {
    TXCLog.w("TXGLSurfaceTextureThread", "init surface texture ");
    this.e = new int[1];
    this.e[0] = j.b();
    Object localObject = this.e;
    if (localObject[0] <= 0)
    {
      this.e = null;
      return;
    }
    this.f = new SurfaceTexture(localObject[0]);
    this.f.setDefaultBufferSize(1280, 720);
    this.f.setOnFrameAvailableListener(new f.2(this));
    localObject = this.d;
    if (localObject != null) {
      ((n)localObject).a(this.f);
    }
  }
  
  private boolean i()
  {
    if (!this.g)
    {
      this.h = 0L;
      this.i = System.nanoTime();
      return false;
    }
    long l1 = System.nanoTime();
    long l2 = this.i;
    if (l1 < this.h * 1000L * 1000L * 1000L / this.a + l2) {
      return false;
    }
    if (l2 == 0L)
    {
      this.i = l1;
    }
    else if (l1 > l2 + 1000000000L)
    {
      this.h = 0L;
      this.i = l1;
    }
    this.h += 1L;
    return true;
  }
  
  public void a()
  {
    f();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a = paramInt;
    b();
  }
  
  public void a(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2) {}
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      if (this.c != null) {
        this.c.post(paramRunnable);
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.c != null) {
        this.c.removeCallbacksAndMessages(null);
      }
      this.g = false;
      if ((this.f != null) && (this.e != null)) {
        this.f.updateTexImage();
      } else {
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTexImage failed.");
      localStringBuilder.append(localException.getMessage());
      TXCLog.e("TXGLSurfaceTextureThread", localStringBuilder.toString());
      this.f.setOnFrameAvailableListener(new f.1(this));
      return;
      label104:
      throw localException;
    }
    finally
    {
      break label104;
    }
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public void c()
  {
    h();
  }
  
  public void d()
  {
    a(102, 5L);
    if (!i()) {
      return;
    }
    SurfaceTexture localSurfaceTexture = this.f;
    if (localSurfaceTexture != null)
    {
      if (this.e == null) {
        return;
      }
      try
      {
        localSurfaceTexture.updateTexImage();
        this.f.getTransformMatrix(this.j);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onMsgRend Exception ");
        localStringBuilder.append(localException.getMessage());
        TXCLog.e("TXGLSurfaceTextureThread", localStringBuilder.toString());
      }
      n localn = this.d;
      if (localn != null) {
        localn.a(this.e[0], this.j);
      }
    }
  }
  
  public void e()
  {
    g();
  }
  
  public EGLContext getGLContext()
  {
    for (;;)
    {
      try
      {
        if (this.c != null)
        {
          EGLContext localEGLContext = this.c.a();
          return localEGLContext;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    return this.f;
  }
  
  public void setRendMirror(int paramInt) {}
  
  public void setRendMode(int paramInt) {}
  
  public void setSurfaceTextureListener(n paramn)
  {
    this.d = paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.c.f
 * JD-Core Version:    0.7.0.1
 */