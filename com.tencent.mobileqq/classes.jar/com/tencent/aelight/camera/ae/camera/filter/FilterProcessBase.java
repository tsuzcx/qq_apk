package com.tencent.aelight.camera.ae.camera.filter;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.ExtractFrameRequest;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public abstract class FilterProcessBase
{
  private long A = ((Long)VSConfigManager.a().a("SmartCutPicSpacing", Long.valueOf(500L))).longValue();
  private boolean B = false;
  private boolean C = false;
  private AECameraGLSurfaceView.ExtractFrameRequest a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected double l;
  protected double m;
  protected FilterProcessBase.VideoOutRatio n = FilterProcessBase.VideoOutRatio.NONE;
  protected final int[] o = new int[2];
  protected boolean p = false;
  protected int q;
  protected SurfaceTexture r;
  protected int[] s = new int[2];
  protected final float[] t = new float[16];
  protected volatile boolean u = false;
  protected int v = 90;
  protected AEFilterProcessTex.CapturePhotoListener w;
  protected final int x = 1080;
  protected float[] y = new float[16];
  private long z;
  
  protected abstract void a();
  
  public abstract void a(float paramFloat);
  
  public void a(int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("previewWidth: ");
    ((StringBuilder)localObject).append(paramInt5);
    ((StringBuilder)localObject).append(" previewHeight: ");
    ((StringBuilder)localObject).append(paramInt6);
    AEQLog.b("FilterProcessBase", ((StringBuilder)localObject).toString());
    double d1 = paramInt1;
    double d2 = paramInt2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    this.m = (d1 / d2);
    if ((paramInt3 > 0) && (paramInt4 > 0))
    {
      this.h = paramInt3;
      this.i = paramInt4;
      d1 = this.h;
      d2 = this.i;
      Double.isNaN(d1);
      Double.isNaN(d2);
      this.l = (d1 / d2);
    }
    this.f = paramInt5;
    paramInt1 = this.f;
    d2 = paramInt1;
    d1 = this.m;
    Double.isNaN(d2);
    this.g = ((int)(d2 / d1));
    this.d = paramInt5;
    d2 = this.d;
    Double.isNaN(d2);
    this.e = ((int)(d2 / d1));
    this.b = 1080;
    d2 = this.b;
    Double.isNaN(d2);
    this.c = ((int)(d2 / d1));
    localObject = this.o;
    localObject[0] = paramInt1;
    localObject[1] = this.g;
  }
  
  public void a(AECameraGLSurfaceView.ExtractFrameRequest paramExtractFrameRequest)
  {
    this.a = paramExtractFrameRequest;
  }
  
  public void a(FilterProcessBase.VideoOutRatio paramVideoOutRatio)
  {
    this.n = paramVideoOutRatio;
  }
  
  public void a(boolean paramBoolean, int paramInt, AEFilterProcessTex.CapturePhotoListener paramCapturePhotoListener)
  {
    this.u = paramBoolean;
    this.v = paramInt;
    this.w = paramCapturePhotoListener;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    try
    {
      if (this.r != null)
      {
        this.r.updateTexImage();
        this.r.getTransformMatrix(this.t);
        System.arraycopy(paramArrayOfFloat, 0, this.y, 0, 16);
        return;
      }
    }
    catch (Exception paramArrayOfFloat)
    {
      paramArrayOfFloat.printStackTrace();
    }
  }
  
  public abstract int[] a(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void b(boolean paramBoolean);
  
  public void e(int paramInt)
  {
    if ((this.a != null) && (paramInt > 0))
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.z >= this.A)
      {
        this.a.onExtract(GlUtil.captureFrame(paramInt, this.f, this.g, 0));
        this.z = l1;
      }
    }
  }
  
  protected abstract void f();
  
  public abstract void g();
  
  public void h(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public SurfaceTexture p()
  {
    if (this.B) {
      return this.r;
    }
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.q = arrayOfInt[0];
    this.r = new SurfaceTexture(this.q);
    this.B = true;
    return this.r;
  }
  
  public void q()
  {
    if (!this.C)
    {
      a();
      this.C = true;
    }
  }
  
  public void r()
  {
    if (this.B)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.q;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.r.release();
      this.r = null;
      this.B = false;
    }
    if (this.C)
    {
      f();
      this.C = false;
    }
  }
  
  public boolean s()
  {
    return (this.B) && (this.C);
  }
  
  public boolean t()
  {
    return this.n == FilterProcessBase.VideoOutRatio.RATIO_9_16;
  }
  
  public int[] u()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
 * JD-Core Version:    0.7.0.1
 */