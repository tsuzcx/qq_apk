package com.tencent.avgame.gameroom.video;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import com.tencent.mobileqq.ar.ARRenderModel.GreetingYUVProgram;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ConcurrentHashMap;

public class AVGameMediaRenderHelper
{
  private long A = 0L;
  private long B = 0L;
  private long C = 0L;
  private long D = 0L;
  private long E = 0L;
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected Point e;
  protected Boolean f;
  protected volatile boolean g = false;
  protected volatile boolean h = false;
  protected byte[] i;
  protected byte[] j;
  protected byte[] k;
  protected boolean l = false;
  protected Rect m;
  protected GreetingYUVProgram n;
  private ByteBuffer[] o = new ByteBuffer[3];
  private int[] p = new int[3];
  private TextureRender q;
  private float[] r = new float[16];
  private float[] s = new float[16];
  private SurfaceTexture t;
  private int u = -1;
  private ConcurrentHashMap<Long, Long> v = new ConcurrentHashMap();
  private long w = 0L;
  private long x = 0L;
  private boolean y = true;
  private long z = 0L;
  
  private void a(long paramLong) {}
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    byte[] arrayOfByte = this.i;
    if (arrayOfByte != null)
    {
      if (arrayOfByte.length == 1) {
        return;
      }
      if ((this.o[0] == null) || (this.p[0] != paramArrayOfByte1.length)) {
        try
        {
          this.o[0] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
          this.o[0].order(ByteOrder.nativeOrder());
        }
        catch (Throwable localThrowable)
        {
          QLog.e("AVGameMediaRenderHelper", 1, "textureYUV fail.", localThrowable);
        }
      }
      this.o[0].clear();
      this.p[0] = paramArrayOfByte1.length;
      this.o[0].put(paramArrayOfByte1);
      this.o[0].position(0);
      if ((this.o[1] == null) || (this.p[1] != paramArrayOfByte2.length)) {
        try
        {
          this.o[1] = ByteBuffer.allocateDirect(paramArrayOfByte2.length);
          this.o[1].order(ByteOrder.nativeOrder());
        }
        catch (Throwable paramArrayOfByte1)
        {
          QLog.e("AVGameMediaRenderHelper", 1, "textureYUV fail.", paramArrayOfByte1);
        }
      }
      this.o[1].clear();
      this.p[1] = paramArrayOfByte2.length;
      this.o[1].put(paramArrayOfByte2);
      this.o[1].position(0);
      if ((this.o[2] == null) || (this.p[2] != paramArrayOfByte3.length)) {
        try
        {
          this.o[2] = ByteBuffer.allocateDirect(paramArrayOfByte3.length);
          this.o[2].order(ByteOrder.nativeOrder());
        }
        catch (Throwable paramArrayOfByte1)
        {
          QLog.e("AVGameMediaRenderHelper", 1, "textureYUV fail.", paramArrayOfByte1);
        }
      }
      this.o[2].clear();
      this.p[2] = paramArrayOfByte3.length;
      this.o[2].put(paramArrayOfByte3);
      this.o[2].position(0);
    }
  }
  
  private Point f()
  {
    Rect localRect = this.m;
    int i1;
    int i2;
    if (localRect != null)
    {
      i1 = localRect.right;
      i1 = this.m.left;
      i2 = this.m.bottom;
      int i3 = this.m.top;
      i1 = this.m.left;
      i2 = this.b - this.m.top - (i2 - i3);
    }
    else
    {
      i1 = (this.a - 640) / 2;
      i2 = this.b - 480 - 40;
    }
    this.e = new Point(i1, i2);
    return this.e;
  }
  
  private void g()
  {
    ??? = this.i;
    if (??? != null)
    {
      if (???.length == 1) {
        return;
      }
      if (!this.n.a()) {
        this.n.b();
      }
      synchronized (this.i)
      {
        if (this.g)
        {
          a(this.i, this.j, this.k);
          this.n.a(this.o[0], this.o[1], this.o[2], this.c, this.d);
          this.g = false;
        }
        return;
      }
    }
  }
  
  private void h()
  {
    if ((this.l) && (this.h) && (this.o[0] != null) && (this.c != 0))
    {
      Object localObject = this.i;
      if (localObject != null)
      {
        if (localObject.length == 1) {
          return;
        }
        QLog.d("AVGameMediaRenderHelper", 1, "loadVerticalBuffer");
        this.l = false;
        localObject = new float[8];
        Object tmp70_68 = localObject;
        tmp70_68[0] = -1.0F;
        Object tmp75_70 = tmp70_68;
        tmp75_70[1] = 1.0F;
        Object tmp79_75 = tmp75_70;
        tmp79_75[2] = 1.0F;
        Object tmp83_79 = tmp79_75;
        tmp83_79[3] = 1.0F;
        Object tmp87_83 = tmp83_79;
        tmp87_83[4] = -1.0F;
        Object tmp92_87 = tmp87_83;
        tmp92_87[5] = -1.0F;
        Object tmp97_92 = tmp92_87;
        tmp97_92[6] = 1.0F;
        Object tmp102_97 = tmp97_92;
        tmp102_97[7] = -1.0F;
        tmp102_97;
        Rect localRect = this.m;
        if (localRect != null)
        {
          int i1 = localRect.right;
          int i2 = this.m.left;
          int i3 = this.m.bottom;
          int i4 = this.m.top;
          int i5 = this.c;
          int i6 = this.d;
          float f1 = i1 - i2;
          float f2 = i3 - i4;
          float f3 = f1 / f2;
          float f4 = i5 / i6;
          if (f3 < f4)
          {
            f1 = f4 * f1 / f2;
            localObject[0] *= f1;
            localObject[2] *= f1;
            localObject[4] *= f1;
            localObject[6] *= f1;
          }
          else if (f3 > f4)
          {
            f1 /= f4 * f2;
            localObject[1] *= f1;
            localObject[3] *= f1;
            localObject[5] *= f1;
            localObject[7] *= f1;
          }
        }
        this.n.a((float[])localObject);
      }
    }
  }
  
  public void a()
  {
    QLog.d("AVGameMediaRenderHelper", 1, "onGLSurfaceDestroy");
    this.q.release();
    this.n.d();
    this.n = null;
    this.i = new byte[1];
    this.j = new byte[1];
    this.k = new byte[1];
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d("AVGameMediaRenderHelper", 1, "onGLSurfaceCreate");
    this.a = paramInt1;
    this.b = paramInt2;
    this.n = new GreetingYUVProgram(0);
    this.i = new byte[1];
    this.j = new byte[1];
    this.k = new byte[1];
    this.q = new TextureRender();
    Matrix.setIdentityM(this.r, 0);
    Matrix.setIdentityM(this.s, 0);
    Matrix.scaleM(this.s, 0, 1.0F, -1.0F, 1.0F);
  }
  
  protected void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (this.h)
    {
      Boolean localBoolean = this.f;
      if (localBoolean != null)
      {
        this.m = paramRect;
        this.a = paramInt1;
        this.b = paramInt2;
        if (localBoolean.booleanValue()) {
          c();
        } else {
          b();
        }
        d();
        return;
      }
    }
    QLog.d("AVGameMediaRenderHelper", 1, "renderVideoCover fail");
  }
  
  public void a(boolean paramBoolean)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("notifySelfMediaRender enable:=");
    ((StringBuilder)???).append(paramBoolean);
    QLog.d("AVGameMediaRenderHelper", 1, ((StringBuilder)???).toString());
    this.h = paramBoolean;
    ??? = this.i;
    if ((??? != null) && (???.length != 1) && (!this.h)) {
      synchronized (this.i)
      {
        this.i = new byte[1];
        this.j = new byte[1];
        this.k = new byte[1];
        this.o = new ByteBuffer[3];
        return;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if ((this.h) && (this.i != null))
    {
      a(paramLong);
      this.f = Boolean.valueOf(true);
      int i1 = this.i.length;
      int i2 = paramInt1 * paramInt2;
      if (i1 != i2)
      {
        this.i = new byte[i2];
        i1 = i2 / 4;
        this.j = new byte[i1];
        this.k = new byte[i1];
        this.l = true;
        QLog.d("AVGameMediaRenderHelper", 1, "onPushVideoMsg mRenderParamsChang;=true");
      }
      this.c = paramInt1;
      this.d = paramInt2;
      synchronized (this.i)
      {
        this.g = true;
        System.arraycopy(paramArrayOfByte, 0, this.i, 0, this.i.length);
        System.arraycopy(paramArrayOfByte, this.i.length, this.j, 0, this.j.length);
        System.arraycopy(paramArrayOfByte, this.i.length + this.j.length, this.k, 0, this.k.length);
        e();
        return;
      }
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("onPushVideoMsg fail mEnablePlayYUV ");
    paramArrayOfByte.append(this.h);
    QLog.d("AVGameMediaRenderHelper", 1, paramArrayOfByte.toString());
  }
  
  protected void b()
  {
    SurfaceTexture localSurfaceTexture = this.t;
    if ((localSurfaceTexture != null) && (this.u != -1))
    {
      if (this.m == null) {
        return;
      }
      try
      {
        this.t.getTransformMatrix(this.r);
        GLES20.glViewport(f().x, f().x, this.m.right - this.m.left, this.m.bottom - this.m.top);
        this.q.drawTexture(36197, this.u, this.r, this.s);
        GLES20.glViewport(0, 0, this.a, this.b);
        return;
      }
      finally {}
    }
  }
  
  protected void c()
  {
    if ((this.h) && (this.f != null) && (this.c != 0) && (this.i.length != 1) && (this.m != null))
    {
      g();
      h();
      if (this.i.length == 1) {
        return;
      }
      GLES20.glViewport(f().x, f().y, this.m.right - this.m.left, this.m.bottom - this.m.top);
      this.n.c();
      GLES20.glViewport(0, 0, this.a, this.b);
      if (this.y) {
        this.y = false;
      }
      return;
    }
    QLog.d("AVGameMediaRenderHelper", 1, "renderVideoCoverBySoft fail");
  }
  
  public void d()
  {
    this.z += 1L;
    if (this.A == 0L) {
      this.A = SystemClock.elapsedRealtime();
    }
    if (SystemClock.elapsedRealtime() - this.A >= 1000L)
    {
      this.B = this.z;
      this.z = 0L;
      this.A = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFPSRate mFrameRate:=");
        localStringBuilder.append(this.B);
        QLog.d("AVGameMediaRenderHelper", 1, localStringBuilder.toString());
      }
    }
  }
  
  public void e()
  {
    this.C += 1L;
    if (this.D == 0L) {
      this.D = SystemClock.elapsedRealtime();
    }
    if (SystemClock.elapsedRealtime() - this.D >= 1000L)
    {
      this.E = this.C;
      this.C = 0L;
      this.D = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFPSRate updateDecodeRate:=");
        localStringBuilder.append(this.B);
        QLog.d("AVGameMediaRenderHelper", 1, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameMediaRenderHelper
 * JD-Core Version:    0.7.0.1
 */