package com.tencent.liteav.basic.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;

public class e
  implements g.a
{
  private volatile HandlerThread a = null;
  private volatile g b = null;
  private h c = null;
  private int d = 0;
  private boolean e = false;
  private float f = 1.0F;
  private float g = 1.0F;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private boolean l = false;
  private o m = null;
  private boolean n = false;
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.l)
    {
      int i1 = this.j;
      if (i1 != 0)
      {
        int i2 = this.k;
        if (i2 != 0)
        {
          int i3;
          if (i1 <= i2) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          i1 = this.k;
          i2 = this.j;
          if (i1 < i2) {
            i1 = i2;
          }
          int i4 = this.k;
          int i5 = this.j;
          i2 = i4;
          if (i4 >= i5) {
            i2 = i5;
          }
          i5 = i1;
          i4 = i2;
          if (i3 != 0)
          {
            i4 = i1;
            i5 = i2;
          }
          ByteBuffer localByteBuffer = ByteBuffer.allocate(i5 * i4 * 4);
          Bitmap localBitmap = Bitmap.createBitmap(i5, i4, Bitmap.Config.ARGB_8888);
          localByteBuffer.position(0);
          GLES20.glReadPixels(paramInt1, paramInt2, i5, i4, 6408, 5121, localByteBuffer);
          o localo = this.m;
          if (localo != null) {
            new Thread(new e.4(this, localByteBuffer, localBitmap, i5, i4, localo)).start();
          }
        }
      }
      this.m = null;
      this.l = false;
    }
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt2;
    float f2 = paramInt1;
    float f3 = f1 / f2;
    float f4 = paramInt4 / paramInt3;
    if (f3 > f4)
    {
      paramInt3 = (int)(f2 * f4);
      paramInt2 = (paramInt2 - paramInt3) / 2;
      paramInt4 = 0;
    }
    else
    {
      paramInt3 = (int)(f1 / f4);
      paramInt4 = (paramInt1 - paramInt3) / 2;
      int i1 = 0;
      paramInt1 = paramInt3;
      paramInt3 = paramInt2;
      paramInt2 = i1;
    }
    return new int[] { paramInt1, paramInt3, paramInt4, paramInt2 };
  }
  
  private void b(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt5 != 0) && (paramInt6 != 0))
    {
      if (this.c == null) {
        return;
      }
      if (this.n)
      {
        this.n = false;
        return;
      }
      if (paramBoolean2)
      {
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        GLES20.glBindFramebuffer(36160, 0);
        if (this.b != null) {
          this.b.c();
        }
        this.n = true;
      }
      if (paramInt3 == 0) {
        paramInt3 = paramInt5;
      }
      if (paramInt4 == 0) {
        paramInt4 = paramInt6;
      }
      int i1 = this.h;
      int i2;
      Object localObject;
      if ((i1 != 0) && (i1 == 1))
      {
        i1 = (720 - this.d) % 360;
        if ((i1 != 90) && (i1 != 270)) {
          i2 = 0;
        } else {
          i2 = 1;
        }
        if (i2 != 0) {
          i1 = paramInt6;
        } else {
          i1 = paramInt5;
        }
        if (i2 != 0) {
          i2 = paramInt5;
        } else {
          i2 = paramInt6;
        }
        localObject = a(paramInt3, paramInt4, i1, i2);
        paramInt3 = localObject[0];
        paramInt4 = localObject[1];
        i2 = localObject[2];
        i1 = localObject[3];
      }
      else
      {
        i1 = 0;
        i2 = 0;
      }
      this.j = paramInt3;
      this.k = paramInt4;
      GLES20.glViewport(i2, i1, paramInt3, paramInt4);
      int i3 = this.i;
      if (i3 == 1)
      {
        if (paramBoolean3) {}
      }
      else {
        while ((i3 == 2) && (paramBoolean3))
        {
          paramBoolean1 ^= true;
          break;
        }
      }
      float f1;
      if (paramInt4 != 0) {
        f1 = paramInt3 / paramInt4;
      } else {
        f1 = 1.0F;
      }
      float f2;
      if (paramInt6 != 0) {
        f2 = paramInt5 / paramInt6;
      } else {
        f2 = 1.0F;
      }
      if ((this.e == paramBoolean1) && (this.d == paramInt2) && (this.f == f1) && (this.g == f2)) {}
      for (;;)
      {
        break;
        this.e = paramBoolean1;
        this.d = paramInt2;
        this.f = f1;
        this.g = f2;
        int i4 = (720 - this.d) % 360;
        if ((i4 != 90) && (i4 != 270)) {
          paramInt2 = 0;
        } else {
          paramInt2 = 1;
        }
        if (paramInt2 != 0) {
          i3 = paramInt4;
        } else {
          i3 = paramInt3;
        }
        if (paramInt2 != 0) {
          paramInt4 = paramInt3;
        }
        localObject = this.c;
        float[] arrayOfFloat = l.a(k.a, false, true);
        f1 = i3 / paramInt4;
        if (paramInt2 != 0) {
          paramBoolean1 = false;
        } else {
          paramBoolean1 = this.e;
        }
        if (paramInt2 != 0) {
          paramBoolean2 = this.e;
        } else {
          paramBoolean2 = false;
        }
        ((h)localObject).a(paramInt5, paramInt6, i4, arrayOfFloat, f1, paramBoolean1, paramBoolean2);
        if (paramInt2 != 0) {
          this.c.g();
        } else {
          this.c.h();
        }
      }
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      GLES20.glBindFramebuffer(36160, 0);
      this.c.a(paramInt1);
      a(i2, i1);
      if (this.b != null) {
        this.b.c();
      }
    }
  }
  
  private void b(Object paramObject, Surface paramSurface)
  {
    f();
    try
    {
      this.a = new HandlerThread("TXGLSurfaceRenderThread");
      this.a.start();
      this.b = new g(this.a.getLooper());
      this.b.a(this);
      if ((paramObject != null) && (!(paramObject instanceof javax.microedition.khronos.egl.EGLContext)))
      {
        this.b.d = true;
        this.b.f = ((android.opengl.EGLContext)paramObject);
      }
      else
      {
        this.b.d = false;
        this.b.h = ((javax.microedition.khronos.egl.EGLContext)paramObject);
      }
      this.b.c = paramSurface;
      paramObject = new StringBuilder();
      paramObject.append("surface-render: create gl thread ");
      paramObject.append(this.a.getName());
      TXCLog.w("TXGLSurfaceRenderThread", paramObject.toString());
      c(100);
      return;
    }
    finally {}
  }
  
  private void c(int paramInt)
  {
    try
    {
      if (this.b != null) {
        this.b.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally {}
  }
  
  private void f()
  {
    try
    {
      if (this.b != null)
      {
        g.a(this.b, this.a);
        TXCLog.w("TXGLSurfaceRenderThread", "surface-render: destroy gl thread");
      }
      this.b = null;
      this.a = null;
      return;
    }
    finally {}
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surface-render: surface render stop ");
    localStringBuilder.append(this);
    TXCLog.i("TXGLSurfaceRenderThread", localStringBuilder.toString());
    f();
  }
  
  public void a(int paramInt)
  {
    a(new e.1(this, paramInt));
  }
  
  public void a(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2, boolean paramBoolean3)
  {
    
    try
    {
      if (this.b != null) {
        this.b.post(new e.3(this, paramInt1, paramBoolean1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean2, paramBoolean3));
      }
      return;
    }
    finally {}
  }
  
  public void a(o paramo)
  {
    this.m = paramo;
    this.l = true;
  }
  
  public void a(Object paramObject, Surface paramSurface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surface-render: surface render start ");
    localStringBuilder.append(paramSurface);
    localStringBuilder.append(", ");
    localStringBuilder.append(this);
    TXCLog.i("TXGLSurfaceRenderThread", localStringBuilder.toString());
    b(paramObject, paramSurface);
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      if (this.b != null) {
        this.b.post(paramRunnable);
      }
      return;
    }
    finally {}
  }
  
  public Surface b()
  {
    for (;;)
    {
      try
      {
        if (this.b != null)
        {
          Surface localSurface = this.b.b();
          return localSurface;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public void b(int paramInt)
  {
    a(new e.2(this, paramInt));
  }
  
  public void c()
  {
    this.c = new h();
    if (!this.c.a()) {
      return;
    }
    this.c.a(l.e, l.a(k.a, false, false));
  }
  
  public void d() {}
  
  public void e()
  {
    h localh = this.c;
    if (localh != null)
    {
      localh.d();
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.c.e
 * JD-Core Version:    0.7.0.1
 */