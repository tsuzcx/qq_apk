package com.tencent.av.opengl.effects;

import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import com.tencent.av.utils.FramePerfData;
import com.tencent.qphone.base.util.QLog;

public class CameraFrame
{
  static long o = 0L;
  static long p = 0L;
  private static final Object u = new Object();
  private static CameraFrame v;
  private static int w = 0;
  private static String x = "";
  private static int y = 0;
  private static long z = 0L;
  public byte[] a = null;
  public int b = 0;
  public int c = 0;
  public int d;
  public int e;
  public int f;
  public boolean g;
  public long h;
  public long i;
  public long j;
  public FramePerfData k;
  public int l;
  public int m;
  public SurfaceTexture n = null;
  private long q = 0L;
  private boolean r = false;
  private CameraFrame s;
  private boolean t = false;
  
  public static void a(SurfaceTexture paramSurfaceTexture)
  {
    o += 1L;
  }
  
  static void a(String paramString)
  {
    x = paramString;
    y = 0;
    z = 0L;
  }
  
  public static void b(SurfaceTexture paramSurfaceTexture)
  {
    p += 1L;
  }
  
  public static void c(SurfaceTexture paramSurfaceTexture)
  {
    o = 0L;
    p = 0L;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearFrameCount, count[");
      localStringBuilder.append(o);
      localStringBuilder.append(",");
      localStringBuilder.append(p);
      localStringBuilder.append("], surfaceTexture[");
      localStringBuilder.append(paramSurfaceTexture);
      localStringBuilder.append("]");
      QLog.i("SurfaceTag", 2, localStringBuilder.toString());
    }
  }
  
  public static boolean d(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool;
    if (o == p) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkFrameDealRight, count[");
      localStringBuilder.append(o);
      localStringBuilder.append(",");
      localStringBuilder.append(p);
      localStringBuilder.append("], surfaceTexture[");
      localStringBuilder.append(paramSurfaceTexture);
      localStringBuilder.append("]");
      QLog.i("SurfaceTag", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public static CameraFrame f()
  {
    synchronized (u)
    {
      if (v != null)
      {
        CameraFrame localCameraFrame = v;
        v = localCameraFrame.s;
        localCameraFrame.s = null;
        w -= 1;
        localCameraFrame.t = false;
        return localCameraFrame;
      }
      return new CameraFrame();
    }
  }
  
  public void a(long paramLong1, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    this.n = paramSurfaceTexture;
    this.a = null;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramBoolean;
    this.h = paramLong2;
    this.i = paramLong3;
    this.j = paramLong1;
    this.l = 0;
    this.m = 0;
    this.q = SystemClock.elapsedRealtime();
    this.r = false;
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    this.a = paramArrayOfByte;
    this.n = null;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramBoolean;
    this.h = paramLong2;
    this.i = paramLong3;
    this.j = paramLong1;
    this.l = 0;
    this.m = 0;
    this.q = SystemClock.elapsedRealtime();
    this.r = false;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    SurfaceTexture localSurfaceTexture = this.n;
    if (localSurfaceTexture != null)
    {
      localSurfaceTexture.updateTexImage();
      if (paramArrayOfFloat != null) {
        this.n.getTransformMatrix(paramArrayOfFloat);
      }
      this.r = true;
      b(this.n);
    }
  }
  
  public boolean a()
  {
    return (this.a == null) && (this.n == null);
  }
  
  public int b()
  {
    byte[] arrayOfByte = this.a;
    if (arrayOfByte == null) {
      return 0;
    }
    return arrayOfByte.length;
  }
  
  public boolean c()
  {
    return (this.a != null) && (this.n == null);
  }
  
  public void d()
  {
    if ((this.n != null) && (!this.r))
    {
      try
      {
        a(null);
      }
      catch (Throwable localThrowable)
      {
        QLog.i("SurfaceTag", 1, "checkAfterFilterRender", localThrowable);
      }
      if (QLog.isColorLevel()) {
        QLog.i("SurfaceTag", 2, "checkAfterFilterRender, not deal by filter render.");
      }
    }
  }
  
  public void e()
  {
    if ((QLog.isDevelopLevel()) && (this.q != 0L))
    {
      long l1 = SystemClock.elapsedRealtime() - this.q;
      y += 1;
      if (y == 1) {
        z = l1;
      } else {
        z = (z + l1) / 2L;
      }
    }
    if ((this.n != null) && (!this.r) && (QLog.isColorLevel())) {
      QLog.i("SurfaceTag", 2, "recycle when tex not updated.");
    }
    this.a = null;
    this.n = null;
    this.b = 0;
    this.c = 0;
    this.j = 0L;
    this.h = 0L;
    this.q = 0L;
    this.r = false;
    synchronized (u)
    {
      if (this.t)
      {
        QLog.i("SurfaceTag", 2, "recycle, error.");
      }
      else
      {
        this.t = true;
        if (w < 4)
        {
          this.s = v;
          v = this;
          w += 1;
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.CameraFrame
 * JD-Core Version:    0.7.0.1
 */