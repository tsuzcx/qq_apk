package com.tencent.av.opengl.effects;

import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.utils.PerfRecorder;

public class ExtraRenderWrapper
{
  public int a = 0;
  private ExtraTextureRender b = null;
  private int c = 0;
  private FilterProcessRender d;
  
  public ExtraRenderWrapper(FilterProcessRender paramFilterProcessRender)
  {
    this.d = paramFilterProcessRender;
  }
  
  public int a(CameraFrame paramCameraFrame, RenderParams paramRenderParams)
  {
    if ((paramRenderParams.c != null) && (paramRenderParams.b != null) && (paramRenderParams.c.needHMirror)) {
      return 1;
    }
    return 0;
  }
  
  public void a()
  {
    if (this.b == null) {
      this.b = new ExtraTextureRender();
    }
  }
  
  public void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams, GLTexture paramGLTexture, int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      return;
    }
    this.a = a(paramCameraFrame, paramRenderParams);
    this.b.a(this.a);
    if (this.b.a())
    {
      if (this.d.j != null) {
        this.d.j.a("extraRenderIn");
      }
      paramCameraFrame = this.b.a(paramGLTexture, paramInt1, paramInt2);
      if (paramCameraFrame != null)
      {
        this.d.a(11, paramGLTexture, paramCameraFrame);
        paramGLTexture.a = paramCameraFrame.a;
        paramGLTexture.b = paramCameraFrame.b;
        paramCameraFrame.a();
      }
      if (this.d.j != null) {
        this.d.j.b("extraRenderIn");
      }
    }
  }
  
  public void a(GLTexture paramGLTexture, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      return;
    }
    int j = 0;
    int i;
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      i = j;
    }
    else
    {
      i = j;
      if (paramBoolean1)
      {
        i = j;
        if (paramBoolean2) {
          i = 1;
        }
      }
    }
    if (i != 0) {
      i = this.c;
    } else {
      i = this.a;
    }
    this.b.a(i);
    if (this.b.a())
    {
      if (this.d.j != null) {
        this.d.j.a("extraRenderOut");
      }
      GLTexture localGLTexture = this.b.a(paramGLTexture, paramInt1, paramInt2);
      if (localGLTexture != null)
      {
        this.d.a(12, paramGLTexture, localGLTexture);
        paramGLTexture.a = localGLTexture.a;
        paramGLTexture.b = localGLTexture.b;
        localGLTexture.a();
      }
      if (this.d.j != null) {
        this.d.j.b("extraRenderOut");
      }
    }
  }
  
  public void b()
  {
    ExtraTextureRender localExtraTextureRender = this.b;
    if (localExtraTextureRender != null)
    {
      localExtraTextureRender.b();
      this.b = null;
    }
  }
  
  public void b(CameraFrame paramCameraFrame, RenderParams paramRenderParams)
  {
    this.c = a(paramCameraFrame, paramRenderParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.ExtraRenderWrapper
 * JD-Core Version:    0.7.0.1
 */