package com.tencent.aelight.camera.ae.camera.filter;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.view.RendererUtils;

public class NonAEFilterProcess
  extends FilterProcessBase
{
  private RenderBuffer A;
  private TextureRender a;
  private RenderBuffer z;
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (this.A == null) {
        this.A = new RenderBuffer(this.f, this.g, 33984);
      }
      this.A.bind();
      Object localObject = new float[16];
      Matrix.setIdentityM((float[])localObject, 0);
      Matrix.scaleM((float[])localObject, 0, 1.0F, -1.0F, 1.0F);
      this.a.drawTexture(3553, paramInt1, null, (float[])localObject);
      this.A.unbind();
      localObject = RendererUtils.saveTexture(this.A.getTexId(), paramInt2, paramInt3);
      if (this.w != null) {
        this.w.onPhotoCaptured((Bitmap)localObject);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label111:
      break label111;
    }
    if (this.w != null) {
      this.w.onCaptureError(103);
    }
  }
  
  public void a()
  {
    this.a = new TextureRender();
  }
  
  public void a(float paramFloat) {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glClearColor(0.92F, 0.93F, 0.96F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    this.a.drawTexture(3553, paramInt1, null, null);
    GLES20.glDisable(3042);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public int[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.h != 0) && (this.i != 0))
    {
      paramBoolean = this.u;
      if (this.z == null) {
        this.z = new RenderBuffer(this.h, this.i, 33984);
      }
      this.z.bind();
      int i = this.f;
      double d1 = this.f;
      double d2 = this.m;
      Double.isNaN(d1);
      int j = (int)(d1 / d2);
      float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.h, this.i, i, j);
      this.a.drawTexture(36197, this.q, this.t, arrayOfFloat);
      this.z.unbind();
      int k = this.z.getTexId();
      a(k, paramInt1, paramInt2);
      if (paramBoolean)
      {
        b(k, i, j);
        this.u = false;
      }
      this.s[0] = k;
      this.s[1] = k;
      return this.s;
    }
    return this.s;
  }
  
  public void b(boolean paramBoolean) {}
  
  public void f()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((TextureRender)localObject).release();
    }
    localObject = this.z;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.A;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    if (this.r != null) {
      this.r.setOnFrameAvailableListener(null);
    }
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.filter.NonAEFilterProcess
 * JD-Core Version:    0.7.0.1
 */